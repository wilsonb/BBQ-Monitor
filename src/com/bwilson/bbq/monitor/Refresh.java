package com.bwilson.bbq.monitor;

import java.util.Date;
import java.text.DateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;



import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;

//import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Refresh {
//public class Refresh extends AsyncTask<String,String,String>{
	private ProgressDialog pDialog;
	String probe0;
	String probe1;
	String probe2;
	String probe3;
	String name0;
	String name1;
	String name2;
	String name3;
	String setvalue;
	String time;
	JSONArray temp1 = null;
	JSONObject settemp = null;
	// ArrayList<HashMap<String, String>> temps = new ArrayList<HashMap<String, String>>();
	// Creating JSON Parser instance
	JSONParser jParser = new JSONParser();
	
	// url to make request
   	private static final String url = "http://192.168.1.113/luci/lm/hmstatus";
   	// JSON: {"time":1345306402,"set":220,"lid":0,"fan":{"c":85,"a":64},"temps":[{"n":"Pit","c":78.3},{"n":"Food 1","c":null},{"n":"Food 2","c":null},{"n":"Ambient","c":72.2}]}
   	// JSON Node names
   	private static final String TEMPERATURES = "temps";
   	private static final String TAG_NAME = "n";
   	private static final String TAG_VALUE = "c";
   	private static final String SET_VALUE = "set";
   	private static final String TIME = "time";
	
//	protected void onPreExecute() {
//		super.onPreExecute();
//		pDialog = new ProgressDialog(Refresh.this);
//		pDialog.setMessage("Loading Data ...");
//		pDialog.setIndeterminate(false);
//		pDialog.setCancelable(false);
//		pDialog.show();
//	
//	
//	
//	
//	
//	}

	
    //-----------------	Pull Heatermeter Data ------------------
	public String doInBackground(String... args) {

	// getting JSON string from URL
	JSONObject json = jParser.getJSONFromUrl(url);
		try {
			setvalue = json.getString(SET_VALUE);
			time = json.getString(TIME);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	try {
	    // Getting Array of Contacts
	    temp1 = json.getJSONArray(TEMPERATURES);
	    
	    
	 
	    // looping through All Contacts
//  	    for(int i = 0; i < 1; i++){   // i< temp1.length()
	        JSONObject a = temp1.getJSONObject(0);
	        name0 = a.getString(TAG_NAME);
	        probe0 = a.getString(TAG_VALUE);
	        JSONObject b = temp1.getJSONObject(1);
	        name1 = b.getString(TAG_NAME);
	        probe1 = b.getString(TAG_VALUE);
	        JSONObject c = temp1.getJSONObject(2);
	        name2 = c.getString(TAG_NAME);
	        probe2 = c.getString(TAG_VALUE);
	        JSONObject d = temp1.getJSONObject(3);
	        name3 = d.getString(TAG_NAME);
	        probe3 = d.getString(TAG_VALUE);                    	 
	//    }
	} catch (JSONException e) {
	    e.printStackTrace();
	}

	return null;
	}{

//	protected void onPostExecute(String file_url) {
//		pDialog.dismiss();
//		runOnUiThread(new Runnable(){
//			public void run(){
//				
//			}
//		});
	
//	
////	--------------------	Print Data to Layout --------------------
//    
//        if(probe0 == "null"){
//        	probe0 = "off";}
//		if(probe1 == "null"){
//        	probe1 = "off";}
//		if(probe2 == "null"){
//        	probe2 = "off";}
//		if(probe3 == "null"){
//    	probe3 = "off";}
//    //---------------	Code to pull date and time ------------ 
//	String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
//    TextView t = (TextView)findViewById(R.id.time);
// // t is the TextView view that should display it
//    t.setText(currentDateTimeString);
////---------------	End Date and Time Code ----------------
//    TextView u = (TextView)findViewById(R.id.name0);
//    u.setText(name0);
//    TextView v = (TextView)findViewById(R.id.name1);
//    v.setText(name1);
//    TextView w = (TextView)findViewById(R.id.name2);
//    w.setText(name2);
//    TextView x = (TextView)findViewById(R.id.name3);
//    x.setText(name3);
//    TextView a = (TextView)findViewById(R.id.probe0);
//    a.setText(probe0);
//    TextView b = (TextView)findViewById(R.id.probe1);
//    b.setText(probe1);
//    TextView c = (TextView)findViewById(R.id.probe2);
//    c.setText(probe2);
//    TextView d = (TextView)findViewById(R.id.probe3);
//    d.setText(probe3);
//    TextView e = (TextView)findViewById(R.id.setpoint);
//    e.setText(setvalue);
//    TextView f = (TextView)findViewById(R.id.debug);
//    f.setText(time);
    
}
}
