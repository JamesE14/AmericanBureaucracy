package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class judicialRelated extends AppCompatActivity
{
   // ImageView judicialLogo;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.judicial);

		//judicialLogo = findViewById(R.id.judLogo);
	}

	protected void onStart()
	{
		super.onStart();
		//judicialLogo.setVisibility(View.VISIBLE);
	}
}
