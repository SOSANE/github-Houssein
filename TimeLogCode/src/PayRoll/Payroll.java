package PayRoll;
import java.time.LocalDate;
import java.util.List;

import TimeLog.*;

public class Payroll implements PayrollInterface {

	@Override
	public void afficherPaie(List<PayInfo> payInfoList) {
		for (PayInfo payInfo : payInfoList) {
			// Code pour afficher chaque PayInfo
			System.out.println("=== Chèque de paie ===");
			System.out.println("ID de l'employé : " + payInfo.getEmployeID());
			System.out.println("Heures de base : " + payInfo.getHeuresBase());
			System.out.println("Heures supplémentaires : " + payInfo.getHeuresSupplementaires());
			System.out.println("Taux horaire de base : " + payInfo.getTauxHoraireBase());
			System.out.println("Taux horaire supplémentaire : " + payInfo.getTauxHoraireSupplementaires());
			System.out.println("Montant brut : " );
			System.out.println("Montant net : " );
			System.out.println("Période de paie : " + " au " );
			System.out.println("=== Fin du chèque de paie ===\n");
		}
	}

	@Override
	public double netFromBrute(double montantBrut, double deductions) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String DeductionsReport(List<PayInfo> payInfoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
