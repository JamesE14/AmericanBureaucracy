package pro.jamesegger.americanbureaucracy.legislative;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pro.jamesegger.americanbureaucracy.R;

public class adapterForBillDisplay extends RecyclerView.Adapter<adapterForBillDisplay.ViewHolder>
{
	private List<billHolderClass> dataSetRecieved = new ArrayList<billHolderClass>();
	private Context context;


	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		// each data item is just a string in this case
		//public TextView nameTextView;
		public Button messageButton;

		public ViewHolder(View v)
		{
			super(v);

			messageButton = (Button) itemView.findViewById(R.id.message_button);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public adapterForBillDisplay(Context context,List<billHolderClass> myDataset)
	{
		dataSetRecieved = myDataset;
		this.context = context;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public adapterForBillDisplay.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{

		// create a new view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.senatorandrepresentativelayout, parent, false);

		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(adapterForBillDisplay.ViewHolder holder, final int position)
	{
		final String billInfo = dataSetRecieved.get(position).theType +" "+ dataSetRecieved.get(position).voteOnBill;

		Button legislatorButton = holder.messageButton;
		legislatorButton.setText(billInfo);


		legislatorButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Intent intent = new Intent(context, legislatordetailsclass.class);
				//intent.putExtra("FullName", billInfo);
				//context.startActivity(intent);
			}
		});

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount()
	{
		return dataSetRecieved.size();
	}

}

