package ICE5;



import javax.swing.JOptionPane;

public class BinarySearch {
  /** Use binary search to find the key in the list */
	public static void main(String args[]) {

		int[] list = {11,15,23,27,39,43,56,64,73,81,90};
		String message;
		String opt;



			 message= "Enter integer key:";
		   // get the answer from user
			 int key = Integer.parseInt(JOptionPane.showInputDialog(message));



    int low = 0;
    int high = list.length - 1;
    int index = -1;

    while (high >= low) {

      int mid = (low + high) / 2;

      if (key < list[mid])
        high = mid - 1;
      else if (key == list[mid]) {
        index =  mid;
        break;
      }
      else
        low = mid + 1;
    }

     if (index == -1)
            index =  -low - 1; // Now high < low


 	if (index < 0 )
 		JOptionPane.showMessageDialog(null, "key is not found, and it can be inserted at index "
 		 	     + (-1 * index -1 ));
 	else
 		JOptionPane.showMessageDialog(null, "key is found at index " + index);
  }

}
