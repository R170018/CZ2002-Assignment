
public class Assessment{
	public static final int MAX_SUBASSESSMENT = 4;
	private Assessment[] subAssessment = new Assessment[MAX_SUBASSESSMENT];
	private String name;
	private int numOfSubAssessments = 0;
	private int percentage = 100;

	public Assessment(String name){
		this.name = name;
	}

	public void setSubAssessment(int index, String name){
		subAssessment[index] = new Assessment(name);
	}

	public void setPercentage(int percentage){
		this.percentage = percentage;
	}

	public int getPercentage(){
		return percentage;
	}

	public String getName(){
		return this.name;
	}

	public Assessment getSubAssessment(int index){
		if(index < numOfSubAssessments){
			return subAssessment[index];
		}
		return null;
	}

	public int getNumOfSubAssessments(){
		return numOfSubAssessments;
	}

	public Boolean setNumOfSubAssessments(int numOfSubAssessments){
		if(numOfSubAssessments >= 0 && numOfSubAssessments <= MAX_SUBASSESSMENT){
			this.numOfSubAssessments = numOfSubAssessments;
			return true;
		}
		else{
			System.out.println("Expecting an non-negative integer no larger than " + MAX_SUBASSESSMENT + ".");
			return false;
		}

	}

	// public void setSubAssessments(){
	// 	String subAssessmentName;
	// 	Scanner scan = new Scanner(System.in);
	// 	int tempNumOfSubAssessments;
	// 	do{
	// 		System.out.println("Number of sub components '" + this.name + "' has:(<" + MAX_SUBASSESSMENT + ")");
	// 		tempNumOfSubAssessments = scan.nextInt();
	// 		scan.nextLine();
	// 	}while(!setNumOfSubAssessments(tempNumOfSubAssessments));
	// 	//terminate condition
	// 	if(numOfSubAssessments > 0){
	// 		//loop to create sub-assessments for current assessment
	// 		for(int i=0; i<numOfSubAssessments; i++){
	// 			System.out.println("Sub components of '" + this.name + "'-----------------------");
	// 			System.out.println("Name of sub component " + (i+1) + ":");
	// 			subAssessmentName = scan.nextLine();
	// 			subAssessment[i] = new Assessment(subAssessmentName);
	// 		}
	// 		//recursive calls
	// 		for(int i=0; i<numOfSubAssessments; i++){
	// 			subAssessment[i].setSubAssessments();
	// 		}
	// 	}
	// }

	// public void printAssessment(int level){
	// 	for(int i=0; i<level; i++){
	// 		System.out.printf("  ");
	// 	}
	// 	System.out.println(this.name);
	// 	//terminate condition
	// 	if(numOfSubAssessments > 0){
	// 		for(int i=0; i<level; i++){
	// 			System.out.printf("  ");
	// 		}
	// 		System.out.println("{");
	// 		//loop to print sub-assessments of current assessment
	// 		for(int i=0; i<numOfSubAssessments; i++){
	// 			subAssessment[i].printAssessment(level+1);
	// 		}
	// 		for(int i=0; i<level; i++){
	// 			System.out.printf("  ");
	// 		}
	// 		System.out.println("}");
	// 	}
	// }
}
