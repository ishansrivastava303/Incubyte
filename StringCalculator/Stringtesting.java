package StringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Stringtesting {
	private String inputString="\\[^[,][%]\n1,2,3,,,400,%,,,600,,,,,,89,,87,905667,90";
	StringSum obj=new StringSum(inputString);
	
	@Test 
	public void IsStartOfStringValid()
	{
			assertEquals(true,obj.validInput());
		
	}
	
	/*@Test(expected = InvalidInputString.class)
	public void invalidDelimitersBetweenDigits() throws InvalidInputString
	{
		try {
			StringSum obj=new StringSum(inputString);
			obj.extractingDigits();
			//assertEquals(true,obj.validInput());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}*/

	@Test
	public void validDelimitersBetweenDigits() 
	{
			assertEquals(true,obj.extractingDigits());
		
	}
	
	
	
	
	
	
	
	

	
	
	

}
