package SCRAME;

public class Professor extends PersonSuperClass {
    private String professorPosition;

    public Professor(String numberID, String name, char gender, String nationality, String address, int contactNo, String email, String professorPosition) {
        super(numberID, name, gender, nationality, address, contactNo, email);
        this.professorPosition = professorPosition;
    }

    public String getProfessorPosition() {
        return professorPosition;
    }

    public void setProfessorPosition(String professorPosition) {
        this.professorPosition = professorPosition;
    }
}
