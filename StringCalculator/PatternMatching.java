package StringCalculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class PatternMatching {
	
	String patternWithDefinedDelimiters="\\\\(\\[(\\W*.*?\\W*.*)\\])+\\n(\\d*[^0-9]*\\d+)+";
	
	String extractingDelimiterPattern="\\[([^\\[\\]]+)\\]";
	
	String negativeNumberPattern="(\\-\\d+)";
	
	ArrayList<String>regexSpecialCharacters=new ArrayList<String>();
	
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
	
	public String getNegativeNumberPattern()
	{
		return negativeNumberPattern;
	}
	
	public int isEmptyInput(String inputString)
	{
		if(inputString.equals(""))
			return 0;
		else
			return 1;
	}
	
	public boolean isValidPattern(String inputString) 
	{
		
		if(Pattern.matches(patternWithDefinedDelimiters, inputString))
			return true;
		
		else
			return false;
		
	}
}
