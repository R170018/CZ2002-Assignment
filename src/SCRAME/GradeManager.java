public class GradeManager
{
	public static void printGrade(Grade grade){
		System.out.println("Grade-------------------------------");
		System.out.println(grade.getCourse().getCourseID() + ": ");
		AssessmentMarkManager.printMark(grade.getAssessmentMark(), 0);
	}
}