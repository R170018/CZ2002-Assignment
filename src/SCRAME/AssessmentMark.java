// package SCRAME;

public class AssessmentMark{
	private Assessment assessment;
	private AssessmentMark[] subAssessmentMark = new AssessmentMark[Assessment.MAX_SUBASSESSMENT];
	private int mark = -1;

	public AssessmentMark(Assessment assessment){
		this.assessment = assessment;
	}

	public void setSubAssessmentMark(int index, Assessment assessment){
		subAssessmentMark[index] = new AssessmentMark(assessment);
	}

	public void setMark(int mark){
		this.mark = mark;
	}

	public int getMark(){
		return mark;
	}

	public int calGrade(){
		int sum = 0;
		//terminate condition
		if(assessment.getNumOfSubAssessments() > 0){
			for(int i=0; i<assessment.getNumOfSubAssessments(); i++){
				//recursive call
				sum += subAssessmentMark[i].calGrade() * subAssessmentMark[i].getPercentage()/100.0;
			}
			setMark(sum);
			return mark;
		}
		else{
			if(mark == -1){
				System.out.println("No mark has been entered yet!");
			}
			return mark;
		}
	}

	public int getNumOfSubAssessmentMarks(){
		return assessment.getNumOfSubAssessments();
	}

	public AssessmentMark getSubAssessmentMark(int index){
		if(index < assessment.getNumOfSubAssessments()){
			return subAssessmentMark[index];
		}
		return null;
	}

	public Assessment getAssessment(){
		return assessment;
	}

	public int getPercentage(){
		return assessment.getPercentage();
	}

	// public void printMark(int level){
	// 	for(int i=0; i<level; i++){
	// 		System.out.printf("  ");
	// 	}
	// 	System.out.println(assessment.getName() + ": " + mark);
	// 	if(assessment.getNumOfSubAssessments() > 0){
	// 		for(int i=0; i<level; i++){
	// 			System.out.printf("  ");
	// 		}
	// 		System.out.println("{");
	// 		for(int i=0; i<assessment.getNumOfSubAssessments(); i++){
	// 			subAssessmentMark[i].printMark(level+1);
	// 		}
	// 		for(int i=0; i<level; i++){
	// 			System.out.printf("  ");
	// 		}
	// 		System.out.println("}");
	// 	}
	// }


	// public void createSubAssessmentMarks(){
	// 	Scanner scan = new Scanner(System.in);
	// 	if(assessment.getNumOfSubAssessments() > 0){
	// 		for(int i=0; i<assessment.getNumOfSubAssessments(); i++){
	// 			subAssessmentMark[i] = new AssessmentMark(assessment.getSubAssessment(i));
	// 		}
	// 	}
	// 	else{
	// 		System.out.println("Enter mark for '" + assessment.getName() + "':");
	// 		setMark(scan.nextInt());
	// 		scan.nextLine();
	// 	}
	// }

}