package linear.equation.solver;
/*
 * https://www.codewars.com/kata/56d6d927c9ae3f115b0008dd/train/java
 * 
 * Only the plus and minus operators are used
 * Both sides of the equation can have variables
 * Variable names are strings of arbitrary length
 * All coefficients are integers and generally fall within the range of -150 to 150, 
 * with a few ranging from -1000 to 1000. Free terms are integers in range -20000 to 20000. 
 * Equations do not necessarily have variables. 
 * Equations have exactly one operator (+ or -) between terms. 
 * Comparisons are performed with accuracy of 1e-6.
 * 
 * https://www.intmath.com/matrices-determinants/1-determinants.php
 * https://en.wikipedia.org/wiki/Gaussian_elimination
 * https://brilliant.org/wiki/gaussian-elimination/
 * 
 * https://people.richland.edu/james/lecture/m116/matrices/pivot.html
 * 
 *  Swapping two rows,
 *  Multiplying a row by a nonzero number,
 *  Adding a multiple of one row to another row.
 *  
 */

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class LinearSolver {
	
	private static Map<String, Double> solution;
	private static Map<String, ArrayList<Double>> hm = new HashMap<>();
	
	private static Map<String, Double> variableValue = new HashMap<>();
	
	private static double coefficient;
	private static String findVariable, onlyCoefficient;
	private static boolean rightHandSide = true;
	
	
	private static void resetAllValuesToZero() {
		for (Map.Entry<String, Double> entry : variableValue.entrySet()) {
		    entry.setValue(0.0);
		}
	}
	
	private static void storeAllTerms(String findVar, double coeff) {
		if(!variableValue.containsKey(findVariable)) {
			variableValue.put(findVariable, coefficient);
		}else {
			variableValue.put(findVariable, variableValue.get(findVariable)+coefficient);
		}
	}
	
	private static String removedVariable(String term) {
		return term.replaceFirst("[a-zA-Z]+", "");
	}
	
	private static void isTheCoefficientOne() {
		if(onlyCoefficient.isEmpty())
			onlyCoefficient= "1";
		else if(onlyCoefficient.equals("-"))
			onlyCoefficient= "-1";
	}
	
	private static String removedCoefficient(String term) {
		return term.replaceFirst("[-0-9]+","");
	}

	private static void isTheTermConstant() {
		if(findVariable.isEmpty())
			findVariable= "constant";
	}
	
	private static void groupingValues(Boolean rightHandSide) {
		if( (rightHandSide && !findVariable.isEmpty()) || 
			(!rightHandSide && findVariable.isEmpty()) ){
				coefficient*= -1;
		}
	}
	
	private static void identifyVariableCoefficientConstantsAndStoreThem(String[] expression, boolean onRightHandSide) {
		for(String term: expression) {
			onlyCoefficient= removedVariable(term);
			isTheCoefficientOne();
			coefficient = Double.parseDouble(onlyCoefficient);
			
			findVariable= removedCoefficient(term);
			groupingValues(onRightHandSide);
			isTheTermConstant();
			
			storeAllTerms(findVariable, coefficient);
		}
	}
	
	//https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
	//note: string... equations is String[], one or more elements
	public static Map<String, Double> solve(String... equations) {
		
		System.out.println(equations.length);

		for(String displayEquation: equations) {
			System.out.print(displayEquation + " ");
		}
		System.out.println();
		
		Equation equationObject;
		
		for(String currentEquation: equations) {
			
			equationObject= new Equation(currentEquation);
			System.out.println(equationObject);

			Equation.printLeftAndRightHandSides();
			
			identifyVariableCoefficientConstantsAndStoreThem(equationObject.getRightHandSide(),rightHandSide);
			identifyVariableCoefficientConstantsAndStoreThem(equationObject.getLeftHandSide(),!rightHandSide);
					
			System.out.println(variableValue);
			
			resetAllValuesToZero();
			
			equationObject.resetObject();
		}
		
		return variableValue;
	}
	public static void main(String[] args) {
		//BasicSingleEquation - changed from 2x=4
		System.out.println(solve("-2x-3r+z+2-3y=8-y"));
		//2.0 x
		
		//BasicTwoEquations - changed
//		System.out.println(solve("2x+8y=4", "-x+4y=14"));
		//-6.0 x
		//2.0 y
		
		//BasicRightHandVariables
//		System.out.println(solve("2x=8y", "x+y=5"));
		//4.0 x
		//1.0 y
		
		//BasicLongVariables
//		System.out.println(solve("2alpha+8beta=4", "-alpha+4beta=14"));
		//-6.0 alpha
		//2.0 beta
		
		//BasicSolvableRepeated
//		System.out.println(solve("x=4y", "2x=8y", "x+y=5"));
		//4.0 x
		//1.0 y
		
		//BasicZeroAsSolution
//		System.out.println(solve("x+y=7z-1", "6x+z=-3y", "4y+10z=-8x"));
		//1.0 x
		//-2.0 y
		
		//BasicRepeatingVariables
//		System.out.println(solve("2x-y+3x=-2y+3x+9y", "-y+x+2y=5"));
		//4.0 x
		//1.0 y
		
		//BasicNotEnoughEqs
//		System.out.println(solve("x+y=0"));
		//null
		
		//BasicIndeterminate
//		System.out.println(solve("x+y=1", "2x+2y=2"));
		//null
		
		//BasicNoSolutions
//		System.out.println(solve("x+2y=1", "2x=2-4y"));
		//null
	}
}
