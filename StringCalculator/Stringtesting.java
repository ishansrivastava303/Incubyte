package StringCalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


public class StringTesting {
	
	 String inputString="\\[\t\t\t\t][,][\\\\n0][**9dd%\n\n\nnnnntt]\n2,2\t\t\t\t3,1000";
	 PatternMatching pattern=new PatternMatching();	
	 Extract extract=new Extract();
	 Numbers number=new Numbers();
	
	@Test 
	@Order(1)
	public void validStringFormat()
	{
		assertEquals(true,pattern.isValidPattern(inputString));
		
		
	}
	

	@Test
	@Order(2)
	public void validDelimitersBetweenDigits() 
	{
			assertEquals(true,extract.extractDigits(inputString));
			
		
	}	
	
	@Test
	@Order(3)
	public void checkNegativeNumbers()
	{
		
		assertThrows(InvalidInputString.class, () ->Numbers.findNegativeNumbers(),"Exception should be thrown for negative numbers");
	}
	
	@Test
	@Order(4)
	public void checkSumOfValidNumbers()
	{
		assertEquals(new BigInteger("1007"),Numbers.Add());
	}


}
