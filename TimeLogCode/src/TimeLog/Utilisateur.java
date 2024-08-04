package TimeLog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Utilisateur {

	// ---------------Attributs---------------
	private String nom;
	private String ID;
	private String SIN; // Assurance social composé de 9 chiffres
	private String poste;
	
	// ---------------Constructeur---------------
	Utilisateur(String nom, String ID, String SIN, String poste){
		this.nom = nom;
		this.ID = ID;
		this.SIN = SIN;
		this.poste = poste;
	}
	
	// ---------------Getters---------------
	public String getID() {
		return this.ID;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getSIN() {
		return this.SIN;
	}
	
	public String getPoste() {
		return this.poste;
	}
	
	// ---------------Setters---------------
	public void setNom(String newNom) {
		this.nom = newNom;
	}
	
	public void setID(String newID) {
		this.ID = newID;
	}
	
	public void setSIN(String newSIN) {
		this.SIN = newSIN;
	}
	
	public void setPoste(String newPoste) {
		this.poste = newPoste;
	}
	
	// ---------------Methode---------------
	// Methode pour l'authentification
	public static Utilisateur authentification() throws ParseException, IOException {
		Scanner scan = new Scanner(System.in);
	    String mdp;
	    String username;

	    Employe employe = new Employe(null, null, null, null, null, null, null, null);
	    Administrateur admin = new Administrateur(null, null, null, null);

	    // Début de l'authentification
	    while (true) { // Vérification du nom d'usager
	        try {
	            System.out.println("\nAfin de procéder à l'authentification de l'utilisateur, veuillez entrer votre nom d'utilisateur.");
	            username = scan.nextLine();

	            // Vérifier si le nom d'usager est présent dans la base de données
	            if (!Operation.verificationJSON(TimeLog.employe, "Nom d'usager", username)) {
	                System.out.println("Votre nom d'usager ne fait pas partie de notre base de donnée. Veuillez ré-ecrire à nouveau votre nom d'usager SVP.");
	                continue;
	            }

	            while (true) { // Vérification du mot de passe
	                try {
	                    System.out.println("\nAfin de valider votre connection, veuillez entrer votre mot de passe (P.S. Votre mot de passe est votre ID d'employé)");
	                    System.out.println("\t[Si vous souhaitez retourner à l'insertion du nom d'utilisateur, veuillez entrer -0]");
	                    mdp = scan.nextLine();

	                    if (mdp.equals("-0")) {
	                        break;
	                    }

	                    // Vérifier la correspondance entre le mot de passe et le nom d'usager
	                    String retrievedUsername = Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "Nom d'usager");
	                    if (retrievedUsername == null || !retrievedUsername.equals(username)) {
	                        System.out.println("Votre mot de passe est incorrect. Veuillez ré-ecrire à nouveau votre mot de passe.");
	                        continue;
	                    }

	                    if (username.equals("admin")) {
	                        admin.setNom(username);
	                        admin.setID(mdp);
	                        admin.setSIN(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "SIN"));
	                        admin.setPoste(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "Poste"));
	                    } else {
	                        HashMap<String, Integer> tauxHoraires = Operation.tauxHistoriques(TimeLog.employeJSON, mdp);
	                        employe.setNom(username);
	                        employe.setID(mdp);
	                        employe.setSIN(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "SIN"));
	                        employe.setPoste(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "Poste"));
	                        employe.setDateEmbauche(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "Date d'embauche"));
	                        employe.setTauxHorairesHistorique(tauxHoraires);
	                        employe.setTauxTempSupp(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "Taux temps supplémentaire"));
	                        employe.setPossibleDateDepart(Operation.valueJSON(TimeLog.employeJSON, "ID", mdp, "Possible date de départ"));
	                    }
	                    break;

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            if (mdp.equals("-0")) {
	                continue;
	            }
	            break;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    Utilisateur utilisateur;
	    if (username.equals("admin")) {
	        utilisateur = admin;
	    } else {
	        utilisateur = employe;
	    }

	    return utilisateur;
	}
}
