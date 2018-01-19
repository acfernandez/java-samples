package ar.com.java.samples.acf;

import static org.springframework.util.Assert.isTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.util.Assert;


public class MathSamples {	

	// Weights
	private static final int CR_WEIGHT = 17;
	private static final int E_WEIGHT = 12;
	private static final int SM_WEIGHT = 22;
	private static final int ODRS_WEIGHT = 27;
	private static final int D_PS_WEIGHT = 22;
	
	private static final int OSI_MANAGER_WEIGHT = 40;
	private static final int OSI_WEIGHT = 45;
	
	private static final int FO_MANAGER_WEIGHT = 40;
	private static final int FO_WEIGHT = 45;
	
	private static final int PD_WEIGHT = 10;
	private static final int EC_WEIGHT = 10;
	
	// Divisors
	private static final int HUNDRED = 100;
	private static final int ONE_MILLON = 1000000;
	
	
	private BigDecimal calculate(int areaResult, int perfResult, int companyResult, int areaMultiplicand,
			int perfMultiplicand) {
		Assert.isTrue(100 == (areaMultiplicand + perfMultiplicand), "The sum of multiplicands whould be 100%");

		BigDecimal area = BigDecimal.valueOf(areaResult * areaMultiplicand);
		BigDecimal perf = BigDecimal.valueOf(perfResult * perfMultiplicand);

		return (perf == BigDecimal.ZERO) ? BigDecimal.ZERO
				: area
				.add(perf)
				.multiply(BigDecimal.valueOf(companyResult))
				.divide(BigDecimal.valueOf(ONE_MILLON))
				.round(new MathContext(1, RoundingMode.HALF_UP));
	}

	private BigDecimal calculateForColaborator(int areaResult, int perfResult, int companyResult) {
		return calculate(areaResult, perfResult, companyResult, 40, 60);
	}

	private BigDecimal calculateForManager(int areaResult, int perfResult, int companyResult) {
		return calculate(areaResult, perfResult, companyResult, 60, 40);
	}
	
	private BigDecimal calculateForCoordinator(int areaResult, int perfResult, int companyResult) {
		return calculate(areaResult, perfResult, companyResult, 50, 50);
	}
	
	private BigDecimal calculateTeam(int OSIValue, int FOValue, int PDValue) {
		return BigDecimal
				.valueOf(
						OSIValue * OSI_WEIGHT + 
						FOValue * FO_WEIGHT +
						PDValue * PD_WEIGHT)
				.divide(BigDecimal.valueOf(HUNDRED));
	}
	
	private BigDecimal calculateManager(int OSIValue, int FOValue, int PDValue, int ECValue) {
		return BigDecimal
				.valueOf(
						OSIValue * OSI_MANAGER_WEIGHT + 
						FOValue * FO_MANAGER_WEIGHT +
						PDValue * PD_WEIGHT +
						ECValue * EC_WEIGHT)
				.divide(BigDecimal.valueOf(HUNDRED));
	}
	
	private BigDecimal calculateArea(int CRValue, int EValue, int SMValue, int ODRSValue, int DPSValue) {
		return BigDecimal
				.valueOf(
						CRValue * CR_WEIGHT + 
						EValue * E_WEIGHT + 
						SMValue * SM_WEIGHT + 
						ODRSValue * ODRS_WEIGHT + 
						DPSValue * D_PS_WEIGHT)
				.divide(BigDecimal.valueOf(HUNDRED)); 
	}


	public static void main(String[] args) {

		MathSamples samples = new MathSamples();
		
		// Tests
		isTrue("100".equals(samples.calculateArea(100, 100, 100, 100, 100).toString()));
		isTrue("100".equals(samples.calculateTeam(100, 100, 100).toString()));
		isTrue("100".equals(samples.calculateManager(100, 100, 100, 100).toString()));

		isTrue("1".equals(samples.calculateForColaborator(100, 100, 100).toString()));
		isTrue("2".equals(samples.calculateForColaborator(120, 120, 160).toString()));
		isTrue("0.8".equals(samples.calculateForColaborator(80, 80, 100).toString()));
		isTrue("0.6".equals(samples.calculateForColaborator(0, 100, 100).toString()));
		isTrue("0".equals(samples.calculateForColaborator(100, 0, 100).toString()));

		isTrue("1".equals(samples.calculateForManager(100, 100, 100).toString()));
		isTrue("2".equals(samples.calculateForManager(120, 120, 160).toString()));
		isTrue("0.4".equals(samples.calculateForManager(100, 100, 40).toString()));
		isTrue("0".equals(samples.calculateForManager(100, 0, 100).toString()));
		
		// Real
		BigDecimal area = samples.calculateArea(120, 120, 120, 100, 100);
		System.out.println("Area result: " + area);
		BigDecimal manager = samples.calculateManager(120, 120, 100, 112);
		System.out.println("Manager result: " + manager);
		BigDecimal result = samples.calculateForManager(area.intValue(), manager.intValue(), 100);
		System.out.println("Final result: " + result);

	}

}
