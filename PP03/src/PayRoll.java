
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PayRoll {
	
	private String fileName;
	private PayRecord[] payRecords;
	private Employee[] employeeArr;
	private int recordCount = 0;
	private int empCount = 0;
	
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
	   //
	   this.employeeArr = new Employee[empCount + 10];
	   empCount = 0;
	   recordCount = 0;
	   
	   //now, go through looking specifically for employees
	   Scanner employeeScan = new Scanner(new File(fileName));
	   SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	   
	   while(employeeScan.hasNextLine()) {
		   String line = employeeScan.nextLine();
		   String[] items = line.split(",");
		   
		   if("employee".equals(items[0].toLowerCase())) {
			   int eID = Integer.parseInt(items[1].trim());
			   String fName = items[2].trim();
			   String lName = items[3].trim();
			   Status status = Status.valueOf(items[4].trim());
			   String street = items[5].trim();
			   int apt = Integer.parseInt(items[6].trim());
			   String city = items[7].trim();
			   String state =items[8].trim();
			   int zip = Integer.parseInt(items[9].trim());
			   createEmployee(fName, lName, new Address(street, apt, city, state, zip), eID, status);
		   }
	   }
	   employeeScan.close();
		  
	 //finally, go through looking specifically for payRecord so we can match them to employees
	   //this way we can make sure there no employee records come after payRecords
	   Scanner payScan = new Scanner(new File(fileName));
	   while(payScan.hasNextLine()) {
		   String line = payScan.nextLine();
		   String[] items = line.split(",");  
		   if("payrecord".equals(items[0].toLowerCase())) {
			   //get IDs
			   int rID = Integer.parseInt(items[1].trim());
			   int empID = Integer.parseInt(items[2].trim());
			   Employee e = empByID(empID);
			   int pID = Integer.parseInt(items[5].trim());
			   //go out of order for sake of shortening
			   //get date
			   Date sDate = df.parse(items[6].trim());
			   Date eDate = df.parse(items[7].trim());
			   double num1 = Double.parseDouble(items[3].substring(0, items[3].indexOf('<')).trim());
			   double num2 = Double.parseDouble(items[4].substring(0, items[4].indexOf('<')).trim());
			   
			   createPayRecord(rID, e, new PayPeriod(pID, sDate, eDate), num1, num2);
		   }//end else if
	   }//end 3rd scan	
	}//end readFromFile() 
   
   public Employee empByID(int empID) {
	   Employee e = employeeArr[0];
	   //search every record for now, can implement binary search, but we are not expecting lots of records at the moment
	   for(int i = 0; i < empCount; i++) {
		   if(employeeArr[i].getEID() == empID) {
			   e = employeeArr[i];
		   }
	   }
	   return e;
   }
   
   public void writeToFile(){
	   // write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data
	   try (PrintWriter writer = new PrintWriter(new FileWriter("PayRecord.txt", true))) {
           for (int i = 0; i < recordCount; i++) {
               writer.println(payRecords[i].toString());
           }
       } catch (IOException ex) {
           System.err.println("Error writing to file: " + ex.getMessage());
       }
	} 
   
	public Employee createEmployee(String fName, String lName, Address address, int eID, Status empStatus) {
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method
		if(empCount >= employeeArr.length) {
            throw new IllegalStateException("Cannot add more employees than allowed!");
        }
		employeeArr[empCount] = new Employee(fName, lName, address, eID, empStatus);
		empCount++;
		return employeeArr[empCount - 1];
	}
	
 
	public void createPayRecord(int id, Employee e, PayPeriod period, double num1, double num2){
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		if(e.empStatus() == Status.HOURLY) {
			payRecords[recordCount] = new PayRecord(id, e, period, num1, num2);
		}else {
			int numMonths = (int) num2;
			payRecords[recordCount] = new PayRecord(id, e, period, num1, numMonths);
		}
		recordCount++;
	}
	
	
    public  void displayPayRecord(JTextArea textArea){
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
    	// Append each pay record to the text area.
        for (int i = 0; i < recordCount; i++) {
            textArea.append(payRecords[i].toString() + "\n");
        }
     // Calculate the average (and update totalNetPay internally)
        double average = avgNetPay();
     // Append the totals to the text area.
        textArea.append("\nTotal Net Pay: " + String.format("%.2f", totalNetPay));
        textArea.append("\nAverage Net Pay: " + String.format("%.2f", average));
	}

    
   public double avgNetPay(){		
	   // returns the average of the total net pay of all added employees
	   totalNetPay = 0;
	   for(int i = 0; i < recordCount; i++) {
		   totalNetPay += payRecords[i].netPay();
	   }
	   avgNetPay = recordCount > 0 ? totalNetPay / recordCount : 0;
       return avgNetPay;
	}
    	

}//end class
