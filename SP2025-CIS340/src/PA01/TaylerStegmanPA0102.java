//**********************************************************************
//*
//* CIS340 Spring Tayler Stegman
//* *
//* Program Assignment PA01 *
//* *
//* Program to handle I/O Exceptions *
//* *
//* Date Created: 01.25.2025 *
//* Saved in: TaylerStegmanPA0101.java
//*********************************************************************
//
// import packages here (if needed – be sure to delete the //)
package PA01;
import javax.swing.*;

public class TaylerStegmanPA0102 {

	public static void main(String[] args) {
		//declare variables and constants
		double numBtc = 0.0, spendAmt = 0.0, numDollar = 0.0, usdForBtc = 0.0, 
				btcForUsd =0.0, totalBtc = 0.0;
		int transactionType;
		String output = "", strErr = "";
		final double BITCOIN_PRICE = 15000;
		
		try {
			//get input for curr btc
			numBtc = Double.parseDouble( JOptionPane.showInputDialog(null,"Number of bitcoins you own: "));
			//if input less than one throw exception
			if(numBtc < 1) {
				strErr += "You must have atleast 1 BTC";
				throw new Exception();
			}
			numDollar = numBtc * BITCOIN_PRICE;
			//gather input for transaction type
			transactionType = Integer.parseInt(JOptionPane.showInputDialog(null,"Choose a transaction type (0:Buy, 1: Sell): "));
			//use switch statement to determine next input based on transaction type
			switch(transactionType) {
				case 0:
					//BUY TRANSACTION
					spendAmt = Double.parseDouble( JOptionPane.showInputDialog(null,"Amount you wish to spend on buying bitcoins: $"));
					if (spendAmt < 100) {
						strErr += "Minimum buying amount is $100";
						throw new Exception();
					}
					btcForUsd = spendAmt / BITCOIN_PRICE;
					totalBtc = numBtc + btcForUsd;
					output += "\nDeposited Bitcoins for $" + String.format("%,.0f", spendAmt) + ":   " + String.format("%.3f", btcForUsd)
							  + "\nTotal Bitcoins:   " + String.format("%.3f",totalBtc)
							  + "\nAmount in USD:   $" + String.format("%,.0f",(totalBtc * BITCOIN_PRICE));
					break;
				case 1:
					//SELL TRANSACTION
					spendAmt = Double.parseDouble( JOptionPane.showInputDialog(null,"Amount in USD you wish to withdraw by selling BTC: $"));
					if(spendAmt > numDollar) {
						strErr += "Withdrawal amount exceeds your current BTC balance in USD.";
						throw new Exception();
					}else {
						usdForBtc = spendAmt/BITCOIN_PRICE;
						totalBtc = numBtc - usdForBtc;
						output += "\nWithdrawed Bitcoins for $" + String.format("%,.0f", spendAmt) + ":   " + String.format("%.3f", usdForBtc)
							   + "\nTotal Bitcoins:   " + String.format("%.3f",totalBtc)
							   + "\nAmount in USD:   $" + String.format("%,.0f",(totalBtc * BITCOIN_PRICE));
					}
					break;
				default:
					throw new Exception();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error in program input\nError: " + strErr);
			System.exit(0);
		}//end try catch
		//display output
		JOptionPane.showMessageDialog(null, output);
		
	}//end main

}
