package StringCalculator;

import java.math.BigInteger;
import java.util.ArrayList;

public class Numbers {
	//ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
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
		for(int i=0;i<validNumbers.size();i++)
		{
			sum=sum.add(validNumbers.get(i));
		}
		return sum;
	}
}
