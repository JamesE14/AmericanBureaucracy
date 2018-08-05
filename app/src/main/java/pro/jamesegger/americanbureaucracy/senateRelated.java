package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class senateRelated extends AppCompatActivity
{
	List<MyModel> jsonFileScannedIn;
	private List<MyModel> senateMembersOnly = new ArrayList<MyModel>();

	private RecyclerView theSenateRecycler;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.senatedetails);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		int senateMembers=0;
		for(int findHouseMembers=0;findHouseMembers<jsonFileScannedIn.size() & senateMembers<100 ;findHouseMembers++)
		{
			int termsOfMember = jsonFileScannedIn.get(findHouseMembers).senAndRepterms.size()-1;
			if(jsonFileScannedIn.get(findHouseMembers).senAndRepterms.get(termsOfMember).type.equals("sen"))
			{
				senateMembersOnly.add(jsonFileScannedIn.get(findHouseMembers));
				senateMembers++;
			}
		}

		theSenateRecycler= findViewById(R.id.senateRecycler);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		theSenateRecycler.setHasFixedSize(true);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		theSenateRecycler.setLayoutManager(mLayoutManager);

		// specify an adapter (see also next example)
		mAdapter = new adapterForjsonParsing(senateMembersOnly);
		theSenateRecycler.setAdapter(mAdapter);
	}

	protected void onStart()
	{
		super.onStart();

	}

}
