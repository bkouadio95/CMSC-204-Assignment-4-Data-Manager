

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	public LinkedList<CourseDBElement>[] hashTable;
	
	int hashTableSize=0;
	//int elementSize=0;
	
	
	/** 
	 * 
	 * the constructor to estimate the size of the hashTable 
	 */
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure( int i) 
	{
		this.hashTableSize = i;
		this.hashTable = new LinkedList[i];
	}
	
	
	/**
	 * 
	 *  the constructor for testing purpose 
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure (String str, int sizeValue)
	{
		this.hashTableSize = sizeValue;
		this.hashTable = new LinkedList[sizeValue];
	} 
	
	
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added
	*/
	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		
		//index is the hash modulus size
		int index = Math.abs(element.hashCode() % this.hashTableSize);
		
		if (this.hashTable[index] != null) 
		{
			this.hashTable[index].add(element);
			//elementSize++;
		}
		else 
		{
			LinkedList<CourseDBElement> list = new LinkedList<>();
			list.add(element);
			this.hashTable[index] = list;
		}
		
	}

	
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param element the CDE to be added
	 * @throws IOException 
	*/
	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		int value = ("" + crn).hashCode() % this.hashTableSize;
		LinkedList<CourseDBElement> myList = this.hashTable[value];
		for(CourseDBElement ele: myList) 
		{
			if(ele.getCRN() == crn) { return ele; } 
		}
		
		throw new IOException();
	}

	
	
	
	/** function to display the elements */
	
	public ArrayList<String> showAll() {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < this.hashTableSize; i++) {
			if(this.hashTable[i] != null) {
				for(int y = 0; y < this.hashTable[i].size(); y++) {
					list.add(this.hashTable[i].get(y).toString());
				}
			}
		}
		return list;
	}
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return this.hashTableSize;
	}
	

}
