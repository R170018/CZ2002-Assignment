
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
		int tempNumOfSubAssessments;
		do{
			System.out.println("Number of assessment components '" + assessment.getName() + "' has:(<" + assessment.MAX_SUBASSESSMENT + ")");
			tempNumOfSubAssessments = InputHandler.getInt();
		}while(!assessment.setNumOfSubAssessments(tempNumOfSubAssessments));
		//terminate condition
		if(tempNumOfSubAssessments > 0){
			//loop to create sub-components for current assessment
			for(int i=0; i<tempNumOfSubAssessments; i++){
				System.out.println("Assessment components of '" + assessment.getName() + "'-----------------------");
				System.out.println("Name of component " + (i+1) + ":");
				subAssessmentName = InputHandler.getLine();
				assessment.setSubAssessment(i, subAssessmentName);
			}
			//recursive calls
			for(int i=0; i<tempNumOfSubAssessments; i++){
				setSubAssessments(assessment.getSubAssessment(i));
			}
		}
	}
}