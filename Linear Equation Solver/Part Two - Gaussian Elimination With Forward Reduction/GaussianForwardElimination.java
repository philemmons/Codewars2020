package solve.system.of.equations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GaussianForwardElimination{
	
	private static double primaryCoeffientMultiplier,
						  reduceCoefficientMultiplier;
	
	private static int numberOfMatrixColumns;
	
	public static void reducingEachRow(double[][] numMatrix) {
		numberOfMatrixColumns= numMatrix.length;
		//first col, second row 3r2-2r1->r2
		    //third row 3r3-5r1->r3
		
		//second col, first row 5r1-2r2->r1
		    //third row 5r3-(-19)r2->r3
		
		//third col, first row 438r1-(-54r3)->r1
		    //second row 438r2-17r3->r2
		
		for(int index =0; index< numberOfMatrixColumns; index++) {
			primaryCoeffientMultiplier = numMatrix[index][index];
			
			for(int row= 0; row< numberOfMatrixColumns; row++) {
				if(row != index) {
					reduceCoefficientMultiplier= numMatrix[row][index];
					
					for(int col = 0; col< numMatrix[row].length; col++) {
						numMatrix[row][col]= primaryCoeffientMultiplier*numMatrix[row][col] - reduceCoefficientMultiplier*numMatrix[index][col];
					}
				}
			}
		}
		
		reducingMatrixIntoItsEchelonForm(numMatrix);
		
	}

	private static void reducingMatrixIntoItsEchelonForm(double[][] numMatrix) {
		int constantIndex= numberOfMatrixColumns;
		
		for(int index =0; index<numberOfMatrixColumns; index++) {
			double numerator= numMatrix[index][constantIndex];
			double denominator= numMatrix[index][index];
			numMatrix[index][index]= 1.0;
			numMatrix[index][constantIndex]= roundingUpToSeveralPlaces(numerator/denominator, 7);
		}
	}
	
	private static void displayNumericalMatrix(double[][] numericalMatrix) {
		for(int row= 0; row < numericalMatrix.length; row++) {
			for(int col= 0; col < numericalMatrix[row].length; col++) {
				System.out.print(numericalMatrix[row][col]+ " ");
			}
			System.out.println();
		}
	}
	
	private static double roundingUpToSeveralPlaces(double value, int places) {
	    assert (places > 0): "Decimal place is less than zero.";
	    
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    
	    return bd.doubleValue();
	}

	public static void main(String[] args) {
		
		double[][] numericalMatrix = new double[][] {
			{3, 2,-4, 3},
			{2, 3, 3,15},
			{5,-3, 1,14}
		};
		
		reducingEachRow(numericalMatrix);
		
		displayNumericalMatrix(numericalMatrix);
	}
}
