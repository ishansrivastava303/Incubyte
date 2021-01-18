package StringCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


public class StringTesting {
	 String inputString="\\[-][,][%]\n2,2,3,,,400,%,,$,600,5678,90,,89,,87,905667,903,4";
	
	// StringSum stringsum=new StringSum();
	 PatternMatching pattern=new PatternMatching();	
	 Extract extract=new Extract();
	 Numbers number=new Numbers();
	
	@Test 
	@Order(1)
	public void validStringFormat()
	{
		//stringsum.setString(inputString);
		assertEquals(true,pattern.isValidPattern(inputString));
		
	}
	

	@Test
	 @Order(2)
	public void validDelimitersBetweenDigits() 
	{
		//System.out.println(stringsum.getString());
			assertEquals(true,extract.extractingDigits(inputString));
			//System.out.println(Numbers.getValidNumbers());
			//System.out.println(Numbers.getNegativeNumbers());
		
	}	
	
	@Test
	@Order(3)
	public void checkNegativeNumbers()
	{
		
		assertThrows(InvalidInputString.class, () ->Numbers.findNegativeNumbers(),"Exception should be thrown for negative numbers");
	}


}
