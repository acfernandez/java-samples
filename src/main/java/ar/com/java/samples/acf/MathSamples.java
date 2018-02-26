package ar.com.java.samples.acf;

import java.math.BigDecimal;

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
	
	
	private BigDecimal calculate(BigDecimal areaResult, BigDecimal perfResult, BigDecimal companyResult, BigDecimal areaMultiplicand,
			BigDecimal perfMultiplicand) {
		Assert.isTrue(areaMultiplicand.add(perfMultiplicand).equals(BigDecimal.valueOf(100)), "The sum of multiplicands whould be 100%");

		BigDecimal area = areaResult.multiply(areaMultiplicand);
		BigDecimal perf = perfResult.multiply(perfMultiplicand);

		return (perf == BigDecimal.ZERO) ? BigDecimal.ZERO
				: area
				.add(perf)
				.multiply(companyResult)
				.divide(BigDecimal.valueOf(ONE_MILLON));
	}

	private BigDecimal calculateForCollaborator(BigDecimal areaResult, BigDecimal perfResult, BigDecimal companyResult) {
		return calculate(areaResult, perfResult, companyResult, BigDecimal.valueOf(40), BigDecimal.valueOf(60));
	}

	private BigDecimal calculateForManager(BigDecimal areaResult, BigDecimal perfResult, BigDecimal companyResult) {
		return calculate(areaResult, perfResult, companyResult, BigDecimal.valueOf(60), BigDecimal.valueOf(40));
	}
	
	private BigDecimal calculateForCoordinator(BigDecimal areaResult, BigDecimal perfResult, BigDecimal companyResult) {
		return calculate(areaResult, perfResult, companyResult, BigDecimal.valueOf(50), BigDecimal.valueOf(50));
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
		
		// Manager
		System.out.println("Manager ------------");
		BigDecimal area = samples.calculateArea(120, 120, 120, 100, 80);
		System.out.println("Area result: " + area);
		BigDecimal manager = samples.calculateManager(120, 120, 100, 112);
		System.out.println("Manager result: " + manager);
		BigDecimal result = samples.calculateForManager(BigDecimal.valueOf(103.24)/*area*/, manager, BigDecimal.valueOf(100));
		System.out.println("Final result: " + result);
		
		// Coordinator
		System.out.println("Coordinator ------------");
		System.out.println("Area result: " + area);
		BigDecimal team = samples.calculateTeam(120, 120, 100);
		System.out.println("Team result: " + team);
		BigDecimal result1 = samples.calculateForCoordinator(BigDecimal.valueOf(103.24)/*area*/, team, BigDecimal.valueOf(100));
		System.out.println("Final result: " + result1);
		
		// Collaborator
		System.out.println("Collaborator ------------");
		System.out.println("Area result: " + area);
		System.out.println("Team result: " + team);
		BigDecimal result2 = samples.calculateForCollaborator(BigDecimal.valueOf(103.24)/*area*/, team, BigDecimal.valueOf(100));
		System.out.println("Final result: " + result2);

	}

}
