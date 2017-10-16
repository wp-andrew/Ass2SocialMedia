package web.app.eng.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class RestPost {
	
	@SuppressWarnings("resource")
	public List<String> ExtractBullyingKeywords(String text) throws ClientProtocolException, IOException
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://d2dcrc.cse.unsw.edu.au:9091/ExtractionAPI-0.0.1-SNAPSHOT/rest/keyword");
		List<NameValuePair> listParameter = new ArrayList<>();
		listParameter.add(new BasicNameValuePair("sentence", text));
		httpPost.setEntity(new UrlEncodedFormEntity(listParameter));
		
		HttpResponse response = httpClient.execute(httpPost);
		if(response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Fail: Http Error Code: " + response.getStatusLine().getStatusCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String line, lines = "";
		while ((line = br.readLine()) != null) {
			lines += line;
		}
		int beginIndex = lines.indexOf("keyword") + 10;
		int endIndex = beginIndex + lines.substring(beginIndex).indexOf('"') - 1;
		
		httpClient.getConnectionManager().shutdown();
		
		String[] keywords = lines.substring(beginIndex, endIndex).split(",");
		
		File file = new File(getClass().getResource("bullying.txt").getPath());
		String content = new Scanner(file).useDelimiter("\\Z").next();
		String[] bullyingKeywords = content.split(", ");
		
		List<String> detectedKeywords = new ArrayList<String>();
		for (String keyword : keywords) {
			for (String bullyingKeyword : bullyingKeywords) {
				if (keyword.length() == bullyingKeyword.length() && keyword.toLowerCase().equals(bullyingKeyword)) {
					detectedKeywords.add(keyword);
					break;
				}
			}
		}
		
		return detectedKeywords;
	}
	
}
