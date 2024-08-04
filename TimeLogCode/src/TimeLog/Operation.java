package TimeLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Operation {

	// Méthode pour debuter une activite OPERATION
	public static boolean debuterActivite(String employeID) throws ParseException, IOException {
		String projetID = Operation.demanderID("Afin de commencer une activité, entrez le nom d'ID du projet ", "ID");
		int choix = Menu.menuActivite(projetID, employeID);

		if (choix == 6) {
			System.out.println("\tRetour au menu précédent...");
			return false;
		}

		String discipline = Menu.choixDiscipline(choix);

		JSONArray tableau = jsonParser(TimeLog.activiteJSON);
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

			JSONObject nouvelleActivite = new JSONObject();
			nouvelleActivite.put("Nom de projet", valueJSON(TimeLog.projetJSON, "ID", projetID, "Nom"));
			nouvelleActivite.put("ID Projet", projetID);
			nouvelleActivite.put("ID Employe", employeID);
			nouvelleActivite.put("Discipline de travail", discipline);
			nouvelleActivite.put("Date de début", LocalDate.now().toString());
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			nouvelleActivite.put("Heure de début", LocalTime.now().format(timeFormatter));
			nouvelleActivite.put("Date de fin", "");
			nouvelleActivite.put("Heure de fin", "");

			ajouterElementTableau(TimeLog.activiteJSON, nouvelleActivite);
			System.out.println("L'activité '" + discipline + "' a été débutée le " + LocalDate.now() + " à " + LocalTime.now());
			System.out.println("\t----Modification accomplie!----");
			return true;
		} else {
			return false;
		}
	}

	// Méthode pour terminer une activite OPERATION
	public static void terminerActivite(String employeID) throws ParseException, IOException {
		System.out.println("Avant de terminer une activite, veuillez vous authentifier: ");
		Utilisateur utilisateur = Utilisateur.authentification();
		String ID = utilisateur.getID();

		if(!(ID.equals(employeID))) {
			System.out.println("\tVous ne pouvez pas terminer l'activité d'une autre personne. ");
			return;
		}
		String projetID = Operation.demanderID("Afin de terminer une activité, entrez le nom d'ID du projet ", "ID");
		int choix = Menu.menuActivite(projetID, employeID);

		if (choix == 6) {
			System.out.println("\tRetour au menu précédent...");
			return;
		}

		String discipline = Menu.choixDiscipline(choix);
		JSONArray tableau = jsonParser(TimeLog.activiteJSON);
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

	// Methode pour modifier une caracteristique d'un employe a partir d'une cle OPERATION
	public static void modifierEmploye(String fichier, String cle, String oldValue, String newValue) throws IOException, ParseException {
		JSONArray tableau = JSONParser(fichier);

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

	// Methode pour modifier une caracteristique d'un employe a partir d'une cle OPERATION
	public static void modifierProjet(String fichier, String cle, String ID, String newValue) throws IOException, ParseException {
		JSONArray tableau = JParser(fichier);

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
	
	// Methode pour demander l'ID OPERATION
	public static String demanderID(String message, String cleID) throws ParseException {
		Scanner scan = new Scanner(System.in);
		String userID;
		while (true) {
			System.out.println("\n\n" + message);
			System.out.println("[Si vous souhaitez retourner au menu précédent, veuillez écrire -0]");
			userID = scan.nextLine();
			if (userID.equals("-0")) {
				return null;
			} else if (!verificationJSON(TimeLog.employe, cleID, userID)) {
				System.out.println(userID + " n'est pas un ID valide");
			} else {
				return userID;
			}
		}
	}

	// Methode pour l'affichage des caractéristiques d'un employé 
	public static void affichageUtilisateur(String ID) throws IOException, ParseException {
		JSONArray tableau = JParser(TimeLog.employeJSON);
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
		Set<String> cles = element.keySet();
		System.out.println();
		for (String cle : cles) {
			Object valeur = element.get(cle);
			System.out.println(cle + ": " + valeur);
		}
	}

	// Methode pour l'affichage des caractéristiques d'un projet
	public static void affichageProjet(String ID) throws IOException, ParseException {
		JSONArray tableau = JParser(TimeLog.projetJSON);
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
		Set<String> cles = projet.keySet();

		for (String cle : cles) {
			Object valeur = projet.get(cles);
			if (valeur instanceof JSONObject) {
				System.out.println(cle + ": ");
				afficherDetails((JSONObject) valeur);
			} else if (valeur instanceof JSONArray) {
				System.out.println("\t"+ cle + ": ");
				afficherDetails((JSONArray) valeur);
			} else {
				System.out.println("\t\t"+cle + ": " + valeur);
			}
		}
	}
	
	// Methode driver pour affichageProjet()
	private static void afficherDetails(JSONArray tableau) {
		for (Object objet : tableau) {
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

	// Methode qui supprime un element a un tableau
	public static void supprimerElementTableau(String fichier, String cle, String valeur) throws IOException, ParseException {
			JSONArray tableau = JParser(fichier);

			for (int i = 0; i < tableau.size(); i++) {
				JSONObject element = (JSONObject) tableau.get(i);
				if (element.containsKey(cle) && element.get(cle).equals(valeur)) {
					tableau.remove(i);
					break; 
				}
			}

			String jsonString = tableau.toJSONString();

			try (FileWriter file = new FileWriter(fichier)) {
				file.write(jsonString);
				file.flush();
			}
		}

	// Methode qui ajoute un element a un tableau
	public static void ajouterElementTableau(String fichier, JSONObject element) throws ParseException, IOException {
			JSONArray tableau = JParser(fichier);
			tableau.add(element);

			String JSONString = tableau.toJSONString();

			try (FileWriter file = new FileWriter(fichier)) {
				file.write(JSONString);
				file.flush();
			}
		}


	// Methode pour extraire les informations du fichier JSON
	public static String getJSONFromFile(String filename) {
		String jsonText = "";
		try {
			BufferedReader bufferedReader = new BufferedReader (new FileReader(filename));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				jsonText += line + "\n";
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonText;
	}

	// Methode pour obtenir le tableau d'un fichier JSON
	public static JSONArray JSONParser(String fichier) throws ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(fichier);
		JSONArray tableau = (JSONArray) object;
		return tableau;
	}

	public static JSONArray JParser(String fichier) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(fichier);
		JSONArray tableau = (JSONArray) parser.parse(reader);
		reader.close();
		return tableau;
	}

	public static JSONArray jsonParser(String fichier) throws ParseException, IOException {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader(fichier)) {
			Object object = parser.parse(reader);
			JSONArray tableau = (JSONArray) object;
			return tableau;
		} catch (IOException | ParseException e) {
			System.err.println("Erreur lors de la lecture ou de l'analyse du fichier JSON: " + e.getMessage());
			throw e;
		}
	}

	// Methode pour obtenir la valeur precise d'une cle dans un fichier JSON
	public static String valueJSON(String cheminFichier, String cleID, String valeurID, String cleValeur) throws ParseException, IOException {
		  JSONParser parser = new JSONParser();
	        FileReader reader = new FileReader(cheminFichier);
	        JSONArray tableau = (JSONArray) parser.parse(reader);
	        reader.close();

	        for (Object obj : tableau) {
	            JSONObject employe = (JSONObject) obj;
	            Object idObject = employe.get(cleID);

	            if (idObject != null && idObject.toString().equals(valeurID)) {
	                Object valueObject = employe.get(cleValeur);
	                if (valueObject instanceof String) {
	                    return (String) valueObject;
	                } else if (valueObject instanceof Long) {
	                    return Long.toString((Long) valueObject);
	                }
	               
	                return valueObject != null ? valueObject.toString() : null;
	            }
	        }

	        return null;
	    }
	
	// Methode qui retourne un boolean qui verifie l'existence d'une valeur dans un fichier JSON
	public static boolean verificationJSON(String fichier, String cle, String valeurACherche) throws ParseException{
		JSONArray tableau = JSONParser(fichier);

		for (int i = 0; i < tableau.size(); i++) { // Itération du tableau
			JSONObject element = (JSONObject) tableau.get(i);
			String valeur = (String) element.get(cle);

			if(valeur.equals(valeurACherche)) {
				return true;
			}
		}
		return false;
	}
	
	// Methode qui verifie l'existence d'une cle
	public static boolean verificationCleJSON(String fichier, String cle) throws ParseException, IOException {
		JSONArray tableau = JParser(fichier);

		for (Object obj : tableau) {
			JSONObject element = (JSONObject) obj;

			if (element.containsKey(cle)) {
				return true;
			}
		}
		return false;
	}

	// Methode pour convertir les taux historiques dans le fichier JSON en HashMap<>
	public static HashMap<String, Integer> tauxHistoriques(String jsonFilePath, String employeeId) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        
        FileReader reader = new FileReader(jsonFilePath);
        JSONArray jsonArray = (JSONArray) parser.parse(reader);
        
        HashMap<String, Integer> tauxHorairesHistorique = new HashMap<>();
        
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            
            String id = (String) jsonObject.get("ID");
            if (employeeId.equals(id)) {
                JSONObject tauxHoraireHistorique = (JSONObject) jsonObject.get("Taux horaire historique");
                
                if (tauxHoraireHistorique != null) {
                    for (Object cle : tauxHoraireHistorique.keySet()) {
                        String date = (String) cle;
                        Integer taux = ((Long) tauxHoraireHistorique.get(cle)).intValue();
                        tauxHorairesHistorique.put(date, taux);
                    }
                }
                
                break;
            }
        }
        
        return tauxHorairesHistorique;
    }
}
