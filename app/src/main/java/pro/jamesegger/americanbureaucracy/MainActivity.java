package pro.jamesegger.americanbureaucracy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

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

		localFileReading readSomePolitics = new localFileReading(this);
	}
}
