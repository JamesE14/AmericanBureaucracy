package pro.jamesegger.americanbureaucracy;

import java.util.ArrayList;
import java.util.List;

public class MyModel
{

	public String first;
	public String last;
	public String fullName;


	public String birthday;
	public String gender;
	public String religion;

	public String voterID;
	public String wikiID;
	public String wikiData;

	List<termStorage> senAndRepterms = new ArrayList<>();

	public MyModel(nameStorage name, idStorage idFromStorage, bioStorage bio, List<termStorage> terms)
	{

		 voterID =idFromStorage.votesmartID;
		 wikiID = idFromStorage.wikipediaID;
		 wikiData = idFromStorage.wikidataID;

		 first = name.first;
		 last = name.last;
		 fullName = name.fullName;

		 birthday = bio.birthday;
		 gender = bio.gender;
		 religion = bio.religion;

		 senAndRepterms = terms;
	}
}
