
public class AssessmentMarkManager{
	
	public static void printMark(AssessmentMark assessmentMark, int level){
		int numOfSubAssessmentMarks = assessmentMark.getNumOfSubAssessmentMarks();
		for(int i=0; i<level; i++){
			System.out.printf("  ");
		}
		if(assessmentMark.getMark() < 0){
			System.out.println(assessmentMark.getAssessment().getName() + " (" + assessmentMark.getAssessment().getPercentage() + "%): No Mark");
		}
		else{
			if(level > 0){
				System.out.println(assessmentMark.getAssessment().getName() + " (" + assessmentMark.getAssessment().getPercentage() + "%): " + assessmentMark.getMark());
			}
			else{
				System.out.println(assessmentMark.getAssessment().getName() + ": " + assessmentMark.getMark());
			}
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
				createSubAssessmentMarks(assessmentMark.getSubAssessmentMark(i));
			}
		}
		else{
			System.out.println("Enter mark for '" + assessmentMark.getAssessment().getName() + "':");
			assessmentMark.setMark(InputHandler.getInt());
		}
	}

	public static int calculateMark(AssessmentMark assessmentMark){
		int sum = 0;
		AssessmentMark subAssessmentMark;
		Assessment assessment = assessmentMark.getAssessment();
		//terminate condition
		if(assessment.getNumOfSubAssessments() > 0){
			for(int i=0; i<assessment.getNumOfSubAssessments(); i++){
				//recursive call
				subAssessmentMark = assessmentMark.getSubAssessmentMark(i);
				sum += calculateMark(subAssessmentMark) * subAssessmentMark.getPercentage()/100.0;
			}
			assessmentMark.setMark(sum);
			return assessmentMark.getMark();
		}
		else{
			if(assessmentMark.getMark() == -1){
				System.out.println("No mark has been entered yet!");
			}
			return assessmentMark.getMark();
		}
	}


}