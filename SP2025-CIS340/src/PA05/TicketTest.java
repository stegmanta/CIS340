package PA05;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TicketTest {

	/*Array of Audience object*/
	static Audience[] audienceList;

	public static void main(String[] args) {

		/*Input variable declaration and initialization*/
		String name = "";
		int noOfAdvancedays = 0;
		int numberOfAudience = 0;
		int status = 0;
		String studentID="";
		String ticketNumber = "";

		/*Get number of audience and create the Audience array*/
		//
		//

		/*Loop over no of audience to create appropriate ticket objects*/
		for (int i = 0; i < numberOfAudience; i++) {

			//Fill in the logic to get the input data
		}

		display(); // display the unsorted list of audience details
		selectionSort(); // sort the list based on ticketPrice
		display(); //display the sorted list
		writeToFile(); //write the sorted list to output file
	}

	/*Method to create Advanced Ticket object and add to audience array*/
	private static void addAdvancedTicket(String name, String ticketNumber, int days) {

	}

	/*Method to create Off campus Advanced Ticket object and add to audience array*/
	private static void addOffcampusAdvanceTicket(String name, String ticketNumber, int days, String ID) {

	}

	/*Method to create On campus Advanced Ticket object and add to audience array*/
	private static void addOncampusAdvanceTicket(String name, String ticketNumber, int days, String ID) {

	}

	/*Method to create Walkup Ticket object and add to audience array*/
	public static void addWalkupTicket(String name, String ticketNumber){

	}

	/*Method to display audience object details*/
	public static void display( ){

	}

	/*Method to sort audience object based on ticketCost using compareTo() method*/
	public static void selectionSort() {

	}

	/*Method to write audience object details into an output file*/
	public static void writeToFile() {


	}

}// end class
