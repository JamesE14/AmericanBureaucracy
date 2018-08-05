package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class legislatordetailsclass extends AppCompatActivity
{

	List<MyModel> jsonFileScannedIn;
	List<MyModel> theWantedLegislator;
	TextView legislatorMainTitle;

	String firstNameOfLegislator;
	String lastNameOfLegislator;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.housedetails);

		Bundle newExtras = getIntent().getExtras();


		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		firstNameOfLegislator =newExtras.getString("FirstName", "ERROR");
		lastNameOfLegislator =newExtras.getString("LastName", "ERROR");


		for (int findLegislator = 0; findLegislator < jsonFileScannedIn.size(); findLegislator++)
		{

			if (jsonFileScannedIn.get(findLegislator).first == firstNameOfLegislator & jsonFileScannedIn.get(findLegislator).last == lastNameOfLegislator)
			{
				theWantedLegislator.add(jsonFileScannedIn.get(findLegislator));
			}
		}


		legislatorMainTitle = findViewById(R.id.legislatorTitle);

	}

	@Override
	protected void onStart()
	{
		super.onStart();
		legislatorMainTitle.setText(firstNameOfLegislator +" "+lastNameOfLegislator);
	}

}
