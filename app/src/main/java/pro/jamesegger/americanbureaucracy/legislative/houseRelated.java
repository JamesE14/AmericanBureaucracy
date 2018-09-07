package pro.jamesegger.americanbureaucracy.legislative;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pro.jamesegger.americanbureaucracy.R;

public class houseRelated extends AppCompatActivity {

	List<MyModel> jsonFileScannedIn;
	private List<MyModel> houseMembersOnly = new ArrayList<MyModel>();

	private RecyclerView theHouseRecycler;
	private adapterForjsonParsing mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private TextView congressTitleInView;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.congresslist);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		int houseMembers = 0;
		for (int findHouseMembers = 0; findHouseMembers < jsonFileScannedIn.size() & houseMembers < 435; findHouseMembers++) {
			int termsOfMember = jsonFileScannedIn.get(findHouseMembers).senAndRepterms.size() - 1;
			if (jsonFileScannedIn.get(findHouseMembers).senAndRepterms.get(termsOfMember).type.equals("rep")) {
				houseMembersOnly.add(jsonFileScannedIn.get(findHouseMembers));
				houseMembers++;
			}
		}

		theHouseRecycler = findViewById(R.id.senateRecycler);
		congressTitleInView = findViewById(R.id.congressTitle);
		congressTitleInView.setText(getResources().getString(R.string.houseRelatedTitle));

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		theHouseRecycler.setHasFixedSize(true);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		theHouseRecycler.setLayoutManager(mLayoutManager);

		//Will display house members and allows for selection.
		mAdapter = new adapterForjsonParsing(this, houseMembersOnly);
		theHouseRecycler.setAdapter(mAdapter);
	}

}
