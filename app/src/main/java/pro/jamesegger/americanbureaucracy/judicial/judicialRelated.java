package pro.jamesegger.americanbureaucracy.judicial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import pro.jamesegger.americanbureaucracy.R;

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

		String url = "https://en.wikipedia.org/w/api.php?format=json&action=parse&section=5&page=Cabinet_of_the_United_States";

		// Instantiate the RequestQueue.
		RequestQueue queue = Volley.newRequestQueue(this);

		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
				(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						// Display the first 500 characters of the response string.
						//textTestDisplay.setText("Response is: "+ response.toString());
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						//textTestDisplay.setText("That didn't work!");
					}
				});

// Add the request to the RequestQueue.
		queue.add(jsonObjectRequest);
	}
}
