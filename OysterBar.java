import java.util.Scanner;
public class OysterBar {

		// Created by Rhiannon Dore
		// CSCI 150L - H1
		// Created 1/16/19
		// This is a program designed to that reads the sizes of the groups that arrive or depart a bar
	
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int maxPeople = 100;
        int currNum = 0;
        int input;

		while(currNum != maxPeople)
	        {
			 System.out.print("Enter number of people that arrive or depart" +
	                    " (use negative numbers for departures): ");

	            input = in.nextInt();
	            currNum += input;
			
	            if (currNum < 0)
	            {
	                System.out.println("Error, they're cannot be less than 0 people in the bar.");
	            }
	            else if (currNum > maxPeople)
	            {
	                System.out.println("The bar is full, no more customers can be seated");
	            }
	            else 
	            {
	                System.out.printf("Number of people in the bar now is %d%n", currNum);
	            }
	        }
	        System.out.print("The bar is full.");
	    }//main


	}
	

	


