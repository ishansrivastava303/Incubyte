package StringCalculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {
	ArrayList<Integer> digits=new ArrayList<Integer>();
	String d[];
	HashSet<String>delimiter=new HashSet<String>();
	ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
	ArrayList<Integer>negNumbers=new ArrayList<Integer>();
	
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
			//System.out.println("delimiter:"+delimiter);
	}
	
	public boolean extractingDigits(String inputString) 
	{
		extractingDelimiters(inputString);
		
		String number="";
		ArrayList<Integer> negativeNumbers=new ArrayList<>();
		int negativeNumberFlag=0;
		int validDelimiter=1;
		int index=inputString.indexOf("\n");
		for(int i=index+1;i<inputString.length();i++)
		{
			char c=inputString.charAt(i);
			if(Character.isDigit(c))
			{
				if(inputString.charAt(i-1)=='-' && negativeNumberFlag==0)
					negativeNumberFlag=1;
				number+=c;
			}
			else
			{
				
				if(!delimiter.contains(String.valueOf(c)))
					validDelimiter=0;
				if(Pattern.matches("\\d+", number) && negativeNumberFlag==1)
				{
					negativeNumbers.add(Integer.parseInt(number)*(-1));
					number="";
					negativeNumberFlag=0;
				}
				
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
		
		if(Pattern.matches("\\d+", number) && negativeNumberFlag==1)
		{
			negativeNumbers.add(Integer.parseInt(number)*(-1));
			number="";
			negativeNumberFlag=0;
		}
		
		System.out.println("positiveNumbers:"+digits);
		System.out.println("negativenumbers:"+negativeNumbers);
		Numbers.setValidNumbers(digits);
		Numbers.setNegativeNumbers(negativeNumbers);
		if(validDelimiter==0)
			return false;
		else return true;
	}
}
