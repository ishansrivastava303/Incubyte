package StringCalculator;

import java.util.regex.Pattern;

public class PatternMatching {
	String patternWithDefinedDelimiters="\\\\(\\[(\\n|.)\\])+\\n(\\d*[^0-9]*\\d+)+";
	String patternWithCommaAndNewline="\\d+(\n*,*\\d+)+$";
	String extractingDelimiterPattern="\\[(\\W?)\\]";
	//StringSum obj=new StringSum();
	
	public String getPattern(String inputString)
	{
		
		return extractingDelimiterPattern;
	}
	
	public boolean isValidPattern(String inputString) 
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
