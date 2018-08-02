package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class houseRelated extends AppCompatActivity
{

	List<MyModel> jsonFileScannedIn;
	RecyclerView theHouseRecycler;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.housedetails);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);


		theHouseRecycler= findViewById(R.id.houseRecycler);
	}

	protected void onStart()
	{
		super.onStart();

		//theHouseRecycler.
	}

}
