package pro.jamesegger.americanbureaucracy.legislative;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import pro.jamesegger.americanbureaucracy.R;

public class congressMemberVotes extends AppCompatActivity {

	private RecyclerView congressVotesRecycler;
	private LinearLayoutManager mLayoutManager;
	private adapterForBillDisplay mAdapter;
	private List<billHolderClass> congressMemberVotes = new ArrayList<billHolderClass>();
	String bioIdForCongressman;
	boolean personOfInterestFound = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legislation);

		congressVotesRecycler = findViewById(R.id.voteDataCongress);


		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		congressVotesRecycler.setHasFixedSize(true);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		congressVotesRecycler.setLayoutManager(mLayoutManager);

		//Replace all my custon json code with moshi?
		localFileReadingJSON(this);
		Bundle newExtras = getIntent().getExtras();


		bioIdForCongressman = newExtras.getString("BioId", "ERROR");

		localFileReadingJSON(this);

		Log.e("votes COunted: ", "" + congressMemberVotes.size());
		//Will display vote history.

		if (congressMemberVotes.size() > 0) {
			mAdapter = new adapterForBillDisplay(this, congressMemberVotes);
			congressVotesRecycler.setAdapter(mAdapter);

		}

	}


	public void localFileReadingJSON(Context myContext)
	{

		try {
			InputStream input = myContext.getAssets().open("congressVotes.json");
			readJsonStream(input);

		} catch (Exception e) {
			Log.e("appDebug", "Error has occured: " + e);
		}


	}


	public void readJsonStream(InputStream in) throws IOException
	{
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		try {
			readMessagesArray(reader);
		} finally {
			reader.close();
		}
	}

	public void readMessagesArray(JsonReader reader) throws IOException
	{
		personOfInterestFound = false;


		reader.beginArray();

		while (reader.hasNext()) {

			if(!personOfInterestFound) {
				readMessage(reader);
			}
			else {
				reader.skipValue();
			}

		}

		reader.endArray();


	}

	public void readMessage(JsonReader reader) throws IOException
	{

		if (!personOfInterestFound) {
			String billType = "Error";
			String billNumber = "Error";
			String billCongress = "Error";
			String voteOnBill = "Error";
			String BioID = "Error";

			reader.beginObject();

			while (reader.hasNext()) {
				String currentName = reader.nextName();

				if (currentName.equals("BioId")) {
					BioID = reader.nextString();

					if (BioID.equals(bioIdForCongressman)) {
						//Exit out.
						personOfInterestFound=true;
						break;

					} else if(!personOfInterestFound) {
						//Reset data stored.
						congressMemberVotes.clear();
					}
				} else if (currentName.equals("Votes")) {
					reader.beginArray();

					while (reader.hasNext()) {
						reader.beginObject();

						currentName = reader.nextName();

						if (currentName.equals("Vote")) {
							voteOnBill = reader.nextString();
						}

						currentName = reader.nextName();


						if (currentName.equals("Bill")) {
							reader.beginObject();

							while (reader.hasNext()) {
								currentName = reader.nextName();

								if (currentName.equals("type")) {
									billType = reader.nextString();
								} else if (currentName.equals("number")) {
									billNumber = reader.nextString();
								} else if (currentName.equals("congress")) {
									billCongress = reader.nextString();
								}
							}

							reader.endObject();
						}

						reader.endObject();

						if(!personOfInterestFound)
						{
							billHolderClass billVote = new billHolderClass(voteOnBill, billType, billNumber, billCongress);

							congressMemberVotes.add(billVote);
						}
					}
					reader.endArray();
				}

			}
			reader.endObject();

		}
	}
}

