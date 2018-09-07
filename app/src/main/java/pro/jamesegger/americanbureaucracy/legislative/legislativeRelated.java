package pro.jamesegger.americanbureaucracy.legislative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pro.jamesegger.americanbureaucracy.R;

public class legislativeRelated extends AppCompatActivity
{
	List<MyModel> jsonFileScannedIn;

	ImageView redSenateBackgroundSolid;
    ImageView blueSenateBackgroundSolid;
    ImageView yellowSenateBackgroundSolid;

	ImageView redHouseBackgroundSolid;
	ImageView blueHouseBackgroundSolid;
	ImageView yellowHouseBackgroundSolid;

    TextView demSen;
	TextView otherSen;
	TextView repSen;
	TextView demRep;
	TextView otherRep;
	TextView repRep;

	Button theHouseButton;
	Button theSenateButton;

	int totalReps=0;
	int totalSen=0;

	int width=0;

	Intent houseView;
	Intent senateView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legislative);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn =readSomePolitics.localFileReadingJSON(this);

		redHouseBackgroundSolid= findViewById(R.id.redHouseBackground);
		blueHouseBackgroundSolid= findViewById(R.id.blueHouseBackground);
		yellowHouseBackgroundSolid= findViewById(R.id.yellowHouseBackground);

		redSenateBackgroundSolid= findViewById(R.id.redSenateBackground);
		blueSenateBackgroundSolid= findViewById(R.id.blueSenateBackground);
		yellowSenateBackgroundSolid= findViewById(R.id.yellowSenateBackground);

		 demSen= findViewById(R.id.demSen);
		 otherSen= findViewById(R.id.otherSen);
		 repSen= findViewById(R.id.repSen);
		 demRep= findViewById(R.id.demRep);
		 otherRep= findViewById(R.id.otherRep);
		 repRep= findViewById(R.id.repRep);

		theHouseButton = findViewById(R.id.buttonHouse);
		theSenateButton = findViewById(R.id.buttonSenate);

		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;

		houseView = new Intent(legislativeRelated.this, houseRelated.class);
		senateView = new Intent(legislativeRelated.this, senateRelated.class);

	}

	protected void onStart()
	{
		super.onStart();

		int democratReps=0;
		int republicanReps=0;
		int otherReps=0;

		int democratSen=0;
		int republicanSen=0;
		int otherSens=0;

		for(int senOrRepToScanIn =0; senOrRepToScanIn<jsonFileScannedIn.size();senOrRepToScanIn++)
		{

			int currentTerm = jsonFileScannedIn.get(senOrRepToScanIn).senAndRepterms.size() -1;

			if(jsonFileScannedIn.get(senOrRepToScanIn).senAndRepterms.get(currentTerm).type.equals("rep"))
			{
				//Democrat
				if(jsonFileScannedIn.get(senOrRepToScanIn).senAndRepterms.get(currentTerm).party.equals("Democrat"))
				{
					democratReps++;
				}

				//Republican
				else if(jsonFileScannedIn.get(senOrRepToScanIn).senAndRepterms.get(currentTerm).party.equals("Republican"))
				{
					republicanReps++;
				}

				//Other
				else
				{
					otherReps++;
				}
				totalReps = democratReps+republicanReps+otherReps;
			}

			//Senator
			else
			{
				//Democrat
				if(jsonFileScannedIn.get(senOrRepToScanIn).senAndRepterms.get(currentTerm).party.equals("Democrat"))
				{
                    democratSen++;
				}

				//Republican
				else if(jsonFileScannedIn.get(senOrRepToScanIn).senAndRepterms.get(currentTerm).party.equals("Republican"))
				{
					republicanSen++;
				}

				//Other
				else
				{
					otherSens++;
				}

				totalSen = democratSen+republicanSen+otherSens;
			}
		}

        float newDemensionsForSenateRep = (republicanSen * width)/100;
		float newDemensionsForSenateDem = (democratSen * width)/100;
		float newDemensionsForSenateOther = (otherSens* width)/100;

		float newDemensionsForHouseRep = (republicanReps * width)/435;
		float newDemensionsForHouseDem = (democratReps * width)/435;
		float newDemensionsForHouseOther = (otherReps * width)/435;

		if((int)newDemensionsForHouseDem!=0)
		{
			blueHouseBackgroundSolid.setVisibility(View.VISIBLE);
			demRep.setVisibility(View.VISIBLE);


		}
		else{
			blueHouseBackgroundSolid.setVisibility(View.INVISIBLE);

			demRep.setVisibility(View.INVISIBLE);

		}

		if((int)newDemensionsForHouseOther!=0)
		{
			yellowHouseBackgroundSolid.setVisibility(View.VISIBLE);
			otherRep.setVisibility(View.VISIBLE);


		}
		else
		{
			yellowHouseBackgroundSolid.setVisibility(View.INVISIBLE);
			otherRep.setVisibility(View.INVISIBLE);

		}

		if((int)newDemensionsForHouseRep!=0)
		{
			redHouseBackgroundSolid.setVisibility(View.VISIBLE);
			repRep.setVisibility(View.VISIBLE);


		}
		else
		{
			redHouseBackgroundSolid.setVisibility(View.INVISIBLE);
			repRep.setVisibility(View.INVISIBLE);

		}

		if((int)newDemensionsForSenateDem!=0)
		{
			blueSenateBackgroundSolid.setVisibility(View.VISIBLE);
			demSen.setVisibility(View.VISIBLE);


		}
		else
		{
			blueSenateBackgroundSolid.setVisibility(View.INVISIBLE);
			demSen.setVisibility(View.INVISIBLE);

		}

		if((int)newDemensionsForSenateOther!=0)
		{
			yellowSenateBackgroundSolid.setVisibility(View.VISIBLE);
			otherSen.setVisibility(View.VISIBLE);


		}

		else{
			yellowSenateBackgroundSolid.setVisibility(View.INVISIBLE);
			otherSen.setVisibility(View.INVISIBLE);

		}

		if((int)newDemensionsForSenateRep!=0)
		{
			redSenateBackgroundSolid.setVisibility(View.VISIBLE);
			repSen.setVisibility(View.VISIBLE);

		}

		else
		{
			redSenateBackgroundSolid.setVisibility(View.INVISIBLE);
			repSen.setVisibility(View.INVISIBLE);

		}


		//35 left 35 right 30 in center.
        redSenateBackgroundSolid.getLayoutParams().width =(int) newDemensionsForSenateRep;
        blueSenateBackgroundSolid.getLayoutParams().width =(int)newDemensionsForSenateDem;
		yellowSenateBackgroundSolid.getLayoutParams().width = (int)newDemensionsForSenateOther;

		redHouseBackgroundSolid.getLayoutParams().width = (int)newDemensionsForHouseRep;
		blueHouseBackgroundSolid.getLayoutParams().width =(int)newDemensionsForHouseDem;
		yellowHouseBackgroundSolid.getLayoutParams().width = (int)newDemensionsForHouseOther;

		repRep.setText("Republicans: "+Integer.toString(republicanReps));
		demRep.setText("Democrats: "+Integer.toString(democratReps));
		otherRep.setText("Other: " +Integer.toString(otherReps));

		repSen.setText("Republicans: "+Integer.toString(republicanSen));
		demSen.setText("Democrats: "+Integer.toString(democratSen));
		otherSen.setText("Other: " +Integer.toString(otherSens));

    }

	public void on_Click_Go_Senate(View view)
	{
		legislativeRelated.this.startActivity(senateView);
	}

	public void on_Click_Go_House(View view)
	{
		legislativeRelated.this.startActivity(houseView);
	}
}
