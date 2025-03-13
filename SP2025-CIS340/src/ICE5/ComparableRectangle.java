package ICE5;

public class ComparableRectangle implements Comparable<ComparableRectangle> {
  private double width;
  private double height;

  public ComparableRectangle() {
  }

  public ComparableRectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  public double getArea() {
    return width * height;
  }

  
  public double getPerimeter() {
    return 2 * (width + height);
  }
  
  @Override // Implement the compareTo method defined in Comparable 
  public int compareTo(ComparableRectangle o) {
    if (getArea() > o.getArea())
      return 1;
    else if (getArea() < o.getArea())
      return -1;
    else
      return 0;
  }
  
  /** Main method */
  public static void main(String[] args) {
	
	  ComparableRectangle r1 = new ComparableRectangle(5, 3);
	  
	  ComparableRectangle r2 = new ComparableRectangle(4, 6);
	  
	  // printing the area for r1 and r2
	  if (r1.compareTo(r2) >  0)
		  System.out.println("The area is " + r1.getArea());
	  else if (r1.compareTo(r2) <  0)
		  System.out.println("The area is " + r2.getArea());
	  else {
		  System.out.println("The area is " + r1.getArea());
		  System.out.println("The area is " + r2.getArea());
		  
	  }
	  
	  
  } // end main()
  
}
