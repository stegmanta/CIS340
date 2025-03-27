package PhoneBillGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;



public class PhoneBillGUI extends JFrame implements ActionListener{
	
	// Array of customers 
	private Customer[] customers;
	
	// file name
	private String fileName;
	
	  // declare all UI components below
	  // UI Labels
	  private JLabel lblName;
	  private JLabel lblNumber;
	  private JLabel lblMinutes;
	  private JLabel lblParticipants;
	  
	  // UI TextFields   
	  private JTextField txtName;
	  private JTextField txtNumber;
	  private JTextField txtMinutes;
	  private JTextField txtParticipants; 
	  
	  
	  // UI Buttons
	  private JButton btnAdd;
	  private JButton btnClose;
	  private JButton btnSave;
	  private JButton btnSort;
	  
	  //UI TextArea & ScrollPane
	  private JTextArea textArea;
	  private JScrollPane jp;
	  
	  // UI RadioButtons
	  JRadioButton goBillRbt ;
      JRadioButton contractBillRbt;
      ButtonGroup groupRbt;

		      	
	// class constructor
	PhoneBillGUI(String fileName, int noOfCustomers) throws FileNotFoundException{
			
		    this.fileName = fileName;
		
		    // create an array of customers
			int fileSize = getFileLength(this.fileName);
			customers = new Customer[noOfCustomers+fileSize];
	       
	        // call methods to do the layout
			initComponent();
			doTheLayout();
			
			// add buttons to the action listeners
			// To Complete
			
			// call read data from file
			readFromFile(this.fileName);
			
		}// end WaterBillGUI

		private void initComponent(){
			
		// Initialize the GUI components
		// labels 
		// To Complete
		this.lblName = new JLabel("Name");
		this.lblNumber = new JLabel("Number");
		this.lblMinutes = new JLabel("Minutes");
		this.lblParticipants = new JLabel("Participants");
		
		// text fields 
		// To Complete
		this.txtName = new JTextField(20);
		this.txtNumber = new JTextField(10);
		this.txtMinutes = new JTextField(10);
		this.txtParticipants = new JTextField(10);
		
//		this.txtMinutes.setEditable(false);
//		this.txtParticipants.setEditable(false);
		// set editable false for txtMinutes and txtParticipants
		
			
			
		// radio buttons
		// To Complete
		// UI Buttons
	    this.goBillRbt = new JRadioButton("Go Bill", true);
	    this.contractBillRbt = new JRadioButton("Go Bill");
	    
		// radio buttons to ButtonGroup
		// To Complete	   
	    this.groupRbt = new ButtonGroup();
	    this.groupRbt.add(this.goBillRbt);
	    this.groupRbt.add(this.contractBillRbt);
	    
	    // add listener to the radio button goBillRbt to set editable true/false for txtMinutes & txtParticipants 
	    //later
	    
	    
		// add listener to the radio button contractBillRbt to set editable true/false for txtMinutes & txtParticipants
		//later
	    
	    
		// buttons
		// To Complete	
	    this.btnAdd =  new JButton("Add");
	    this.btnClose =  new JButton("Close");
	    this.btnSave=  new JButton("Save");
	    this.btnSort=  new JButton("Sort");
	    
		// define text area and add it to scroll pane
		// To Complete
	    this.textArea = new JTextArea("Program Display\n", 10, 30);
	    this.jp = new JScrollPane(this.textArea);
		this.textArea.setEditable(false);
	  
		} // end initComponent

	   private void doTheLayout(){
			// Organize the components into GUI window
		    // declare top, center, centerTop, centerBottom, and bottom panels
		    // To Complete
		   JPanel top = new JPanel();
		   JPanel centerTop = new JPanel();
		   JPanel center = new JPanel();
		   JPanel centerBottom= new JPanel();
		   JPanel bottom = new JPanel();
		   
	        // add components to the top panel
		    // To Complete
		   top.add(lblName);
		   top.add(txtName);
		   top.add(this.goBillRbt);
		   top.add(this.contractBillRbt);
		     		      
		    // set the BorderLayout layout for the center panel
		    // To Complete
		   center.setLayout(new BorderLayout());
		   center.setBorder(new LineBorder(Color.black,2));
		  
		   // add components to the centerTop panel
		   // To Complete
		   centerTop.add(lblNumber);
		   centerTop.add(txtNumber);
		   centerTop.add(lblMinutes);
		   centerTop.add(txtMinutes);
		   centerTop.add(lblParticipants);
		   centerTop.add(txtParticipants);
		   
		    // add components to the centerBottom panel
		   // To Complete 
		   centerBottom.add(this.btnAdd);
		   centerBottom.add(this.btnClose);
		   centerBottom.add(this.btnSave);
		   centerBottom.add(this.btnSort);
		    
		   // add panels centerTop and centerBottom to the center panel
		   // use BorderLayout.CENTER and BorderLayout.SOUTH  
		   // To Complete
		   center.add(centerTop, "North");
		   center.add(centerBottom, "Center");
		      
		   // add the JB scroll pane to the bottom panel
		   // To Complete
		   bottom.add(jp);

		    //add the top, center, and bottom panels to the JFrame GUI content pane
		    // To Complete
		   add(top, "North");
		   add(center, "Center");
		   add(bottom, "South");
		   
		 
		}// end doTheLayout

	    // Provide the implementation to the actionPerformed method of the ActionListener interface
		@Override
		public void actionPerformed(ActionEvent e) {
		// use if statement to call proper methods to process user events
			// To Complete
		} // end actionPerformed

		// Response when the Close button is clicked
		private void btnCloseClicked() {
			// exit program
			JOptionPane.showMessageDialog(null, "Program Exit!");
			System.exit(0);
		}//end btnCloseClicked

		
		// Response when the Save button is clicked
		private void saveBnttonClicked() throws FileNotFoundException{
			// code to be executed once the save button is clicked
			sortBill();
			writeToFile("PhoneBillOut.txt");
			display();
		}//end saveBnttonClicked
		
		
		// Response when the Sort button is clicked
		private void sortBnttonClicked(){
			// code to be executed once the close button is clicked
			sortBill();
			display();
			
		}//end sortBnttonClicked
		
		// Response when the Add button is clicked
		private void btnAddClicked(){
			// code to be executed once the add button is clicked
			// validation .... 
			// declare local variables
			String name = "";
			int number = 0;
			int minutes = 0;
			int participants =0;
			
			// read and validate (Not Empty) input of txtname, use if-statement 
			// To Complete
			
			// read and validate input txtnumber, use try catch for input validations
			// To Complete
			
						
						
			// based on selected radio button call method addCusomer(), with a specific bill type
			//read and validate input txtminutes, use try-catch
			//Or
			//read and validate input txtparticipants, use try-catch
			// To Complete
			// To Complete
			
			// clear text fields from data
			txtName.setText("");
			txtNumber.setText("");
			txtMinutes.setText("");
			txtParticipants.setText("");
			

		}// end btnAddClicked

	
		public void addCustomer(String name, int custId, int minutes, int noOfParticipants, int custType) {
			
			// add Customer object to the customers array
			// This method must check whether the array if full 
			// To Complete
			if (custType == BaseCharge.GO_BILL)
			        customers[Customer.getNoOfCustomers()] =
					new Customer(name, custId, new GoBill(minutes));
			else if (custType == BaseCharge.CONTRACT_BILL)
				    customers[Customer.getNoOfCustomers()] =
				    new Customer(name, custId, new ContractBill(noOfParticipants));
			
			display();
				
		}// end addCustomer

		// display two after sorting areas
		private  void display() {
			// output the areas after sorting
			String out ="Phone Bill:\n" + "Number\t" + "Name\t" + "Type\t" +
	                "Minutes\t" + "Participants\t" + "Value\t" + "Date";
			for (int i =0; i < Customer.getNoOfCustomers(); i++)
				out+= "\n" + customers[i].toString();
			
			  // add the bill average
			  out+= "\n Avg Phone Bill Values: " + String.format("%.2f",avg());
			  
			  // add the minimum phone bill value
			  out+= "\n The Min Phone Bill Customer: " + customers[minIndex()].toString();
			  
			  // add the maximum phone bill value
			  out+= "\n The Max Phone Bill Customer: " + customers[maxIndex()].toString();
			
			// display message to the text area, use setText() method
			// To Complete
			
		}// displayBill
	
	private void sortBill() {
			// Sorting arrays using the selection sort based on bill value
		    for (int i = 0; i < customers.length -1; i++) {
		        
		        // Find the minimum in the list[i..list.length-1]
		        Customer currentMin = customers[i];
		        int currentMinIndex = i;
		        
		        for (int j = i + 1; j < customers.length; j++) {
		          if (currentMin.getName().compareTo(customers[j].getName()) > 0) {
		            currentMin = customers[j];
		            currentMinIndex = j;
		          }
		        } // end inner for loop

		        // Swap list[i] with list[currentMinIndex] if necessary;
		        if (currentMinIndex != i) {
		        	customers[currentMinIndex] = customers[i];
		        	customers[i] = currentMin;
		       }
		      } // end outer for loop
		    
		    JOptionPane.showMessageDialog(null, "Done Sorting Customers Array!");
		    
		    display();
		    
		}// end sortBill
	
void writeToFile(String fileName) throws FileNotFoundException {
	    
		// create a file object
		File file = new File(fileName);
		
		// create the PrintWriter object
		PrintWriter p = new PrintWriter(file);
		
		// output the areas after sorting
				String out ="Phone Bill:\n" + "Number\t" + "Name\t" + "Type\t" +
		                     "Minutes\t" + "Participants\t" + "Value\t" + "Date";
				
				for (int i =0; i < customers.length; i++)
					out+= "\n" + customers[i].toString();
				
		// write data to file
		p.print(out);
		
		// close file
		p.close();
		
		JOptionPane.showMessageDialog(null, "Done Writing Array to file outputPhoneBill.txt");
		
	}// end method writeToFile
	
	// To read the file size, number of customers
	public int getFileLength(String fileName) throws FileNotFoundException {
		
	    //To Complete in class
	    // read data from inputWaterBill, (see week 03 - Text I/O files)
		// Create a File instance
	    File file = new File(fileName);
	
	    // Create a Scanner for the file
	    Scanner sc = new Scanner(file);

	    // Read data from a file, the data fields are separated by ',' 
	    // Change the Scanner default delimiter to ','
	   
	    
	   // Start reading data from file using while loop
	 
	    int i = 0;
	    while (sc.hasNext()) {
		  sc.nextLine();
		  i++;
	   }// end while
		
		
		// Close the file
	    sc.close();
	    	    
	    
	     // display message the program done reading data
	     JOptionPane.showMessageDialog(null, "Completed Reading Data to File \"inputPhoneBill.txt\"");
	     
	     return i;
	  }// end read methods
	  
	private void readFromFile(String fileName) throws FileNotFoundException {
		
		// create file object
		File file = new File(fileName);
		
		// create scanner object
		Scanner sc = new Scanner(file);
		
		// Change the scanner delimiter
		sc.useDelimiter(",|\r\n");
		
		while (sc.hasNext()) {
			
			int custNumber = Integer.parseInt(sc.next().trim());
			String custName = sc.next().trim();
			int custType = Integer.parseInt(sc.next().trim());
			int minutes = Integer.parseInt(sc.next().trim());
			int noOfParticipants = Integer.parseInt(sc.next().trim());
			
			// call 
			addCustomer(custName, custNumber, minutes, noOfParticipants, custType);
		}// end while
		
		sc.close();
		
		JOptionPane.showMessageDialog(null,"Done Reading Data From File!");
		display();
	}// end readFromFile

	private  int minIndex() {
		double min = customers[0].getBill().getValue();
		int index = 0;
		
		for (int i = 1; i< Customer.getNoOfCustomers(); i++)
			if (min > customers[i].getBill().getValue()) {
				min = customers[i].getBill().getValue();
				index = i;
			}// end for
		
		return index;
	}// end minIndex()
	
	private int maxIndex() {
		double max = customers[0].getBill().getValue();
		int index = 0;
		
		for (int i = 1; i< Customer.getNoOfCustomers(); i++)
			if (max < customers[i].getBill().getValue()) {
				max = customers[i].getBill().getValue();
				index = i;
			}// end for
				
		return index;
	}// end maxIndex() 
	
	private double avg() {
		
		double sum =0;
		for (int i = 0; i< Customer.getNoOfCustomers(); i++)
			sum+=customers[i].getBill().getValue();
		
		return (sum/customers.length);
			
	}// end avg()
	
	// main method
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		        //declare variables
				int numberOfcustomers = 0;
				
				// inputs the number of users
				boolean stop = false;
				   //declare array variables
		        while (!stop) 
				try {
				numberOfcustomers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of Customers:"));
				stop = true;
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Program Exit!");
				
				}
				
				
				PhoneBillGUI frame = new PhoneBillGUI("inputPhoneBill.txt", numberOfcustomers);
				frame.setTitle("User Water Bill Company");
			    frame.pack();
			    frame.setLocationRelativeTo(null); // Center the frame
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);

	
	}// end main
	

}
