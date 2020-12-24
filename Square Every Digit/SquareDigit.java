public class SquareDigit {
  
  String s, result = "";
  char[] digit;
  int square;
  
  public int squareDigits(int n) {
    
    // create a string
    s = Integer.toString(n);

    // create a char array
    digit = s.toCharArray();
    
    // get one digit at a time
    for( int i = 0; i< digit.length; i++){
        // transform the char to int
          square = Character.getNumericValue(digit[i]);
        // square the digit
          square *= square;
        // transform the result to string and append to string
          result += String.valueOf(square);   
    }
    // transform the string to int, and return the value
    return Integer.valueOf(result);
  }
  
}
