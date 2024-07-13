package TimeLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import PayRoll.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TimeLog {

	public static void main(String[] args) throws ParseException {

		// Initialisation des bases de données employeJSON et projetJSON
		String employeJSON = getJSONFromFile("C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\ProjetFinal_INF1163\\bin\\FichierJSON\\employe.json");
		String projetJSON = getJSONFromFile("C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\ProjetFinal_INF1163\\bin\\FichierJSON\\projet.json");
		
		// Affichage initial
		System.out.println("Bonjour, bienvenue dans l'environnement TimeLog.");
		Scanner scan = new Scanner(System.in);
		String username;
		String mdp;
		
		// Début de l'authentification
		while (true) { // Vérification du nom d'usager
			try {
				System.out.println("\nAfin de procéder à l'authentification de l'utilisateur, veuillez entrer votre nom d'utilisateur.");
				username = scan.nextLine();
				if(!verificationJSON(employeJSON, "Nom d'usager", username)) {
					System.out.println("Votre nom d'usager ne fait pas partie de notre base de donnée. Veuillez ré-ecrire à nouveau votre nom d'usager SVP.");
					continue;
				}
				while (true) { // Vérification du mot de passe
					try {
						System.out.println("\nAfin de valider votre connection, veuillez entrer votre mot de passe (P.S. Votre mot de passe est votre ID d'employé)");
						System.out.println("Si vous souhaitez retourner à l'insertion du nom d'utilisateur, veuillez entrer 9");
						mdp = scan.nextLine();
						if(mdp.equals("9")) {
							break;
						} else if(!verificationJSON(employeJSON, "ID", mdp)) {
							System.out.println("Votre mot de passe est incorrect. Veuillez ré-ecrire à nouveau votre mot de passe.");
							continue;
						}
						break;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(mdp.equals("9")) {
					continue;
				}
				break;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ***Fin Authentification***
		
		// Affichage après authentification
		System.out.println("Bonjour, "+ username+". Votre demande d'authentification a été validé.");
		System.out.println("Que souhaitez-vous accomplir? Veuillez choisir une opération du menu en utilisant les touches interactives. ");
		
		// Cas ou l'utilisateur est ou n'est pas un admin
		if(!username.equals("admin")) {
			
		} else {
			
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

	// Methode qui affiche la valeur precise d'une cle dans un fichier JSON
	public static String affichageJSON(String fichier, int index, String cle) throws ParseException {
		JSONArray tableau = JSONParser(fichier);
        
		JSONObject element = (JSONObject) tableau.get(index);
		String valeur = (String) element.get(cle);
		return valeur;
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
	
}
