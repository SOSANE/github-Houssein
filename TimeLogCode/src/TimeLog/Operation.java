package TimeLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Operation {

	public static void main(String[] args) throws IOException, ParseException {

		//menuGestionUtilisateur();
		//Menu.affichageMenuEmploye("-1");
	}

	// Méthode pour le menu de la gestion utilisateur
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

			int choix = Menu.choixUtilisateur();
			if(!gererUtilisateur(choix)) {
				break;
			}
		}
	}

	// Méthode pour la gestion projets
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

	// Méthode pour gérer les projets
	public static boolean gererProjet(int choix) throws ParseException, IOException {
		Scanner scan = new Scanner(System.in); // Initialisation variable
		String projetID;

		switch(choix) {
		case 1: 
			projetID = demanderID("Veuillez entrer l'ID du projet afin de modifier son nom. ", "ID");

			if(projetID != null) {
				String oldName = TimeLog.valueJSON(TimeLog.projetJSON, "ID", projetID, "Nom");
				System.out.println("Veuillez écrire le nouveau nom de ce projet. ");
				String newName = scan.nextLine();
				modifierProjet(TimeLog.projetJSON, "Nom", oldName, newName);
			}
			return true;
		case 2: 
			return true;
		case 3: 
			return true;
		case 4: 
			return true;
		case 5: 
			projetID = demanderID("Afin d'afficher les caractéristiques d'un projet, entrez le nom d'ID du projet ", "ID");
			if(projetID != null) {
				affichageProjet(projetID);
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

	// Méthode pour la gestion discipline
	public static void menuGestionDiscipline() {
		while(true) {

		}

	}

	// Méthode pour gérer les utilisateur
	public static boolean gererUtilisateur(int choix) throws ParseException, IOException {

		Scanner scan = new Scanner(System.in); // Initialisation variable
		String userID;

		switch(choix) {
		case 1: 
			userID = demanderID("Veuillez entrer l'ID de l'utilisateur afin de modifier son nom d'usager. ", "ID");

			if(userID != null) {
				String oldUsername = TimeLog.valueJSON(TimeLog.employeJSON, "ID", userID, "Nom d'usager");
				System.out.println("Veuillez écrire le nouveau nom d'usager de cet employé. ");
				String username = scan.nextLine();
				modifierEmploye(TimeLog.employe, "Nom d'usager", oldUsername, username);
			}
			return true;
		case 2:
			userID = demanderID("Veuillez entrez le ID de l'utilisateur afin de modifier son mot de passe. \n**Le ID d'un employé est son mot de passe**", "ID");

			if(userID != null) {
				String oldID = TimeLog.valueJSON(TimeLog.employeJSON, "ID", userID, "ID");
				System.out.println("Veuillez ecrire le nouveau mot de passe de cet employé.");
				String newID = scan.nextLine();
				modifierEmploye(TimeLog.employe, "ID", oldID, newID);
			}
			return true;
		case 3:
			userID = demanderID("Veuillez entrez le ID de l'utilisateur afin de modifier ou d'ajouter le projet assigné à un employé. ", "ID");

			if(userID != null) {
				String oldProjet = TimeLog.valueJSON(TimeLog.employeJSON, "ID", userID, "Projet assigné");
				if(oldProjet == null) {
					System.out.println("Cet employé n'as pas de projet assigné");
				}
				System.out.println("Veuillez ecrire l'ID du projet a assigner");
				String newProjet = scan.nextLine();
				modifierEmploye(TimeLog.employe, "Projet assigné", oldProjet, newProjet);
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

			TimeLog.ajouterElementTableau(TimeLog.employeJSON, newEmploye);
			System.out.println(username+" a été ajouté");
			return true;
		case 5:
			userID = demanderID("Quelle est le nom d'ID de l'employé a supprimer de la liste d'employé? ", "ID");

			if(userID != null) {
				username = TimeLog.valueJSON(TimeLog.employeJSON, "ID", userID, "Nom d'usager");
				TimeLog.supprimerElementTableau(TimeLog.employeJSON, "ID", userID);
				System.out.println("L'employé "+username+" est supprime de la liste d'employé. ");
			}
			return true;
		case 6:
			userID = demanderID("Afin de modifier son poste, entrez le nom d'ID de l'employé. ", "ID");
			if(userID != null) {
				String oldPoste = TimeLog.valueJSON(TimeLog.employeJSON, "ID", userID, "Poste");
				System.out.println("Veuillez ecrire le nouveau poste de cet employé.");
				String newPoste = scan.nextLine();
				modifierEmploye(TimeLog.employe, "Poste", oldPoste, newPoste);
			}
			return true;
		case 7: 
			userID = demanderID("Afin d'afficher les caractéristiques d'un employé, entrez le nom d'ID de l'employé. ", "ID");
			if(userID != null) {
				affichageUtilisateur(userID);
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

	// Methode pour modifier une caracteristique d'un employe a partir d'une cle
	public static void modifierEmploye(String fichier, String cle, String oldValue, String newValue) throws IOException, ParseException {
		JSONArray tableau = TimeLog.JSONParser(fichier);

		for(Object empObject : tableau) {
			JSONObject employe = (JSONObject) empObject;
			String valeur = (String) employe.get(cle);

			if(valeur.equals(oldValue)) {
				employe.put(cle, newValue);
				break;
			}
		}

		try (FileWriter writer = new FileWriter(TimeLog.employeJSON)) {
			writer.write(tableau.toJSONString());
		}

		System.out.println("\t----Modification accomplie!----");
	}

	// Methode pour modifier une caracteristique d'un employe a partir d'une cle
	public static void modifierProjet(String fichier, String cle, String ID, String newValue) throws IOException, ParseException {
		JSONArray tableau = TimeLog.JParser(fichier);

		for (Object obj : tableau) {
			JSONObject projet = (JSONObject) obj;
			String projetID = (String) projet.get("ID");

			if (projetID.equals(ID)) {
				if (projet.containsKey(cle)) {
					projet.put(cle, newValue);
					break;
				} else {
					System.out.println("Clé " + cle + " non trouvée dans le projet avec ID: " + ID);
					return;
				}
			}
		}

		ecrireJSONFile(fichier, tableau);
	}
	// Methode pour demander l'ID
	public static String demanderID(String message, String cleID) throws ParseException {
		Scanner scan = new Scanner(System.in);
		String userID;
		while (true) {
			System.out.println("\n\n" + message);
			System.out.println("[Si vous souhaitez retourner au menu précédent, veuillez écrire -0]");
			userID = scan.nextLine();
			if (userID.equals("-0")) {
				return null;
			} else if (!TimeLog.verificationJSON(TimeLog.employe, cleID, userID)) {
				System.out.println(userID + " n'est pas un ID valide");
			} else {
				return userID;
			}
		}
	}

	// Methode pour l'affichage des caractéristiques d'un employé
	public static void affichageUtilisateur(String ID) throws IOException, ParseException {
		JSONArray tableau = TimeLog.JParser(TimeLog.employeJSON);
		for (Object objet : tableau) {
			JSONObject employe = (JSONObject) objet;
			String employeID = (String) employe.get("ID");

			if(employeID.equals(ID)) {
				System.out.println("\n\nCaractéristique de l'ID "+employeID+ ": ");
				driverAffichageFichier(employe);
				return;
			}
		}

	}

	// Methode driver pour affichageUtilisateur() et affichageProjet()
	public static void driverAffichageFichier(JSONObject element) {
		Set<String> keys = element.keySet();
		System.out.println();
		for (String key : keys) {
			Object value = element.get(key);
			System.out.println(key + ": " + value);
		}
	}

	// Methode pour l'affichage des caractéristiques d'un projet
	public static void affichageProjet(String ID) throws IOException, ParseException {
		JSONArray tableau = TimeLog.JParser(TimeLog.projetJSON);
		for (Object objet : tableau) {
			JSONObject projet = (JSONObject) objet;
			String projetID = (String) projet.get("ID");

			if (projetID.equals(ID)) {
				System.out.println("Caractéristiques du projet avec ID: " + ID);
				afficherDetails(projet);
				return;
			}
		}
	}
	// Methode driver pour affichageProjet()
	private static void afficherDetails(JSONObject projet) {
		Set<String> keys = projet.keySet();

		for (String key : keys) {
			Object value = projet.get(key);
			if (value instanceof JSONObject) {
				System.out.println(key + ": ");
				afficherDetails((JSONObject) value);
			} else if (value instanceof JSONArray) {
				System.out.println("\t"+ key + ": ");
				afficherDetails((JSONArray) value);
			} else {
				System.out.println("\t\t"+key + ": " + value);
			}
		}
	}
	// Methode driver pour affichageProjet()
	private static void afficherDetails(JSONArray array) {
		for (Object objet : array) {
			if (objet instanceof JSONObject) {
				afficherDetails((JSONObject) objet);
			} else {
				System.out.println(objet);
			}
		}
	}

	// Methode pour ecrire un tableau dans un fichierJSON
	public static void ecrireJSONFile(String fichier, JSONArray tableau) throws IOException {
		try (FileWriter file = new FileWriter(fichier)) {
			file.write(tableau.toJSONString());
			file.flush();
		}
	}
}
