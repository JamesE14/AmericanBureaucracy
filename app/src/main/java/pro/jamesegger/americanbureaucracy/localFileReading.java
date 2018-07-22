package pro.jamesegger.americanbureaucracy;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import org.yaml.snakeyaml.Yaml;


public class localFileReading
{
	public localFileReading(Context myContext)
	{

			testLoadFromStream(myContext);


	}


	public void testLoadFromStream(Context myContext)
	{
		try {
		InputStream input = myContext.getAssets().open("legislatorscurrent.yaml");
		Yaml yaml = new Yaml();
		ArrayList newList = yaml.load(input);

			//Map newmap = (Map) data;

			//Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(input);

			//System.out.println(module_name);
			//System.out.println(module_name.get(0).get("First"));
			//System.out.println(module_name.get(1).get("Last"));

			
			Log.e("app","values: "+newList.get(1).);
		//
		//data = yaml.load(new ByteArrayInputStream("name".getBytes()));
		//assertEquals("test2", data);
		}

		catch (Exception e)
		{
			Log.e("app","ERROR: "+e);

		}
	}
}
