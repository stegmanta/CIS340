package PP02;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number) {
		return validating.aValidNumber(number);
	} // end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
	public static String createHashCode(String number) {
		return hashing.getHashCode(number);
	} // end of the createHashCode method

	// it adds a new customer to the array of customers once the payment was successful
	public static void addCustomer(Customer customer) {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] == null) {
				customers[i] = customer;
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Customer array is full!", "Error", JOptionPane.ERROR_MESSAGE);
	} // end of the addCustomer method

	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat() {
		if (customers == null || customers.length == 0 || customers[0] == null) {
			JOptionPane.showMessageDialog(null, "No valid payments to display statistics.");
			return;
		}
		double sum = 0;
		double max = customers[0].getAmount();
		double min = customers[0].getAmount();
		int count = 0;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null) {
				double amt = customers[i].getAmount();
				sum += amt;
				if (amt > max)
					max = amt;
				if (amt < min)
					min = amt;
				count++;
			}
		}
		if (count > 0) {
			double avg = sum / count;
			JOptionPane.showMessageDialog(null, "Payment Statistics:\nAverage Payment: " + avg + "\nMaximum Payment: " + max + "\nMinimum Payment: " + min);
		} else {
			JOptionPane.showMessageDialog(null, "No valid payments to display statistics.");
		}
	} // end of the displayStat method

	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
	public static void writeToFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("Customer.txt"))) {
			writer.println("Customer Data:");
			for (int i = 0; i < customers.length; i++) {
				if (customers[i] != null) {
					Customer customer = customers[i];
					CreditCard card = customer.getCard();
					String encryptedCard = createHashCode(String.valueOf(card.getNumber()));
					writer.printf("%s, %s, ID: %d, Amount: %.2f, Card: %s, Expiry: %s%n",
							customer.getfName(), customer.getlName(), customer.getId(),
							customer.getAmount(), encryptedCard, card.getExpDate());
				}
			}
			JOptionPane.showMessageDialog(null, "Customer data written to file successfully!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error writing file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	} // end of the writeToFile method

	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) {
		hashing = new HashCode();
		validating = new Validation();
		int n = 0;
		while (true) {
			try {
				n = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of customers:"));
				if (n <= 0)
					throw new NumberFormatException();
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number of customers. Please enter a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		customers = new Customer[n];
		for (int i = 0; i < n; i++) {
			String fName = "";
			while (fName == null || fName.trim().isEmpty()) {
				fName = JOptionPane.showInputDialog("Enter first name:");
			}
			String lName = "";
			while (lName == null || lName.trim().isEmpty()) {
				lName = JOptionPane.showInputDialog("Enter last name:");
			}
			int id = 0;
			while (true) {
				try {
					id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid ID. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (id == 0) {
				JOptionPane.showMessageDialog(null, "ID 0 entered. Terminating input.");
				break;
			}
			double amount = 0;
			while (true) {
				try {
					amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:"));
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			String cardNumber = "";
			while (cardNumber == null || cardNumber.trim().isEmpty()) {
				cardNumber = JOptionPane.showInputDialog("Enter credit card number:");
			}
			String expDate = "";
			while (expDate == null || expDate.trim().isEmpty()) {
				expDate = JOptionPane.showInputDialog("Enter expiry date (MM/YY):");
			}

			CreditCard card = new CreditCard(Long.parseLong(cardNumber), expDate);

			// Validate the credit card before adding the customer
			if (isValidCard(cardNumber)) {
				Customer customer = new Customer(fName, lName, id, amount, card);
				addCustomer(customer); // Add the customer to the array
				JOptionPane.showMessageDialog(null, "Customer added successfully!");
			} else {
				JOptionPane.showMessageDialog(null, "Invalid credit card number! Customer not added. Exiting ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (customers.length > 0) {
			String output = "";
			for (Customer c : customers) {
				if (c != null) {
					output += c.toString() + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, output);
		} else {
			JOptionPane.showMessageDialog(null, "No valid customers were added.");
		}
		displayStat();
		writeToFile();
	}
}
