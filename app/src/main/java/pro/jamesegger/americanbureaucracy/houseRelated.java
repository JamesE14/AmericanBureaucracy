package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class houseRelated extends AppCompatActivity
{

	List<MyModel> jsonFileScannedIn;
	private List<MyModel> houseMembersOnly = new ArrayList<MyModel>();


	private RecyclerView theHouseRecycler;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.housedetails);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		int houseMembers=0;
		for(int findHouseMembers=0;findHouseMembers<jsonFileScannedIn.size() & houseMembers<435 ;findHouseMembers++)
		{
			int termsOfMember = jsonFileScannedIn.get(findHouseMembers).senAndRepterms.size()-1;
			if(jsonFileScannedIn.get(findHouseMembers).senAndRepterms.get(termsOfMember).type.equals("rep"))
			{
				houseMembersOnly.add(jsonFileScannedIn.get(findHouseMembers));
				houseMembers++;
			}
		}


		theHouseRecycler= findViewById(R.id.houseRecycler);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		theHouseRecycler.setHasFixedSize(true);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		theHouseRecycler.setLayoutManager(mLayoutManager);

		// specify an adapter (see also next example)
		mAdapter = new adapterForjsonParsing(houseMembersOnly);
		theHouseRecycler.setAdapter(mAdapter);
	}

	protected void onStart()
	{
		super.onStart();

	}

}
