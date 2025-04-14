
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PayRoll {
	
	private String fileName;
	private PayRecord[] payRecords;
	private Employee[] employee;
	private int recordCount = 0;
	
	private  double totalNetPay;
	private  double avgNetPay;
	
	public PayRoll(String fileName, int n){
		
		this.fileName = fileName;
        this.payRecords = new PayRecord[n];
	}
	
	
   public void readFromFile() throws IOException, ParseException{
	  
	// parts: ["employee","1011","Jack","Johnson","FULLTIME","1246 Drake St","104","Fort Collins","Colorado","80526"]
		// read the initial data from PayRoll file to create the full 
	   // pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
	   
	   //FIRST we will pass through once to count employees to create the array
	   Scanner countScan = new Scanner(new File(fileName));
	   int empCount = 0;
	   while(countScan.hasNextLine()) {
		   String line = countScan.nextLine();
		   if(line.toLowerCase().startsWith("employee,")){
			   empCount++;
		   }
	   }
	   countScan.close();
	   this.employee = new Employee[empCount];
	   
	   //go through again to get nessecary data
	   Scanner scan = new Scanner(new File(fileName));
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	   int empIdx = 0;
	   
	   while(scan.hasNextLine()) {
		   String line = scan.nextLine();
		   String[] items = line.split(",");
		   
		   if("employee".equals(items[0])) {
			   int eID = Integer.parseInt(items[1]);
			   String fName = items[2];
			   String lName = items[3];
			   Status status = status.valueOf(items[4]);
		   }
	   }
	   
	   
		
	}//end readFromFile() 
   
   
   public void writeToFile(){
		
		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data
		
	} 
   
	public Employee createEmployee(String fName, String lName, Address address, int eID, Status empStatus){
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method
		return null;
		
	}
	
 
	public void createPayRecord(){
		
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		
	}
	
	
    public  void displayPayRecord(){
		
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
		
	}

    
   public double avgNetPay(){
		
		  	// returns the average of the total net pay of all added employees
	   
	   return 0;
		
	}
    	

}
