package com.example.kananapp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.ListFragment;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class videourlnew extends ListFragment{

	private ProgressDialog pDialog;

	// URL to get contacts JSON
		private static String url = "http://kanaan.ps/webapi/SiteVideo?SiteID=2&langID=1";

		// JSON Node names
		private static final String TAG_CONTACTS = "oResult";
		private static final String TAG_NAME = "FileName";

	ListView lv ;
	
	


	// contacts JSONArray
	JSONArray contacts = null;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	View view = inflater.inflate(R.layout.test, container ,false);
	
	contactList = new ArrayList<HashMap<String, String>>();

	
	new GetContacts().execute();

	return view;


		// Calling async task to get json
	}



@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	 lv = getListView();

	
	
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
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);
					
					// Getting JSON Array node
					contacts = jsonObj.getJSONArray(TAG_CONTACTS);

					// looping through All Contacts
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(i);
						
						String name = c.getString(TAG_NAME);
						String Img = c.getString(TAG_NAME);

						// Phone node is JSON Object
						

						// tmp hashmap for single contact
						HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						contact.put(TAG_NAME, name);
						contact.put("http://img.youtube.com/vi/"+TAG_NAME+"/default.jpg", Img);

						// adding contact to contact list
						contactList.add(contact);
					}
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
			/**
			 * Updating parsed JSON data into ListView
			 * */
			
			/*
			ListAdapter adapter = new SimpleAdapter(
					getActivity(), contactList,
					R.layout.list_item, new String[] { TAG_NAME, TAG_EMAIL
							 }, new int[] { R.id.name,
							R.id.email });

			setListAdapter(adapter);
			
			*/
			
			
			   
		    String[] from = {"FileName","FileName"};

	        // Ids of views in listview_layout
	       int[] to = { R.id.name , R.id.imageView1 };         
	        SimpleAdapter adapter = new SimpleAdapter(getActivity(), contactList, R.layout.listitemnew, from, to);

	        lv.setAdapter(adapter); 
	       
	        try{
	        for(int i=0;i<adapter.getCount();i++){
	        	HashMap<String, Object> hm = (HashMap<String, Object>) adapter.getItem(i);
	        	
	        	String imgUrl = (String) hm.get("FileName");
	        	ImageLoaderTaskc imageLoaderTask = new ImageLoaderTaskc();
	        //	dbConnector.Updatemeetourdoc(i+1, "fsdfsf") ;
	        HashMap<String, Object> hmDownload = new HashMap<String, Object>();
	        	//hm.clear();
	        	hm.put("FileName",imgUrl);
	        	hm.put("position", i);
	        	//Toast.makeText(getActivity(),i + imgUrl, Toast.LENGTH_LONG).show();
	        	// Starting ImageLoaderTask to download and populate image in the listview 
	        	imageLoaderTask.execute(hm);
	        	//Toast.makeText(getActivity(),i + imgUrl, Toast.LENGTH_LONG).show();
	        }}
	        catch (Exception e) {
				// TODO: handle exception

	        	
			}
	      
			
			
		     
		}
	
			
			
		}

	

	 /** AsyncTask to download and load an image in ListView */
	    private class ImageLoaderTaskc extends AsyncTask<HashMap<String, Object>, Void, HashMap<String, Object>>{

			@Override
			protected HashMap<String, Object> doInBackground(HashMap<String, Object>... hm) {
				
				InputStream iStream=null;
				String imgUrl = (String) hm[0].get("FileName");
				int position = (Integer) hm[0].get("position");
				
				URL url;
			
				try {
					
					url = new URL(imgUrl);
					
					// Creating an http connection to communicate with url
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

		            // Connecting to url	            
		            urlConnection.connect();

		            // Reading data from url 
		            iStream = urlConnection.getInputStream();
		            
		            // Getting Caching directory 
		            File cacheDirectory = getActivity().getCacheDir();
		            
		            // Temporary file to store the downloaded image 
		            File tmpFile = new File(cacheDirectory.getPath() + "/wpta_"+position+".png");
		            
		          //  tmpFile.getParentFile().mkdirs();
		            // The FileOutputStream to the temporary file
		            FileOutputStream fOutStream = new FileOutputStream(tmpFile);
		            
		            // Creating a bitmap from the downloaded inputstream
		            Bitmap b = BitmapFactory.decodeStream(iStream);	            
		            
		            // Writing the bitmap to the temporary file as png file
		            b.compress(Bitmap.CompressFormat.PNG,100, fOutStream);	            
		            
		            // Flush the FileOutputStream
		            fOutStream.flush();
		            
		            //Close the FileOutputStream
		            fOutStream.close();	            
		            
		            // Create a hashmap object to store image path and its position in the listview
		            HashMap<String, Object> hmBitmap = new HashMap<String, Object>();
		            
		            // Storing the path to the temporary image file
		         hmBitmap.put("FileName",tmpFile.getPath());
		            
		            // Storing the position of the image in the listview
		        hmBitmap.put("position",position);	            
		            
		            // Returning the HashMap object containing the image path and position
		            return hmBitmap;	            
		            

				}catch (Exception e) {				
					e.printStackTrace();
				}
				
				
				return null;
			}
			
			@Override
			protected void onPostExecute(HashMap<String, Object> result) {
				// Getting the path to the downloaded image
				if (result !=null){
				String path = (String) result.get("FileName");			
				//String npath = (String) result.get("");			

				// Getting the position of the downloaded image
				int position = (Integer) result.get("position");
				try{
					
				
				// Getting adapter of the listview
		      SimpleAdapter adapter = (SimpleAdapter ) lv.getAdapter();
				
				// Getting the hashmap object at the specified position of the listview
				HashMap<String, Object> hm = (HashMap<String, Object>) adapter.getItem(position);	
				
				// Overwriting the existing path in the adapter 
			//Toast.makeText(getActivity(), path, Toast.LENGTH_LONG).show();	
				
			hm.put("FileName",path);
				///hm.put("flag",npath);

				// Noticing listview about the dataset changes
				adapter.notifyDataSetChanged();	
				}
			catch(Exception e) {
				
				
			}
				
				
			}
				
			
			
			else {
				
				//Toast.makeText(getActivity(), "result null", Toast.LENGTH_LONG).show();
				
			}
	    }}
	    
	    
	    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        bitmap.compress(CompressFormat.PNG, 0, outputStream);       
	        return outputStream.toByteArray();
	    }    
	   

}

