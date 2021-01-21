package StringCalculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {
	ArrayList<Integer> posnumbers=new ArrayList<Integer>();
	String d[];
	static HashSet<String>delimiter=new HashSet<String>();
	ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
	ArrayList<Integer>negNumbers=new ArrayList<Integer>();
	ArrayList<String>regexSpecialCharacters;
	PatternMatching patternmatching=new PatternMatching();
	//StringSum stringsum=new StringSum();
	
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
		
		splitDelimiter=splitDelimiter.substring(0,splitDelimiter.length()-1);
		
		System.out.println("splitdelimiter:"+splitDelimiter);
		
		String ans[]=str.split(splitDelimiter);
		
		for(String i:ans)
		{
			if(!Pattern.matches("-?\\d+", i))
			{
				validDelimiter=false;
				continue;
			}
				
			if(Pattern.matches("-\\d+", i))
				negNumbers.add(Integer.parseInt(i));
			else
				posnumbers.add(Integer.parseInt(i));
		}
		
		Numbers.setValidNumbers(posnumbers);
		Numbers.setNegativeNumbers(negNumbers);
		
		if(validDelimiter)
			return true;
		else
			return false;
	}
}
