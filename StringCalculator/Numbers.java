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
	/*
	public void findNegativeNumbers(String inputString)
	{
		findNegSignIndices(inputString);
		String number="";
		for(int i=0;i<negNumberIndices.size();i++)
		{
			if(negNumberIndices.get(i)==inputString.length()-1)
				break;
			number="";
			if(Character.isDigit(inputString.charAt(negNumberIndices.get(i)+1)))
			{
				for(int j=negNumberIndices.get(i)+1;j<inputString.length();j++)
				{
					if(Character.isDigit(inputString.charAt(j)))
						number+=String.valueOf(inputString.charAt(j));
					else
						break;
				}
				negNumbers.add(Integer.parseInt(number)*(-1));
			}
		}
		System.out.println("negNumbers:"+negNumbers);
	}
	
	public void findNegSignIndices(String inputString)
	{
		int index=inputString.indexOf("\n");
		int negSignIndex=inputString.indexOf("-", index+1);
		while(negSignIndex>=0)
		{
			negNumberIndices.add(negSignIndex);
			negSignIndex=inputString.indexOf("-",negSignIndex+1);
		}
	}*/
	
}
