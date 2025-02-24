//**********************************************************************
//*
//* CIS340 Spring Tayler Stegman
//* *
//* Program Assignment PA03 *
//* *
//* Program for modularization*
//* *
//* Date Created: 2.20.2025 *
//* Saved in: TaylerStegmanPA0301.java
//*********************************************************************
//
// import packages here (if needed – be sure to delete the //)
package PA03;

import javax.swing.JOptionPane;

public class TaylerStegmanPA0301 {

	public static void main(String[] args) {
		double numStorage = 0.0, total = 0.0;
		int numMonths = 0, student = 0, option = 0;
		boolean boolStudent = false;
		
		//try numStorage input
		while(true) {
			try {
				numStorage = Double.parseDouble( JOptionPane.showInputDialog(null,"Enter the number of storage in TB"));
				if(numStorage <= 0)
					throw new Exception();
				break;
			}catch(Exception ex) {
				option = JOptionPane.showConfirmDialog(null, "Invalid input, do you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		}//end numStorage while
		
		//try numStorage input
//		System.out.println(numStorage);
		
		//try numMonths input
		while(true) {
			try {
				numMonths = Integer.parseInt( JOptionPane.showInputDialog(null,"Enter the number of months"));
				if(numMonths < 1)
					throw new Exception();
				break;
			}catch(Exception ex) {
				option = JOptionPane.showConfirmDialog(null, "Invalid input, do you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		}//end num months while
		
		//figure out if user is a student (0 = yes, 1 = no)
		while(true) {
			student = JOptionPane.showConfirmDialog(null, "Are you a student","Storage Calculator", JOptionPane.YES_NO_OPTION);
			if(student == -1) {
				option = JOptionPane.showConfirmDialog(null, "Invalid input, do you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}else {
				break;
			}
		}//end student input
		switch(student) {
		case 0:
			boolStudent = true;
			break;
		case 1:
			boolStudent = false;
			break;
		}//end switch
		
//		System.out.println(student + " " + boolStudent);
		
		total = storageCharges(numStorage, numMonths, boolStudent);
		JOptionPane.showMessageDialog(null, "Your storage charges (" + String.format("%.0f", numStorage) + "TB) for " + numMonths + " months is " + String.format("%.2f", total));
	

	}//end main
	
	public static double storageCharges(double storage, int months) {
		double charges = 0.0;
		if(storage < 1) {
			charges = 1.99 * months;
		}
		else if(storage < 10) {
			charges = 9.99 * months;
		}
		else {
			charges = 99.99 * months;
		}
//		System.out.println("Before " + charges);
		return charges;
	}
	
	public static double storageCharges(double storage, int months, boolean isStudent) {
		double charges = 0.0;
		charges = storageCharges(storage, months);
		if(isStudent) {
			charges = charges - (charges * 0.10);
		}
//		System.out.println("After " + charges);
		return charges;
	}

}//end class 
