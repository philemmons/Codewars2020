import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class LinearSolverTestBasic {

	public static final double TOLERANCE = 1e-6;
	
	@Test
	public void testBasicSingleEquation() {

		assertEquals(2.0, new LinearSolver().solve("2x=4").get("x"), TOLERANCE);
	}

	@Test
	public void testBasicTwoEquations() {

		Map<String, Double> result = new LinearSolver().solve("2x+8y=4", "-x+4y=14");

		assertEquals(-6.0, result.get("x"), TOLERANCE);
		assertEquals(2.0, result.get("y"), TOLERANCE);
	}
	
	@Test
	public void testBasicLongVariables() {
		
		Map<String, Double> result = new LinearSolver().solve("2alpha+8beta=4", "-alpha+4beta=14");
		
		assertEquals(-6.0, result.get("alpha"), TOLERANCE);
		assertEquals(2.0, result.get("beta"), TOLERANCE);
	}

	@Test
	public void testBasicRightHandVariables() {

		Map<String, Double> result = new LinearSolver().solve("2x=8y", "x+y=5");

		assertEquals(4.0, result.get("x"), TOLERANCE);
		assertEquals(1.0, result.get("y"), TOLERANCE);
	}
	
	@Test
	public void testBasicSolvableRepeated() {

		Map<String, Double> result = new LinearSolver().solve("x=4y", "2x=8y", "x+y=5");

		assertEquals(4.0, result.get("x"), TOLERANCE);
		assertEquals(1.0, result.get("y"), TOLERANCE);
	}

	@Test
	public void testBasicZeroAsSolution() {

		Map<String, Double> result = new LinearSolver().solve("x+y=7z-1", "6x+z=-3y", "4y+10z=-8x");

		assertEquals(1.0, result.get("x"), TOLERANCE);
		assertEquals(-2.0, result.get("y"), TOLERANCE);
	}
	
	@Test
	public void testBasicRepeatingVariables() {

		Map<String, Double> result = new LinearSolver().solve("2x-y+3x=-2y+3x+9y", "-y+x+2y=5");

		assertEquals(4.0, result.get("x"), TOLERANCE);
		assertEquals(1.0, result.get("y"), TOLERANCE);
	}

	@Test
	public void testBasicNotEnoughEqs() {
		assertEquals(null, new LinearSolver().solve("x+y=0"));
	}
	
	@Test
	public void testBasicIndeterminate() {		
		assertEquals(null, new LinearSolver().solve("x+y=1", "2x+2y=2"));
	}
	
	@Test
	public void testBasicNoSolutions() {
		assertEquals(null, new LinearSolver().solve("x+2y=1", "2x=2-4y"));
	}
	
}
