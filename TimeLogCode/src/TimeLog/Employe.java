package TimeLog;
import java.util.HashMap;
import PayRoll.*;

public class Employe extends Utilisateur {
	
	// ---------------Attributs---------------
	private String dateEmbauche; // Format: 7/12/2024 = 12 juillet 2024
	private String poste; // Poste de l'employé
	private HashMap<String, Integer> tauxHorairesHistorique; // La clé est la date, la valeur est le taux horaire
	private int tauxTempSupp; // Taux pour le temps supplémentaire d'un employé
	private String possibleDateDepart; // Format: 7/12/2024 = 12 juillet 2024
	
	// ---------------Constructeur---------------
	Employe(String nom, int ID, int SIN, String poste, String dateEmbauche, HashMap<String, Integer> tauxHorairesHistorique, int tauxTempSupp, String possibleDateDepart) {
		super(nom, ID, SIN, poste);
		this.dateEmbauche = dateEmbauche;
		this.tauxHorairesHistorique = tauxHorairesHistorique;
		this.tauxTempSupp = tauxTempSupp;
		this.possibleDateDepart = possibleDateDepart;
	}
	
	// ---------------Getters---------------
	public String getDateEmbauche() {
		return this.dateEmbauche;
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
	public void setDateEmbauche(String newDateEmbauche) {
		this.dateEmbauche = newDateEmbauche;
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
