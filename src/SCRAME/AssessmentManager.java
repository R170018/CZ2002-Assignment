/**
 * The manager class of assessment
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class AssessmentManager {
    /**
     * Print the details of an assessment and its level
     *
     * @param assessment refers to the assessment object
     * @param level      refers to the level of its component
     */
    public static void printAssessment(Assessment assessment, int level) {
        for (int i = 0; i < level; i++) {
            System.out.printf("  ");
        }
        System.out.println(assessment.getName() + "   " + assessment.getPercentage() + "%");
        //terminate condition
        if (assessment.getNumOfSubAssessments() > 0) {
            for (int i = 0; i < level; i++) {
                System.out.printf("  ");
            }
            System.out.println("{");
            //loop to print sub-assessments of current assessment
            for (int i = 0; i < assessment.getNumOfSubAssessments(); i++) {
                printAssessment(assessment.getSubAssessment(i), level + 1);
            }
            for (int i = 0; i < level; i++) {
                System.out.printf("  ");
            }
            System.out.println("}");
        }
    }

    /**
     * Get the sub assessments of a given assessment
     *
     * @param assessment assessment object of given assessment
     */
    public static void setSubAssessments(Assessment assessment) {
        String subAssessmentName;
        int tempNumOfSubAssessments;
        int remainingPercentage = 100;
        int percentage;
        do {
            System.out.println("Number of assessment components '" + assessment.getName() + "' has:(no larger than " + assessment.MAX_SUBASSESSMENT + ")");
            tempNumOfSubAssessments = InputHandler.getInt();
            if (tempNumOfSubAssessments < 0 || tempNumOfSubAssessments > assessment.MAX_SUBASSESSMENT) {
                System.out.println("Expecting an non-negative integer no larger than " + assessment.MAX_SUBASSESSMENT + ".");
            } else {
                break;
            }
        } while (true);
        assessment.setNumOfSubAssessments(tempNumOfSubAssessments);
        //terminate condition
        if (tempNumOfSubAssessments > 0) {
            System.out.println("Assessment components of '" + assessment.getName() + "'-----------------------------------");
            //loop to create sub-components for current assessment
            for (int i = 0; i < tempNumOfSubAssessments; i++) {
                System.out.println("Name of component " + (i + 1) + ":");
                subAssessmentName = InputHandler.getLine();
                assessment.setSubAssessment(i, subAssessmentName);
                //Get percentage
                if (i != tempNumOfSubAssessments - 1) {
                    while (true) {
                        System.out.println("Weightage percentage of " + subAssessmentName + ":(Integer required. E.g., enter 10 to represent 10%)");
                        percentage = InputHandler.getInt();
                        if (percentage >= 0 && percentage <= remainingPercentage) {
                            break;
                        }
                        System.out.println("Expecting an integer between 0 and " + remainingPercentage + ".");
                    }

                    assessment.getSubAssessment(i).setPercentage(percentage);
                    remainingPercentage -= percentage;
                    System.out.println("Weightage percentage of " + subAssessmentName + " is " + percentage + "%.");
                } else {
                    assessment.getSubAssessment(i).setPercentage(remainingPercentage);
                    System.out.println("Weightage percentage of " + subAssessmentName + " is " + remainingPercentage + "%.");
                }
            }
            //recursive calls
            for (int i = 0; i < tempNumOfSubAssessments; i++) {
                setSubAssessments(assessment.getSubAssessment(i));
            }
        }
    }
}