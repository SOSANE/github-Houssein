package PayRoll;
import java.time.LocalDate;

import TimeLog.*;

public class PayInfo {

	// ---------------Attributs---------------
	private String employeID;
	private double heuresBase;
	private double heuresSupplementaires;
	private double tauxHoraireBase;
	private double tauxHoraireSupplementaires;
	private LocalDate dateDebutPaie;
	private LocalDate dateFinPaie;


	// ---------------Constructeur---------------
	public PayInfo(String employeID, double heuresBase, double heuresSupplementaires, double tauxHoraireBase, double tauxHoraireSupplementaires, LocalDate dateDebutPaie, LocalDate dateFinPaie) {
		this.employeID = employeID;
		this.heuresBase = heuresBase;
		this.heuresSupplementaires = heuresSupplementaires;
		this.tauxHoraireBase = tauxHoraireBase;
		this.tauxHoraireSupplementaires = tauxHoraireSupplementaires;
		this.dateDebutPaie = dateDebutPaie;
		this.dateFinPaie = dateFinPaie;
	}

	// ---------------Getters et Setters---------------
	public String getEmployeID() {
		return employeID;
	}

	public void setEmployeID(String employeID) {
		this.employeID = employeID;
	}

	public double getHeuresBase() {
		return heuresBase;
	}

	public void setHeuresBase(double heuresBase) {
		this.heuresBase = heuresBase;
	}

	public double getHeuresSupplementaires() {
		return heuresSupplementaires;
	}

	public void setHeuresSupplementaires(double heuresSupplementaires) {
		this.heuresSupplementaires = heuresSupplementaires;
	}

	public double getTauxHoraireBase() {
		return tauxHoraireBase;
	}

	public void setTauxHoraireBase(double tauxHoraireBase) {
		this.tauxHoraireBase = tauxHoraireBase;
	}

	public double getTauxHoraireSupplementaires() {
		return tauxHoraireSupplementaires;
	}

	public void setTauxHoraireSupplementaires(double tauxHoraireSupplementaires) {
		this.tauxHoraireSupplementaires = tauxHoraireSupplementaires;
	}

	public LocalDate getDateDebutPaie() {
		return dateDebutPaie;
	}

	public void setDateDebutPaie(LocalDate dateDebutPaie) {
		this.dateDebutPaie = dateDebutPaie;
	}

	public LocalDate getDateFinPaie() {
		return dateFinPaie;
	}

	public void setDateFinPaie(LocalDate dateFinPaie) {
		this.dateFinPaie = dateFinPaie;
	}
}
