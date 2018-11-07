import java.util.*;

public class CourseManager
{
	private ArrayList<Course> courseList = new ArrayList<Course>();

	public Course addCourse(String courseID, String courseName)
	{
		Course tempCourse = new Course(courseID, courseName);
		courseList.add(tempCourse); 
		return tempCourse;
	}

	public void addCourseDetails(Course course)
	{

		System.out.println("Enter course size: ");
		course.setCourseSize(InputHandler.getInt());

		System.out.println("Enter lecture group number: ");
		course.setLecGroupNum(InputHandler.getInt());
		course.setLecGroupSize();
		course.setLecGroupList();

		System.out.println("Enter laborotary group number: ");
		course.setLabGroupNum(InputHandler.getInt());
		course.setLabGroupSize();
		course.setLabGroupList();

		System.out.println("Enter tutorial group number: ");
		course.setTutGroupNum(InputHandler.getInt());
		course.setTutGroupSize();
		course.setTutGroupList();
	}

	public boolean addProfInCourse(Course course, Professor prof)
	{
		return course.addProf(prof);
	}

	public String[] addStudentInCourse(Course course, Student student)
	{
		return course.addStudent(student);
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
		System.out.println("Courses List----------------------------");
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
			System.out.println("ERROR: Course does not exist.");
		}
		
	}

	public Boolean printAssessment(String courseID)
	{
		Course courseToPrint = getCourse(courseID);
		if(courseToPrint == null)
		{
			System.out.println("ERROR: Course does not exist.");
			return false;
		}
		else
		{
			System.out.println("//Course structure-------------------------");
			courseToPrint.printAssessment();
			return true;
		}
	}
}