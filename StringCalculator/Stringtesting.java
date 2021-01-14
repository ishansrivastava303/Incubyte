package StringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Stringtesting {

	@Test
	public void stringSum() {
		StringSum obj=new StringSum("");
		assertEquals(0, obj.getSum());
	}
	
	

}
