package edu.westga.comp4420.junit_sample.model;

public class TelephoneChecker {
	
	/** Verifies that the provided number is a valid phone number.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number is a valid phone number
	 * 			false	if number is not a valid phone number
	 */
	public boolean verifyNumber(long number) {
		if (number < 1000000L) {
			return false;
		} else if (number <= 9999999L) {
			return true;
		} else if (number < 1000000000L) {
			return false;
		} else {
			return number <= 9999999999L;
		} 
	}
	
	/** Identifies if a provided phone number is potential spam based on the area code.
	 * The following area codes should be reported as potential spam:
	 * 	999
	 * 	900
	 * 	888
	 * 	800
	 * 	911
	 * 	411
	 * 
	 * @precondition number if a valid phone number
	 * @postcondition none
	 * 
	 * @param number the number provided to be checked
	 * 
	 * @return	true	if number matches heuristics for potential spam
	 * 			false	if number does not match heuristics for potential spam
	 */
	public boolean identifySpam(long number) {
		if (!this.verifyNumber(number)) {
			throw new IllegalArgumentException("Error: invalid phone number");
		}
		
		long areaCode = number / 10000000;
    
	    boolean isSpam = false;

		if (areaCode == 999) {
			isSpam = true;
		} else if (areaCode == 900) {
			isSpam = true;
		} else if (areaCode == 888) {
			isSpam = true;
		} else if (areaCode == 800) {
			isSpam = true;
		} else if (areaCode == 911) {
			isSpam = true;
		} else if (areaCode == 411) {
			isSpam = true;
		}
		
		return isSpam;
	}
}
