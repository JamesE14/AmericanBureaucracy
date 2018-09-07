package pro.jamesegger.americanbureaucracy.legislative;

public class billHolderClass
{

	public String voteOnBill;
	public String theType;
	public String theNumber;
	public String theCongress;


	public billHolderClass(String newVoteOnBill,String newTheType,String newTheNumber,String newTheCongress)
	{

		voteOnBill =newVoteOnBill;
		theType = newTheType;
		theNumber = newTheNumber;
		theCongress = newTheCongress;

	}
}
