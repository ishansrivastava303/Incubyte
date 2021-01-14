package StringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Stringtesting {
	
	@Test
	public void stringSum() {
		StringSum obj=new StringSum("1,2,3,4,1");
		assertEquals(11, obj.Add());
	}
	
	@Test
	public void EmptyStringSum() {
		StringSum obj=new StringSum("");
		assertEquals(0, obj.Add());
	}

	
	
	

}
