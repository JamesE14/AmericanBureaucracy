package pro.jamesegger.americanbureaucracy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

	Intent startLegislativeGUI;
	Intent startExecutiveGUI;
	Intent startJudicialGUI;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startLegislativeGUI = new Intent(MainActivity.this, legislativeRelated.class);
		startExecutiveGUI = new Intent(MainActivity.this, executiveRelated.class);
		startJudicialGUI = new Intent(MainActivity.this, judicialRelated.class);

	}

	@Override
	protected void onStart()
	{
		super.onStart();

		if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
		{

			Log.e("NOOOOO", "NOT Granted!");

			if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET))
			{

			}

			else
			{
					ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
			}

			//onRequestPermissionsResult(1,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},);
		}
		else
		{
			//Log.e("YAYYYY", "Granted!");

			// Permission has already been granted
		}
	}

	public void on_Click_Go_Executive(View view)
	{
		MainActivity.this.startActivity(startExecutiveGUI);
	}

	public void on_Click_Go_Judicial(View view)
	{
		MainActivity.this.startActivity(startJudicialGUI);
	}

	public void on_Click_Go_Legislative(View view)
	{
		MainActivity.this.startActivity(startLegislativeGUI);
	}

}
