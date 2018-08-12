package pro.jamesegger.americanbureaucracy;

import android.content.Context;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class localFileReading
{
	public List<MyModel> localFileReadingJSON(Context myContext)
	{

		/*
		InputStream newGITdownload = new InputStream() {
			@Override
			public int read() throws IOException
			{
				return 0;
			}
		};


		try
		{
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			newGITdownload = new URL("https://theunitedstates.io/congress-legislators/legislators-current.json").openStream();
		}

		catch (MalformedURLException e)
		{
			//
		}
		catch (IOException e)
		{
			//
		}

*/
		try
		{
			InputStream input = myContext.getAssets().open("legislators-current.json");
/*
			boolean isTwoEqual = IOUtils.contentEquals(input, newGITdownload);

			Log.e("are files equal", " "+isTwoEqual);

			if (isTwoEqual)
			{
				return (readJsonStream(input));
			}

			else
			{
				return (readJsonStream(newGITdownload));
			}
			*/
			return (readJsonStream(input));
		}

		catch (Exception e)
		{
			Log.e("appDebug", "Error has occured: " + e);
			return null;
		}


	}




	public List<MyModel> readJsonStream(InputStream in) throws IOException
	{
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		try
		{
			return readMessagesArray(reader);
		}

		finally
		{
			reader.close();
		}
	}

	public List<MyModel> readMessagesArray(JsonReader reader) throws IOException
	{
		List<MyModel> messages = new ArrayList<MyModel>();

		reader.beginArray();

		while (reader.hasNext())
		{
			messages.add(readMessage(reader));
		}

		reader.endArray();


		return messages;
	}

	public MyModel readMessage(JsonReader reader) throws IOException
	{
		 nameStorage name = new nameStorage("First", "Last" , "FullName");
		 bioStorage bio=new bioStorage("Birthday","Gender", "Religion");
		idStorage idFromStorage = new idStorage("VoterSmartID", "WikipediaID", "WikiDataID");
		List<termStorage> termsForRepAndSen = new ArrayList<termStorage>();


		reader.beginObject();

		while (reader.hasNext())
		{
			String aname = reader.nextName();


			if(aname.equals("name") || aname.equals("bio") || aname.equals("id"))
			{

				if (aname.equals("name")) {
					name = readName(reader);
				} else if (aname.equals("bio")) {
					bio = readBio(reader);
				}
				else if (aname.equals("id")) {
					idFromStorage = readId(reader);
				}
			}

			else if(aname.equals("terms"))
			{

				if(reader.peek() == JsonToken.BEGIN_ARRAY)
				{
					reader.beginArray();

					while (reader.hasNext())
					{
						termsForRepAndSen.add(readTerms(reader));
					}
					reader.endArray();
				}

				else
				{
					reader.skipValue();
				}
			}

			else if(aname.equals("leadership_roles"))
			{
				reader.skipValue();
			}

			else
			{
				reader.skipValue();
			}
		}

		reader.endObject();

		return new MyModel(name,idFromStorage, bio, termsForRepAndSen);
	}

	public idStorage readId(JsonReader reader) throws IOException
	{
		String voteSmart = null;
		String wikipedia = null;
		String wikiData = null;

		reader.beginObject();

		while (reader.hasNext()) {

			String name = reader.nextName();

			if (name.equals("votesmart")) {
				voteSmart = reader.nextString();
			}
			else if (name.equals("wikipedia")) {
				wikipedia = reader.nextString();
			}
			else if(name.equals("wikidata"))
			{
				wikiData = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}

		reader.endObject();

		return new idStorage(voteSmart, wikipedia, wikiData);
	}

	public nameStorage readName(JsonReader reader) throws IOException
	{
		String first = null;
		String last = null;
		String full = null;

		reader.beginObject();

		while (reader.hasNext()) {

			String name = reader.nextName();

			if (name.equals("first")) {
				first = reader.nextString();
			}
			else if (name.equals("last")) {
				last = reader.nextString();
			}
			else if(name.equals("official_full"))
			{
				full = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}

		reader.endObject();

		return new nameStorage(first, last, full);
	}

	public bioStorage readBio(JsonReader reader) throws IOException
	{
		String birthday=null;
		String gender=null;
		String religion=null;

		reader.beginObject();

		while (reader.hasNext())
		{

				String name = reader.nextName();

				if (name.equals("birthday")) {
					birthday = reader.nextString();
				} else if (name.equals("gender")) {
					gender = reader.nextString();
				} else if (name.equals("religion")) {
					religion = reader.nextString();
				} else {
					reader.skipValue();
				}

		}

		reader.endObject();

		return new bioStorage(birthday,gender,religion);
	}

	public termStorage readTerms(JsonReader reader) throws IOException
	{

		String state=null;
		String party=null;
		String type=null;

		reader.beginObject();

		while (reader.hasNext())
		{
				String name = reader.nextName();

				if (name.equals("state")) {
					state = reader.nextString();
				} else if (name.equals("party")) {
					party = reader.nextString();
				} else if (name.equals("type")) {
					type = reader.nextString();
				}
				else{
					reader.skipValue();
				}

		}

		reader.endObject();

		return new termStorage(state,party,type);
	}

}
