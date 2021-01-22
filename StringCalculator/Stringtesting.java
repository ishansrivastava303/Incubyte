package StringCalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


public class StringTesting {
	
	 String inputString="\\[\t\t\t\t][,][\\\\n0][**9dd%\n\n\nnnnntt]\n2,2\t\t\t\t3,100,1000,21000";
	 PatternMatching pattern=new PatternMatching();	
	 Extract extract=new Extract();
	 Numbers number=new Numbers();
	
	@Test 
	@Order(1)
	public void validStartOfString()
	{
		/*check that the start of the string is of given format://[any character][any character]\n1 
		and the whole string should end with a digit.*/
		assertEquals(true,pattern.isValidPattern(inputString));
			
	}
	
	@Test
	@Order(2)
	public void isEmptyString()
	{
		/*check that if the inputstring is empty then it returns 0*/
		assertEquals(0, pattern.isEmptyInput(inputString));
	}
	

	@Test
	@Order(3)
	public void validDelimitersBetweenDigits() 
	{
			/*check that the delimiters been used between digits have been properly defined as per the given format.*/
			assertEquals(true,extract.extractDigits(inputString));
	}	
	
	@Test
	@Order(4)
	public void checkNegativeNumbers()
	{
		/*checks that if any negative number is present the exception is thrown.*/
		assertThrows(InvalidInputString.class, () ->Numbers.findNegativeNumbers(),"Exception should be thrown for negative numbers");
	}
	
	@Test
	@Order(5)
	public void checkSumOfValidNumbers()
	{
		/*checks that the sum of vaid numbers are calculated correctly.*/
		assertEquals(new BigInteger("1107"),Numbers.Add());
	}


}
