package pro.jamesegger.americanbureaucracy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class adapterForjsonParsing extends RecyclerView.Adapter<adapterForjsonParsing.ViewHolder>
{
	    private List<MyModel> dataSetRecieved = new ArrayList<MyModel>();


		public static class ViewHolder extends RecyclerView.ViewHolder
		{
			// each data item is just a string in this case
			//public TextView nameTextView;
			public Button messageButton;

			public ViewHolder(View v)
			{
				super(v);

				//nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
				messageButton = (Button) itemView.findViewById(R.id.message_button);
			}
		}

		// Provide a suitable constructor (depends on the kind of dataset)
		public adapterForjsonParsing(List<MyModel> myDataset)
		{
			dataSetRecieved = myDataset;
		}

		// Create new views (invoked by the layout manager)
		@Override
		public adapterForjsonParsing.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
		{

			// create a new view
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.senatorandrepresentativelayout, parent, false);

			ViewHolder vh = new ViewHolder(v);
			return vh;
		}

		// Replace the contents of a view (invoked by the layout manager)
		@Override
		public void onBindViewHolder(adapterForjsonParsing.ViewHolder holder, int position)
		{
			final String firstName = dataSetRecieved.get(position).first;
			final String lastName = dataSetRecieved.get(position).last;

			Button legislatorButton = holder.messageButton;
			legislatorButton.setText(firstName +" "+lastName);

			legislatorButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					launchActivityForLegislator newListenerLeg = new launchActivityForLegislator();
					newListenerLeg.launchActivityForLegislator(firstName,lastName);
				}
			});

			if(dataSetRecieved.get(position).senAndRepterms.get(dataSetRecieved.get(position).senAndRepterms.size()-1).party.equals("Democrat"))
			{
				legislatorButton.setBackgroundColor(Color.argb(100,0,0,255));
			}

			else if(dataSetRecieved.get(position).senAndRepterms.get(dataSetRecieved.get(position).senAndRepterms.size()-1).party.equals("Republican"))
			{
				legislatorButton.setBackgroundColor(Color.argb(100,255,0,0));
			}

			else
			{
				legislatorButton.setBackgroundColor(Color.argb(100,255,255,0));
			}

		}

		// Return the size of your dataset (invoked by the layout manager)
		@Override
		public int getItemCount()
		{
			return dataSetRecieved.size();
		}
}

class launchActivityForLegislator extends AppCompatActivity
{
	void launchActivityForLegislator(String firstName, String lastName)
	{
		Intent houseRepView = new Intent(launchActivityForLegislator.this, legislatordetailsclass.class);
		houseRepView.putExtra("FirstName",firstName);
		houseRepView.putExtra("LastName", lastName);
		launchActivityForLegislator.this.startActivity(houseRepView);
	}

}
