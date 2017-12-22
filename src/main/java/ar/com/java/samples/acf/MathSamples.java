package ar.com.java.samples.acf;

import static org.springframework.util.Assert.isTrue;

import java.math.BigDecimal;

public class MathSamples {

	private static final BigDecimal DIVISOR = BigDecimal.valueOf(1000000);

	private BigDecimal calculate(int areaResult, int perfResult, int companyResult, 
			int areaMultiplicand, int perfMultiplicand) {

		BigDecimal area = BigDecimal.valueOf(areaResult * areaMultiplicand);
		BigDecimal perf = BigDecimal.valueOf(perfResult * perfMultiplicand);
		return (perf == BigDecimal.ZERO) ? BigDecimal.ZERO
				: area.add(perf).multiply(BigDecimal.valueOf(companyResult)).divide(DIVISOR);
	}

	private BigDecimal calculateForColaborator(int areaResult, int perfResult, int companyResult) {
		return calculate(areaResult, perfResult, companyResult, 40, 60);
	}

	private BigDecimal calculateForManager(int areaResult, int perfResult, int companyResult) {
		return calculate(areaResult, perfResult, companyResult, 50, 50);
	}

	public static void main(String[] args) {

		MathSamples samples = new MathSamples();

		isTrue("1".equals(samples.calculateForColaborator(100, 100, 100).toString()));
		isTrue("1.92".equals(samples.calculateForColaborator(120, 120, 160).toString()));
		isTrue("0.8".equals(samples.calculateForColaborator(80, 80, 100).toString()));
		isTrue("0.6".equals(samples.calculateForColaborator(0, 100, 100).toString()));
		isTrue("0".equals(samples.calculateForColaborator(100, 0, 100).toString()));

		isTrue("1".equals(samples.calculateForManager(100, 100, 100).toString()));
		isTrue("1.92".equals(samples.calculateForManager(120, 120, 160).toString()));
		isTrue("0.4".equals(samples.calculateForManager(100, 100, 40).toString()));
		isTrue("0.5".equals(samples.calculateForManager(0, 100, 100).toString()));
		isTrue("0".equals(samples.calculateForManager(100, 0, 100).toString()));

		BigDecimal salary = BigDecimal.valueOf(1);
		System.out.println(samples.calculateForManager(0, 0, 0).multiply(salary));
	}

}
