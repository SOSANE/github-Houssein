package TimeLog;
import java.util.HashMap;

import PayRoll.*;

public class Administrateur extends Employe{

	public Administrateur(int ID, String nom, String dateEmbauche, int SIN, String poste, HashMap<String, Integer> tauxHorairesHistorique, int tauxTempSupp, String possibleDateDepart) {
		super(ID, nom, dateEmbauche, SIN, poste, tauxHorairesHistorique, tauxTempSupp, possibleDateDepart);
	}
	
}
