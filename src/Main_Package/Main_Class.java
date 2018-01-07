package Main_Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

public class Main_Class
{
	public static void main(String[] args) throws ClientProtocolException, IOException
	{
		
		String api_Key = "hackerrank|334220-126|dc4d3eebdb8b8168b5d4b36a01859dad87dc62ca"; //Registered api_key of client
		String url = "http://api.hackerrank.com/checker/submission.json";  //URL of hackerrank API service
		String lang = "5";  //Language Code. For example "5" for Python 2, "1" for C. Defined by Hackerrank.
		String source = "print 'The name of our country is Bangladesh.'"; //Source code of corresponding language. Here our language is Python 2 and it's code is "5"
		ArrayList<String> test = new ArrayList<String>(); //To make testcases in JSON(Javascript object notation) format.
		test.add("The name of our country is Bangladesh");
		String testcases = new JSONArray(test).toString(); //String test turns into JSON format String testcases
		
		ArrayList<NameValuePair> arguments = new ArrayList<NameValuePair>(); //To add arguments of HTTP POST request parameters.
		
		//Lets add the arguments. These four arguments are must. Extra arguments can be added
		
		arguments.add(new BasicNameValuePair("source", source));
		arguments.add(new BasicNameValuePair("lang", lang));
		arguments.add(new BasicNameValuePair("testcases", testcases));
		arguments.add(new BasicNameValuePair("api_key", api_Key));
		
		//Lets create a HTTP connection and make a HTTP post request with required arguments.
		
		HttpClient client = HttpClientBuilder.create().build();  // Create a HTTP client
		HttpPost httppost = new HttpPost(url);  // HTTP POST to Hackerrank API
		httppost.setEntity(new UrlEncodedFormEntity(arguments)); //arguments are added to POST request.
		HttpResponse httpresponse = client.execute(httppost); //HTTP response containing compilation & execution result sent by Hackerrank API. Default format is JSON format.

		//Lets retrieve message of the response as String(JSON format). 
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(httpresponse.getEntity().getContent()));
		StringBuffer response = new StringBuffer();
		String line = "";
		while ((line = BR.readLine()) != null)
		{
			response.append(line);
		}
		BR.close();
		System.out.println(response);
	}
}
