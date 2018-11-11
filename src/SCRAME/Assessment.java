import java.io.Serializable;

/**
 * This is an entity class for storing assessment information. 
 */
public class Assessment implements Serializable{
	public static final int MAX_SUBASSESSMENT = 4;
	private Assessment[] subAssessment = new Assessment[MAX_SUBASSESSMENT];
	private String name;
	private int numOfSubAssessments = 0;
	private int percentage = 100;

	/**
	 * @param name name of the assessment 
	 */
	public Assessment(String name){
		this.name = name;
	}

	/**
	 * @param index position of the subAssessment array to insert sub assessment to
	 * @param name name of the sub assessment
	 */
	public void setSubAssessment(int index, String name){
		subAssessment[index] = new Assessment(name);
	}

	/**
	 * @param percentage the weightage percentage of the assessment
	 */
	public void setPercentage(int percentage){
		this.percentage = percentage;
	}

	/**
	 * @return the weightage percentage of the assessment
	 */
	public int getPercentage(){
		return percentage;
	}

	/**
	 * @return the name of the assessment
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * @param index position of the subAssessment array to read sub assessment from
	 * @return sub assessment of this assessment
	 */
	public Assessment getSubAssessment(int index){
		if(index < numOfSubAssessments){
			return subAssessment[index];
		}
		return null;
	}

	/**
	 * @return number of sub assessments this assessment has
	 */
	public int getNumOfSubAssessments(){
		return numOfSubAssessments;
	}

	/**
	 * @param numOfSubAssessments number of sub assessments to set for this assessment
	 */
	public void setNumOfSubAssessments(int numOfSubAssessments){
		if(numOfSubAssessments >= 0 && numOfSubAssessments <= MAX_SUBASSESSMENT){
			this.numOfSubAssessments = numOfSubAssessments;
		}
	}

}
