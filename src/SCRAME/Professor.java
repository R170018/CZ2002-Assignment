public class Professor extends PersonSuperClass
{
	private String profID = null;
	private String rank = null;

	public Professor(String profID, String profName)
	{
		super(profName);
		this.profID = profID;
	}

	public String getProfID()
	{
		return profID;
	}

	public String getRank()
	{
		return rank;
	}

	public void setRank(String rank)
	{
		this.rank = rank;
	}

	public void printProf()
	{
		System.out.println("Professor ID: " +  this.profID + "   " + "Name: " + this.getName());
	}
}