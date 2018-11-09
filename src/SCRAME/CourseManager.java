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
		System.out.println("Enter course size: ");
		course.setCourseCapacity(InputHandler.getInt());

		System.out.println("Enter number of lecture groups: ");
		course.setLecGroupNum(InputHandler.getInt());
		course.setLecGroupSize();
		course.setLecGroupList();

		System.out.println("Enter number of laborotary groups: ");
		course.setLabGroupNum(InputHandler.getInt());
		course.setLabGroupSize();
		course.setLabGroupList();

		System.out.println("Enter number of tutorial groups: ");
		course.setTutGroupNum(InputHandler.getInt());
		course.setTutGroupSize();
		course.setTutGroupList();
	}

	//change
	public void addProfToCourse(String courseID, Professor prof){	
		Course tempCourse = getCourse(courseID);
		tempCourse.addProf(prof);
	}

	//change
	public void addStudentToCourse(String courseID, Student student)
	{	
		Course tempCourse = getCourse(courseID);
		tempCourse.addStudent(student);
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
			course.printCourse();
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
		else
		{
			System.out.println("Course does not exist!");
		}
		
	}

	public void printAssessment(String courseID)
	{
		Course courseToPrint = getCourse(courseID);
		if(courseToPrint == null)
		{
			System.out.println("Course does not exist!");
		}
		else
		{
			System.out.println("Course structure---------------------------");
			courseToPrint.printAssessment();
		}
	}
}