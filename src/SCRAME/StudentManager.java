// package SCRAME;
import java.util.*;
public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public void addStudent(String studentID) {
        //TODO check if student exists
        for (Student student : studentList) {
            if (studentID.equals(student.getStudentID())) { // if there is same student id
                System.out.println("Invalid input. StudentID already exist.");
                return;
            }
        }
        System.out.println("Enter student name:");
        String name = InputHandler.getLine();

        System.out.println("Enter student gender:");
        char gender = InputHandler.getLine().charAt(0);


        System.out.println("Enter student nationality:");
        String nationality = InputHandler.getLine();

        System.out.println("Enter student address:");
        String address = InputHandler.getLine();


        System.out.println("Enter student contact no.:");
        int contactNo = InputHandler.getInt();


        System.out.println("Enter student email:");
        String email = InputHandler.getLine();

        System.out.println("Is student studying fullTime? (Y/N)");
        Boolean fullTime = ('Y' == InputHandler.getLine().charAt(0));

        System.out.println("Is student (1) Exchange/ (2) Graduate / (3) Undergraduate?");
        int studentType = InputHandler.getInt();

        System.out.println("Student Year for Student? (e.g. 2018)");
        int studyYear = InputHandler.getInt();


        Student newStudent = new Student(studentID, name, gender, nationality, address, contactNo, email, fullTime, studentType, studyYear);

        studentList.add(newStudent);
        for (Student student : studentList) {
            student.printStudent();
        }
    }

    public void printStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getStudentID());
        }
    }

    public void setMark(String studentID, String courseID) {
        Student student = getStudent(studentID);
        //TODO: if student doesn't exist
        if(student != null){
            student.createMarks(courseID);
        }
    }

    public Student getStudent(String studentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equals(studentID)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public void printGrade(String studentID) {
        Student student = getStudent(studentID);
        if (student != null) {
            student.printGrade();
        } else {
            System.out.println("Student doesn't exist!");
        }
    }
}