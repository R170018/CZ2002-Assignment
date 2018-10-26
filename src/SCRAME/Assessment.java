package SCRAME;
public class Assessment{
	private string name;
	private float percentage;
	private Assessment[4] subAssessment;
	private int numOfSubAssessment = 0;

	public setName(string name){
		this.name = name;
	}

	public setPercentage(float percentage){
		if(percentage > 0 && percentage <=1){
			this.percentage = percentage;
		}
		else{
			System.out.println("Percentage needs to be a number between 0 and 1");
		}
	}

	public setNumOfSubAssessment(int number){
		numOfSubAssessment = number;
	}

	public setSubAssessments(int index, string name, float percentage){
		if(index < numOfSubAssessment){
			subAssessment[index].setName(name);
			subAssessment[index].setPercentage(percentage);
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