import java.util.*;
//import java.io.Serializable;

/**
 * Control class of all the students
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class StudentManager extends PeopleManager
{
    /**
     * Get the student Object of the person
     * @param studentID ID of the student
     * @return Student Object of the person
     */
    public Student getPerson(String studentID){
        if(super.getPerson(studentID) instanceof Student){
            return (Student) super.getPerson(studentID);
        }
        return null;
    }

    /**
     * Add a person to the list of students
     * @param studentID id of the person
     * @param studentName name of the person
     */
    public void addPerson(String studentID, String studentName)
    {
        Student student = new Student(studentID, studentName);
        personList.add(student);
    
        System.out.println("Add detail information for this student?(1 : yes, 0 : no): ");
        if(InputHandler.getInt() == 1){
            addStudentDetails(studentID);
        }
        System.out.println("Student " + studentID + " successfully added!");
    }

    /**
     * Add the details of the student
     * @param studentID id of the student
     */
    public void addStudentDetails(String studentID/*change: Student student*/)
    {   
        Student student = getPerson(studentID);
        System.out.println("Enter gender(male: M; female: F): ");
        student.setGender(InputHandler.getLine().charAt(0));

        System.out.println("Enter nationality: ");
        student.setNationality(InputHandler.getLine());

        System.out.println("Enter address: ");
        student.setAddress(InputHandler.getLine());

        System.out.println("Enter contact number: ");
        student.setContactNum(InputHandler.getLine());

        System.out.println("Enter email: ");
        student.setEmail(InputHandler.getLine());

        System.out.println("Is student studying full-time or part-time? (F/P)");
        student.setTypeOfStudy('F' == InputHandler.getLine().charAt(0));

        System.out.println("Is student a graduate or an undergraduate? (G/U)");
        student.setStudentType('U' == InputHandler.getLine().charAt(0));

        System.out.println("Student Year for Student? (e.g. 2018)");
        student.setStudyYear(InputHandler.getInt());
    }

    /**
     * Print the list of students and its relevant information
     */
    public void printList() 
    {
        System.out.println("Student list----------------------------");
        super.printList();
    }

    /**
     * Set the mark of specific course for a specific student
     * @param studentID id of the student
     * @param courseID id of the specific course
     */
    public void setMark(String studentID, String courseID) 
    {
        Student student = getPerson(studentID);
        if(student != null)
        {   
            Grade tempGrade = null;
            Course tempCourse;
            for(int i = 0; i < student.getNumOfGrade(); i++)
            {
                tempCourse = student.getGradeByIndex(i).getCourse();

                if(tempCourse.getCourseID().equals(courseID))
                {
                    tempGrade = student.getGradeByIndex(i);
                }
            }
            if(tempGrade != null)
            {
                GradeManager.createAssessmentMarks(tempGrade);
            }
            else
            {
                System.out.println("Student " + studentID + " is not taking course " + courseID + ".");
            }
        }
    }

    /**
     * Print the grade of a certain student
     * @param studentID id of the student
     */
    public void printGrade(String studentID) 
    {
        Student student = getPerson(studentID);
        if (student != null) 
        {   
            if(student.getNumOfGrade() == 0)
            {
                System.out.println("Student has not taken any courses.");
            }
            else
            {
                for(int i=0; i<student.getNumOfGrade(); i++)
                {
                    GradeManager.printGrade(student.getGradeByIndex(i));
                }
            }
        } 
    }

     // print 1 student info

    /**
     * Print the information of one student only
     * @param student student object
     */
    public static void printStudentInfo(Student student) 
    {   
        if(student == null){return;}
        System.out.printf("StudentID: " +  student.getID() + "   " + "Name: " + student.getName());
        if(student.getTypeOfStudy() != null){
            System.out.printf(" Type of study: "+student.getTypeOfStudy());
        }
        if(student.getStudentType() != null){
            System.out.printf(" Type of Student:" +student.getStudentType());
        }
        if(student.getStudyYear() != 0){
            System.out.printf(" Year of Study: "+student.getStudyYear());
        }
        System.out.println();
    }

}