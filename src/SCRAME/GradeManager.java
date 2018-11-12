/**
 * Manager class of the grade
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */

public class GradeManager {
    /**
     * Print the grades of certain grade
     *
     * @param grade grade object
     */
    public static void printGrade(Grade grade) {
        System.out.println("Grade-------------------------------");
        System.out.println(grade.getCourse().getCourseID() + ": " + grade.getGrade());
        AssessmentMarkManager.printMark(grade.getAssessmentMark(), 0);
    }

    /**
     * Calculate the grade and print out the grade alphabet
     *
     * @param grade grade object
     */
    public static void calculateGrade(Grade grade) {
        String strGrade;
        AssessmentMarkManager.calculateMark(grade.getAssessmentMark());
        switch ((grade.getAssessmentMark().getMark() * 2) / 10) {
            case 20:
            case 19:
                strGrade = "A+";
                break;
            case 18:
                strGrade = "A";
                break;
            case 17:
                strGrade = "A-";
                break;
            case 16:
                strGrade = "B+";
                break;
            case 15:
                strGrade = "B";
                break;
            case 14:
                strGrade = "B-";
                break;
            case 13:
                strGrade = "C+";
                break;
            case 12:
                strGrade = "C";
                break;
            case 11:
                strGrade = "C-";
                break;
            default:
                strGrade = "F";
        }
        grade.setGrade(strGrade);
    }

    /**
     * Create assessment marks of certain grade
     *
     * @param grade grade object
     */
    public static void createAssessmentMarks(Grade grade) {
        grade.setAssessmentMark(new AssessmentMark(grade.getCourse().getAssessment()));
        AssessmentMarkManager.createSubAssessmentMarks(grade.getAssessmentMark());
        calculateGrade(grade);
    }
}