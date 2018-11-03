// package SCRAME;

public class PersonSuperClass {
    private String numberID;
    private String name;
    private char gender;
    private String nationality;
    private String address;
    private int contactNo;
    private String email;

    public PersonSuperClass(String numberID, String name, char gender, String nationality, String address, int contactNo, String email) {
        this.numberID = numberID;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
    }

    public String getNumberID() {
        return numberID;
    }

    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
