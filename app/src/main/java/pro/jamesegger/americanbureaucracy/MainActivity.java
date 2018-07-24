package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

	List<MyModel> jsonFileScannedIn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart()
	{
		super.onStart();

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn = readSomePolitics.localFileReadingJSON(this);

		//Log.e("appdebug", "json file output: "+jsonFileScannedIn.get(0).senAndRepterms.size());
	}
}
