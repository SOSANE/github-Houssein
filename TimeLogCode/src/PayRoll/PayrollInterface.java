package PayRoll;
import java.util.List;

import TimeLog.*;

public interface PayrollInterface {
	void afficherPaie(List<PayInfo> payInfoList);
	double netFromBrute(double grossAmount, double deductions);
	String DeductionsReport(List<PayInfo> payInfoList);
}
