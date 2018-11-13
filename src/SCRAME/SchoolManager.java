// package SCRAME;

import java.io.Serializable;

/**
 * The control class for the whole school, the control class that controls the sub control classes
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class SchoolManager implements Serializable {
    /**
     * The control class for courses
     */
    private CourseManager courseManager = new CourseManager();
    /**
     * The Control class for the students
     */
    private StudentManager studentManager = new StudentManager();
    /**
     * The control class for the professors
     */
    private ProfessorManager professorManager = new ProfessorManager();

    /**
     * Function to start the SCRAME application
     */
    public void start() {
        int choice;
        String tempStudentID;
        String tempProfID;
        String tempCourseID;


        do {
            System.out.println("(1)Add a student;");
            System.out.println("(2)Add a professor;");
            System.out.println("(3)Add a course;");
            System.out.println("(4)Enter course assessment components;");
            System.out.println("(5)Print course list;");
            System.out.println("(6)Print course structure;");
            System.out.println("(7)Print student list;");
            System.out.println("(8)Print student list for a course;");
            System.out.println("(9)Print professor list;");
            System.out.println("(10)Register student for a course;");
            System.out.println("(11)Assign professor to a course;");
            System.out.println("(12)Enter mark for a student;");
            System.out.println("(13)Print grade of a student;");
            System.out.println("(14)Print course statistics;");
            System.out.println("(15)Check available slot in a class (vacancy in a class);");
            System.out.println("(16)Exit;");
            System.out.println("Please enter your choice:");

            choice = InputHandler.getInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    addProf();
                    break;

                case 3:
                    addCourse();
                    break;

                case 4:
                    System.out.println("Enter the target course ID:");
                    tempCourseID = InputHandler.getLine();
                    addCourseComponent(tempCourseID);
                    break;

                case 5:
                    courseManager.printCourseList();
                    break;

                case 6:
                    System.out.println("Enter course ID: ");
                    tempCourseID = InputHandler.getLine();
                    printCourseComponent(tempCourseID);
                    break;

                case 7:
                    studentManager.printList();
                    break;

                case 8:
                    System.out.println("Enter course ID: ");
                    tempCourseID = InputHandler.getLine();
                    printStudentListForCourse(tempCourseID);
                    break;

                case 9:
                    professorManager.printList();
                    break;

                case 10:
                    assignStudentToCourse();
                    break;
                case 11:
                    assignProfToCourse();
                    break;

                case 12:
                    System.out.println("Enter student ID:");
                    tempStudentID = InputHandler.getLine();
                    enterStudentMark(tempStudentID);
                    break;

                case 13:
                    System.out.println("Enter student ID: ");
                    tempStudentID = InputHandler.getLine();
                    printStudentGrade(tempStudentID);
                    break;

                // 9. print course stats
                case 14:
                    System.out.println("Enter course ID: ");
                    tempCourseID = InputHandler.getLine();
                    printCourseStatistic(tempCourseID);
                    break;
                // 4
                case 15:
                    System.out.println("Enter course ID: ");
                    tempCourseID = InputHandler.getLine();
                    checkCourseVacancy(tempCourseID);
                    break;

                case 16:
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
            }

        } while (choice != 16);

    }

    /**
     * Function to add a student into the group of all the students
     */
    public void addStudent() {
        String tempStudentID;
        String tempStudentName;

        System.out.println("Enter student ID: ");
        tempStudentID = InputHandler.getLine();
        if (!studentManager.havePerson(tempStudentID)) {
            System.out.println("Enter student name: ");
            tempStudentName = InputHandler.getLine();
            studentManager.addPerson(tempStudentID, tempStudentName);
            studentManager.printList();
        } else {
            System.out.println("Student exists!");
        }
    }

    /**
     * Function to add a professor into the group of professors
     */
    public void addProf() {
        String tempProfID, tempProfName;

        System.out.println("Enter professor ID: ");
        tempProfID = InputHandler.getLine();
        if (!professorManager.havePerson(tempProfID)) {
            System.out.println("Enter professor name: ");
            tempProfName = InputHandler.getLine();
            professorManager.addPerson(tempProfID, tempProfName);
            professorManager.printList();
        } else {
            System.out.println("Professor exists!");
        }
    }

    /**
     * Function to add a course into the group of courses
     */
    public void addCourse() {
        String tempCourseID, tempCourseName;
        String tempProfID, tempProfName;
        Professor tempProf;

        System.out.println("Input course ID: ");
        tempCourseID = InputHandler.getLine();
        if (!courseManager.haveCourse(tempCourseID)) {
            System.out.println("Input course Name: ");
            tempCourseName = InputHandler.getLine();
            courseManager.addCourse(tempCourseID, tempCourseName);
            System.out.println("Assign professors to course " + tempCourseID + "---------------------------");
            System.out.println("Enter professor ID:");
            tempProfID = InputHandler.getLine();
            do {
                boolean firstProfEntered = true;
                if (!professorManager.havePerson(tempProfID)) {
                    firstProfEntered = false;
                    System.out.println("Professor " + tempProfID + " doesn't exist.");
                    int tempInt;
                    do {
                        System.out.println("Your options:");
                        System.out.println("(1)Add professor " + tempProfID + " to professor list;");
                        System.out.println("(2)Enter professor ID again.");
                        System.out.println("(3)Print professor list.");
                        System.out.println("Please enter your choice:");
                        tempInt = InputHandler.getInt();
                        switch (tempInt) {
                            case 1:
                                System.out.println("Enter professor name: ");
                                tempProfName = InputHandler.getLine();
                                professorManager.addPerson(tempProfID, tempProfName);
                                professorManager.printList();
                                firstProfEntered = true;
                                break;
                            case 2:
                                System.out.println("Enter professor ID:");
                                tempProfID = InputHandler.getLine();
                                //firstProfEntered = false;
                                break;
                            case 3:
                                professorManager.printList();
                                tempInt = 0;
                                break;
                        }
                    } while (tempInt != 1 && tempInt != 2 && tempInt != 3);
                }
                if (firstProfEntered) {
                    tempProf = professorManager.getPerson(tempProfID);
                    courseManager.addProfToCourse(tempCourseID, tempProf);
                    System.out.println("Enter next professor ID: (enter -1 to stop)");
                    tempProfID = InputHandler.getLine();
                }
            } while (!tempProfID.equals("-1"));
            courseManager.printCourseList();
        } else {
            System.out.println("Course exists!");
        }
    }

    /**
     * Add course component into certain course
     *
     * @param tempCourseID id of the course
     */
    public void addCourseComponent(String tempCourseID) {
        if (courseManager.haveCourse(tempCourseID)) {
            courseManager.setAssessment(tempCourseID);
            courseManager.printAssessment(tempCourseID);
        } else {
            System.out.println("Course does not exist!");
        }
    }

    /**
     * Print the course components of a certain course
     *
     * @param tempCourseID id of the course
     */
    public void printCourseComponent(String tempCourseID) {
        if (courseManager.haveCourse(tempCourseID)) {
            courseManager.printAssessment(tempCourseID);
        } else {
            System.out.println("Course does not exist!");
        }
    }

    public void printStudentListForCourse(String courseID) {
        try {
            if (!courseManager.haveCourse(courseID)) {
                throw new Exception("Error: Course does not exist!");
            }

            System.out.println("Print student list according to a group type: Lecture(0) / Lab(1) / Tutorial(2) : ");
            GroupType groupType = GroupType.values()[InputHandler.getInt()];
            courseManager.printStudentList(courseID, groupType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Assign a student into certain course
     */
    public void assignStudentToCourse() {
        String tempStudentID, tempCourseID;
        Student tempStudent;

        //change
        System.out.println("Enter student ID: ");
        tempStudentID = InputHandler.getLine();
        if (studentManager.havePerson(tempStudentID) == false) {
            System.out.println("Student does not exist!");
            return;
        } else {
            tempStudent = studentManager.getPerson(tempStudentID);
        }

        System.out.println("Enter course ID: ");
        tempCourseID = InputHandler.getLine();
        if (courseManager.haveCourse(tempCourseID) == false) {
            System.out.println("Course does not exist!");
            return;
        }

        courseManager.addStudentToCourse(tempCourseID, tempStudent);
    }

    /**
     * Assign a professor into a certain course
     */
    public void assignProfToCourse() {
        String tempCourseID, tempProfID;
        Professor tempProf;

        System.out.println("Enter course ID:");
        tempCourseID = InputHandler.getLine();
        if (!courseManager.haveCourse(tempCourseID)) {
            System.out.println("Course does not exist!");
            return;
        }

        System.out.println("Enter professor ID:");
        tempProfID = InputHandler.getLine();
        if (!professorManager.havePerson(tempProfID)) {
            System.out.println("Professor does not exist!");
            return;
        } else {
            tempProf = professorManager.getPerson(tempProfID);
        }

        tempProf = professorManager.getPerson(tempProfID);
        courseManager.addProfToCourse(tempCourseID, tempProf);
    }

    /**
     * Enter the student mark of a specific student
     *
     * @param tempStudentID id of the student
     */
    public void enterStudentMark(String tempStudentID) {
        String tempCourseID;

        if (!studentManager.havePerson(tempStudentID)) {
            System.out.println("Student doesn't exist!");
            return;
        }

        System.out.println("Enter course ID:");
        tempCourseID = InputHandler.getLine();
        if (!courseManager.haveCourse(tempCourseID)) {
            System.out.println("Course doesn't exist!");
            return;
        }

        studentManager.setMark(tempStudentID, tempCourseID);
    }

    /**
     * Print the grade of a certain student
     *
     * @param tempStudentID id of the student
     */
    public void printStudentGrade(String tempStudentID) {
        if (studentManager.havePerson(tempStudentID)) {
            studentManager.printGrade(tempStudentID);
        } else {
            System.out.println("Student doesn't exist!");
        }
    }

    /**
     * Print the course statistics of a certain course
     *
     * @param courseID id of the course
     */
    public void printCourseStatistic(String courseID) {
        try {

            if (!courseManager.haveCourse(courseID)) {
                throw new Exception("Error: Course does not exist!");
            }

            courseManager.printStatistic(courseID);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Check the vacancy of a course
     *
     * @param courseID id of the course
     */
    public void checkCourseVacancy(String courseID) {
        try {
            //check if the course exists
            if (!courseManager.haveCourse(courseID)) {
                throw new Exception("Error: Course does not exist!");
            }

            courseManager.checkVacancy(courseID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}