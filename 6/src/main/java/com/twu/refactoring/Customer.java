package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.String.format;

public class Customer {
	private static final String First_line = "Rental Record for %s\n";
	private static final String Each_rental_record = "\t%s\t%s\n";
	private static final String Total_amount = "Amount owed is %s\n";
	private static final String Total_point = "You earned %s frequent renter points";

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	public String statement() {
		StringBuilder result = new StringBuilder(format(First_line, name));
		for (Rental rental : rentalList) {
			result.append(format(Each_rental_record,rental.getMovie().getTitle(),rental.getAmount(rental.getDaysRented())));
		}
		result.append(format(Total_amount,getTotalAmount()));
		result.append(format(Total_point,getTotalFrequentRenterPoints()));

		return result.toString();
	}

	public String getTotalAmount() {
		double totalAmount = 0.0;
		for (Rental rental : rentalList) {
			totalAmount += rental.getAmount(rental.getDaysRented());
		}
		return totalAmount+"";
	}

	public String getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentalList) {
			frequentRenterPoints += rental.getFrequentRenterPoints(rental.getDaysRented());
		}
		return frequentRenterPoints+"";
	}

	public String htmlStatement() {
		//todo
		String New_Each_rental_record = "%s: %s\n";
		StringBuilder result = new StringBuilder(format(First_line, name));
		for (Rental rental : rentalList) {
			result.append(format(New_Each_rental_record,rental.getMovie().getTitle(),rental.getAmount(rental.getDaysRented())));
		}
		result.append(format(Total_amount,getTotalAmount()));
		result.append(format(Total_point,getTotalFrequentRenterPoints()));

		String[] statement = result.toString().split("\n");
		String resultString = "<h1>" +statement[0] + "</h1>\n" +
				"<p>" + statement[1] + "<br>" +
				statement[2] + "<br>" +
				statement[3] + "<br></p>" +
				"<p>" + statement[4] + "</p>\n" +
				"<p>" + statement[5] + "</p>";
		return resultString;
	}

}
