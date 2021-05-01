package nasa.exoplanets.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class JSON {

	public static JSONArray readFromURL(String URL) throws MalformedURLException, IOException {
		
		InputStream is = new URL(URL).openStream();
		
		String rawData = IOUtils.toString(is, Charset.forName("UTF-8"));
		
		is.close();
		
		return new JSONArray(rawData);
	}
	
}
