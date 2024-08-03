package TimeLog;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Menu {

	// ---------------Attributs---------------
	private Utilisateur utilisateur;

	// ---------------Constructeur---------------
	Menu(Utilisateur utilsateur){
		this.utilisateur = utilisateur;
	}

	// ---------------Getters---------------
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	// ---------------Setters---------------
	public void setUtilisateur(Utilisateur newUtilisateur) {
		this.utilisateur = newUtilisateur;
	}

	// Méthode pour l'affichage du menu principal
	public void affichageMenu() {
		if(utilisateur instanceof Administrateur) {

		} else if (utilisateur instanceof Employe) {

		}
	}

	// Méthode pour l'affichage du menu admin
	public static void affichageMenuAdmin() throws ParseException, IOException {
		while(true) {
			System.out.println("\n\n\t----Menu Administrateur----");

			System.out.println("1. Gérer les utilisateurs ou changer le mot de passe");
			System.out.println("2. Gérer les projets");
			System.out.println("3. Modification du NPE");
			System.out.println("4. Déconnexion");

			int choix = choixUtilisateur();
			if(!gererChoixAdmin(choix)) {
				break;
			}
		}
	}
	// Méthode pour l'affichage du menu employé
	public static void affichageMenuEmploye(String employeID) throws ParseException, IOException {
		while(true) {
			System.out.println("\n\n\t----Menu Employé----");

			System.out.println("1. Débuter une activité");
			System.out.println("2. Terminer une activité");
			System.out.println("3. Affichage des rapports");
			System.out.println("4. Affichage talon de paie");
			System.out.println("5. Déconnexion");

			int choix = choixUtilisateur();
			if(!gererChoixEmploye(choix, employeID)) {
				break;
			}
		}
	}
	// Méthode pour obtenir choix de l'utilisateur
	public static int choixUtilisateur() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez votre choix: ");
		return scan.nextInt();
	}

	// Méthode pour gérer le choix admin
	public static boolean gererChoixAdmin(int choix) throws ParseException, IOException {
		switch(choix) {
		case 1: 
			Operation.menuGestionUtilisateur();
			return true;
		case 2: 
			Operation.menuGestionProjet();
			return true;
		case 3: 
			Operation.menuGestionUtilisateur();
			return true;
		case 4: 
			System.out.println("\tDéconnexion...");
			return false;
		default:
			System.out.println("Choix invalide.");
			return true;

		}
	}
	// Méthode pour gérer le choix employé
	public static boolean gererChoixEmploye(int choix, String employeID) throws ParseException, IOException {
		switch(choix) {
		case 1: 
			debuterActivite(employeID);
			return true;
		case 2: 
			terminerActivite(employeID);
			return true;
		case 3: 
			String projetID = Operation.demanderID("Afin d'afficher les rapports d'un projet, entrez le nom d'ID du projet ", "ID");
			if(projetID != null) {
				Operation.affichageProjet(projetID);
			}
			return true;
		case 4: 
			return true;
		case 5: 
			System.out.println("\tDéconnexion...");
			return false;
		default:
			System.out.println("Choix invalide.");
			return true;

		}
	}

	// Méthode pour debuter une activite
	public static boolean debuterActivite(String employeID) throws ParseException, IOException {
		String projetID = Operation.demanderID("Afin de commencer une activité, entrez le nom d'ID du projet ", "ID");
		int choix = menuActivite(projetID, employeID);

		if (choix == 6) {
			System.out.println("\tRetour au menu précédent...");
			return false;
		}

		String discipline = choixDiscipline(choix);

		// Vérifier si l'employé a déjà une activité en cours
		JSONArray tableau = TimeLog.jsonParser(TimeLog.activiteJSON);
		for (Object objet : tableau) {
			JSONObject element = (JSONObject) objet;
			String activiteEmployeID = (String) element.get("ID Employe");
			String activiteDiscipline = (String) element.get("Discipline de travail");
			String dateFin = (String) element.get("Date de fin");

			if (activiteEmployeID.equals(employeID) && dateFin.isEmpty() && !(choix == -0)) {
				System.out.println("Vous avez déjà une activité en cours. Veuillez la terminer avant de commencer une nouvelle activité.");
				return true;
			}

			if (activiteDiscipline.equals(discipline) && projetID.equals(element.get("ID Projet")) && dateFin.isEmpty()) {
				System.out.println("Cette activité a déjà été débutée pour ce projet.");
				return true;
			}
		}

		if (!(choix == -0)) {
			// Ajouter la nouvelle activité
			JSONObject nouvelleActivite = new JSONObject();
			nouvelleActivite.put("Nom de projet", TimeLog.valueJSON(TimeLog.projetJSON, "ID", projetID, "Nom"));
			nouvelleActivite.put("ID Projet", projetID);
			nouvelleActivite.put("ID Employe", employeID);
			nouvelleActivite.put("Discipline de travail", discipline);
			nouvelleActivite.put("Date de début", LocalDate.now().toString());
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			nouvelleActivite.put("Heure de début", LocalTime.now().format(timeFormatter));
			nouvelleActivite.put("Date de fin", "");
			nouvelleActivite.put("Heure de fin", "");

			TimeLog.ajouterElementTableau(TimeLog.activiteJSON, nouvelleActivite);
			System.out.println("L'activité '" + discipline + "' a été débutée le " + LocalDate.now() + " à " + LocalTime.now());
			System.out.println("\t----Modification accomplie!----");
			return true;
		} else {
			return false;
		}
	}


	// Méthode pour terminer une activite
	public static void terminerActivite(String employeID) throws ParseException, IOException {
		System.out.println("Avant de terminer une activite, veuillez vous authentifier: ");
		String ID = TimeLog.authentification();

		if(!(ID.equals(employeID))) {
			System.out.println("\tVous ne pouvez pas terminer l'activité d'une autre personne. ");
			return;
		}
		String projetID = Operation.demanderID("Afin de terminer une activité, entrez le nom d'ID du projet ", "ID");
		int choix = menuActivite(projetID, employeID);

		if (choix == 6) {
			System.out.println("\tRetour au menu précédent...");
			return;
		}

		String discipline = choixDiscipline(choix);
		JSONArray tableau = TimeLog.jsonParser(TimeLog.activiteJSON);
		boolean trouve = false;

		for (Object objet : tableau) {
			JSONObject element = (JSONObject) objet;
			String activiteEmployeID = (String) element.get("ID Employe");
			String activiteDiscipline = (String) element.get("Discipline de travail");
			String dateFin = (String) element.get("Date de fin");

			if (activiteEmployeID.equals(employeID) && activiteDiscipline.equals(discipline) && dateFin.isEmpty()) {
				element.put("Date de fin", LocalDate.now().toString());
				DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				element.put("Heure de fin", LocalTime.now().format(timeFormatter));
				trouve = true;
				break;
			}
		}

		if (trouve) {
			try (FileWriter file = new FileWriter(TimeLog.activiteJSON)) {
				file.write(tableau.toJSONString());
				file.flush();
			}
			System.out.println("L'activité '" + discipline + "' a été terminée le " + LocalDate.now() + " à " + LocalTime.now());
		} else {
			System.out.println("Aucune activité trouvée pour la discipline spécifiée.");
		}
	}


	// Methode pour le menu gestion Activite
	public static int menuActivite(String projetID, String employeID) throws ParseException, IOException {
		int choix = 0;
		if(projetID != null) {
			System.out.println("\n\nSur quelle discipline de travail allez-vous travailler? ");

			System.out.println("1. design1");
			System.out.println("2. design2");
			System.out.println("3. implémentation");
			System.out.println("4. test");
			System.out.println("5. déploiement");
			System.out.println("6. Retour au menu précedent");

			choix = choixUtilisateur();

		}
		return choix;
	}
	// Méthode pour obtenir la discipline depuis le choix de l'utilisateur
	private static String choixDiscipline(int choix) {
		switch (choix) {
		case 1: return "design1";
		case 2: return "design2";
		case 3: return "implémentation";
		case 4: return "test";
		case 5: return "déploiement";
		default: return "";
		}
	}

}
