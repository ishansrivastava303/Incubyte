package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.*;
public class StringSum {
	
	String inputString;
	ArrayList<Integer> digits=new ArrayList<Integer>();
	String d[];
	HashSet<String>delimiter=new HashSet<String>();
	String patternWithDefinedDelimiters="\\\\(\\[(\\n|.)+\\])+\\n(\\d*[^0-9]*\\d+)+";
	String patternWithCommaAndNewline="\\d+(\n*,*\\d+)+$";
	String extractingDelimiterPattern="\\[(\\W?)\\]";
	
	
	StringSum(String inputString)
	{
		this.inputString=inputString;
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
	
	public void extractingDigits() throws InvalidInputString
	{
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
					throw new InvalidInputString();
				if(Pattern.matches("\\d+", number))
				{
					digits.add(Integer.parseInt(number));
					number="";
				}
				
			}
		}
		digits.add(Integer.parseInt(number));
		System.out.println(digits);
	}
	public boolean validInput() 
	{
		
		if(Pattern.matches(patternWithDefinedDelimiters, inputString) || inputString.equals(""))
		{
			extractingDelimiters();
			return true;
		}
			
		if(Pattern.matches(patternWithCommaAndNewline, inputString))
		{
			//extractingDigits(inputString);
			return true;
		}
			
		return false;
		
	}
	
}
