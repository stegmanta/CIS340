package PA05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TicketTest {

	/*Array of Audience object*/
	static Audience[] audienceList;

	public static void main(String[] args) throws FileNotFoundException {

		/*Input variable declaration and initialization*/
		String name = "";
		int noOfAdvanceDays = 0;
		int numberOfAudience = 0;
		boolean status;
		int option;
		String studentID="";
		String ticketNumber = "";

		/*Get number of audience and create the Audience array*/
		//
		//
		numberOfAudience = gatherInput("How many tickets were purchased (number of audience)?"
										,"Number of audience must be at least 1" ,1);
		audienceList = new Audience[numberOfAudience];
				

		/*Loop over no of audience to create appropriate ticket objects*/
		for (int i = 0; i < numberOfAudience; i++) {
			//Fill in the logic to get the input data
			ticketNumber = String.format("T-%05d", (int)(Math.random() * 1000));
			/*
			 * GET name of audience
			 */
			while(true) {
			      name = JOptionPane.showInputDialog("Enter Customer Name:");
			      if(!name.matches("[A-Z][a-z]+\\s+[A-Z][a-z]+")|| name.isEmpty()) {
			    	  option = JOptionPane.showConfirmDialog(null, "Invalid Customer Name Input \n Would You Like To Try Again?", "Invalid Customer Name", JOptionPane.YES_NO_OPTION);
					  if (option != JOptionPane.YES_OPTION)
							System.exit(0);
			      } else
			    	  break;
		 	}// end get audience name
			
			//get number of days in advance
			noOfAdvanceDays = gatherInput("Enter Number of Days before the event"
					,"Number of days must be at least 0" ,0);
			if(noOfAdvanceDays ==0)
				addWalkupTicket(name, ticketNumber);
			
			//get if ticket buyer is student or not
			status = gatherInput("Are you a student?");
			if(!status) {
				addAdvancedTicket(name, ticketNumber, noOfAdvanceDays);
			}
			else {
				//get student ID
				studentID = JOptionPane.showInputDialog(null, "Enter student ID:");
				status = gatherInput("Are you an on-campus student?");
				if(status)
					addOncampusAdvanceTicket(name, ticketNumber, noOfAdvanceDays, studentID);
				else
					addOffcampusAdvanceTicket(name, ticketNumber, noOfAdvanceDays, studentID);
			}	
		}

		display(); // display the unsorted list of audience details
		selectionSort(); // sort the list based on ticketPrice
		JOptionPane.showMessageDialog(null, "Now here, is the output after sorting");
		display(); //display the sorted list
		writeToFile(); //write the sorted list to output file
	}

	/*Method to create Advanced Ticket object and add to audience array*/
	private static void addAdvancedTicket(String name, String ticketNumber, int days) {
		int index = Audience.getNoOfAudience();
		audienceList[index] = new Audience(name,new AdvancedTicket(ticketNumber, days));
	}

	/*Method to create Off campus Advanced Ticket object and add to audience array*/
	private static void addOffcampusAdvanceTicket(String name, String ticketNumber, int days, String ID) {
		int index = Audience.getNoOfAudience();
		audienceList[index] = new Audience(name,new OffcampusStudentAdvanceTicket(ticketNumber, days, ID));
	}

	/*Method to create On campus Advanced Ticket object and add to audience array*/
	private static void addOncampusAdvanceTicket(String name, String ticketNumber, int days, String ID) {
		int index = Audience.getNoOfAudience();
		audienceList[index] = new Audience(name,new OncampusStudentAdvanceTicket(ticketNumber, days, ID));
	}

	/*Method to create Walkup Ticket object and add to audience array*/
	public static void addWalkupTicket(String name, String ticketNumber){
		int index = Audience.getNoOfAudience();
		audienceList[index] = new Audience(name, new WalkupTicket(ticketNumber));
	}

	/*Method to display audience object details*/
	public static void display( ){
		String out = "";
		String header = "Name\tTicket Number\tTicket Price\tDate Purchased\tDays Advance\tStudentID\tIs On-Campus";
		for(int i = 0; i < audienceList.length; i++) {
			out += "\n" + audienceList[i].toString();
		}
		JOptionPane.showMessageDialog(null, new JTextArea(header + out));

	}

	/*Method to sort audience object based on ticketCost using compareTo() method*/
	public static void selectionSort() {
		for(int i = 0; i < audienceList.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < audienceList.length; j++) {
				//returns negative if j is less than the minIndex
				if(audienceList[j].compareTo(audienceList[minIndex]) < 0) {
					minIndex = j;
				}
			}//end inner for
			
			if(minIndex != i) {
				Audience temp = audienceList[i];
				audienceList[i] = audienceList[minIndex];
				audienceList[minIndex] = temp;
			}
		}//end outer for
	}

	/*Method to write audience object details into an output file*/
	public static void writeToFile() throws FileNotFoundException{
		File file = new File("Audience.txt");
		PrintWriter writer = new PrintWriter(file);
		writer.println("Name\tTicket Number\tTicket Price\tDate Purchased\tDays Advance\tStudentID\tIs On-Campus");
		for(int i = 0; i < audienceList.length; i++) {
			writer.println("\n" + audienceList[i].toString());
		}
	}
	
	//static method to help with gathering inputs
	public static int gatherInput(String msg, String errMsg, int minInclusive){
		int option;
		while(true) {
			try {
				int value = Integer.parseInt( JOptionPane.showInputDialog(null,msg));
				if(value < minInclusive)
					throw new Exception();
				else
					return value;
			}catch(Exception ex) {
				//if exception thrown check if they want to try again
				option = JOptionPane.showConfirmDialog(null, errMsg + ", Try again?","Invalid Input", JOptionPane.YES_NO_OPTION);
				  if (option != JOptionPane.YES_OPTION)
						System.exit(0);
			}
		}//end while
	}//end int input
	
	//overload gather input for boolean
	public static boolean gatherInput(String msg) {
		while(true) {
			int value;
			int option;
			String[] choices = {"Yes", "No"};
			value = JOptionPane.showOptionDialog(
					null,
					msg,
					"Title",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					choices,
					null
			);
			boolean bValue = value == 0 ? true: false;
			if(value >= 0) {
				return bValue;
			}else {
				option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}//end if else
		}//end while
	}//end boolean input

}// end class
