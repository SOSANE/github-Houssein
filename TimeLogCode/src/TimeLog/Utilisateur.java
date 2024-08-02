package TimeLog;

public class Utilisateur {

	// ---------------Attributs---------------
	private String nom;
	private int ID;
	private int SIN; // Assurance social composé de 9 chiffres
	private String poste;
	
	// ---------------Constructeur---------------
	Utilisateur(String nom, int ID, int SIN, String poste){
		this.nom = nom;
		this.ID = ID;
		this.SIN = SIN;
		this.poste = poste;
	}
	
	// ---------------Getters---------------
	public int getID() {
		return this.ID;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getSIN() {
		return this.SIN;
	}
	
	public String getPoste() {
		return this.poste;
	}
	
	// ---------------Setters---------------
	public void setNom(String newNom) {
		this.nom = newNom;
	}
	
	public void setID(int newID) {
		this.ID = newID;
	}
	
	public void setSIN(int newSIN) {
		this.SIN = newSIN;
	}
	
	public void setPoste(String newPoste) {
		this.poste = newPoste;
	}
	
}
