package ICE3;
import java.io.*;

import javax.swing.*;

public class WriteData {
	
  //To Complete
  // Update this method to write data (String) to file and return true	
  public static boolean writeFile(String s) throws Exception {
    
	// Get the file name from this line  
	String fileName = s + "scores" + System.currentTimeMillis() + ".txt";
	
	// Instantiate a file object
	File file = new File(fileName);
    if (file.exists()) {
    	JOptionPane.showMessageDialog(null,"File already exists");
        System.exit(0);
    }

    // Create a file
    PrintWriter output = new PrintWriter(file);

    // Test to write formatted output data to the file\
    ///does a terrible job explaining what it wants us to print, this assignment was explained very poorly!
    output.print(s);
    output.print("John T Smith ");
    output.println(90);
    output.print("Eric K Jones ");
    output.println(85);

    // Close the file
    output.close();
    return true;
  }// end method
}// end class
