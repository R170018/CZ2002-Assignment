import java.util.*;

public class CourseManager
{
	private ArrayList<Course> courseList = new ArrayList<Course>();

	//change
	// public Course addCourse(String courseID, String courseName)
	// {
	// 	Course tempCourse = new Course(courseID, courseName);
	// 	courseList.add(tempCourse); 
	// 	return tempCourse;
	// }

	public void addCourse(String courseID, String courseName)
	{
		Course tempCourse = new Course(courseID, courseName);
		courseList.add(tempCourse); 
		addCourseDetails(courseID);
		System.out.println("Course " + courseID + " successfully added!");
	}

	public void addCourseDetails(String courseID/*change: Course course*/)
	{
		Course course = getCourse(courseID);
		if(course == null){
			return;
		}
		System.out.println("Enter course capacity: ");
		course.setCourseCapacity(InputHandler.getInt());

		System.out.println("Enter number of lecture groups: ");
		course.createGroupList(InputHandler.getInt(), 0);
		setGroup(courseID, 0);
		//course.setLecGroupSize();
		// course.setLecGroupList();

		System.out.println("Enter number of laborotary groups: ");
		course.createGroupList(InputHandler.getInt(), 1);
		setGroup(courseID, 1);
		//course.setLabGroupSize();
		// course.setLabGroupList();

		System.out.println("Enter number of tutorial groups: ");
		course.createGroupList(InputHandler.getInt(), 2);
		setGroup(courseID, 2);
		//course.setTutGroupSize();
		// course.setTutGroupList();
	}

	public void setGroup(String courseID, int type){
		Course course = getCourse(courseID);
		if(course == null){
			return;
		}
		int groupNum = course.getGroupNum(type);
		String groupType = course.getGroupType(type);
		int courseCapacity = course.getCourseCapacity();
		if(course != null){
			if(groupNum == 0){
				return;
			}
			int size = courseCapacity / groupNum;
			for(int i = 1; i <= groupNum; i++)
			{	
				if(i == groupNum){
					size = courseCapacity - (groupNum-1) * size;
				}
				System.out.println("Input ID for " + groupType + " group " + i + ": ");
				String tempID = InputHandler.getLine();
				Group newGroup = new Group(size, tempID, groupType);
				course.setGroup(i-1, newGroup, type);
			}
		}
	}

	//change
	public void addProfToCourse(String courseID, Professor prof){	
		Course tempCourse = getCourse(courseID);
		if(tempCourse != null){
			for(int i=0; i<tempCourse.getProfNum(); i++){
				if(tempCourse.getProf(i).getProfID().equals(prof.getProfID())){	
					System.out.println("Unsuccessful! Professor " + prof.getProfID() + " is already teaching course " + tempCourse.getCourseID() + "!" );
					return;
				}
			}
			tempCourse.addProf(prof);
			System.out.println("Professor " + prof.getProfID() + " has been successfully assigned to course " + tempCourse.getCourseID() + ".");
		}
	}

	//change
	public void addStudentToCourse(String courseID, Student student)
	{	
		Course course = getCourse(courseID);
		Group tempGroup;
		boolean hasVacancy = false;
		if(course == null){
			return;
		}
		//check if student's already taking the course
		for(int i=0; i<course.getGroupNum(0); i++){
			tempGroup = course.getGroup(0, i);
			if(tempGroup.haveStudent(student)){
				System.out.println("Unsuccessful! Student " + student.getStudentID() + " is already taking course " + course.getCourseID() + ".");
				break;
			}
		}
		//check vacancy and add student
		for(int i=0; i<course.getGroupNum(0); i++){
			tempGroup = course.getGroup(0, i);
			if(tempGroup.getVacancy() != 0){
				tempGroup.addStudent(student);
				System.out.println("Student " + student.getStudentID() + " is assigned to lecture group " + tempGroup.getGroupID() + ".");
				hasVacancy = true;
				break;
			}
		}
		if(!hasVacancy){
			System.out.println("Unsuccessful! Course " + course.getCourseID() + " has no vacancy.");
		}
		else{
			for(int i=0; i<course.getGroupNum(1); i++){
				tempGroup = course.getGroup(1, i);
				if(tempGroup.getVacancy() != 0){
					tempGroup.addStudent(student);
					System.out.println("Student " + student.getStudentID() + " is assigned to lab group " + tempGroup.getGroupID() + ".");
					break;
				}
			}

			for(int i=0; i<course.getGroupNum(2); i++){
				tempGroup = course.getGroup(2, i);
				if(tempGroup.getVacancy() != 0){
					tempGroup.addStudent(student);
					System.out.println("Student " + student.getStudentID() + " is assigned to tutorial group " + tempGroup.getGroupID() + ".");
					break;
				}
			}
			
			//Pass course reference to student
			student.createGrade(course);

			System.out.println("Student " + student.getStudentID() + " has been successfully assigned to course " + course.getCourseID() + ".");
		}
	}

	public Boolean haveCourse(String courseID)
	{
		for(Course course : courseList)
		{
			if(courseID.equals(course.getCourseID()))
			{
				return true;
			}
		}
		return false;
	}

	public Course getCourse(String courseID)
	{
		for(Course course : courseList)
		{
			if(courseID.equals(course.getCourseID()))
			{
				return course;
			}
		}
		return null;
	}

	public void printCourseList()
	{
		System.out.println("Course List----------------------------------");
		for(Course course : courseList)
		{
			System.out.println("Course ID: " + course.getCourseID());
			System.out.println("Course Name: " + course.getCourseName());
			System.out.println("Professor in charge: ");
			for(int i=0; i<course.getProfNum(); i++){
				System.out.println("	ID:" + course.getProf(i).getProfID() + "	Name:" + course.getProf(i).getName());
			}
			System.out.println("---------------------------------------------");
		}
	}

	public void setAssessment(String courseID)
	{
		//find the target course to set assessments
		Course courseToSet = getCourse(courseID);
		if(courseToSet != null)
		{
			courseToSet.setAssessment();
		}
		
	}

	public void printAssessment(String courseID)
	{
		Course courseToPrint = getCourse(courseID);
		if(courseToPrint != null){
			System.out.println("Course structure---------------------------");
			courseToPrint.printAssessment();
		}
	}

	public void printGroup(String courseID){
		Course tempCourse = getCourse(courseID);
		if(tempCourse != null){
			
		}
	}

}