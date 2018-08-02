package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class senateRelated extends AppCompatActivity
{
	List<MyModel> jsonFileScannedIn;
	RecyclerView theSenateRecycler;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.senatedetails);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		theSenateRecycler= findViewById(R.id.senateRecycler);

	}

	protected void onStart()
	{
		super.onStart();

	}

}
