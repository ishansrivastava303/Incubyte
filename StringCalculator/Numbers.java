package StringCalculator;

import java.util.ArrayList;

public class Numbers {
	//ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
	static ArrayList<Integer>negNumbers=new ArrayList<Integer>();
	static ArrayList<Integer>validNumbers=new ArrayList<Integer>();
	
	public static void setValidNumbers(ArrayList<Integer> a)
	{
		validNumbers=a;
	}
	public static ArrayList<Integer> getValidNumbers()
	{
		return validNumbers;
	}
	public static void setNegativeNumbers(ArrayList<Integer> a)
	{
		negNumbers=a;
	}
	public static ArrayList<Integer> getNegativeNumbers()
	{
		return negNumbers;
	}
	public static void findNegativeNumbers() throws InvalidInputString
	{
		
		if(negNumbers.size()>0)
		{
			String s="negatives not allowed:";
			for(int i:negNumbers)
				s+=i+",";
			throw new InvalidInputString(s);
		}
			
	}
	public static Integer Add()
	{
		int sum=0;
		for(int i=0;i<validNumbers.size();i++)
		{
			sum+=validNumbers.get(i);
		}
		return sum;
	}
}
