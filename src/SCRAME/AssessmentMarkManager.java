
public class AssessmentMarkManager{
	
	public static void printMark(AssessmentMark assessmentMark, int level){
		int numOfSubAssessmentMarks = assessmentMark.getNumOfSubAssessmentMarks();
		for(int i=0; i<level; i++){
			System.out.printf("  ");
		}
		if(assessmentMark.getMark() < 0){
			System.out.println(assessmentMark.getAssessment().getName() + ": No Mark");
		}
		else{
			System.out.println(assessmentMark.getAssessment().getName() + ": " + assessmentMark.getMark());
		}
		if(numOfSubAssessmentMarks > 0){
			for(int i=0; i<level; i++){
				System.out.printf("  ");
			}
			System.out.println("{");
			for(int i=0; i<numOfSubAssessmentMarks; i++){
				printMark(assessmentMark.getSubAssessmentMark(i), level+1);
			}
			for(int i=0; i<level; i++){
				System.out.printf("  ");
			}
			System.out.println("}");
		}
	}

	public static void createSubAssessmentMarks(AssessmentMark assessmentMark){
		int tempNumOfSubAssessmentMarks = assessmentMark.getNumOfSubAssessmentMarks();
		if(tempNumOfSubAssessmentMarks > 0){
			for(int i=0; i<tempNumOfSubAssessmentMarks; i++){
				assessmentMark.setSubAssessmentMark(i, assessmentMark.getAssessment().getSubAssessment(i));
			}
		}
		else{
			System.out.println("Enter mark for '" + assessmentMark.getAssessment().getName() + "':");
			assessmentMark.setMark(InputHandler.getInt());
		}
	}


}