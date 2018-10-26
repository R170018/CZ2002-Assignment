package SCRAME;

public class Assessment{
	public static final int MAX_SUBASSESSMENT = 4;
	private string name;
	private float percentage;
	private Assessment[MAX_SUBASSESSMENT] subAssessment;
	private int numOfSubAssessment = 0;
	private int maxMark;

	public setName(string name){
		this.name = name;
	}

	public int setPercentage(float percentage){
		if(percentage > 0 && percentage <=1){
			this.percentage = percentage;
			return 1;
		}
		else{
			System.out.println("Percentage needs to be a number between 0 and 1");
			return -1;
		}
	}

	public int setNumOfSubAssessment(int number){
		if(number <= MAX_SUBASSESSMENT){
			numOfSubAssessment = number;
			return 1;
		}
		else{
			System.out.println("Number of sub-assessment cannot exceed " + MAX_SUBASSESSMENT);
			return -1;
		}
	}

	public setSubAssessments(int index, string name, float percentage, int maxMark){
		if(index < numOfSubAssessment){
			subAssessment[index].setName(name);
			subAssessment[index].setPercentage(percentage);
			subAssessment[index].setMaxMark(maxMark);
		}
		else{
			System.out.println("Index go beyond allowed number of sub-assessment.");
		}
	}
		
	public int checkPercentage(){
		int percentageSum = 0;
		for(int i=0; i<numOfSubAssessment; i++){
			percentage += subAssessment[i].percentage;
		}
		if(percentage == 1){
			return 1;
		}
		return -1;
	}

	public Assessment[] getSubAssessment(){
		return subAssessment;
	}

	public getName(){
		return name;
	}

	public getPercentage(){
		return percentage;
	}

}