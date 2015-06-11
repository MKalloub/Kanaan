package com.example.kananapp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class contactus extends Fragment{

	private ProgressDialog pDialog;
	Bitmap mIcon_val;
	// URL to get contacts JSON
	private static String url = "http://kanaan.ps/webapi/getteam?LangID=1";
	Bitmap bmp;
	ListView lv ;
	URL newurl;
	URL urlr;
	TextView tit1 ,sumary1,tit2,sumary2,tit3,sumary3,tit4,sumary4;
	ImageView image2 , image3 , image4 ,image1;
	ImageView fb1 , linkin1 , twitt1 , fb2 , linkin2 , twitt2 , fb3 , linkin3 , twitt3 , fb4 , linkin4 , twitt4 ;
	
	String stit1 , ssumary1 , simag1 , sfb1,slink1,stwi1 ;
	String stit2 , ssumary2 , simag2 , sfb2,slink2,stwi2 ;
	String stit3 , ssumary3 , simag3 , sfb3,slink3,stwi3 ;
	String stit4 , ssumary4 , simag4 , sfb4,slink4,stwi4 ;
	LinearLayout full ;
	
	
	// JSON Node names
	private static final String TAG_CONTACTS = "oResult";
	private static final String TAG_ID = "ID";
	private static final String TAG_NAME = "Title";
	private static final String TAG_EMAIL = "Summary";
	private static final String TAG_ADDRESS = "FBLink";
	private static final String TAG_GENDER = "Email";
	private static final String TAG_IMAGE = "Img";
	private static final String TAG_TWI = "TWLink";
	private static final String TAG_LINK = "LNLink";


	// contacts JSONArray
	JSONArray contacts = null;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	View view = inflater.inflate(R.layout.listitemnewfull, container ,false);
	
	contactList = new ArrayList<HashMap<String, String>>();

	((MainActivity) getActivity())
    .setActionBarTitlee(R.drawable.icon);	
	new GetContacts().execute();

	return view;


		// Calling async task to get json
	}




@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onViewCreated(view, savedInstanceState);
	// lv.setItemsCanFocus(false);	

	
	 full =(LinearLayout) getView().findViewById(R.id.fill) ;
	full.setVisibility(View.GONE) ;
	
	
	 tit1 = (TextView)getView().findViewById(R.id.name) ;
     image1 = (ImageView)getView().findViewById(R.id.imageView1) ;
	 sumary1 = (TextView)getView().findViewById(R.id.email) ;
     fb1 = (ImageView) getView().findViewById(R.id.button1) ;
     linkin1 = (ImageView) getView().findViewById(R.id.button2) ;
     twitt1 = (ImageView) getView().findViewById(R.id.button3) ;
	
    
    
    
     tit2 = (TextView)getView().findViewById(R.id.name2) ;
	 image2 = (ImageView)getView().findViewById(R.id.imageView2) ;
	 sumary2 = (TextView)getView().findViewById(R.id.email2) ;
     fb2 = (ImageView) getView().findViewById(R.id.button12) ;
     linkin2 = (ImageView) getView().findViewById(R.id.button22) ;
     twitt2 = (ImageView) getView().findViewById(R.id.button32) ;
	
    
    
    
     tit3 = (TextView)getView().findViewById(R.id.name3) ;
	 image3 = (ImageView)getView().findViewById(R.id.imageView3) ;
	 sumary3 = (TextView)getView().findViewById(R.id.email3) ;
     fb3 = (ImageView) getView().findViewById(R.id.button13) ;
     linkin3 = (ImageView) getView().findViewById(R.id.button23) ;
     twitt3 = (ImageView) getView().findViewById(R.id.button33) ;
	
    
    
    
    
     tit4 = (TextView)getView().findViewById(R.id.name4) ;
	 image4 = (ImageView)getView().findViewById(R.id.imageView4) ;
	 sumary4 = (TextView)getView().findViewById(R.id.email4) ;
     fb4 = (ImageView) getView().findViewById(R.id.button14) ;
     linkin4 = (ImageView) getView().findViewById(R.id.button24) ;
     twitt4 = (ImageView) getView().findViewById(R.id.button34) ;
	
     
     Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
		        "GE.Thameen.Book.otf");
     tit1.setTypeface(tf);	
     tit2.setTypeface(tf);
     tit3.setTypeface(tf);
     tit4.setTypeface(tf);
     sumary4.setTypeface(tf);
     sumary3.setTypeface(tf);
     sumary2.setTypeface(tf);
     sumary1.setTypeface(tf);
     
     
     
     
     fb1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(sfb1)) ;
		startActivity(ff) ;
			
			
			
			
		}
	}) ;

     linkin1.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(slink1)) ;
		startActivity(ff) ;
 			
 			
 			
 		}
 	}) ;
     
     twitt1.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(stwi1)) ;
		startActivity(ff) ;
 			
 			
 			
 		}
 	}) ;
	
     
     fb2.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
 			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(sfb2)) ;
		startActivity(ff) ;	
 			
 			
 		}
 	}) ;

      linkin2.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(slink2)) ;
		startActivity(ff) ;		
  			
  			
  			
  			
  		}
  	}) ;
      
      twitt2.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
  			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(stwi2)) ;
		startActivity(ff) ;	
  			
  			
  			
  		}
  	}) ;
	
      
      fb3.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
  			
  			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(sfb3)) ;
		startActivity(ff) ;	
  			
  			
  		}
  	}) ;

       linkin3.setOnClickListener(new OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			// TODO Auto-generated method stub
   			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(slink3)) ;
		startActivity(ff) ;	
   			
   			
   		}
   	}) ;
       
       twitt3.setOnClickListener(new OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			// TODO Auto-generated method stub
   			
   			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(stwi3)) ;
		startActivity(ff) ;	
   			
   			
   		}
   	}) ;  
      
       fb4.setOnClickListener(new OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			// TODO Auto-generated method stub
   			
			
		Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(sfb4)) ;
		startActivity(ff) ;	
   			
   			
   		}
   	}) ;

        linkin4.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			
    			
    			
    			Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(slink4)) ;
    			startActivity(ff) ;
    			
    		}
    	}) ;
        
        twitt4.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			
    			
    			Intent ff = new Intent(Intent.ACTION_VIEW , Uri.parse(stwi4)) ;
    			startActivity(ff) ;	
    			
    			
    			
    		}
    	}) ;
      
      
	
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
						JSONObject c = contacts.getJSONObject(0);
						
						String id = c.getString(TAG_ID);
						 stit1 = c.getString(TAG_NAME);
						 ssumary1 = c.getString(TAG_EMAIL);
						 sfb1 = c.getString(TAG_ADDRESS);
						String email = c.getString(TAG_GENDER);
						 simag1 = c.getString(TAG_IMAGE);
						 stwi1 = c.getString(TAG_TWI);
						 slink1 = c.getString(TAG_LINK);
					}
						
					
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(1);
						
						String id = c.getString(TAG_ID);
						 stit2 = c.getString(TAG_NAME);
						 ssumary2 = c.getString(TAG_EMAIL);
						 sfb2 = c.getString(TAG_ADDRESS);
						String email = c.getString(TAG_GENDER);
						 simag2 = c.getString(TAG_IMAGE);
						 stwi2 = c.getString(TAG_TWI);
						 slink2 = c.getString(TAG_LINK);
					}
					
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(2);
						
						String id = c.getString(TAG_ID);
						 stit3 = c.getString(TAG_NAME);
						 ssumary3 = c.getString(TAG_EMAIL);
						 sfb3 = c.getString(TAG_ADDRESS);
						String email = c.getString(TAG_GENDER);
						 simag3 = c.getString(TAG_IMAGE);
						 stwi3 = c.getString(TAG_TWI);
						 slink3 = c.getString(TAG_LINK);
					}
					
					
					
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(3);
						
						String id = c.getString(TAG_ID);
						 stit4 = c.getString(TAG_NAME);
						 ssumary4 = c.getString(TAG_EMAIL);
						 sfb4 = c.getString(TAG_ADDRESS);
						String email = c.getString(TAG_GENDER);
						 simag4 = c.getString(TAG_IMAGE);
						 stwi4 = c.getString(TAG_TWI);
						 slink4 = c.getString(TAG_LINK);
					}
						
						
						// Phone node is JSON Object
						

						// tmp hashmap for single contact
						//HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						//contact.put(TAG_ID, id);
						///contact.put(TAG_NAME, name);
						//contact.put(TAG_EMAIL, sumary);
						//contact.put(TAG_IMAGE, Img);

						// adding contact to contact list
						//contactList.add(contact);
				
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
			
			
			tit1.setText(stit1) ;
			sumary1.setText(ssumary1) ;
			
			tit2.setText(stit2) ;
			sumary2.setText(ssumary2) ;
			
			tit3.setText(stit3) ;
			sumary3.setText(ssumary3) ;
			
			tit4.setText(stit4) ;
			sumary4.setText(ssumary4) ;
			
			//Bitmap bitmap = DownloadImage("http://www.kanaan.ps/Files/News/thumb/10ff14f7-5281-44d9-95bb-d7a6ab1a18e6.jpg");
			 
			//image1.setImageBitmap(bitmap);
			
			
			
			new DownloadImageTask(image1)
	        .execute(simag1);
			
			new DownloadImageTask(image2)
	        .execute(simag2);
			
			new DownloadImageTask(image3)
	        .execute(simag3);
			
			new DownloadImageTask(image4)
	        .execute(simag4);
			
			
			
			full.setVisibility(View.VISIBLE) ;
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
			
			/*
			   
		    String[] from = {"Title","Img" , "Summary"};

	        // Ids of views in listview_layout
	       int[] to = { R.id.name , R.id.imageView1 ,R.id.email };         
	        SimpleAdapter adapter = new SimpleAdapter(getActivity(), contactList, R.layout.listitemnew, from, to);
	       
	        lv.setAdapter(adapter); 
	       
	        try{
	        for(int i=0;i<adapter.getCount();i++){
	        	HashMap<String, Object> hm = (HashMap<String, Object>) adapter.getItem(i);
	        	
	        	String imgUrl = (String) hm.get("Img");
	        	ImageLoaderTaskc imageLoaderTask = new ImageLoaderTaskc();
	        //	dbConnector.Updatemeetourdoc(i+1, "fsdfsf") ;
	        HashMap<String, Object> hmDownload = new HashMap<String, Object>();
	        	//hm.clear();
	        	hm.put("Img",imgUrl);
	        	hm.put("position", i);
	        	//Toast.makeText(getActivity(),i + imgUrl, Toast.LENGTH_LONG).show();
	        	// Starting ImageLoaderTask to download and populate image in the listview 
	        	imageLoaderTask.execute(hm);
	        	//Toast.makeText(getActivity(),i + imgUrl, Toast.LENGTH_LONG).show();
	        }}
	        catch (Exception e) {
				// TODO: handle exception

	        	*/
			//}
	      
			
			
		     
		}
	
			
			
		}

	

	 /** AsyncTask to download and load an image in ListView */
	    private class ImageLoaderTaskc extends AsyncTask<HashMap<String, Object>, Void, HashMap<String, Object>>{

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
		      SimpleAdapter adapter = (SimpleAdapter ) lv.getAdapter();
				
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
	    
	    
	    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        bitmap.compress(CompressFormat.PNG, 0, outputStream);       
	        return outputStream.toByteArray();
	    }    
	   
	    private InputStream OpenHttpConnection(String urlString) throws IOException {
	        InputStream in = null;
	        int response = -1;

	        URL url = new URL(urlString);
	        URLConnection conn = url.openConnection();

	        if (!(conn instanceof HttpURLConnection))
	            throw new IOException("Not an HTTP connection");

	        try {
	            HttpURLConnection httpConn = (HttpURLConnection) conn;
	            httpConn.setAllowUserInteraction(false);
	            httpConn.setInstanceFollowRedirects(true);
	            httpConn.setRequestMethod("GET");
	            httpConn.connect();
	            response = httpConn.getResponseCode();
	            if (response == HttpURLConnection.HTTP_OK) {
	                in = httpConn.getInputStream();
	            }
	        } catch (Exception ex) {
	            throw new IOException("Error connecting");
	        }
	        return in;
	    }

	    private Bitmap DownloadImage(String URL) {
	        Bitmap bitmap = null;
	        InputStream in = null;
	        try {
	            in = OpenHttpConnection(URL);
	            bitmap = BitmapFactory.decodeStream(in);
	            in.close();
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        return bitmap;
	    } 
	    
	    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
	    	  ImageView bmImage;

	    	  public DownloadImageTask(ImageView bmImage) {
	    	      this.bmImage = bmImage;
	    	  }

	    	  protected Bitmap doInBackground(String... urls) {
	    	      String urldisplay = urls[0];
	    	      Bitmap mIcon11 = null;
	    	      try {
	    	        InputStream in = new java.net.URL(urldisplay).openStream();
	    	        mIcon11 = BitmapFactory.decodeStream(in);
	    	      } catch (Exception e) {
	    	          Log.e("Error", e.getMessage());
	    	          e.printStackTrace();
	    	      }
	    	      return mIcon11;
	    	  }

	    	  protected void onPostExecute(Bitmap result) {
	    	      bmImage.setImageBitmap(result);
	    	  }
	    	}  
	    
	    

}

