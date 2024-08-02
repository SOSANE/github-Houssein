package TimeLog;

public class Menu {
	
	// ---------------Attributs---------------
	private Utilisateur utilisateur;
	
	// ---------------Constructeur---------------
	Menu(Utilisateur utilsateur){
		this.utilisateur = utilisateur;
	}
	
	// ---------------Getters---------------
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	
	// ---------------Setters---------------
	public void setUtilisateur(Utilisateur newUtilisateur) {
		this.utilisateur = newUtilisateur;
	}
	
	// Méthode pour l'affichage du menu principal
	public void affichageMenu() {
		if(utilisateur instanceof Administrateur) {
			
		} else if (utilisateur instanceof Employe) {
			
		}
	}
	
	// Méthode pour l'affichage du menu admin
	
	// Méthode pour l'affichage du menu employé
}
