import java.util.*;

public class AssessmentManager{
	public static void printAssessment(Assessment assessment, int level){
		for(int i=0; i<level; i++){
			System.out.printf("  ");
		}
		System.out.println(assessment.getName());
		//terminate condition
		if(assessment.getNumOfSubAssessments() > 0){
			for(int i=0; i<level; i++){
				System.out.printf("  ");
			}
			System.out.println("{");
			//loop to print sub-assessments of current assessment
			for(int i=0; i<assessment.getNumOfSubAssessments(); i++){
				printAssessment(assessment.getSubAssessment(i), level+1);
			}
			for(int i=0; i<level; i++){
				System.out.printf("  ");
			}
			System.out.println("}");
		}
	}

	public static void setSubAssessments(Assessment assessment){
		String subAssessmentName;
		Scanner scan = new Scanner(System.in);
		int tempNumOfSubAssessments;
		do{
			System.out.println("Number of assessments '" + assessment.getName() + "' has:(<" + assessment.MAX_SUBASSESSMENT + ")");
			tempNumOfSubAssessments = scan.nextInt();
			scan.nextLine();
		}while(!assessment.setNumOfSubAssessments(tempNumOfSubAssessments));
		//terminate condition
		if(tempNumOfSubAssessments > 0){
			//loop to create sub-components for current assessment
			for(int i=0; i<tempNumOfSubAssessments; i++){
				System.out.println("Sub components of '" + assessment.getName() + "'-----------------------");
				System.out.println("Name of sub-component " + (i+1) + ":");
				subAssessmentName = scan.nextLine();
				assessment.setSubAssessment(i, subAssessmentName);
			}
			//recursive calls
			for(int i=0; i<tempNumOfSubAssessments; i++){
				setSubAssessments(assessment.getSubAssessment(i));
			}
		}
	}
}