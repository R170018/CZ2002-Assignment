//package SCRAME;
import java.io.Serializable;

public class PersonSuperClass implements Serializable
{
    private String name = null;
    private char gender = 'N';
    private String nationality = null;
    private String address = null;
    private String contactNum = null;
    private String email = null;

    public PersonSuperClass(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setContactNum(String contactNum)
    {
        this.contactNum = contactNum;
    }

    public void setEmail(String email)
    {
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
