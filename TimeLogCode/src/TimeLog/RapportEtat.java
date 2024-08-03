package TimeLog;
import java.util.HashMap;

import PayRoll.*;

public class RapportEtat {

	// ---------------Attributs---------------
	private HashMap<String, Double> avancementDiscipline; // Pourcentage d'avancement par discipline
	private double avancementTotal; // Pourcentage d'avancement total
	private HashMap<String, Integer> nbHeureTravailleeDiscipline; // String: Discipline, Integer: nb. d'heure travaillée dans une discipline

	// ---------------Constructeur---------------
	RapportEtat(HashMap<String, Double> avancementDiscipline, double avancementTotal, HashMap<String, Integer> nbHeureTravailleeDiscipline){
		this.avancementDiscipline = avancementDiscipline;
		this.avancementTotal = avancementTotal;
		this.nbHeureTravailleeDiscipline = nbHeureTravailleeDiscipline;
	}

	// ---------------Getters---------------
	public HashMap<String, Double> getAvancementDiscipline() {
		return this.avancementDiscipline;
	}

	public double getAvancementTotal() {
		return this.avancementTotal;
	}

	public HashMap<String, Integer> getNbHeureTravailleeDiscipline() {
		return this.nbHeureTravailleeDiscipline;
	}

	// ---------------Setters---------------
	public void setAvancementDiscipline(HashMap<String, Double> newAvancementDiscipline) {
		this.avancementDiscipline = newAvancementDiscipline;
	}

	public void setAvancementTotal(double newAvancementTotal) {
		this.avancementTotal = newAvancementTotal;
	}

	public void setNbHeureTravailleeDiscipline(HashMap<String, Integer> newNbHeureTravailleeDiscipline) {
		this.nbHeureTravailleeDiscipline = newNbHeureTravailleeDiscipline;
	}
}
