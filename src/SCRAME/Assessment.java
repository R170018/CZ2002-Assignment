import java.io.Serializable;

public class Assessment implements Serializable{
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

	public void setNumOfSubAssessments(int numOfSubAssessments){
		if(numOfSubAssessments >= 0 && numOfSubAssessments <= MAX_SUBASSESSMENT){
			this.numOfSubAssessments = numOfSubAssessments;
		}
	}

}
