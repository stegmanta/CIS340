
public class PayRollApp {
    public static void main(String[] args) {
        try {
            // adjust the filename and max records to whatever makes sense
            PayRoll pr = new PayRoll("PayRoll.txt", 100);
            pr.readFromFile();          // parses employees & payRecords
//            pr.displayPayRecord();      // pops up your GUI or prints to console
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}