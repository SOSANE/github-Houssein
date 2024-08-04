package TimeLog;
import PayRoll.*;

public class Activite {
	
	// ---------------Attributs---------------
	private String nomProjet;
	private String disciplineDeTravail; // Soit design1, design2, implementation, test ou deploiement
	private String dateDebut;
	private String heureDebut; 
	private String heureArret;
	private String dateFin;
	
	// ---------------Constructeurs---------------
	Activite(String nomProjet, String disciplineDeTravail, String heureDebut, String heureArret) {
		this.nomProjet = nomProjet;
		this.disciplineDeTravail = disciplineDeTravail;
		this.heureDebut = heureDebut;
		this.heureArret = heureArret;
	}
	
	// ---------------Getters---------------
	public String getNomProjet() {
		return this.nomProjet;
	}
	
	public String getDisciplineDeTravail() {
		return this.disciplineDeTravail;
	}
	
	public String getHeureDebut() {
		return this.heureDebut;
	}
	
	public String getHeureArret() {
		return this.heureArret;
	}
	
	// ---------------Setters---------------
	public void setNomProjet(String newNomProjet) {
		this.nomProjet = newNomProjet;
	}
	
	public void setDisciplineDeTravail(String newDisciplineDeTravail) {
		this.disciplineDeTravail = newDisciplineDeTravail;
	}
	
	public void setHeureDebut(String newHeureDebut) {
		this.heureDebut = newHeureDebut;
	}
	
	public void setHeureArret(String newHeureArret) {
		this.heureArret = newHeureArret;
	}
}
