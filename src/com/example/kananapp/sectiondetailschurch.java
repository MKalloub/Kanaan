package com.example.kananapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sectiondetailschurch extends Fragment{
	
	
	private ProgressDialog pDialog;

	// URL to get contacts JSON
	//private static String url = "http://kanaan.ps/webapi/Articles?ArticleID="+7+"&langID=1";

	// JSON Node names
	private static final String TAG_About = "oResult";
	private static final String TAG_ID = "ID";
	private static final String TAG_TITLE = "Title";
	private static final String TAG_TEXT = "Details";
	
	// contacts JSONArray
String tex ;
	TextView gtext ;
	
	JSONArray contacts = null;
	String ii = "";
	Button img  , vid , det;

	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.sectiondetailschu, container, false);
	

		
		return view ;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		TextView title = (TextView)getView().findViewById(R.id.textView1)	;
		
		img =(Button)getView().findViewById(R.id.button1)	;
		vid =(Button)getView().findViewById(R.id.button2)	;
		det =(Button)getView().findViewById(R.id.button3)	;

		
		gtext = (TextView)getView().findViewById(R.id.textView2)	;
		
		
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
		        "GE.Thameen.Book.otf");
				
		img.setTypeface(tf);
		vid.setTypeface(tf);
		gtext.setTypeface(tf);
		title.setTypeface(tf);
		det.setTypeface(tf);
det.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Fragment newFragmentapp = new details();
		FragmentTransaction transactionapp = getFragmentManager().beginTransaction();
		//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
		// Replace whatever is in the fragment_container view with this fragment,
		transactionapp.replace(R.id.content_frame, newFragmentapp);
		transactionapp.addToBackStack(null);

		// Commit the transaction
		transactionapp.commit();	
		
		
		
		
	}
}) ;

		

		String ti = getArguments().getString("Name"); 
		 ii = getArguments().getString("Idd"); 
//Toast.makeText(getActivity(), ii, Toast.LENGTH_LONG).show();
		title.setText(ti) ;
		new GetContacts().execute();

		
		
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
				Bundle bundle = new Bundle();

				bundle.putString("Idd", ii);

				Fragment newFragmentapp = new imagegallerydet();
				FragmentTransaction transactionapp = getFragmentManager().beginTransaction();
				//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack
				
				newFragmentapp.setArguments(bundle);

				
				transactionapp.replace(R.id.content_frame, newFragmentapp);
				transactionapp.addToBackStack(null);

				// Commit the transaction
				transactionapp.commit();		
						
				
				
				
			}
		});	
		
		 vid.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			
					
					Fragment newFragmentapp = new videogallerydet();
					FragmentTransaction transactionapp = getFragmentManager().beginTransaction();
					//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
					// Replace whatever is in the fragment_container view with this fragment,
					// and add the transaction to the back stack
					transactionapp.replace(R.id.content_frame, newFragmentapp);
					transactionapp.addToBackStack(null);

					// Commit the transaction
					transactionapp.commit();		
							
					
					
					
				}
			});	
				
		
	}
	
	/**
	 * Async task class to get json by making HTTP call
	 * */
	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall("http://kanaan.ps/webapi/Articles?ArticleID="+ii+"&langID=1", ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);
			
			
			
			

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr).getJSONObject("oResult");

					// Getting JSON Array node
					//appointments = jsonObj.getJSONArray(TAG_APPOINTMENT);

					// looping through All Contacts
					//
					
				//	JSONObject contactss = jsonObj.getJSONObject("oResult");
					String text = jsonObj.getString(TAG_TEXT);
					tex = text ;
					// looping through All Contacts
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			if (pDialog.isShowing())
				pDialog.dismiss();
			//Toast.makeText(getActivity(), ti + "" +tex, Toast.LENGTH_LONG).show() ;
			gtext.setText(tex);
			
			/**
			 * Updating parsed JSON data into ListView
			 * */
		}	

	}
	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }  

	
	   

}
