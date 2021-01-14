package StringCalculator;

public class StringSum {
	
	String inputString;
	StringSum(String inputString)
	{
		this.inputString=inputString;
	}
	public int Add()
	{
		if(inputString.equals(""))
			return 0;
		else
		{
			String[] str=inputString.split(",");
			int sum=0;
			for(int i=0;i<str.length;i++)
				sum+=Integer.parseInt(String.valueOf(str[i]));
			return sum;
		}
	}
}
