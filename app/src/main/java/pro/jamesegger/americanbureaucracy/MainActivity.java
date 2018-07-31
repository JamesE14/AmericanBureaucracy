package pro.jamesegger.americanbureaucracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
