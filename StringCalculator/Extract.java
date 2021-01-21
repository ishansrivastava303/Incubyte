package StringCalculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {
	ArrayList<BigInteger> posnumbers=new ArrayList<BigInteger>();
	String d[];
	static HashSet<String>delimiter=new HashSet<String>();
	ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
	ArrayList<BigInteger>negNumbers=new ArrayList<BigInteger>();
	ArrayList<String>regexSpecialCharacters;
	PatternMatching patternmatching=new PatternMatching();
	
	public void extractingDelimiters(String inputString)
	{
		
			Pattern pattern = Pattern.compile(patternmatching.getPattern(inputString));
			Matcher matcher = pattern.matcher(inputString);
			while(matcher.find())
			{
				String s=matcher.group(1);
				delimiter.add(s);
			}
			System.out.println("delimiter:"+delimiter);
	}
	
	public void extractNegativeNumbers(String s)
	{
		Pattern pattern=Pattern.compile(patternmatching.getNegativeNumberPattern());
        Matcher matcher=pattern.matcher(s);
        while(matcher.find())
			{
			    negNumbers.add(new BigInteger(matcher.group(1)));
			}
	}
	
	public  String generateSplitRegexExpression(String inputString)
	{
		String splitDelimiter="";
		
		regexSpecialCharacters=patternmatching.getRegexSpecialCharacters();
		for(String s:delimiter)
		{
			if(!delimiter.contains(s))
				continue;
			else
			{
				for(int i=0;i<s.length();i++)
				{
					String str=String.valueOf(s.charAt(i));
					if(regexSpecialCharacters.contains(str))
					{
						if(str.equals("\n"))
							splitDelimiter+="\\n";
						else
						splitDelimiter+="\\"+str;
					}
						
					else
						splitDelimiter+=str;
				}
				splitDelimiter+="|";
				
			}
				
		}
		
		splitDelimiter=splitDelimiter.substring(0,splitDelimiter.length()-1);
		return splitDelimiter;
		
		
	}
	
	public boolean extractDigits(String inputString)
	{
		extractingDelimiters(inputString);
		
		int index=0;
		boolean validDelimiter=true;
		
		String splitDelimiter=generateSplitRegexExpression(inputString);
		
		index=inputString.indexOf("]\n");
		
		String str=inputString.substring(index+2);
		
		
		System.out.println("splitdelimiter:"+splitDelimiter);
		
		String ans[]=str.split(splitDelimiter);
		
		for(String i:ans)
		{
			if(!Pattern.matches("\\d+", i))
			{
				validDelimiter=false;
				extractNegativeNumbers(i);
				continue;
			}
				
			
			else
				posnumbers.add(new BigInteger(i));
		}
		
		Numbers.setValidNumbers(posnumbers);
		Numbers.setNegativeNumbers(negNumbers);
		
		if(validDelimiter)
			return true;
		else
			return false;
	}
}
