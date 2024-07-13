package TimeLog;
import java.util.HashMap;
import PayRoll.*;

public class Projet {
	
	// ---------------Attributs---------------
	private String nom;
	private int ID;
	private RapportEtat rapportEtat;
	private String dateDebut; // Format: 7/12/2024 = 12 juillet 2024
	private String dateFin; // Format: 7/12/2024 = 12 juillet 2024
	private HashMap<String, Integer> nbHeureDiscipline; // String correspond à la discipline et Integer correspond au nombre d'heures alloués
	
	// ---------------Constructeur---------------
	Projet(String nom, int ID, RapportEtat rapportEtat, String dateDebut, String dateFin, HashMap<String, Integer> nbHeureDiscipline) {
		this.nom = nom;
		this.ID = ID;
		this.rapportEtat = rapportEtat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbHeureDiscipline = nbHeureDiscipline;
	}
	
	// ---------------Getters---------------
	public String getNom() {
		return this.nom;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public RapportEtat getRapportEtat() {
		return this.rapportEtat;
	}
	
	public String getDateDebut() {
		return this.dateDebut;
	}
	
	public String getDateFin() {
		return this.dateFin;
	}
	
	public HashMap<String, Integer> getnbHeureDiscipline() {
		return this.nbHeureDiscipline;
	}
	
	// ---------------Setters---------------
	public void setNom(String newNom) {
		this.nom = newNom;
	}
	
	public void setID(int newID) {
		this.ID = newID;
	}
	
	public void setRapportEtat(RapportEtat newRapportEtat) {
		this.rapportEtat = newRapportEtat;
	}
	
	public void setDateDebut(String newDateDebut) {
		this.dateDebut = newDateDebut;
	}
	
	public void setDateFin(String newDateFin) {
		this.dateFin = newDateFin;
	}
	
	public void setNbHeureDiscipline(HashMap<String, Integer> newNbHeureDiscipline) {
		this.nbHeureDiscipline = newNbHeureDiscipline;
	}
}
