package pro.jamesegger.americanbureaucracy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class executiveRelated extends AppCompatActivity
{

    ImageView executiveLogo;


    @Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.executive);
        executiveLogo = findViewById(R.id.whLogo);

    }

	protected void onStart()
	{
		super.onStart();

        executiveLogo.setVisibility(View.VISIBLE);
	}


}
