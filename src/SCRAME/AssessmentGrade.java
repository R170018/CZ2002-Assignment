package SCRAME;

public class AssessmentGrade {
    private Assessment assessment;
	private float mark;
	private AssessmentGrade[] subAssessmentGrade = new AssessmentGrade[4] ;

    //constructor 
    public AssessmentGrade(Assessment assessment, float mark){
        this.assessment=assessment;
        this.mark=mark;
        // for assessment with sub assessment will have a mark of -1;

    }


    public float calculateMark(){
        for (int i=0; i<assessment.getNumOfSubAssessment(); i++){
            if (subAssessmentGrade[i].getMark()==-1){
                subAssessmentGrade[i].calculateMark();
            }
            mark += (subAssessmentGrade[i].getMark() / subAssessmentGrade[i].getMaxMark()*100) * subAssessmentGrade[i].getPercentage();
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
        return Mark;
    }

    /**public int getSubAssessment(){
        for (int i=0;i<numOfSubAssessment;i++){

        }
    } **/
    
    

    //set one of its subAssessmentGrade
    public void setSubAssessmentGrade(int index, Assessment assessment, int mark){
        if(index < assessment.getNumOfSubAssessment()){
            subAssessment[index] = new AssessmentGrade(assessment, mark);
		}
		else{
			System.out.println("Index goes beyond allowed number of sub-assessment.");
		}       
    }



	

}
