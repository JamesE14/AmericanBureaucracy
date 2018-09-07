package pro.jamesegger.americanbureaucracy.executive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pro.jamesegger.americanbureaucracy.R;

public class executiveSpecific extends AppCompatActivity
{
	String specificExecutiveLimb;
	TextView titleOfLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.executivespecific);
		titleOfLayout = findViewById(R.id.titleNameTextView);

		Bundle newExtras = getIntent().getExtras();
		specificExecutiveLimb = newExtras.getString("ExecutiveSpecific", "ERROR");
	}

	@Override
	protected void onStart()
	{
		super.onStart();

		if(specificExecutiveLimb.equals("President"))
		{
			titleOfLayout.setText(R.string.president);
		}

		else if(specificExecutiveLimb.equals("Vice"))
		{
			titleOfLayout.setText(R.string.vicePresident);
		}

		else if(specificExecutiveLimb.equals("Cabinet"))
		{
			titleOfLayout.setText("Main Cabinet");
		}

		else if(specificExecutiveLimb.equals("Level"))
		{
			titleOfLayout.setText("Cabinet-Level");
		}

	}
}

