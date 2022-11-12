package tax.calculator;

import java.util.Scanner;

public class IncomeTax {		
	static void calculateTax(double ti) { // ti -> total income
		double tax = 0; 
		if(ti >= 5280 && ti <= 67440) tax = (ti*0.2) - 10560; // first batch 
		else if(ti > 67440) tax = ((67440*0.2) + (ti-67440)*0.3) - 10560; // second batch
		else {}
		System.out.println("Total Annual Tax is: M "+tax+"0"); 
		System.out.println("Total Annual Income is: M "+(ti - tax+"0")); 
	} 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); // scanner object 
		System.out.print("Enter Total Annual Income: M "); 
		double total_income = sc.nextDouble(); // accept console input 
		calculateTax(total_income); // calculate tax 
		sc.close(); // close scanner 	
	}
}
