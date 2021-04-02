package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Nathan Assefa
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure structure = new CourseDBStructure(20);
	
	/**
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(element);
	}

	/**
	 * @param input
	 * 
	 */
	public void readFile(File input) throws FileNotFoundException {
			Scanner data = new Scanner(input);
			String id, roomNum = null, instructor = null;
			String crn, credits;
			CourseDBElement element;
			if(!input.canExecute()) {
				throw new FileNotFoundException();
			}
			while(data.hasNext()) {
				id = data.next();
				crn = data.next();
				credits = data.next();
				roomNum = data.next();
				instructor = data.nextLine();
				element = new CourseDBElement(id, Integer.parseInt(crn), Integer.parseInt(credits),roomNum, instructor);
				structure.add(element);
			}

	}

	/**
	 * @param crn
	 * @return total
	 */
	public String get(int crn) {
		boolean equals = false;
		for(int i=0; i<structure.hashTable.length; i++) {
			if(structure.hashTable[i] == null) {
				continue;
			}
			else {
				int count = structure.hashTable[i].size();
				int begin = 0;
			while(begin < count && !(structure.hashTable[i].get(begin).CRN == crn)) {
				
				if(begin < count && structure.hashTable[i].get(begin).CRN == crn) {
					equals = true;}
				else
					begin++;
			}
			
			if(begin < count && structure.hashTable[i].get(begin).CRN == crn) {
				equals = true;}
			
			if(equals) {
				String total = " ";
				total = "\nCourse:" + structure.hashTable[i].get(begin).courseID + 
						" CRN:" + structure.hashTable[i].get(begin).CRN +
						" Credits:" + structure.hashTable[i].get(begin).numOfCredits +
						" Instructor:" + structure.hashTable[i].get(begin).instructor +
						" Room:" + structure.hashTable[i].get(begin).roomNumber;
				return total;
			}		
			}
		}
		return null;
	}

	/**
	 * @return list
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		for(int i=0; i<structure.hashTable.length; i++) {
			if(structure.hashTable[i] == null) {
				continue;
			}
			else {
				count = structure.hashTable[i].size();
				int begin = 0;
			while(begin < count) {
			list.add("\nCourse:" + structure.hashTable[i].get(begin).courseID + 
					" CRN:" + structure.hashTable[i].get(begin).CRN +
					" Credits:" + structure.hashTable[i].get(begin).numOfCredits +
					" Instructor:" + structure.hashTable[i].get(begin).instructor +
					" Room:" + structure.hashTable[i].get(begin).roomNumber);
			begin++;
			}
			}
		}
		
		return list;
	}

}
