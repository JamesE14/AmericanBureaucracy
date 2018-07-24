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
		try
		{
			InputStream input = myContext.getAssets().open("legislators-current.json");
			return (readJsonStream(input));
		}

		catch(Exception e)
		{
			Log.e("appDebug", "Error has occured: "+e);
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
		 nameStorage name = new nameStorage("First", "Last");
		 bioStorage bio=new bioStorage("Birthday","Gender", "Religion");
		List<termStorage> termsForRepAndSen = new ArrayList<termStorage>();


		reader.beginObject();

		while (reader.hasNext())
		{
			String aname = reader.nextName();


			if(aname.equals("name") || aname.equals("bio"))
			{

				if (aname.equals("name")) {
					name = readName(reader);
				} else if (aname.equals("bio")) {
					bio = readBio(reader);
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

		//Log.e("Person name", name.first +" : "+name.last);


		return new MyModel(name, bio, termsForRepAndSen);
	}

	public nameStorage readName(JsonReader reader) throws IOException
	{
		String first = null;
		String last = null;

		reader.beginObject();

		while (reader.hasNext()) {

			String name = reader.nextName();

			if (name.equals("first")) {
				first = reader.nextString();
			} else if (name.equals("last")) {
				last = reader.nextString();
			} else {
				reader.skipValue();
			}
		}

		reader.endObject();

		return new nameStorage(first, last);
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
