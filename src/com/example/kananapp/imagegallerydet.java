package com.example.kananapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class imagegallerydet extends Fragment {
	
	private ProgressDialog pDialog;
	GridView grd ;
	Bitmap bitmap;
String ii ;
	// URL to get contacts JSON
//private static String url = "http://kanaan.ps/webapi/getArticlesMedia?ArticleID=7&langID=1&Type=1";
	

AlertDialog.Builder builder ;
AlertDialog dialog ; 

	// JSON Node names
	private static final String TAG_OFFERS = "oResult";
	private static final String TAG_IMAGE = "Img";
	private static final String TAG_TITLE = "Image_Title";

		// contacts JSONArray
		JSONArray offers = null;

		// Hashmap for ListView
		ArrayList<HashMap<String, String>> offerList;

	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		setHasOptionsMenu(true);

		
		
		
	View view = inflater.inflate(R.layout.imagegallery, container, false);
	
	grd = (GridView)view.findViewById(R.id.category_items_gridView);
	ii = getArguments().getString("Idd"); 
	// Toast.makeText(getActivity(), ii, Toast.LENGTH_LONG).show();
//ii="7" ;
	offerList = new ArrayList<HashMap<String, String>>();


	new GetContacts().execute();
	//new LoadImage().execute(headerurl);

	
	grd.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			String im = ((TextView) view.findViewById(R.id.textView1))
					.getText().toString();


			String tit = ((TextView) view.findViewById(R.id.textView2))
					.getText().toString();
			Bundle bundle = new Bundle();

			bundle.putString("Image", im);
			bundle.putString("Title", tit);
			Fragment newFragment = new imgdetail();

			newFragment.setArguments(bundle);

			FragmentTransaction transaction = getFragmentManager().beginTransaction();


			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			//transaction.setCustomAnimations(R.anim.slide_left, R.anim.slide_right);

			transaction.replace(R.id.content_frame, newFragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();						

	
		
		
		}
	});
	
	
	/*
	adver.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Bundle bundle = new Bundle();


			bundle.putString("urllink", advlink);

			newFragment.setArguments(bundle);

			FragmentTransaction transaction = getFragmentManager().beginTransaction();


			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			//transaction.setCustomAnimations(R.anim.slide_left, R.anim.slide_right);

			transaction.replace(R.id.content_frame, newFragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();				

			
			
			
		}
	}) ;
	
	*/
	
		return view ;
	}

	
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
			String jsonStr = sh.makeServiceCall("http://kanaan.ps/webapi/getArticlesMedia?ArticleID="+ii+"&langID=1&Type=1", ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);
			
	            


			if (jsonStr != null) {
				try {
					
					//JSONArray contacts = new JSONArray(result);
					JSONObject jsonObj = new JSONObject(jsonStr);

					// Getting JSON Array node
				offers = jsonObj.getJSONArray(TAG_OFFERS);
	

					// looping through All Contacts
					
					
					for (int i = 0; i < offers.length(); i++) {
						JSONObject c = offers.getJSONObject(i);
						
						String image = c.getString(TAG_IMAGE);
						String title = c.getString(TAG_TITLE);
						
						// Phone node is JSON Object
						

						// tmp hashmap for single contact
						HashMap<String, String> offer = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						offer.put(TAG_IMAGE,image);
						offer.put(TAG_TITLE,title);
						// adding contact to contact list
						offerList.add(offer);
					
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
			
			pDialog.dismiss() ;
			 
			String[] from = {"Img","Img" , "Image_Title"};
        //Toast.makeText(getActivity(), headerurl, Toast.LENGTH_LONG).show();
       //  new LoadImage().execute(headerurl);
       //  new LoadImagea().execute(advurl);

	        // Ids of views in listview_layout
         int[] to = {R.id.imageView1, R.id.textView1 , R.id.textView2};       
	        SimpleAdapter adapter = new SimpleAdapter(getActivity(), offerList, R.layout.griditem, from, to);

	        
	        grd.setAdapter(adapter); 
	    
	        for(int i=0;i<adapter.getCount();i++){
	        	HashMap<String, Object> hm = (HashMap<String, Object>) adapter.getItem(i);
	        	
	        	String imgUrl = (String) hm.get("Img");
	        	ImageLoaderTask imageLoaderTask = new ImageLoaderTask();
	        	
	        HashMap<String, Object> hmDownload = new HashMap<String, Object>();
	        	//hm.clear();
	        	hm.put("Img",imgUrl);
	        	hm.put("position", i);
	        	//Toast.makeText(getActivity(),i + imgUrl, Toast.LENGTH_LONG).show();
	        	// Starting ImageLoaderTask to download and populate image in the listview 
	        	imageLoaderTask.execute(hm);	
			
				pDialog.dismiss() ;

			
			
			
	        }}

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

	 

	 /** AsyncTask to download and load an image in ListView */
	    private class ImageLoaderTask extends AsyncTask<HashMap<String, Object>, Void, HashMap<String, Object>>{

			@Override
			protected HashMap<String, Object> doInBackground(HashMap<String, Object>... hm) {
				
				InputStream iStream=null;
				String imgUrl = (String) hm[0].get("Img");
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
		         hmBitmap.put("Img",tmpFile.getPath());
		            
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
				String path = (String) result.get("Img");			
				//String npath = (String) result.get("");			

				// Getting the position of the downloaded image
				int position = (Integer) result.get("position");
				try{
					
				
				// Getting adapter of the listview
		      SimpleAdapter adapter = (SimpleAdapter ) grd.getAdapter();
				
				// Getting the hashmap object at the specified position of the listview
				HashMap<String, Object> hm = (HashMap<String, Object>) adapter.getItem(position);	
				
				// Overwriting the existing path in the adapter 
			//Toast.makeText(getActivity(), path, Toast.LENGTH_LONG).show();	
				
			hm.put("Img",path);
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
	  
	   
	      
}
