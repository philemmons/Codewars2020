import java.lang.Math;
public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        //System.out.println( startPriceOld+ "  "+ startPriceNew+ "  "+ savingperMonth+ "  "+ percentLossByMonth);
        
        // He can buy it now!!
        if(startPriceOld == startPriceNew) return new int[]{0,0};
      
        // A man has a rather old car being worth $2000.
        double oldCar= (double)startPriceOld;
        
        // He saw a secondhand car being worth $8000. 
        double newCar= (double)startPriceNew;
      
        // He thinks he can save $1000 each month but
        double spm= (double)savingperMonth,
               saved= 0.0,
               numMonth= 0.0,
               perLoss= percentLossByMonth/100.0;
      
        // He wants to keep his old car until he can buy the secondhand one.
        while( saved+oldCar <= newCar ){
            // How many months will it take him to save up enough money to buy the car he wants, 
            numMonth++;
            // Furthermore this percent of loss increases of 0.5 percent at the end of every two months. 
            if(numMonth % 2 == 0){
                perLoss+= 0.005;
            }
            // the prices of his old car and of the new one decrease of 1.5 percent per month.
            oldCar-= (oldCar* perLoss);
            newCar-= (newCar* perLoss);
            saved+= spm;
            //System.out.println( "end month "+ numMonth + ": percentLoss " + perLoss +  " available "+ (saved+oldCar-newCar) );
        }
        // and how much money will he have left over?
        return new int[]{ (int)numMonth, (int)Math.round(saved+oldCar-newCar) };
    }
}
