package SCRAME;

import java.util.*;
public class Course{
	public static final int MAX_ASSESSMENT = 4;
	private String name;
	private int numOfAssessments = 0;
	private String courseID;
	private Assessment[] assessment = new Assessment[MAX_ASSESSMENT];

	public Course(String courseID){
		this.courseID = courseID;
	}

	public void setAssessmentNum(int num){
		this.numOfAssessments = num;
	}

	public void setAssessments(){
		int numOfSubAssessments;
		String assessmentName;
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<numOfAssessments; i++){
			System.out.println("Name of assessment " + (i+1) +":");
			assessmentName = scan.nextLine();
			System.out.println("Number of sub-assessments '" + assessmentName + "' has:");
			numOfSubAssessments = scan.nextInt();
			scan.nextLine();
			assessment[i] = new Assessment(assessmentName, numOfSubAssessments);
		}	
	}

	public void setSubAssessments(){
		for(int i=0; i<numOfAssessments; i++){
			assessment[i].setSubAssessments();
		}
	}

	public String getCourseId(){
		return courseID;
	}

	public void printAssessment(){
		System.out.println("//Course structure-----------------------");
		for(int i=0; i<numOfAssessments; i++){
			assessment[i].printAssessment(0);
		}
	}

	public int getNumOfAssessments(){
		return numOfAssessments;
	}

	public Assessment getAssessment(int index){
		if(index < numOfAssessments){
			return assessment[index];
		}
		else{
			return null;
		}
	}
}