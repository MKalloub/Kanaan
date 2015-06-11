package com.example.kananapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class bouthilaionen  extends Fragment{
	
	private ProgressDialog pDialog;

	// URL to get contacts JSON
	private static String url = "http://kanaan.ps/webapi/StaticPages?PageID=2&langID=2";

	// JSON Node names
		private static final String TAG_CONTACTS = "oResult";
		private static final String TAG_ID = "ID";
		private static final String TAG_NAME = "Title";
		private static final String TAG_DETAILS = "Details";
		String tex ;
		TextView gtext ;
		


	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	View view = inflater.inflate(R.layout.about_hilarionen, container, false);

	gtext = (TextView)view.findViewById(R.id.textView1);

	Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
	        "Calibri_Bold.ttf");
			
	gtext.setTypeface(tf);
	
	
	new GetContacts().execute();

		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
	Button map = (Button) getView().findViewById(R.id.button2) ;	
	Button in = (Button) getView().findViewById(R.id.button3) ;	
	Button pano = (Button) getView().findViewById(R.id.button5) ;	
	Button img = (Button) getView().findViewById(R.id.button4) ;	
	Button vid = (Button) getView().findViewById(R.id.button1) ;	
	
	
	Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
	        "GE.Thameen.Book.otf");
			
	pano.setTypeface(tf);
	
	
	vid.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent vv = new Intent(getActivity() , youtubeapieng.class) ;
			startActivity(vv) ;
			
			
/*
			Fragment newFragmentapp = new videourlnew();
			FragmentTransaction transactionapp = getFragmentManager().beginTransaction();
			//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transactionapp.replace(R.id.content_frame, newFragmentapp);
			transactionapp.addToBackStack(null);

			// Commit the transaction
			transactionapp.commit();		
				
			*/
			
		}
	});
	
	
	
	
	
	

img.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			

			Fragment newFragmentapp = new imagegallery();
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
	
	
	
	
	map.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			

			Fragment newFragmentapp = new mapsmain();
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
	
	
in.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			

			Fragment newFragmentapp = new indooren();
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
		
pano.setOnClickListener(new OnClickListener() {
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
Intent cc = new Intent(getActivity() , panorama.class) ;
		startActivity(cc) ;
		
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
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);
			
			
			
			

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);

					// Getting JSON Array node
					//appointments = jsonObj.getJSONArray(TAG_APPOINTMENT);

					// looping through All Contacts
					//
					JSONObject re = jsonObj.getJSONObject(TAG_CONTACTS);

						
						String id = re.getString(TAG_ID);
						String text = re.getString(TAG_DETAILS);

						tex = text ;

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
