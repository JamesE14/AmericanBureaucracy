package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.List;

public class legislativeRelated extends AppCompatActivity
{
	List<MyModel> jsonFileScannedIn;
	ImageView legislativeLogo;

	TableLayout entireTableView;
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

	Button buttons[];

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legislative);

		localFileReading readSomePolitics = new localFileReading();
		jsonFileScannedIn =readSomePolitics.localFileReadingJSON(this);

		legislativeLogo = findViewById(R.id.legLogo);

		entireTableView = findViewById(R.id.mainTable);
		entireTableView.setShrinkAllColumns(true);

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

	}

	protected void onStart()
	{
		super.onStart();
		legislativeLogo.setVisibility(View.VISIBLE);

		buttons = new Button[jsonFileScannedIn.size()];
		int nextLegislatorIteration=0;

		for(int createButtons =0; createButtons<jsonFileScannedIn.size()-100;createButtons++)
		{
			Button myNewButton = new Button(this);

			//Log.e("sen or rep")
			if(jsonFileScannedIn.get(createButtons).senAndRepterms.get(0).type.equals("rep")) {
				myNewButton.setBackgroundResource(R.drawable.roundbuttonred);
			}

			else {
				myNewButton.setBackgroundResource(R.drawable.roundbuttonblue);
			}

			myNewButton.setVisibility(View.VISIBLE);
			buttons[createButtons] = myNewButton;

			if((createButtons+1)%10 == 1)
			{
				tableRow1.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 2)
			{
				tableRow2.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 3)
			{
				tableRow3.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 4)
			{
				tableRow4.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 5)
			{
				tableRow5.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 6)
			{
				tableRow6.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 7)
			{
				tableRow7.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 8)
			{
				tableRow8.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 9)
			{
				tableRow9.addView(myNewButton);
			}
			else if((createButtons+1)%10 == 0)
			{
				tableRow10.addView(myNewButton);
			}

		}

	}


}
