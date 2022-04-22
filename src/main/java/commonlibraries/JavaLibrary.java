package commonlibraries;

import java.util.Random;

public class JavaLibrary 
{
	public int getRandomNumber()
	{
		Random ran = new Random();
		return ran.nextInt(1000);
	}

	

}
