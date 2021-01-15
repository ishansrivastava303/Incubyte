package StringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Stringtesting {
	private String inputString="";
	
	@Test
	public void isInputValid()
	{
		StringSum obj=new StringSum(inputString);
		assertEquals(true,obj.validInput());
	}
	
	
	
	
	
	

	
	
	

}
