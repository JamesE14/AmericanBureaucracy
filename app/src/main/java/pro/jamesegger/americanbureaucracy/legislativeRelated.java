package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.List;

public class legislativeRelated extends AppCompatActivity
{
	List<MyModel> jsonFileScannedIn;

	TableLayout entireTableViewReps;
	TableRow tableRow1;
	TableRow tableRow2;
	TableRow tableRow3;
	TableRow tableRow4;
	TableRow tableRow5;
	TableRow tableRow6;
	TableRow tableRow7;
	TableRow tableRow8;
	TableRow tableRow9;
	TableRow tableRow10;

	TableLayout entrieTableViewSen;
	TableRow tableRow1Sen;
	TableRow tableRow2Sen;
	TableRow tableRow3Sen;
	TableRow tableRow4Sen;

	Button buttons[];
	int totalReps=0;
	int totalSen=0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legislative);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn =readSomePolitics.localFileReadingJSON(this);


		entireTableViewReps = findViewById(R.id.mainTableRepresentatives);
		entireTableViewReps.setShrinkAllColumns(true);

		 tableRow1= findViewById(R.id.table1);
		 tableRow2= findViewById(R.id.table2);
		 tableRow3= findViewById(R.id.table3);
		 tableRow4= findViewById(R.id.table4);
		 tableRow5= findViewById(R.id.table5);
		 tableRow6= findViewById(R.id.table6);
		 tableRow7= findViewById(R.id.table7);
		 tableRow8= findViewById(R.id.table8);
		 tableRow9= findViewById(R.id.table9);
		 tableRow10= findViewById(R.id.table10);

		entrieTableViewSen = findViewById(R.id.mainTableSenators);
		entrieTableViewSen.setShrinkAllColumns(true);

		tableRow1Sen= findViewById(R.id.table1Sen);
		tableRow2Sen= findViewById(R.id.table2Sen);
		tableRow3Sen= findViewById(R.id.table3Sen);
		tableRow4Sen= findViewById(R.id.table4Sen);
		}

	protected void onStart()
	{
		super.onStart();

		buttons = new Button[jsonFileScannedIn.size()];
		int democratReps=0;
		int republicanReps=0;
		int otherReps=0;

		int democratSen=0;
		int republicanSen=0;
		int otherSen=0;

		for(int createButtons =0; createButtons<jsonFileScannedIn.size()-100;createButtons++)
		{

			int currentTerm = jsonFileScannedIn.get(createButtons).senAndRepterms.size() -1;

			if(jsonFileScannedIn.get(createButtons).senAndRepterms.get(currentTerm).type.equals("rep"))
			{
				Button myNewButton = new Button(this);

				//Democrat
				if(jsonFileScannedIn.get(createButtons).senAndRepterms.get(currentTerm).party.equals("Democrat"))
				{
					myNewButton.setBackgroundResource(R.drawable.roundbuttonblue);
					democratReps++;
				}

				//Republican
				else if(jsonFileScannedIn.get(createButtons).senAndRepterms.get(currentTerm).party.equals("Republican"))
				{
					myNewButton.setBackgroundResource(R.drawable.roundbuttonred);
					republicanReps++;
				}

				//Other
				else
				{
					myNewButton.setBackgroundResource(R.drawable.roundbuttonyellow);
					otherReps++;
				}

				myNewButton.setVisibility(View.VISIBLE);
				buttons[createButtons] = myNewButton;

				totalReps = democratReps+republicanReps+otherReps;

				if((totalReps+1)%10 == 1)
				{
					tableRow1.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 2)
				{
					tableRow2.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 3)
				{
					tableRow3.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 4)
				{
					tableRow4.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 5)
				{
					tableRow5.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 6)
				{
					tableRow6.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 7)
				{
					tableRow7.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 8)
				{
					tableRow8.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 9)
				{
					tableRow9.addView(myNewButton);
				}
				else if((totalReps+1)%10 == 0)
				{
					tableRow10.addView(myNewButton);
				}
			}

			//Senator
			else
			{
				Button myNewButton = new Button(this);

				//Democrat
				if(jsonFileScannedIn.get(createButtons).senAndRepterms.get(currentTerm).party.equals("Democrat"))
				{
					myNewButton.setBackgroundResource(R.drawable.roundbuttonblue);
					democratSen++;
				}

				//Republican
				else if(jsonFileScannedIn.get(createButtons).senAndRepterms.get(currentTerm).party.equals("Republican"))
				{
					myNewButton.setBackgroundResource(R.drawable.roundbuttonred);
					republicanSen++;
				}

				//Other
				else
				{
					myNewButton.setBackgroundResource(R.drawable.roundbuttonyellow);
					otherSen++;
				}

				myNewButton.setVisibility(View.VISIBLE);
				buttons[createButtons] = myNewButton;

				totalSen = democratSen+republicanSen+otherSen;

				if((totalSen+1)%4 == 1)
				{
					tableRow1Sen.addView(myNewButton);
				}
				else if((totalSen+1)%4 == 2)
				{
					tableRow2Sen.addView(myNewButton);
				}
				else if((totalSen+1)%4 == 3)
				{
					tableRow3Sen.addView(myNewButton);
				}
				else if((totalSen+1)%4 == 0) {
					tableRow4Sen.addView(myNewButton);
				}
			}
		}
	}
}
