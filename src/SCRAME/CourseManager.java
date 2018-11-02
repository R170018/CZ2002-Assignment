import java.util.*;
public class CourseManager{
	private ArrayList<Course> courses = new ArrayList<Course>();

	public void addCourse(String courseID){
		//TODO:check if course already added
		courses.add(new Course(courseID));
	}

	public Boolean setAssessment(String courseID){
		Scanner scan = new Scanner(System.in);
		int numOfAssessments;
		//find the target course to set assessments
		Course courseToSet = null;
		for(int i=0; i<courses.size(); i++){
			if(courses.get(i).getCourseId().equals(courseID)){
				courseToSet = courses.get(i);
				break;
			}
		}
		if(courseToSet != null){
			//get input
			do{
				System.out.println("Enter the number of assessments to add:(<=" + Course.MAX_ASSESSMENT + ")");
				//TODO What if user enter a string instead of int
				numOfAssessments = scan.nextInt();
				scan.nextLine();
			}while(numOfAssessments > Course.MAX_ASSESSMENT);

			courseToSet.setAssessmentNum(numOfAssessments);
			//create assessments of the course
			courseToSet.setAssessments();
			//create sub-assessments of the course
			courseToSet.setSubAssessments();
			return true;
		}
		else{
			System.out.println("ERROR: Course does not exist.");
			return false;
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

	public Boolean printAssessment(String courseID){
		Course courseToPrint = getCourse(courseID);
		if(courseToPrint == null){
			System.out.println("ERROR: Course does not exist.");
			return false;
		}
		else{
			courseToPrint.printAssessment();
			return true;
		}
	}
}