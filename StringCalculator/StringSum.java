package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.*;
public class StringSum {
	
	private static String inputString;
	ArrayList<Integer> digits=new ArrayList<Integer>();
	String d[];
	HashSet<String>delimiter=new HashSet<String>();
	String patternWithDefinedDelimiters="\\\\(\\[(\\n|.)\\])+\\n(\\d*[^0-9]*\\d+)+";
	String patternWithCommaAndNewline="\\d+(\n*,*\\d+)+$";
	String extractingDelimiterPattern="\\[(\\W?)\\]";
	ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
	ArrayList<Integer>negNumbers=new ArrayList<Integer>();
	
	
	
	public void  setString(String input)
	{
		inputString=input;
	}
	
	public static String getString()
	{
		return inputString;
	}
	
	public void findNegativeNumbers()
	{
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
	
	public void findNegSignIndices()
	{
		int index=inputString.indexOf("\n");
		int negSignIndex=inputString.indexOf("-", index+1);
		while(negSignIndex>=0)
		{
			negNumberIndices.add(negSignIndex);
			negSignIndex=inputString.indexOf("-",negSignIndex+1);
		}
	}
	
	public boolean extractingDigits() 
	{
		extractingDelimiters();
		findNegSignIndices();
		findNegativeNumbers();
		String number="";
		int index=inputString.indexOf("\n");
		for(int i=index+1;i<inputString.length();i++)
		{
			char c=inputString.charAt(i);
			if(Character.isDigit(c))
			{
				number+=c;
			}
			else
			{
				
				if(!delimiter.contains(String.valueOf(c)))
					return false;
				if(Pattern.matches("\\d+", number))
				{
					digits.add(Integer.parseInt(number));
					number="";
				}
				
			}
		}
		
		if(Pattern.matches("\\d+", number))
		{
			digits.add(Integer.parseInt(number));
		}
		
		System.out.println(digits);
		return true;
	}
	
	public void extractingDelimiters()
	{
		
			Pattern pattern = Pattern.compile(extractingDelimiterPattern);
			Matcher matcher = pattern.matcher(inputString);
			while(matcher.find())
			{
				String s=matcher.group(1);
				delimiter.add(s);
			}
			System.out.println(delimiter);
	}
	public boolean validInput() 
	{
		
		if(Pattern.matches(patternWithDefinedDelimiters, inputString) || inputString.equals(""))
		{
			return true;
		}
			
		if(Pattern.matches(patternWithCommaAndNewline, inputString))
		{
			return true;
		}
			
		return false;
		
	}
	
}
