package StringCalculator;

import java.util.ArrayList;
import java.util.regex.*;
public class StringSum {
	
	String inputString;
	ArrayList<Integer> digits=new ArrayList<Integer>();
	String delimiter[];
	String patternWithDefinedDelimiters="^(\\\\\\[\\W+]\\n).*";
	String patternWithCommaAndNewline="\\d+(\n*,*\\d+)+$";
	String extractingDelimiterPattern="\\\\\\[(\\W+)\\]\\n.*";
	StringSum(String inputString)
	{
		this.inputString=inputString;
		//validInput();
	}
	public void extractingDelimiters(String patternWithDefinedDelimiters,String extractingDelimiterPattern, String inputString)
	{
		
			Pattern pattern = Pattern.compile(extractingDelimiterPattern);
			Matcher matcher = pattern.matcher(inputString);
			while(matcher.find())
			{
				delimiter=matcher.group(1).split("");
			}
	}
	
	public boolean validInput()
	{

		if(Pattern.matches(patternWithDefinedDelimiters, inputString) || inputString.equals(""))
		{
			extractingDelimiters(patternWithDefinedDelimiters,extractingDelimiterPattern,inputString);
			return true;
		}
			
		if(Pattern.matches(patternWithCommaAndNewline, inputString))
			return true;
		return false;
		
	}
	
}
