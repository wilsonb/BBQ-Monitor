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



public class MainActivity extends SherlockActivity {
//	private ProgressDialog pDialog;
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
	Refresh getData = new Refresh();
//	JSONArray temp1 = null;
//	JSONObject settemp = null;
//	// ArrayList<HashMap<String, String>> temps = new ArrayList<HashMap<String, String>>();
//	// Creating JSON Parser instance
//	JSONParser jParser = new JSONParser();
//	
//	// url to make request
//   	private static final String url = "http://192.168.1.113/luci/lm/hmstatus";
//   	// JSON: {"time":1345306402,"set":220,"lid":0,"fan":{"c":85,"a":64},"temps":[{"n":"Pit","c":78.3},{"n":"Food 1","c":null},{"n":"Food 2","c":null},{"n":"Ambient","c":72.2}]}
//   	// JSON Node names
//   	private static final String TEMPERATURES = "temps";
//   	private static final String TAG_NAME = "n";
//   	private static final String TAG_VALUE = "c";
//   	private static final String SET_VALUE = "set";
//   	private static final String TIME = "time";

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // View main layout activity   
        setContentView(R.layout.activity_main);
        //new RefreshScreen().execute();
        getData.doInBackground(time);
        TextView f = (TextView)findViewById(R.id.debug);
        f.setText(time);
        

    }
// This creates the menu popup when the menu button is pressed
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.settings_action_provider, menu);
        
        return true;
    }
// This defines what the menu does when each item is clicked    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
//    	switch (item.getItemId()) {
//    	case R.id.menu_settings:
//    		//Action when settings is clicked
//    		//c.setText("Settings");
//    		openSettings();
//    		return true;
//    	case R.id.menu_refresh:
//    		//Action when refresh is clicked
//    		//c.setText("Refresh");
//    		new RefreshScreen().execute();
//			
//    		return true;
//    	}
    	getData.doInBackground(time);
      TextView f = (TextView)findViewById(R.id.debug);
      f.setText(time);

    	return(super.onOptionsItemSelected(item));   	
    }
    
    public static class SettingsActionProvider extends ActionProvider {

        /** An intent for launching the system settings. */
        private static final Intent sSettingsIntent = new Intent(Settings.ACTION_SETTINGS);

        /** Context for accessing resources. */
        private final Context mContext;

        /**
         * Creates a new instance.
         *
         * @param context Context for accessing resources.
         */
        public SettingsActionProvider(Context context) {
            super(context);
            mContext = context;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public View onCreateActionView() {
            // Inflate the action view to be shown on the action bar.
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.settings_action_provider, null);
            ImageButton button = (ImageButton) view.findViewById(R.id.button);
            // Attach a click listener for launching the system settings.
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(sSettingsIntent);
                }
            });
            return view;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onPerformDefaultAction() {
            // This is called if the host menu item placed in the overflow menu of the
            // action bar is clicked and the host activity did not handle the click.
            mContext.startActivity(sSettingsIntent);
            return true;
        }
    }    

    public void openSettings() {
    	Intent i = new Intent(MainActivity.this,SettingsActivity.class);
    	startActivity(i);
    }
}
    
//    private class RefreshScreen extends AsyncTask<String,String,String>{
//
//    	protected void onPreExecute() {
//    		super.onPreExecute();
//    		pDialog = new ProgressDialog(MainActivity.this);
//    		pDialog.setMessage("Loading Data ...");
//    		pDialog.setIndeterminate(false);
//    		pDialog.setCancelable(false);
//    		pDialog.show();
//    	
//    	
//    	
//    	
//    	
//    	}
//
//    	
//        //-----------------	Pull Heatermeter Data ------------------
//    	protected String doInBackground(String... args) {
//
//    	// getting JSON string from URL
//    	JSONObject json = jParser.getJSONFromUrl(url);
//    		try {
//				setvalue = json.getString(SET_VALUE);
//				time = json.getString(TIME);
//			} catch (JSONException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//    	try {
//    	    // Getting Array of Contacts
//    	    temp1 = json.getJSONArray(TEMPERATURES);
//    	    
//    	    
//    	 
//    	    // looping through All Contacts
//  //  	    for(int i = 0; i < 1; i++){   // i< temp1.length()
//    	        JSONObject a = temp1.getJSONObject(0);
//    	        name0 = a.getString(TAG_NAME);
//    	        probe0 = a.getString(TAG_VALUE);
//    	        JSONObject b = temp1.getJSONObject(1);
//    	        name1 = b.getString(TAG_NAME);
//    	        probe1 = b.getString(TAG_VALUE);
//    	        JSONObject c = temp1.getJSONObject(2);
//    	        name2 = c.getString(TAG_NAME);
//    	        probe2 = c.getString(TAG_VALUE);
//    	        JSONObject d = temp1.getJSONObject(3);
//    	        name3 = d.getString(TAG_NAME);
//    	        probe3 = d.getString(TAG_VALUE);                    	 
//    	//    }
//    	} catch (JSONException e) {
//    	    e.printStackTrace();
//    	}
//
//    	return null;
//    	}
//    	protected void onPostExecute(String file_url) {
//    		pDialog.dismiss();
//    		runOnUiThread(new Runnable(){
//    			public void run(){
//    				
//    			}
//    		});
//    	
//    
    //	--------------------	Print Data to Layout --------------------
//        
//            if(probe0 == "null"){
//            	probe0 = "off";}
//    		if(probe1 == "null"){
//            	probe1 = "off";}
//    		if(probe2 == "null"){
//            	probe2 = "off";}
//    		if(probe3 == "null"){
//        	probe3 = "off";}
//        //---------------	Code to pull date and time ------------ 
//    	String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
//        TextView t = (TextView)findViewById(R.id.time);
//     // t is the TextView view that should display it
//        t.setText(currentDateTimeString);
//    //---------------	End Date and Time Code ----------------
//        TextView u = (TextView)findViewById(R.id.name0);
//        u.setText(name0);
//        TextView v = (TextView)findViewById(R.id.name1);
//        v.setText(name1);
//        TextView w = (TextView)findViewById(R.id.name2);
//        w.setText(name2);
//        TextView x = (TextView)findViewById(R.id.name3);
//        x.setText(name3);
//        TextView a = (TextView)findViewById(R.id.probe0);
//        a.setText(probe0);
//        TextView b = (TextView)findViewById(R.id.probe1);
//        b.setText(probe1);
//        TextView c = (TextView)findViewById(R.id.probe2);
//        c.setText(probe2);
//        TextView d = (TextView)findViewById(R.id.probe3);
//        d.setText(probe3);
//        TextView e = (TextView)findViewById(R.id.setpoint);
//        e.setText(setvalue);
//        TextView f = (TextView)findViewById(R.id.debug);
//        f.setText(time);
//        
//    }
//}


    



