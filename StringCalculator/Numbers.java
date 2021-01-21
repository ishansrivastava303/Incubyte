package StringCalculator;

import java.math.BigInteger;
import java.util.ArrayList;

public class Numbers {

	static ArrayList<BigInteger>negNumbers=new ArrayList<BigInteger>();

	static ArrayList<BigInteger>validNumbers=new ArrayList<BigInteger>();

	public static void setValidNumbers(ArrayList<BigInteger> a)
	{
		validNumbers=a;
	}
	public static ArrayList<BigInteger> getValidNumbers()
	{
		return validNumbers;
	}
	public static void setNegativeNumbers(ArrayList<BigInteger> a)
	{
		negNumbers=a;
	}
	public static ArrayList<BigInteger> getNegativeNumbers()
	{
		return negNumbers;
	}
	public static void findNegativeNumbers() throws InvalidInputString
	{

		if(negNumbers.size()>0)
		{
			String s="negatives not allowed:";
			for(int i=0;i<negNumbers.size();i++)
				s+=negNumbers.get(i)+",";
			throw new InvalidInputString(s);
		}

	}
	public static BigInteger Add()
	{
		BigInteger sum=BigInteger.ZERO;
		BigInteger thousand=new BigInteger("1000");
		for(int i=0;i<validNumbers.size();i++)
		{
			int compareValue=validNumbers.get(i).compareTo(thousand);
			if(compareValue==1)
				continue;
			//System.out.println(validNumbers.get(i));
			sum=sum.add(validNumbers.get(i));
		}
		return sum;
	}
}
