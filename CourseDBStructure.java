package application;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.LinkedList;
/**
 * 
 * @author Nathan Assefa
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	LinkedList<CourseDBElement> linkedList;
	int tableSize = 0;
	public LinkedList<CourseDBElement>[] hashTable;
	
	public CourseDBStructure() {
		linkedList = new LinkedList<CourseDBElement>();
	}
	public CourseDBStructure(int size) {
		tableSize = size;
		hashTable =  new LinkedList[size];
	}

	public CourseDBStructure(String string, int size) {
		tableSize = size;
		hashTable = new LinkedList[size];

	}

	/**
	 * @param element
	 * 
	 */
	public void add(CourseDBElement element) {
		boolean full = true;
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[element.hashCode()] == null) {
				LinkedList<CourseDBElement> linkedList = new LinkedList<CourseDBElement>();
				linkedList.add(element);
				hashTable[element.hashCode()] = linkedList;
				tableSize++;
				full = false;
				break;
			}
			else if(hashTable[element.hashCode()] != null ) {
				hashTable[element.hashCode()].add(element);
			}
			else if(i == hashTable.length-1 && full == true) {
				break;
			}
			else
				continue;
		break;
		}
	}


	public int getTableSize() {
		return tableSize;
	}

	/**
	 * @param crn
	 * @return hashTable[i].get(begin)
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int length = hashTable.length;
		for(int i=0; i<length; i++) {
			if(hashTable[i] == null) {
				continue;
			}
			else {
				int count = hashTable[i].size();
				int begin = 0;
			while(begin < count && !(hashTable[i].get(begin).CRN == crn)) {
			begin++;
			}
			if(begin == count) {
				begin--;
			}
			return hashTable[i].get(begin);
			}		}
		return null;
	}

}
/*
boolean found = false;
for(int i=0; i<hashTable.length; i++) {
	if(hashTable[i] == null) {
		continue;
	}
	else if(hashTable[i].element().CRN == element.CRN) {
		found = true;
		break;
	}
	else if(i==(hashTable.length-1) && found==false) {
		linkedList.add(element);
		hashTable[element.hashCode() % getTableSize()] = linkedList;
	}
}		
tableSize++;
*/