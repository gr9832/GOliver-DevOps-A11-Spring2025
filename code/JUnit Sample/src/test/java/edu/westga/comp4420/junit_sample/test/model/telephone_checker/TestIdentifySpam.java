package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {

   @ParameterizedTest
    @CsvSource({
        "9995551234, true", "9005551234, true", "8885551234, true", 
		"8005551234, true", "9115551234, true", "4115551234, true",
        "5555551234, false", "2125551234, false"
    })
    void testIdentifySpam(long number, boolean expectedResult) {
        TelephoneChecker checker = new TelephoneChecker();

        boolean result = checker.identifySpam(number);

        assertEquals(expectedResult, result, "checking if number (" + number + ") is spam");
    }
	
	@Test
    void testIdentifySpamEnforcesPrecondition() {
        TelephoneChecker checker = new TelephoneChecker();

        long invalidNumber = 999999; 

        assertThrows(IllegalArgumentException.class, () -> {
            checker.identifySpam(invalidNumber);
        }, "Error: invalid phone number");
    }
}
