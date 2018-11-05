//package SCRAME;

public class PersonSuperClass 
{
    private String name;
    private char gender;
    private String nationality;
    private String address;
    private String contactNum;
    private String email;

    public PersonSuperClass(String name, char gender, String nationality, String address, String contactNum, String email) 
    {
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.contactNum = contactNum;
        this.email = email;
    }

    public String getName() 
    {
        return name;
    }

    public char getGender()
    {
        return gender;
    }

    public String getNationality()
    {
        return nationality;
    }

    public String getAddress()
    {
        return address;
    }

    public String getContactNum()
    {
        return contactNum;
    }

    public String getEmail()
    {
        return email;
    }
}
