package SCRAME;

import java.util.*;
public class Assessment{
	public static final int MAX_SUBASSESSMENT = 4;
	private Assessment[] subAssessment = new Assessment[MAX_SUBASSESSMENT];
	private String name;
	private int numOfSubAssessments = 0;

	public Assessment(String name, int numOfSubAssessments){
		this.name = name;
		this.numOfSubAssessments = numOfSubAssessments;
	}

	public void setSubAssessments(){
		String subAssessmentName;
		int numOfSubOfSub;
		Scanner scan = new Scanner(System.in);
		//terminate condition
		if(numOfSubAssessments > 0){
			//loop to create sub-assessments for current assessment
			for(int i=0; i<numOfSubAssessments; i++){
				System.out.println("Sub-assessments of '" + this.name + "'-----------------------");
				System.out.println("Name of sub-assessment " + (i+1) + ":");
				subAssessmentName = scan.nextLine();
				System.out.println("Number of sub-assessments '" + subAssessmentName + "' has:");
				numOfSubOfSub = scan.nextInt();
				scan.nextLine();
				subAssessment[i] = new Assessment(subAssessmentName, numOfSubOfSub);
			}
			//recursive calls
			for(int i=0; i<numOfSubAssessments; i++){
				subAssessment[i].setSubAssessments();
			}
		}
	}

	public void printAssessment(int level){
		for(int i=0; i<level; i++){
			System.out.printf("  ");
		}
		System.out.println(this.name);
		//terminate condition
		if(numOfSubAssessments > 0){
			for(int i=0; i<level; i++){
				System.out.printf("  ");
			}
			System.out.println("{");
			//loop to print sub-assessments of current assessment
			for(int i=0; i<numOfSubAssessments; i++){
				subAssessment[i].printAssessment(level+1);
			}
			for(int i=0; i<level; i++){
				System.out.printf("  ");
			}
			System.out.println("}");
		}
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
}
