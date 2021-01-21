package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.*;
public class StringSum {
	
	private static String inputString="2,2,3,,,400,%,,,-600,5678,90,,89,,87,9\n\n05***667,903,-4,,,,,,,,,*******-4";
	ArrayList<Integer> digits=new ArrayList<Integer>();
	String d[];
	static ArrayList<String>delimiter=new ArrayList<String>();
	String patternWithDefinedDelimiters="\\\\(\\[(\\n|.)\\])+\\n(\\d*[^0-9]*\\d+)+";
	String patternWithCommaAndNewline="\\d+(\n*,*\\d+)+$";
	String extractingDelimiterPattern="\\[(\\W?)\\]";
	ArrayList<Integer>negNumberIndices=new ArrayList<Integer>();
	ArrayList<Integer>negNumbers=new ArrayList<Integer>();
	HashSet<String>nodes=new HashSet<String>();
	public static void main(String args[])
	{
		delimiter.add("%");
		delimiter.add(",");
		delimiter.add("-");
		delimiter.add("^");
		delimiter.add("*");
		//StringSum obj=new StringSum();
		String s[]=inputString.split("%|,|\\*\\*\\*|-|\\n\\n");
		for(int i=0;i<s.length;i++)
			System.out.println(s[i]+" ");
		//System.out.println(s.length);
		//obj.print();
	}
	
	public Integer extractDigits(String s)
	{
		if(s.equals(""))
			return 0;
		if(Pattern.matches("-?\\d+", s))
			return Integer.parseInt(s);
		for(int i=0;i<delimiter.size();i++)
		{
			if(nodes.contains(s))
				continue;
			else
				nodes.add(s);
			int index=s.indexOf(delimiter.get(i));
			if(index==-1)
				continue;
			Integer left=extractDigits(s.substring(0,index));
			
			if(left !=0)
				digits.add(left);
			
			Integer right=extractDigits(s.substring(index+1,s.length()));
		
			if(right!=0)
				digits.add(right);
		}
		return 0;
	}
	
	public void print()
	{
		System.out.println(digits);
	}
	
	/*public void  setString(String input)
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
		
	}*/
	
}
