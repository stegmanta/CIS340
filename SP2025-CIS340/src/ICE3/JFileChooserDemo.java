package ICE3;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JFileChooserDemo {
     static String message = "";
	 // To Complete
	 // Update this method to return file name as a String: getFileName()
	 public static String getFileName() {
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose a File");
	    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	message = "getCurrentDirectory(): " + chooser.getCurrentDirectory() +"\n"
	    			+ "getSelectedFile() : " + chooser.getSelectedFile();
	      JOptionPane.showMessageDialog(null,message);
	     } else {
	    	JOptionPane.showMessageDialog(null,"No Selection ");
	    }
	    return chooser.getSelectedFile().toString();
	  }//end method
}//end class
