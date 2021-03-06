package StringCalculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {
	ArrayList<BigInteger> posnumbers=new ArrayList<BigInteger>();
	static HashSet<String>delimiter=new HashSet<String>();
	ArrayList<BigInteger>negNumbers=new ArrayList<BigInteger>();
	ArrayList<String>regexSpecialCharacters;
	PatternMatching patternmatching=new PatternMatching();

	/*This function extracts the valid delimiters from the given format //[any character][any character]\n1*/
	public void extractingDelimiters(String inputString)
	{

		Pattern pattern = Pattern.compile(patternmatching.getPattern(inputString));
		Matcher matcher = pattern.matcher(inputString);
		while(matcher.find())
		{
			String s=matcher.group(1);
			delimiter.add(s);
		}
		//System.out.println("delimiter:"+delimiter);
	}

	/*This function extracts negative numbers from the string if present.*/
	public void extractNegativeNumbers(String s)
	{
		Pattern pattern=Pattern.compile(patternmatching.getNegativeNumberPattern());
		Matcher matcher=pattern.matcher(s);
		while(matcher.find())
		{
			negNumbers.add(new BigInteger(matcher.group(1)));
		}
	}

	/*This function generates the regex expression which will be used as delimiter in split() function to split the string and 
	 * get the valid numbers*/
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
					
					/*Here we are checking that if any special character is in the list of valid delimiters 
					 * then we have to add an escape character in front of it. */
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

	/*This functions extracts the positive and negative numbers (if present) from the string and store it in their respective data structure.*/
	public boolean extractDigits(String inputString)
	{
		extractingDelimiters(inputString);

		int index=0;
		boolean validDelimiter=true;

		String splitDelimiter=generateSplitRegexExpression(inputString);

		index=inputString.indexOf("]\n");

		String str=inputString.substring(index+2);


		//System.out.println("splitdelimiter:"+splitDelimiter);

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
