package TimeLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import PayRoll.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Reader;
public class TimeLog {
	// Initialisation des bases de données employeJSON et projetJSON
	static String employeJSON = "C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\TimeLogCode\\src\\FichierJSON\\employe.json"; // Veuillez insérer le chemin d'accès correspondant sur votre machine
	static String projetJSON = "C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\TimeLogCode\\src\\FichierJSON\\projet.json";
	static String activiteJSON = "C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\TimeLogCode\\src\\FichierJSON\\activite.json";


	static String employe = getJSONFromFile(employeJSON); 
	static String projet = getJSONFromFile(projetJSON);	
	static String activite = getJSONFromFile(activiteJSON);

	public static void main(String[] args) throws ParseException, IOException {
		// Affichage initial
		System.out.println("Bonjour, bienvenue dans l'environnement TimeLog.");

		String ID = authentification();
		String username = valueJSON(employeJSON, "ID", ID, "Nom d'usager");


		System.out.println("\nBonjour, "+ username+". Votre demande d'authentification a été validé.");
		// Affichage après authentification
		System.out.println("Que souhaitez-vous accomplir? Veuillez choisir une opération du menu en utilisant la ligne de commande. ");

		if(ID.equals("0")) {
			Menu.affichageMenuAdmin();
		} else {
			Menu.affichageMenuEmploye(ID);
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

	public static String valueJSON(String cheminFichier, String cleID, String valeurID, String cleValeur) throws ParseException, IOException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(cheminFichier);
		JSONArray tableau = (JSONArray) parser.parse(reader);
		reader.close();

		for (Object obj : tableau) {
			JSONObject employe = (JSONObject) obj;
			String id = (String) employe.get(cleID);

			if (id != null && id.equals(valeurID)) {
				return (String) employe.get(cleValeur);
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

	// Methode pour l'authentification
	public static String authentification() {
		Scanner scan = new Scanner(System.in);
		String mdp;
		String username;
		// Début de l'authentification
		while (true) { // Vérification du nom d'usager
			try {
				System.out.println("\nAfin de procéder à l'authentification de l'utilisateur, veuillez entrer votre nom d'utilisateur.");
				username = scan.nextLine();
				if(!verificationJSON(employe, "Nom d'usager", username)) {
					System.out.println("Votre nom d'usager ne fait pas partie de notre base de donnée. Veuillez ré-ecrire à nouveau votre nom d'usager SVP.");
					continue;
				}
				while (true) { // Vérification du mot de passe
					try {
						System.out.println("\nAfin de valider votre connection, veuillez entrer votre mot de passe (P.S. Votre mot de passe est votre ID d'employé)");
						System.out.println("\t[Si vous souhaitez retourner à l'insertion du nom d'utilisateur, veuillez entrer -0]");
						mdp = scan.nextLine();
						if(mdp.equals("-0")) {
							break;
						} else if(!verificationJSON(employe, "ID", mdp)) {
							System.out.println("Votre mot de passe est incorrect. Veuillez ré-ecrire à nouveau votre mot de passe.");
							continue;
						}
						break;

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(mdp.equals("-0")) {
					continue;
				}
				break;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ***Fin Authentification***

		return mdp;
	}
}
