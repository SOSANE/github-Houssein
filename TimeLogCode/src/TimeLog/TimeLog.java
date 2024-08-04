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


	static String employe = Operation.getJSONFromFile(employeJSON); 
	static String projet = Operation.getJSONFromFile(projetJSON);	
	static String activite = Operation.getJSONFromFile(activiteJSON);

	public static void main(String[] args) throws ParseException, IOException {
		
		// Affichage initial
		System.out.println("Bonjour, bienvenue dans l'environnement TimeLog.");

		Utilisateur utilisateur = Utilisateur.authentification();
		String ID = utilisateur.getID();
		String username = utilisateur.getNom();

		// Affichage après authentification
		System.out.println("\nBonjour, "+ username+". Votre demande d'authentification a été validé.");
		System.out.println("Que souhaitez-vous accomplir? Veuillez choisir une opération du menu en utilisant la ligne de commande. ");
		
		Menu.affichageMenu(utilisateur, ID);
		
	}
}
