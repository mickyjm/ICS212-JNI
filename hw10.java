/*****************************************************************
*
* NAME: Michael Mangrobang
*
* HOMEWORK: 10
*
* CLASS: ICS 212
*
* INSTRUCTOR: Ravi Narayan
*
* DATE: December 10, 2015
*
* FILE: hw10.java
*
* DESCRIPTION: Main driver file. Uses Java to get input and print
*              ouput. Uses JNI to convert and round up input
*
*****************************************************************/

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class hw10
{

	public native float convertFtoC(int fahrenheit);
  
	public native int roundUp(int degree);

	static
	{
		System.loadLibrary("HW10");
	}
	
	public static void main(String[] args)
	{

		hw10 hw;
		Scanner scan;
    
		int input;
		
		hw = new hw10();
		scan = new Scanner(System.in);
		
		input = 0;
		
		System.out.println("Hello User! \nWelcome to Micky's Java Native Interface Temperature Conversion Program!");
		System.out.println("This program runs from Java and converts your input with C code!");

		System.out.print("Please enter an integer for your max temperature in F: ");
    
		input = scan.nextInt();
    
		while (input <= 0)
		{
			
			if (input < 0)
			{
				System.out.println("Input is less than 0.");
			}
			else if (input == 0)
			{
				System.out.println("Input is 0.");
			}
			
			System.out.print("Please enter an integer greater than 0: ");
			
			input = scan.nextInt();
			
		}
	
		input = hw.roundUp(input);

		System.out.println("Max Temperature: " + input + " F");
		System.out.println("Temperature in: \nF\tC");
    
		hw.printTemperature(input);

	}

/*****************************************************************
*
* Function name: printTemperature
*
* DESCRIPTION: Prints temperature from 0 to max rounded input.
*              Calls Native function to convert fahrenheit to celsius
*
* Parameters: maxDegree (int): The max rounded input to print up to
*
*****************************************************************/
  
	private void printTemperature(int maxDegree)
	{
    
		DecimalFormat df;
	
		int currentDegree;
    
		float celsius;
    
		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
	
		currentDegree = 0;
    
		while (currentDegree <= maxDegree)
		{
			celsius = convertFtoC(currentDegree);

			System.out.println(currentDegree + "\t" + df.format(celsius));
			
			currentDegree += 5;
		}
    
	}

}
