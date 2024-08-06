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
	private static Utilisateur utilisateur;

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
	public static void affichageMenu(Utilisateur utilisateur, String employeID) throws ParseException, IOException {
		if(utilisateur instanceof Administrateur) {
			affichageMenuAdmin();
		} else if (utilisateur instanceof Employe) {
			affichageMenuEmploye(employeID);
		}
	}

	// Méthode pour l'affichage du menu admin MENU
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
	// Méthode pour l'affichage du menu employé MENU
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

	// Méthode pour le menu de la gestion utilisateur MENU
	public static void menuGestionUtilisateur() throws ParseException, IOException {
			while(true) {
				System.out.println("\t----Menu de la gestion des utilisateurs----");

				System.out.println("\n1. Changer le nom usager d'un utilisateur");
				System.out.println("2. Changer le ID (et mdp) d'un utilisateur");
				System.out.println("3. Assigner un projet à employé");
				System.out.println("4. Ajouter un employé de la liste");
				System.out.println("5. Supprimer un employé de la liste");
				System.out.println("6. Modifier le poste");
				System.out.println("7. Affichage des caractéristiques d'un employé");
				System.out.println("8. Retour au menu précédent");

				int choix = choixUtilisateur();
				if(!gererUtilisateur(choix)) {
					break;
				}
			}
		}
	
	// Méthode pour le menu de la gestion projets MENU
	public static void menuGestionProjet() throws ParseException, IOException {
			while(true) {
				System.out.println("\t----Menu de la gestion des projets----");

				System.out.println("\n1. Changer le nom usager d'un projet");
				System.out.println("2. Changer le ID d'un projet");
				System.out.println("3. Modifier les détails des disciplines d'activités");
				System.out.println("4. Modifier le rapport d'état");
				System.out.println("5. Affichage des caractéristiques d'un projet");
				System.out.println("6. Retour au menu précédent");

				int choix = Menu.choixUtilisateur();
				if(!gererProjet(choix)) {
					break;
				}
			}
		}
	
	// Methode pour le menu gestion Activite MENU
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
		
	// Méthode pour gérer les utilisateur MENU
	public static boolean gererUtilisateur(int choix) throws ParseException, IOException {

			Scanner scan = new Scanner(System.in); // Initialisation variable
			String userID;

			switch(choix) {
			case 1: 
				userID = Operation.demanderID("Veuillez entrer l'ID de l'utilisateur afin de modifier son nom d'usager. ", "ID");

				if(userID != null) {
					String oldUsername = Operation.valueJSON(TimeLog.employeJSON, "ID", userID, "Nom d'usager");
					System.out.println("Veuillez écrire le nouveau nom d'usager de cet employé. ");
					String username = scan.nextLine();
					Operation.modifierEmploye(TimeLog.employe, "Nom d'usager", oldUsername, username);
				}
				return true;
			case 2:
				userID = Operation.demanderID("Veuillez entrez le ID de l'utilisateur afin de modifier son mot de passe. \n**Le ID d'un employé est son mot de passe**", "ID");

				if(userID != null) {
					String oldID = Operation.valueJSON(TimeLog.employeJSON, "ID", userID, "ID");
					System.out.println("Veuillez ecrire le nouveau mot de passe de cet employé.");
					String newID = scan.nextLine();
					Operation.modifierEmploye(TimeLog.employe, "ID", oldID, newID);
				}
				return true;
			case 3:
				userID = Operation.demanderID("Veuillez entrez le ID de l'utilisateur afin de modifier ou d'ajouter le projet assigné à un employé. ", "ID");

				if(userID != null) {
					String oldProjet = Operation.valueJSON(TimeLog.employeJSON, "ID", userID, "Projet assigné");
					if(oldProjet == null) {
						System.out.println("Cet employé n'as pas de projet assigné");
					}
					System.out.println("Veuillez ecrire l'ID du projet a assigner");
					String newProjet = scan.nextLine();
					Operation.modifierEmploye(TimeLog.employe, "Projet assigné", oldProjet, newProjet);
				}
				return true;
			case 4:
				JSONObject newEmploye = new JSONObject();
				System.out.println("[Si vous souhaitez retourner au menu précédent, veuillez écrire -0]");
				String rep = scan.nextLine();
				if(rep.equals("-0")) {return true;}

				System.out.println("Quelle est le nom d'usager de cet employé? ");
				String username = scan.nextLine();

				System.out.println("Quelle est l'ID de cet employé? ");
				String ID = scan.nextLine();

				newEmploye.put("Nom d'usager", username);
				newEmploye.put("ID", ID);

				Operation.ajouterElementTableau(TimeLog.employeJSON, newEmploye);
				System.out.println(username+" a été ajouté");
				return true;
			case 5:
				userID = Operation.demanderID("Quelle est le nom d'ID de l'employé a supprimer de la liste d'employé? ", "ID");

				if(userID != null) {
					username = Operation.valueJSON(TimeLog.employeJSON, "ID", userID, "Nom d'usager");
					Operation.supprimerElementTableau(TimeLog.employeJSON, "ID", userID);
					System.out.println("L'employé "+username+" est supprime de la liste d'employé. ");
				}
				return true;
			case 6:
				userID = Operation.demanderID("Afin de modifier son poste, entrez le nom d'ID de l'employé. ", "ID");
				if(userID != null) {
					String oldPoste = Operation.valueJSON(TimeLog.employeJSON, "ID", userID, "Poste");
					System.out.println("Veuillez ecrire le nouveau poste de cet employé.");
					String newPoste = scan.nextLine();
					Operation.modifierEmploye(TimeLog.employe, "Poste", oldPoste, newPoste);
				}
				return true;
			case 7: 
				userID = Operation.demanderID("Afin d'afficher les caractéristiques d'un employé, entrez le nom d'ID de l'employé. ", "ID");
				if(userID != null) {
					Operation.affichageUtilisateur(userID);
				}
				return true;
			case 8:
				System.out.println("\tRetour au menu précédent...");
				return false;
			default:
				System.out.println("Choix invalide.");
				return true;
			}
		}
	
	// Méthode pour gérer les projets MENU
	public static boolean gererProjet(int choix) throws ParseException, IOException {
			Scanner scan = new Scanner(System.in); // Initialisation variable
			String projetID;

			switch(choix) {
			case 1: 
				projetID = Operation.demanderID("Veuillez entrer l'ID du projet afin de modifier son nom. ", "ID");

				if(projetID != null) {
					String oldName = Operation.valueJSON(TimeLog.projetJSON, "ID", projetID, "Nom");
					System.out.println("Veuillez écrire le nouveau nom de ce projet. ");
					String newName = scan.nextLine();
					Operation.modifierProjet(TimeLog.projetJSON, "Nom", oldName, newName);
				}
				return true;
			case 2: 
				return true;
			case 3: 
				return true;
			case 4: 
				return true;
			case 5: 
				projetID = Operation.demanderID("Afin d'afficher les caractéristiques d'un projet, entrez le nom d'ID du projet ", "ID");
				if(projetID != null) {
					Operation.affichageProjet(projetID);
				}
				return true;
			case 6:
				System.out.println("\tRetour au menu précédent...");
				return false;
			default:
				System.out.println("Choix invalide.");
				return true;
			}
		}
	
	// Méthode pour gérer le choix admin MENU
	public static boolean gererChoixAdmin(int choix) throws ParseException, IOException {
		switch(choix) {
		case 1: 
			menuGestionUtilisateur();
			return true;
		case 2: 
			menuGestionProjet();
			return true;
		case 3: 
			menuGestionUtilisateur();
			return true;
		case 4: 
			System.out.println("\tDéconnexion...");
			return false;
		default:
			System.out.println("Choix invalide.");
			return true;

		}
	}

	// Méthode pour gérer le choix employé MENU
	public static boolean gererChoixEmploye(int choix, String employeID) throws ParseException, IOException {
		switch(choix) {
		case 1: 
			Operation.debuterActivite(employeID);
			return true;
		case 2: 
			Operation.terminerActivite(employeID);
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

	// Méthode pour obtenir choix de l'utilisateur OPERATION
	public static int choixUtilisateur() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Entrez votre choix: ");
			return scan.nextInt();
		}
	
	// Méthode pour obtenir la discipline depuis le choix de l'utilisateur MENU
	public static String choixDiscipline(int choix) {
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
