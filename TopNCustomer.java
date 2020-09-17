import java.util.ArrayList;
import java.util.Scanner;
public class TopNCustomer {
	
			// Created by Rhiannon Dore
			// CSCI 150L - H1
			// Created 1/20/19
			// This is a program designed to prompt the cashier to enter all prices and names, adds them to two array lists, calls the method that you implemented, and displays the result

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Array List

        ArrayList<Double> sales = new ArrayList<Double>();
        ArrayList<String> customers = new ArrayList<String>();
        
        // establish price at 0

        boolean zeroPrice = false;
        
        // prepare for sale input
        
        while (!zeroPrice) {
            System.out.println("Please enter the customer's sale followed by their first name.");
            System.out.print("Sale: ");
            double sale = input.nextDouble();

            // prepare for customer 
            
            if (sale != 0) {
                sales.add(sale);
                System.out.print("Customer: ");
                String customer = input.next();
                customers.add(customer);
            } else {
                zeroPrice = true;
                System.out.println("There were no more customers.");
            }
        }
        // Ask how many "best customers" the user would like to see
        
        System.out.print("Please enter how many best customers you would like to see:");
        int topN = input.nextInt();
        
        input.close();
        
        // List best customers of the day
        
        System.out.println("The best customers are: ");
        ArrayList<String> bestCustomers = nameOfBestCustomers(sales, customers, topN);
        for (int i = 0; i < bestCustomers.size(); i++) {
            System.out.println(bestCustomers.get(i));
        }
    } //main

	// implement nameOfBestCustomers method
	
    public static ArrayList<String> nameOfBestCustomers(ArrayList<Double> sales, ArrayList<String> customers, int topN) {
        if (topN >= customers.size()) {
            return customers;
        } else {
            ArrayList<String> topCustomers = new ArrayList<String>();

            while (topN > 0) {
                String topCustomer = getTopCustomer(sales, customers);
                topCustomers.add(topCustomer);

                int customerIn = customers.indexOf(topCustomer);
                sales.remove(customerIn);
                customers.remove(customerIn);

                topN--;
            }

            return topCustomers;
        }
    } //nameOfBestCustomers

    //top customer sales
    
    public static String getTopCustomer(ArrayList<Double> sales, ArrayList<String> customers) {
        double largestSale = 0;
        int largeSaleIn = 0;

        for (int i = 0; i < sales.size(); i++) {
            double currentSale = sales.get(i);

            if (currentSale > largestSale) {
                largestSale = currentSale;
                largeSaleIn = i;
            }
        }

        return customers.get(largeSaleIn);
    }
}