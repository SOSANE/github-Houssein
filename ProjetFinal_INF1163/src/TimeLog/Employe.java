package TimeLog;
import java.util.HashMap;
import PayRoll.*;

public class Employe {
	
	// ---------------Attributs---------------
	private int ID;
	private String nom;
	private String dateEmbauche; // Format: 7/12/2024 = 12 juillet 2024
	private int SIN; // Assurance social composé de 9 chiffres
	private String poste; // Poste de l'employé
	private HashMap<String, Integer> tauxHorairesHistorique; // La clé est la date, la valeur est le taux horaire
	private int tauxTempSupp; // Taux pour le temps supplémentaire d'un employé
	private String possibleDateDepart; // Format: 7/12/2024 = 12 juillet 2024
	
	// ---------------Constructeurs---------------
	public Employe(int ID, String nom, String dateEmbauche, int SIN, String poste, HashMap<String, Integer> tauxHorairesHistorique, int tauxTempSupp, String possibleDateDepart) {
		this.ID = ID;
		this.nom = nom;
		this.dateEmbauche = dateEmbauche;
		this.SIN = SIN;
		this.poste = poste;
		this.tauxHorairesHistorique = tauxHorairesHistorique;
		this.tauxTempSupp = tauxTempSupp;
		this.possibleDateDepart = possibleDateDepart;
	}
	
	// ---------------Getters---------------
	public int getID() {
		return this.ID;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getDateEmbauche() {
		return this.dateEmbauche;
	}
	
	public int getSIN() {
		return this.SIN;
	}
	
	public String getPoste() {
		return this.poste;
	}
	
	public HashMap<String, Integer> getTauxHorairesHistorique() {
		return this.tauxHorairesHistorique;
	}
	
	public int getTauxTempSupp() {
		return this.tauxTempSupp;
	}
	
	public String getPossibleDateDepart() {
		return this.possibleDateDepart;
	}
	
	// ---------------Setters---------------
	public void setID(int newID) {
		this.ID = newID;
	}
	
	public void setNom(String newNom) {
		this.nom = newNom;
	}
	
	public void setDateEmbauche(String newDateEmbauche) {
		this.dateEmbauche = newDateEmbauche;
	}
	
	public void setSIN(int newSIN) {
		this.SIN = newSIN;
	}
	
	public void setPoste(String newPoste) {
		this.poste = newPoste;
	}
	
	public void setTauxHorairesHistorique(HashMap<String, Integer> newTauxHorairesHistorique) {
		this.tauxHorairesHistorique = newTauxHorairesHistorique;
	}
	
	public void setTauxTempSupp(int newTauxTempSupp) {
		this.tauxTempSupp = newTauxTempSupp;
	}
	
	public void setPossibleDateDepart(String newPossibleDateDepart) {
		this.possibleDateDepart = newPossibleDateDepart;
	}
}
