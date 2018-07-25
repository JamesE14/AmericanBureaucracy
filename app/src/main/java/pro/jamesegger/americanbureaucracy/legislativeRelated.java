package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.List;

public class legislativeRelated extends FragmentActivity
{
	List<MyModel> jsonFileScannedIn;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legislative);


		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn =readSomePolitics.localFileReadingJSON(this);
	}

	protected void onStart()
	{
		super.onStart();
	}


}
