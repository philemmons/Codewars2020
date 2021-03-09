package linear.equation.solver;

import java.util.Arrays;

public class Equation {
	
	private static String expression, regEx= "([+])";
	private static String[] halfEquation, rightHandSide, leftHandSide;
	
	public Equation(String originalExpression) {
		//expression= replaceTwoMinusWithPlus(originalExpression);
		expression= insertPlusBeforeEachMinus(originalExpression);
		halfEquation= expression.split("=");
		removingPlusAtIndexZero();
		leftHandSide= halfEquation[0].split(regEx);
		rightHandSide= halfEquation[1].split(regEx);
	}
	
	private static String insertPlusBeforeEachMinus(String exp) {
		return exp.replaceAll("-", "+-");
	}
	
	private static String replaceTwoMinusWithPlus(String exp) {
		return exp.replaceAll("--", "+");
	}
	
	private static void removingPlusAtIndexZero() {
		for(int i= 0; i< halfEquation.length; i++) {
			if(halfEquation[i].charAt(0)=='+')
				halfEquation[i]=  halfEquation[i].substring(1);
		}	
	}

	@Override
	public String toString() {
		return "Equation: "+ expression;
	}
	
	public static void printLeftAndRightHandSides() {
		System.out.println("LHS: "+ Arrays.toString(leftHandSide));
		System.out.println("RHS: "+ Arrays.toString(rightHandSide));
	}

	protected String[] getRightHandSide() {
		return rightHandSide;
	}

	protected String[] getLeftHandSide() {
		return leftHandSide;
	}
	
	protected void resetObject() {
		expression= null;
		halfEquation= null;
		leftHandSide= null;
		rightHandSide= null;
		System.out.println("EquationObject values are null.");
	}
}//EOC
