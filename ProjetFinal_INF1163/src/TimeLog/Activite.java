package TimeLog;
import PayRoll.*;

public class Activite extends Projet{
	
	// ---------------Attributs---------------
	private String nomProjet;
	private String disciplineDeTravail; // Soit design1, design2, implementation, test ou deploiement
	private int heureDebut; // Format: 08:36 = 836
	private int heureArret;
	
	// ---------------Constructeurs---------------
	public Activite(String nomProjet, String disciplineDeTravail, int heureDebut, int heureArret) {
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
	
	public int getHeureDebut() {
		return this.heureDebut;
	}
	
	public int getHeureArret() {
		return this.heureArret;
	}
	
	// ---------------Setters---------------
	public void setNomProjet(String newNomProjet) {
		this.nomProjet = newNomProjet;
	}
	
	public void setDisciplineDeTravail(String newDisciplineDeTravail) {
		this.disciplineDeTravail = newDisciplineDeTravail;
	}
	
	public void setHeureDebut(int newHeureDebut) {
		this.heureDebut = newHeureDebut;
	}
	
	public void setHeureArret(int newHeureArret) {
		this.heureArret = newHeureArret;
	}
}
