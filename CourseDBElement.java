

/**
 * CourseDBElement implements Comparable, and consists 
 * of five attributes: the Course ID (a String), 
 * the CRN (an int), the number of credits (an int), 
 * the room number (a String), and the instructor name (a String).   
 * Normally the CourseDBElement will be an object consisting 
 * of these five attributes, and is referred to as a CDE.
 *
 * @author Betty Kouadio
 *
 */

public class CourseDBElement implements Comparable {
	//the attributes variable
	String courseID, rooNumber, instruName;
	int crn, numOfCredits;
	
	
	/**
	 * arg Constructor
	 */
	
public CourseDBElement (String courseID, int crn, int numOfCredits, String rooNumber, String instruName)
{
	super();
	this.courseID = courseID;
	this.crn = crn;
	this.numOfCredits = numOfCredits;
	this.rooNumber = rooNumber;
	this.instruName = instruName;
}

/**
 *  Constructor m 
 */
public CourseDBElement() 
{
	super();
}



/**
 * This interface imposes a total ordering on the objects of each 
 * class that implements it. This ordering is referred to as the 
 * class's natural ordering, and the class's compareTo method is 
 * referred to as its natural comparison method.
 * 
 * Lists (and arrays) of objects that implement this interface 
 * can be sorted automatically by Collections.sort (and Arrays.sort). 
 * 
 * @param element a CourseDBElement
 * @return a negative integer if x.compareTo(y) < 0, 
 *         zero if x.compareTo(y) == 0,
 * 	   and a positive integer if x.compareTo(y) > 0.
 */

	@Override
	public int compareTo(CourseDBElement element) {
		// TODO Auto-generated method stub
		return this.crn - element.getCRN();
	}
	
	
	/** getters and setter
	 * 
	 */
	
	public int getCRN() { return this.crn; }
	public void setCRN(int crn) { this.crn = crn; }
	
	public String getCourseID() { return this.courseID ; }
	public void setCourseID(String courseID) { this.courseID = courseID; }
	
	public int getNumOfCredits() { return this.numOfCredits; }
	public void setNumOfCredits( int numOfCredits) { this.numOfCredits = numOfCredits; }
	
	public String getInstruName() { return this.instruName; }
	public void setInstruName( String instruName) { this.instruName = instruName;}
	
	public String getRooNumber() { return this.rooNumber; }
	public void setRooNumber( String rooNumber) { this.rooNumber = rooNumber;}
	
	/**
	 *  Taking care of the hashcode() of CRN 
	 * 
	 */
	
	public int hashCode()
		{
			
		return ("" + crn).hashCode();
	}
	
	/** 
	 * 
	 * the toString method 
	 * 
	 */
	
	 public String toString() 
	 {
		 return "\nCourse:" + this.courseID + " " + "CRN:" + this.crn + " " + "Credits:" + this.numOfCredits +
				 " " + "Instructor:" + this.instruName + " " + "Room:" + this.rooNumber;
	 }

} // THE END
