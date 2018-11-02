package SCRAME;

public class AssessmentMark {
    private Assessment assessment;
	private float mark;
	private AssessmentMark[] subAssessmentMark = new AssessmentMark[4] ;

    //constructor 
    public AssessmentGrade(Assessment assessment, float mark){
        this.assessment=assessment;
        // assessment with sub assessment will have a mark of -1;
        this.mark=mark;
        

    }

    // setMark for assessment with subassessment
    public float calculateMark(){
        for (int i=0; i<assessment.getNumOfSubAssessment(); i++){
            mark += subAssessmentGrade[i].getMark() * subAssessmentGrade[i].getPercentage();
        } 
    } 

    //set one of its subAssessmentGrade
    public void setSubAssessmentMark(int index, Assessment assessment, int mark){
        if(index < assessment.getNumOfSubAssessment()){
            subAssessmentMark[index] = new AssessmentMark(assessment, mark);
		}
		else{
			System.out.println("Index goes beyond allowed number of sub-assessment.");
		}       
    }

    //reference assessment's information
    public String getName(){
        return assessment.getName();
    }

    public float getPercentage(){
        return assessment.getPercentage();
    }

    public int getNumOfSubAssessment(){
        return assessment.getNumOfSubAssessment();
    }
    // its own info
    public float getMark(){
        if (Mark==-1){
            calculateMark();
        }
        return Mark;
    }

    /**public int getSubAssessment(){
        for (int i=0;i<numOfSubAssessment;i++){

        }
    } **/
    
    





	

}
