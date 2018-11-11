
public class Professor extends Person
{	
	private String rank;

	public Professor(String profID, String profName)
	{
		super(profID, profName);
	}

	public void setRank(String rank){
		this.rank = rank;
	}

	public String getRank(){
		return rank;
	}
}