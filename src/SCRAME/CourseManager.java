//package SCRAME;

import java.util.*;

public class CourseManager
{
	private ArrayList<Course> courses = new ArrayList<Course>();

	public void addCourse(String courseID)
	{
		
		//TODO:check if course already added
		Scanner sc = new Scanner(System.in);

		System.out.println("input course ID: ");
		String tempCourseID = InputHandler.getLine();

		System.out.println("input course name: ");
		String tempCourseName = InputHandler.getLine();

		System.out.println("input course size: ");
		int tempCourseSize = InputHandler.getInt();

		System.out.println("intput lecture group number");
		int templecGroupNum = InputHandler.getInt();

		System.out.println("intput laborotary group number");
		int templabGroupNum = InputHandler.getInt();

		System.out.println("intput tutorial group number");
		int temptutGroupNum = InputHandler.getInt();

		System.out.println("input the number of instructors: ");
		int tempProfNum = InputHandler.getInt();

		Professor[] tempProfArr = new Professor[tempProfNum];
		for(int i = 0; i < tempProfNum; i ++)
		{
			System.out.println("input the ");
		}
		
		courses.add(new Course(tempCourseID, tempCourseName, tempCourseSize, templecGroupNum, templabGroupNum, temptutGroupNum, tempProfNum));
	}

	public void setAssessment(String courseID){
		//find the target course to set assessments
		Course courseToSet = getCourse(courseID);
		if(courseToSet != null){
			courseToSet.setAssessment();
		}
		else{
			System.out.println("ERROR: Course does not exist.");
		}
		
	}

	public void printCourses(){
		System.out.println("Courses----------------------------");
		for(int i=0; i<courses.size(); i++){
			System.out.println(courses.get(i).getCourseId());
		}
	}

	public Course getCourse(String courseID){
		for(int i=0; i<courses.size(); i++){
			if(courses.get(i).getCourseId().equals(courseID)){
				return courses.get(i);
			}
		}
		return null;
	}

	public Boolean haveCourse(String courseID){
		for(int i=0; i<courses.size(); i++){
			if(courses.get(i).getCourseId().equals(courseID)){
				return true;
			}
		}
		return false;
	}

	public Boolean printAssessment(String courseID){
		Course courseToPrint = getCourse(courseID);
		if(courseToPrint == null){
			System.out.println("ERROR: Course does not exist.");
			return false;
		}
		else{
			System.out.println("//Course structure-------------------------");
			courseToPrint.printAssessment();
			return true;
		}
	}
}