

import static org.junit.Assert.*;



import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	
	private CourseDBManagerInterface cdm = new CourseDBManager();
	
	
	/**
	 *  testing my methods
	 */
	
	@Before
	public void setUp() throws Exception {
		cdm = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		cdm = null;
	}
	
	@Test
	public void testAddToDB() {
		try {
			cdm.add("CMSC101", 10000, 3, "LAFAYETT", "MANOU_BETTY");
		}
		catch(Exception e){
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		cdm.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		cdm.add("CMSC203",30503,4,"SC450","Jill B. Who-Dunit");
		cdm.add("CMSC204",30559,4,"SC450","BillyBob Jones");
		
		//add more example it is easy to add here
		ArrayList<String> list = cdm.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450");
		assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30504 Credits:4 Instructor:Joey Bag-O-Donuts Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:BillyBob Jones Room:SC450");
		
		//add more example it is easy to add here
			}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC203 30503 4 SC450 Jill B. Who-Dunit");
			
			//add more example it is easy to add here
			
			inFile.close();
			cdm.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
