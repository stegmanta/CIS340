

public class Employee extends Person{
	
	private int eID;
    private Status empStatus;
    
    // 1- The Employee class extends superclass Person
    // 2- add the subclass Employee constructor that calls the supper Person class constructor, you should provide input data for all parent class data fields

    
    public Employee(String fName, String lName, Address address, int eID, Status empStatus) {
    	super(fName, lName, address);
    	this.eID = eID;
    	this.empStatus = empStatus;
    }
   // 3- add setters/getters methods

	public int getEID() {
		return eID;
	}

	public void setEID(int eID) {
		this.eID = eID;
	}

	public Status empStatus() {
		return empStatus;
	}

	public void setEmpStatus(Status empStatus) {
		this.empStatus = empStatus;
	}
	// 4- add override toString() method that overrides toString() in the superclass Person 

	@Override
	public String toString() {
		return "Employee [eID=" + eID + ", empStatus=" + empStatus + ", fName=" + fName + ", lName=" + lName
				+ ", address=" + address + "]";
	}
    
	
	
}
