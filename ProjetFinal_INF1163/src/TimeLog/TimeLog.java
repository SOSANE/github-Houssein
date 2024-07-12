package TimeLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import PayRoll.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class TimeLog {

	public static void main(String[] args) {
		String employeJSON = getJSONFromFile("C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\ProjetFinal_INF1163\\bin\\Database\\employe.json");
		String projetJSON = getJSONFromFile("C:\\Users\\sosan\\OneDrive\\Documents\\GitHub\\github-Houssein\\ProjetFinal_INF1163\\bin\\Database\\projet.json");
		
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(employeJSON);
			JSONObject mainJSONObject = (JSONObject) object;
			
			JSONArray employe = (JSONArray) mainJSONObject.get("employe");
			JSONObject firstEmploye = (JSONObject) employe.get(0);
			String nomUsager = (String) firstEmploye.get("nomUsager");
			System.out.println("Nom d'usager: " + nomUsager);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Bonjour, bienvienue dans l'environnement TimeLog.");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nAfin de procéder à l'authentification de l'utilisateur, veuillez entrez votre nom d'utilisateur: ");
		
		
		
		while (true) {
			try {
				String username = scan.nextLine();
				break;
			} catch (Exception e) {

			}
		}
		
		
	}
	
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

}
