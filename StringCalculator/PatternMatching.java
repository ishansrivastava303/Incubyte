package StringCalculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class PatternMatching {
	String patternWithDefinedDelimiters="\\\\(\\[(\\W*.*?\\W*.*)\\])+\\n(\\d*[^0-9]*\\d+)+";
	String patternWithCommaAndNewline="\\d+(\n*,*\\d+)+$";
	String extractingDelimiterPattern="\\[([^\\[\\]]+)\\]";
	String extractingDelimiterPattern2="\\d+(\\W?)\\d+";
	ArrayList<String>regexSpecialCharacters=new ArrayList<String>();
	//String patternWithDefinedDelimiters="\\\\(\\[.*?\\])+\\n\\d.*";
	//String patternWithDefinedDelimiters2="\\\\(\\n|.)+\\n(\\d*[^0-9]*\\d+)+";
	//String extractingDelimiterPattern="\\[(\\s+.+?|.*?)\\]";
	//String extractingDelimiterPattern2="\\\\(\\W?)\\n";
	//StringSum obj=new StringSum();
	
	
	public ArrayList<String> getRegexSpecialCharacters()
	{
		regexSpecialCharacters.add("+");
		regexSpecialCharacters.add("*");
		regexSpecialCharacters.add("?");
		regexSpecialCharacters.add("^");
		regexSpecialCharacters.add("$");
		regexSpecialCharacters.add("(");
		regexSpecialCharacters.add(")");
		regexSpecialCharacters.add("[");
		regexSpecialCharacters.add("]");
		regexSpecialCharacters.add("{");
		regexSpecialCharacters.add("}");
		regexSpecialCharacters.add("|");
		regexSpecialCharacters.add("\\");
		regexSpecialCharacters.add("\n");
		return regexSpecialCharacters;
	}
	public String getPattern(String inputString)
	{
		
		/*if(Pattern.matches(patternWithDefinedDelimiters, inputString))
			return extractingDelimiterPattern;
		
		else
			return extractingDelimiterPattern2;*/
		return extractingDelimiterPattern;
		
	}
	
	public boolean isValidPattern(String inputString) 
	{
		
		if(Pattern.matches(patternWithDefinedDelimiters, inputString) || inputString.equals("") 
		|| Pattern.matches(patternWithCommaAndNewline, inputString) )
			{
				return true;
			}
			
		else
			return false;
		
	}
}
