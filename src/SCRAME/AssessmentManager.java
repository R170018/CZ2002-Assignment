
public class AssessmentManager{
	public static void printAssessment(Assessment assessment, int level){
		for(int i=0; i<level; i++){
			System.out.printf("  ");
		}
		System.out.println(assessment.getName() + "  percentage: " + assessment.getPercentage() + "%");
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
		int remainingPercentage = 100;
		int percentage;
		do{
			System.out.println("Number of assessment components '" + assessment.getName() + "' has:(no larger than " + assessment.MAX_SUBASSESSMENT + ")");
			tempNumOfSubAssessments = InputHandler.getInt();
		}while(!assessment.setNumOfSubAssessments(tempNumOfSubAssessments));
		//terminate condition
		if(tempNumOfSubAssessments > 0){
			System.out.println("Assessment components of '" + assessment.getName() + "'-----------------------------------");
			//loop to create sub-components for current assessment
			for(int i=0; i<tempNumOfSubAssessments; i++){	
				System.out.println("Name of component " + (i+1) + ":");
				subAssessmentName = InputHandler.getLine();
				assessment.setSubAssessment(i, subAssessmentName);
				//Get percentage
				if(i != tempNumOfSubAssessments-1){
					System.out.println("Weightage percentage of " + subAssessmentName + ":(Integer required. E.g., enter 10 to represent 10%)");
					percentage = InputHandler.getInt();
					assessment.getSubAssessment(i).setPercentage(percentage);
					remainingPercentage -= percentage;
					System.out.println("Weightage percentage of " + subAssessmentName + " is " + percentage + "%.");
				}
				else{
					assessment.getSubAssessment(i).setPercentage(remainingPercentage);
					System.out.println("Weightage percentage of " + subAssessmentName + " is " + remainingPercentage + "%.");
				}
			}
			//recursive calls
			for(int i=0; i<tempNumOfSubAssessments; i++){
				setSubAssessments(assessment.getSubAssessment(i));
			}
		}
	}
}