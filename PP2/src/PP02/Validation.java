package PP02;

public class Validation extends Payment{


  // Return true if the card number is valid, otherwise returns false, this method is already implemented
  public boolean aValidNumber(String n) {

	long number = Long.parseLong(n);
	return  (numLength(number) >= 13) && (numLength(number) <= 16) &&
        (prefixCheck(number, 4) || prefixCheck(number, 5) ||
        prefixCheck(number, 6) || prefixCheck(number, 37)) &&
        (totalEevenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
  }// end of aValidNumber method

  //get the sum of even places numbers, Starting from the second digit from right
  private int totalEevenNumbers(long number) {
	  int sum = 0;
	    String numStr = String.valueOf(number);
	    for (int i = numStr.length() - 2; i >= 0; i -= 2) {
	        sum += singleDigit(Character.getNumericValue(numStr.charAt(i)) * 2);
	    }
	    return sum;
	
  }// end of totalEevenNumbers method

  // Return the same number if it is a single digit, otherwise, return the sum of
  // the two digits in this number
  private int singleDigit(int number) {
	  return number < 10 ? number : number / 10 + number % 10;
  } // end of singleDigit method



  // Return the sum of odd place digits in number
  private int totalOddNumbers(long number) {
	  int sum = 0;
	    String numStr = String.valueOf(number);
	    for (int i = numStr.length() - 1; i >= 0; i -= 2) {
	        sum += Character.getNumericValue(numStr.charAt(i));
	    }
	    return sum;
  }// end of totalOddNumbers method

  // Return true if the digit d is a prefix for number
  private boolean prefixCheck(long number, int d) {

	  return String.valueOf(number).startsWith(String.valueOf(d));
  }// end of prefixCheck method


  // Return the number of digits in this number parameter
  private int numLength(long number) {

    return String.valueOf(number).length();
  }// end of numLength method

  // Return the first k number of digits from number, which is either a first digit or first two digits
  // Depending on the card type
  private long numPrefix(long number, int k) {
      return 0L;
  }// end of numPrefix method

}// end of the class
