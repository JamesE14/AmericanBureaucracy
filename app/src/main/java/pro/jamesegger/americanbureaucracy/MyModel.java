package pro.jamesegger.americanbureaucracy;

import java.util.ArrayList;
import java.util.List;

public class MyModel
{

	public String first;
	public String last;

	public String birthday;
	public String gender;
	public String religion;

	List<termStorage> senAndRepterms = new ArrayList<>();

	public MyModel(nameStorage name, bioStorage bio, List<termStorage> terms)
	{
		 first = name.first;
		 last = name.last;

		 birthday = bio.birthday;
		 gender = bio.gender;
		 religion = bio.religion;

		 senAndRepterms = terms;
	}
}
