package application;
/**
 * 
 * @author Nathan Assefa
 *
 */
public class CourseDBElement implements Comparable {

	String courseID = "" , roomNumber = "", instructor = "";
	int CRN=0 , numOfCredits = 0;
	
	/**
	 * 
	 * @param ID
	 * @param crnNumber
	 * @param credits
	 * @param room
	 * @param teacher
	 */
	public CourseDBElement(String ID, int crnNumber, int credits, String room, String teacher) {
		courseID = ID;
		roomNumber = room;
		instructor = teacher;
		CRN = crnNumber;
		numOfCredits = credits;
	}

	public CourseDBElement() {
	}

	/**
	 * 
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}
	
	
	public int hashCode() {
		int hash = 0;
		String code = String.valueOf(getCRN());
		int length = code.length();
		for(int i=0; i<length; i++) {
			hash += 31*hash + code.charAt(i);
		}
		hash = code.hashCode() % length;
		return hash;
	}

	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 * @param parseInt
	 */
	public void setCRN(int parseInt) {
		CRN = parseInt;
		
	}


}
