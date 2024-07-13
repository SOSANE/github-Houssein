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
	
	
}
