package ICE06;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;



public class WaterBillGUI extends JFrame {
	
	// Array of customers 
	private Customer[] customers;
	
	// file name
	private String fileName;
	
	  // declare all UI components below
	  // UI Labels
	  private JLabel lblName;
	  private JLabel lblNumber;
	  private JLabel lblGallons;
	  
	  // UI TextFields   
	  private JTextField txtName;
	  private JTextField txtNumber;
	  private JTextField txtGallons;
	  
	  // UI Buttons
	  private JButton btnAdd;
	  private JButton btnClear;
	  private JButton btnClose;
	  private JButton btnSave;
	  private JButton btnSort;
	  
	  //UI TextArea & ScrollPane
	  private JTextArea textArea;
	  private JScrollPane jp;
	  
	  // UI RadioButtons
	  JRadioButton singleFamilyRbt ;
      JRadioButton duplexRbt;
      ButtonGroup groupRbt;

		      	
	// class constructor
	WaterBillGUI(String fileName, int noOfCustomers) throws FileNotFoundException{
			
		    this.fileName = fileName;
		
		    // create an array of customers
			int fileSize = getFileLength(this.fileName);
			customers = new Customer[noOfCustomers+fileSize];
	       
	        // call methods to do the layout
			initComponent();
			doTheLayout();
			
			// add buttons to the action listeners
			// Use the lambda expression to respond to the user event of button clicked, as discussed in class
			// To Complete
			this.btnAdd.addActionListener(e -> btnAddClicked());
			this.btnClear.addActionListener(e -> btnClearClicked());
			this.btnSort.addActionListener(e -> btnSortClicked());
			this.btnSave.addActionListener(e -> {
				try {
					btnSaveClicked();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});			
			
			// call read data from file
			readFromFile(this.fileName);
			
		}// end WaterBillGUI

		private void initComponent(){
			
		// Initialize the GUI components
		// labels 
		
		this.lblName = new JLabel("Name");
		lblNumber = new JLabel("Number");
		lblGallons = new JLabel("Gallons");
		
		// text fields 
		this.txtName = new JTextField(20);
		txtNumber = new JTextField(10);
		txtGallons = new JTextField(10);
		
		this.txtName.setToolTipText("You must provide the customer name?");
			
			
		// radio buttons
		
		this.singleFamilyRbt = new JRadioButton("Single Family", true);
	    this.duplexRbt = new JRadioButton("Duplex");
	    
		// radio buttons to ButtonGroup
			     
	    this.groupRbt = new ButtonGroup();
	    this.groupRbt.add(this.singleFamilyRbt);
	    this.groupRbt.add(this.duplexRbt);
	    
	    
		// buttons
		
		this.btnAdd = new JButton("Add");
		this.btnClear = new JButton("Clear");
		this.btnSort = new JButton("Sort");
		this.btnSave = new JButton("Save");
		this.btnClose = new JButton("Close");
	    
	    
		// define text area and add it to scroll pane
		
		this.textArea = new JTextArea("Program Display\n", 15,45);
		this.jp = new JScrollPane(textArea);
		this.textArea.setEditable(false);
	  
		} // end initComponent

	   private void doTheLayout(){
			// Organize the components into GUI window
		    // declare top, center, centerTop, centerBottom, and bottom panels
		    
		    JPanel top = new JPanel();
		    JPanel center = new JPanel();
		    JPanel centerTop = new JPanel();
		    JPanel centerBottom = new JPanel();
		    JPanel bottom = new JPanel();
		    
		   		      
	        // add components to the top panel
		    
		    top.add(lblName);
		    top.add(txtName);
		    top.add(singleFamilyRbt);
		    top.add(duplexRbt);
		     		      
		    // set the BorderLayout layout for the center panel
		   
		    center.setLayout(new BorderLayout());
		      
		   // add components to the centerTop panel
		   
		   centerTop.add(lblNumber);
		   centerTop.add(txtNumber);
		   centerTop.add(lblGallons);
		   centerTop.add(txtGallons);
		      		      
		    // add components to the centerBottom panel
		   
		   centerBottom.add(btnAdd);
		   centerBottom.add(btnSort);
		   centerBottom.add(btnSave);
		   centerBottom.add(btnClose);
		   centerBottom.add(btnClear);
		    
		   // add panels centerTop and centerBottom to the center panel
		   // use BorderLayout.CENTER and BorderLayout.SOUTH  
		   
		   center.add(centerTop,BorderLayout.CENTER);
		   center.add(centerBottom,BorderLayout.SOUTH);
		   
		      
		    // add the JB scroll pane to the bottom panel
		    
		    bottom.add(jp);

		    //add the top, center, and bottom panels to the JFrame GUI content pane
		    
		    this.add(top,"North");
		    this.add(center,"Center");
		    this.add(bottom,"South");
		 
		}// end doTheLayout

	   
		// Response when the Close button is clicked
		private void btnCloseClicked() {
			// exit program
			JOptionPane.showMessageDialog(null, "Program Exit!");
			System.exit(0);
		}//end btnCloseClicked

		
		// Response when the Save button is clicked
		private void btnSaveClicked() throws FileNotFoundException{
			// code to be executed once the save button is clicked
			selectionSort();
			writeToFile();
			display();
		}//end saveBnttonClicked
		
		
		// Response when the Sort button is clicked
		private void btnSortClicked(){
			// code to be executed once the close button is clicked
			selectionSort();
			display();
			
		}//end sortBnttonClicked
		
		// Response when the Clear button is clicked
		private void btnClearClicked(){
			// clear text fields from data
			this.txtName.setText("");
			this.txtNumber.setText("");
			this.txtGallons.setText("");
				
		}// end method
		
		// Response when the Add button is clicked
		// To Complete
		private void btnAddClicked(){
			// code to be executed once the add button is clicked
			// validation .... 
			// declare local variables
			String name = "";
			int number = 0;
			int gallons = 0;
			
			// read and validate (matches a pattern Fname Lname) input of txtname, use if-statement 
			// To Complete
			name = this.txtName.getText().trim();
			if (!name.matches("[A-Z][a-z]+//s+[A-Z][a-z]+")) {
				JOptionPane.showMessageDialog(this.txtName, "Invalid Input");
				this.txtName.setText("");
				return;
			}
			
			// read and validate input txtnumber, use try catch for input validations
			// User number must not exist, use the binarySearch() method to check of duplicates 
			// To Complete
			try {
			    number = Integer.parseInt(this.txtNumber.getText().trim());
			    if(String.valueOf(number).length() != 6) {
			        throw new Exception("Customer ID must be 6 digits");
			    }
			    int index = binarySearch(number);
			    if(index >= 0) {
			        JOptionPane.showMessageDialog(null, new JTextArea("Customer ID: " + number + "\n" + customers[index].toString()));
			        throw new Exception("Duplicate Customer ID");
			    }

			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(this.txtName, ex.getMessage());
			    this.txtNumber.setText("");
			    return;
			}
						
			//read and validate input txtGallons, use try-catch
			// The number of gallons must be greater than 0
			// To Complete
			try {
			    gallons = Integer.parseInt(this.txtGallons.getText().trim());
			    if (gallons <= 0) {
			        throw new Exception("Gallons must be greater than 0");
			    }
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(this.txtName, ex.getMessage());
			    this.txtGallons.setText("");
			    return;
			}
			
			// based on selected radio button call method addCusomer(), with a specific bill type
			// check which radio button is selected, singleFamilyRbt or duplexRbt 
			// To Complete
			if(this.singleFamilyRbt.isSelected())
	        	   this.addCustomer(name, BaseCharge.SINGLR_FAMILY, number, gallons);
	           else if(this.singleFamilyRbt.isSelected())
	        	   this.addCustomer(name, BaseCharge.DUPLEX, number, gallons);
	           
			
			// Clear text fields from data after the new customer is added
			// To Complete
			String message = null;
			this.txtName.setText("");
			this.txtNumber.setText("");
			this.txtGallons.setText("");
			this.textArea.append(message);
			
		}// end btnAddClicked
		
		
		
		public void addCustomer(String name, int status, int number, int gallons){
			
			// add Customer object to the customers array
			// This method must check whether the array is full 
			// To Complete
			if (status == BaseCharge.SINGLR_FAMILY) 
				        customers[Customer.getNoOfCustomers()] =
						new Customer(name, number, new SingleFamily(gallons));
				else if (status == BaseCharge.DUPLEX)
					    customers[Customer.getNoOfCustomers()] =
					    new Customer(name, number, new Duplex(gallons));
			    
			this.display();
							
		}// end addCustomer

	private void display(){
		
		// prepare the output
		String message = "Water Bill: \n" + "Name\t" + "Number\t" + "Gallons\t" + "Bill\t" + "Type\t"+ "Bill Date";
		for (int i = 0; i < Customer.getNoOfCustomers(); i++)
		   message+="\n" + customers[i].toString();
		
		// call the method average
		message+= "\nAverage Bill Values: " + String.format("%.2f", avg());
		
		// display message to the text area, use setText() method
		// To Complete
		this.textArea.append(message);
		
	}// end display
	
	private void selectionSort() {
		
		 for (int i = 0; i < Customer.getNoOfCustomers() -1; i++) {
		      // Find the minimum in the customers[i..customers.length-1]
		      Customer currentMin = customers[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < Customer.getNoOfCustomers(); j++) {
		        if (currentMin.compareTo(customers[j]) > 0) {
		          currentMin = customers[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap customers[i] with customers[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        customers[currentMinIndex] = customers[i];
		        customers[i] = currentMin;
		      }
		    }
		 
		 JOptionPane.showMessageDialog(null, "Done Sorting Customers Array!");
	}// end selectionSort
	
	private void writeToFile() throws FileNotFoundException {
		File file = new File("outputWaterBill.txt");

	    // Create a file
	    PrintWriter output = new PrintWriter(file);
		

		for (int i =0; i < Customer.getNoOfCustomers(); i++)
			output.println(customers[i].toString());

	    // Close the file
	    output.close();
	    
	    JOptionPane.showMessageDialog(null, "Done Writing Array to file outputWarterBill.txt");
	}// end writeToFile
	
	
	// To read the file size, number of customers
	public int getFileLength(String fileName) throws FileNotFoundException {
		
	    
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
	     JOptionPane.showMessageDialog(null, "Start Reading Data From File \"inputWaterBill.txt\" For " + i + " Customers ");
	     
	     return i;
	     
	  }// end read methods
	  
	private void readFromFile(String filename) throws FileNotFoundException {
		
		// Create a File instance
	    java.io.File file = new java.io.File(fileName);

	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);

	 
	    // Read data from a file
	    while (input.hasNext()) {
	      String line = input.nextLine();
	      String[] customer = line.split(",");
	      addCustomer(customer[0].trim(), Integer.parseInt(customer[1].trim()), Integer.parseInt(customer[2].trim()),Integer.parseInt(customer[3].trim()));	  
	      
	    }// end-while

	    // Close the file
	    input.close();
	    JOptionPane.showMessageDialog(null, "Done Reading Customers Data From File " + fileName + " and Creating "
	    		+ this.getFileLength(filename) + " Customer Objects"  );
	    
	    // display the data read from file
	    display();
	    
	  }// end readFromFile

	
	private double avg(){
		double sum =0;
		for (int i = 0; i < Customer.getNoOfCustomers(); i++)
			sum+=customers[i].getBill().getValue();
		
		return sum/Customer.getNoOfCustomers() ;
	}//end avg

	// uses the binary search to make sure all customers have a unique id 
  private int binarySearch(int key) {
		
		// Array of customers must be sorted by customer numbers first 
		sortArrayByNumber();
	    
		// use the code from the binary search example
		// Search by the Customer objects by customer number as the key
		int index = -1;
		int low = 0;
	    int high = Customer.getNoOfCustomers() - 1 ;
	    
	    while (high >= low) {

	      int mid = (low + high) / 2;

	      if (key < customers[mid].getNumber())
	        high = mid - 1;
	      else if (key == customers[mid].getNumber()) {
	        index =  mid;
	        break;
	      }
	      else
	        low = mid + 1;
	    }
	    
		JOptionPane.showMessageDialog(null, "Done Searching In Customer Data Based on Customer's Number!");
		
		 if (index == -1)
	            index =  -low - 1; // Now high < low
		 
		return index;
		
	}// end binarySearch()

	// Use the selection sort to sort the current elements in the customers array, the array is not completely filled out yet, 
	// based on Customer number 
	private void sortArrayByNumber() {
								
		for (int i = 0; i < Customer.getNoOfCustomers() - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      Customer currentMin = customers[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < Customer.getNoOfCustomers(); j++) {
		        			    	  
		    	  
		    	  // Update the if-statement to use the Customer customers by customer numbers
		    	  if (currentMin.compareToByID(customers[j]) > 0) {
		    		  currentMin = customers[j];
		              currentMinIndex = j;
		        }
		      }// end for j

		   		      		      
		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		    	  customers[currentMinIndex] = customers[i];
		    	  customers[i] = currentMin;
		         
		      }
		    }// end for i

		
		JOptionPane.showMessageDialog(null, "Done Sorting Customer Data Based on Customer's Number!");
		
		
	}// end sortArrayByNumber()
	
	// main method
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		        //declare variable
				int numberOfcustomers = 0;
				
				// read the number of customers to be added by the program user
				numberOfcustomers = DataEntries.intInput("Enter number of Customers To Read From The User:");
				
				// create a JFrame object by calling a constructor of class WaterBillGUI, a subclass of JFrame
				WaterBillGUI frame = new WaterBillGUI("inputWaterBill.txt", numberOfcustomers);
				frame.setTitle("User Water Bill Company");
			    frame.pack();
			    frame.setLocationRelativeTo(null); // Center the frame
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);

	
	}// end main
	

}
