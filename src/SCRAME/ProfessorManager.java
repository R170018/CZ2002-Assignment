import java.util.*;

public class ProfessorManager
{
	private ArrayList<Professor> profList = new ArrayList<Professor>();

	public boolean haveProf(String profID)
	{
		for (Professor professor : profList) 
        {
            if (profID.equals(professor.getProfID())) 
            { 
                return true;
            }
        }
        return false;
	}

	public Professor getProf(String profID)
	{
		for (Professor professor : profList) 
        {
            if (profID.equals(professor.getProfID())) 
            { 
                return professor;
            }
		}
		return null;
	}

	// change
	// public Professor addProf(String profID, String profName)
	// {
	// 	Professor tempProf = new Professor(profID, profName);
	//  	profList.add(tempProf);
	//  	return tempProf;
	// }

	public void addProf(String profID, String profName)
	{
		Professor tempProf = new Professor(profID, profName);
        profList.add(tempProf);
        System.out.println("Add detail information for this professor?(1 : yes, 0 : no): ");
		if(InputHandler.getInt() == 1)
		{
			addProfDetails(profID);
		}
		System.out.println("Professor " + profID + " successfully added!");
	}

	public void addProfDetails(String profID/*change: Professor prof*/)
	{
		Professor prof = getProf(profID);
		System.out.println("Enter gender(male: M; female: F): ");
		prof.setGender(InputHandler.getLine().charAt(0));

		System.out.println("Enter nationality: ");
		prof.setNationality(InputHandler.getLine());

		System.out.println("Enter address: ");
		prof.setAddress(InputHandler.getLine());

		System.out.println("Enter contact number: ");
		prof.setContactNum(InputHandler.getLine());

		System.out.println("Enter email: ");
		prof.setEmail(InputHandler.getLine());

		System.out.println("Enter rank: ");
		prof.setRank(InputHandler.getLine());
	}

	public void printProfList()
	{
		System.out.println("Professor list------------------------------------------------");
		for(Professor prof : profList)
		{
			prof.printProf();
		}
	}
}