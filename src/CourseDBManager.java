
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Betty Kouadio
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	
	CourseDBStructure cds = new CourseDBStructure(20);
	/**
	 * @param crn
	 * @return null
	 */
	@Override
	public CourseDBElement get(int crn) {
		//CourseDBElement cde = null;
		
		try {
			return cds.get(crn);
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	/**
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * 
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		
		CourseDBElement cdb = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cdb);
		
	}

	

	/**
	 * The data manager allows the user to read the 
	 * courses from a file or to enter the data by hand, 
	 * and uses an Alert to print out the database elements. 
	 * The input is read from a file or read from the textfields 
	 * and is added to the data structure through the add method. 
	 * The add method uses the CDS add method. The CourseDBManager 
	 * is also referred to as a CDM.
	 * 
	 * CMSC100 21556 2 Distance-Learning Janet E. Joy 

	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(input);
		
		//try {
		while (scan.hasNext()) {
			
			String[] myArray = scan.nextLine().split(" ", 5);
			ArrayList<String> list = new ArrayList<String>(10);
			list.add(myArray[0]);
			list.add(myArray[1]);
			list.add(myArray[2]);
			list.add(myArray[3]);
			list.add(myArray[4]);
			
		
		
		//CMSC100 22344 2 SW217 Gloria E. Barron
		CourseDBElement cdemt = new CourseDBElement(myArray[0], Integer.parseInt(myArray[1]), 
				Integer.parseInt(myArray[2]), myArray[3], myArray[4]);
			
		  cds.add(cdemt);
		}
	//} catch(IOException e) { }
		
		scan.close();
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		return cds.showAll();
	}
	

}
