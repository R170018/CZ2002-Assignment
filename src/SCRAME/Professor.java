public class Professor extends PersonSuperClass
{
	private String profID;
	private String rank;

	public Professor(String profID, String rank, String name, char gender, String nationality, String address, String contactNum, String email)
	{
		super(name, gender, nationality, address, contactNum, email);
		this.profID = profID;
		this.rank = rank;
	}

	public String getProfID()
	{
		return profID;
	}

	public String getRank()
	{
		return rank;
	}
}