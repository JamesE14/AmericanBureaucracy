package pro.jamesegger.americanbureaucracy.legislative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import pro.jamesegger.americanbureaucracy.R;

public class legislatordetailsclass extends AppCompatActivity
{

	List<MyModel> jsonFileScannedIn;
	MyModel theWantedLegislator;
	TextView legislatorMainTitle;
	TextView partyAffiliation;
	TextView gender;
	TextView birthday;
	TextView stateAffiliation;

	String fullNameOfLegislator;

	Intent legislationVotes;



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legislatordetails);

		Bundle newExtras = getIntent().getExtras();


		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		fullNameOfLegislator =newExtras.getString("FullName", "ERROR");


		for (int findLegislator = 0; findLegislator < jsonFileScannedIn.size(); findLegislator++)
		{

			if (jsonFileScannedIn.get(findLegislator).fullName.equals(fullNameOfLegislator))
			{
				theWantedLegislator =jsonFileScannedIn.get(findLegislator);
				break;
			}
		}


		legislatorMainTitle = findViewById(R.id.legislatorTitle);
		partyAffiliation = findViewById(R.id.legislatorParty);
		stateAffiliation = findViewById(R.id.legislatorState);
		gender = findViewById(R.id.legislatorGender);
		birthday = findViewById(R.id.BioIdDisplay);

		legislationVotes = new Intent(legislatordetailsclass.this, congressMemberVotes.class);


	}

	@Override
	protected void onStart()
	{
		super.onStart();

		int mostRecentRole = theWantedLegislator.senAndRepterms.size();

		legislatorMainTitle.setText(fullNameOfLegislator);
		partyAffiliation.setText("Party: "+theWantedLegislator.senAndRepterms.get(mostRecentRole-1).party);
		stateAffiliation.setText("State: "+ theWantedLegislator.senAndRepterms.get(mostRecentRole-1).state);
		gender.setText("Gender: " + theWantedLegislator.gender);
		birthday.setText("Bio ID: "+ theWantedLegislator.bioGuide);
	}

	public void launchWikiPage(View view)
	{

	}

	public void launchVotingHistory(View view)
	{
		legislationVotes.putExtra("BioId", theWantedLegislator.bioGuide);
		legislatordetailsclass.this.startActivity(legislationVotes);

	}

	public void launchPolitiFactsPage(View view)
	{

	}

}
