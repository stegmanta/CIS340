import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserGUI extends JPanel {

    // Employee panel fields
    private JTextField txtEmployeeID;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JRadioButton rbFullTime;
    private JRadioButton rbHourly;
    private JTextField txtStreet;
    private JTextField txtApt;
    private JTextField txtCity;
    private JTextField txtState;
    private JTextField txtZip;
    private JButton btnAddEmployee;
    
    // Pay Period panel fields
    private JTextField txtPayPeriodID;
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    
    // Pay Record panel fields
    // Note the new txtPayRecordEmpID, which mirrors the Employee ID
    private JTextField txtPayRecordEmpID;
    private JTextField txtMonthlyIncome;
    private JTextField txtNumMonths;
    private JTextField txtPayHours;
    private JTextField txtPayRate;
    private JButton btnAddPayRecord;
    
    // Display area
    private JTextArea textArea;
    
    // Payroll logic
    private PayRoll payRoll;
    private String fileName = "PayRoll.txt";
    
    public UserGUI() {
    	int n = 0;
    	while (true) {
    	    try {
    	        String s = JOptionPane.showInputDialog("Enter the number of pay records you wish to add");
    	        if (s == null || s.trim().isEmpty()) throw new Exception("Invalid input");
    	        n = Integer.parseInt(s.trim());
    	        if (n <= 0) throw new Exception("Must be greater than zero");
    	        break;
    	    } catch (Exception ex) {
    	        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    	    }
    	}
        payRoll = new PayRoll(fileName, n);
        try {
            payRoll.readFromFile();
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Error reading file: " + ex.getMessage());
        }
        initGUI();
        layoutGUI();
        registerListeners();
        payRoll.displayPayRecord(textArea);
    }
    
    private void initGUI() {
        // Employee Panel
        txtEmployeeID = new JTextField(10);
        txtFirstName = new JTextField(10);
        txtLastName = new JTextField(10);
        rbFullTime = new JRadioButton("Full Time", true);
        rbHourly = new JRadioButton("Hourly");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbFullTime);
        bg.add(rbHourly);
        txtStreet = new JTextField(10);
        txtApt = new JTextField(5);
        txtCity = new JTextField(10);
        txtState = new JTextField(10);
        txtZip = new JTextField(6);
        btnAddEmployee = new JButton("Add Employee");
        
        // Pay Period Panel
        txtPayPeriodID = new JTextField(5);
        txtStartDate = new JTextField(10);
        txtEndDate = new JTextField(10);
        
        // Pay Record Panel
        // New text field specifically for the Pay Record "ID," which is the same as the Employee ID
        txtPayRecordEmpID = new JTextField(5);
        txtPayRecordEmpID.setEditable(false);  // read-only, so user sees the ID but can’t change it
        txtMonthlyIncome = new JTextField(7);
        txtNumMonths = new JTextField(5);
        txtPayHours = new JTextField(5);
        txtPayRate = new JTextField(5);
        btnAddPayRecord = new JButton("Add Pay Record");
        
        // Set pay record fields initial enable state (default is Full Time)
        txtMonthlyIncome.setEditable(true);
        txtNumMonths.setEditable(true);
        txtPayHours.setEditable(false);
        txtPayRate.setEditable(false);
        
        // Display area
        textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
    }
    
    private void layoutGUI() {
        setLayout(new BorderLayout(5, 5));
        
        // Employee Panel
        JPanel empPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        empPanel.setBorder(BorderFactory.createTitledBorder("Employee"));
        
        empPanel.add(new JLabel("ID:"));
        empPanel.add(txtEmployeeID);
        empPanel.add(new JLabel("First Name:"));
        empPanel.add(txtFirstName);
        
        empPanel.add(new JLabel("Last Name:"));
        empPanel.add(txtLastName);
        empPanel.add(new JLabel("Status:"));
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        statusPanel.add(rbFullTime);
        statusPanel.add(rbHourly);
        empPanel.add(statusPanel);
        
        empPanel.add(new JLabel("Street:"));
        empPanel.add(txtStreet);
        empPanel.add(new JLabel("Apt:"));
        empPanel.add(txtApt);
        
        empPanel.add(new JLabel("City:"));
        empPanel.add(txtCity);
        empPanel.add(new JLabel("State:"));
        empPanel.add(txtState);
        
        empPanel.add(new JLabel("Zip Code:"));
        empPanel.add(txtZip);
        empPanel.add(new JLabel(""));
        empPanel.add(btnAddEmployee);
        
        // Pay Period Panel
        JPanel periodPanel = new JPanel(new GridLayout(1, 6, 5, 5));
        periodPanel.setBorder(BorderFactory.createTitledBorder("Pay Period"));
        periodPanel.add(new JLabel("Pay Period ID:"));
        periodPanel.add(txtPayPeriodID);
        periodPanel.add(new JLabel("Start Date (MM/dd/yyyy):"));
        periodPanel.add(txtStartDate);
        periodPanel.add(new JLabel("End Date (MM/dd/yyyy):"));
        periodPanel.add(txtEndDate);
        
        // Pay Record Panel
        // Now includes a row for "ID" that matches the Employee ID
        JPanel payRecordPanel = new JPanel(new GridLayout(3, 4, 5, 5));
        payRecordPanel.setBorder(BorderFactory.createTitledBorder("Pay Record"));
        
        // Row 1: Show the ID from the employee panel
        payRecordPanel.add(new JLabel("ID:"));
        payRecordPanel.add(txtPayRecordEmpID);
        // Put placeholders or blank labels to keep alignment
        payRecordPanel.add(new JLabel(""));
        payRecordPanel.add(new JLabel(""));
        
        // Row 2: For FULLTIME employees
        payRecordPanel.add(new JLabel("Monthly Income:"));
        payRecordPanel.add(txtMonthlyIncome);
        payRecordPanel.add(new JLabel("Number of Months:"));
        payRecordPanel.add(txtNumMonths);
        
        // Row 3: For HOURLY employees
        payRecordPanel.add(new JLabel("Pay Hours:"));
        payRecordPanel.add(txtPayHours);
        payRecordPanel.add(new JLabel("Pay Rate:"));
        payRecordPanel.add(txtPayRate);
        
        // Button row for Pay Record
        JPanel recButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        recButtonPanel.add(btnAddPayRecord);
        
        // Display area panel
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder(
            "Current Employee Record and Stat (Total & Average Pays)"));
        JScrollPane scrollPane = new JScrollPane(textArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Close button panel
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnClose = new JButton("Close");
        closePanel.add(btnClose);
        btnClose.addActionListener(e -> {
            payRoll.writeToFile();
            System.exit(0);
        });
        
        // Top container with Employee, Pay Period, and Pay Record panels
        JPanel topContainer = new JPanel(new GridLayout(3, 1, 5, 5));
        topContainer.add(empPanel);
        topContainer.add(periodPanel);
        topContainer.add(payRecordPanel);
        
        add(topContainer, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(recButtonPanel, BorderLayout.WEST);
        add(closePanel, BorderLayout.SOUTH);
    }
    
    private void registerListeners() {
        btnAddEmployee.addActionListener((ActionEvent e) -> addEmployeeAction());
        btnAddPayRecord.addActionListener((ActionEvent e) -> addPayRecordAction());
        
        rbFullTime.addActionListener((ActionEvent e) -> {
            txtMonthlyIncome.setEditable(true);
            txtNumMonths.setEditable(true);
            txtPayHours.setEditable(false);
            txtPayRate.setEditable(false);
        });
        
        rbHourly.addActionListener((ActionEvent e) -> {
            txtMonthlyIncome.setEditable(false);
            txtNumMonths.setEditable(false);
            txtPayHours.setEditable(true);
            txtPayRate.setEditable(true);
        });
    }
    
    private void addEmployeeAction() {
        try {
            int id = Integer.parseInt(txtEmployeeID.getText().trim());
            String fName = txtFirstName.getText().trim();
            String lName = txtLastName.getText().trim();
            String street = txtStreet.getText().trim();
            int aptNum = Integer.parseInt(txtApt.getText().trim());
            String city = txtCity.getText().trim();
            String state = txtState.getText().trim();
            int zip = Integer.parseInt(txtZip.getText().trim());
            
            Status status = rbFullTime.isSelected() ? Status.FULLTIME : Status.HOURLY;
            
            // Create the new Employee in your PayRoll system
            payRoll.createEmployee(fName, lName, 
                new Address(street, aptNum, city, state, zip), id, status);
            
            // Update Pay Record ID field to match the new Employee’s ID
            txtPayRecordEmpID.setText(String.valueOf(id));
            
            // Refresh display
            textArea.setText("");
            payRoll.displayPayRecord(textArea);
            
            JOptionPane.showMessageDialog(this, "Employee added successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Invalid number format: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + ex.getMessage());
        }
    }
    
    private void addPayRecordAction() {
        try {
            // IMPORTANT: Now we read the ID from the pay record ID field,
            // which was set to the same as the Employee ID:
            int empID = Integer.parseInt(txtPayRecordEmpID.getText().trim());
            
            int payPeriodID = Integer.parseInt(txtPayPeriodID.getText().trim());
            String start = txtStartDate.getText().trim();
            String end   = txtEndDate.getText().trim();
            
            // For simplicity, pass null for the dates. You can parse them with SimpleDateFormat if desired.
            PayPeriod pp = new PayPeriod(payPeriodID, null, null);
            
            Employee e = payRoll.empByID(empID);
            if(e.empStatus() == Status.FULLTIME) {
                double monthlyInc = Double.parseDouble(txtMonthlyIncome.getText().trim());
                int numMonths = Integer.parseInt(txtNumMonths.getText().trim());
                // Use empID for creating this record
                payRoll.createPayRecord(empID, e, pp, monthlyInc, numMonths);
            } else {
                double hours = Double.parseDouble(txtPayHours.getText().trim());
                double rate  = Double.parseDouble(txtPayRate.getText().trim());
                payRoll.createPayRecord(empID, e, pp, hours, rate);
            }
            
            // Refresh display
            textArea.setText("");
            payRoll.displayPayRecord(textArea);
            
            JOptionPane.showMessageDialog(this, "Pay record added successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Invalid number format: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Pay Roll");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new UserGUI());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
