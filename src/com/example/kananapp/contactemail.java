package com.example.kananapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.app.Dialog;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class contactemail extends Fragment {
	
	private static String urlc = "http://kanaan.ps/webapi/contactUs";

	EditText name , ttext , email ; 
	Button send ;
	String pname ,ptext , pemail = "" ;
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.contactemail, container, false);
		
		((MainActivity) getActivity())
        .setActionBarTitlee(R.drawable.icon);	
		
		return view ;
	}
	
	
	

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		name = (EditText)getView().findViewById(R.id.editText1) ;
		ttext = (EditText)getView().findViewById(R.id.editText3) ;
		email = (EditText)getView().findViewById(R.id.editText2) ;

		send = (Button) getView().findViewById(R.id.button1) ;
		
		
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
		        "GE.Thameen.Book.otf");
				
		name.setTypeface(tf);
		ttext.setTypeface(tf);		
		email.setTypeface(tf);		
		send.setTypeface(tf);		

		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
			pname = name.getText().toString() ; 
			ptext = ttext.getText().toString() ;
			pemail = email.getText().toString() ;	
			
		if (pname.equals("")|| ptext.equals("") ||pemail.equals("") ) { 
			
			final Dialog dialog = new Dialog(getActivity());
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

			dialog.setContentView(R.layout.customdialogealertar);


			TextView text = (TextView) dialog.findViewById(R.id.text);
			TextView textt = (TextView) dialog.findViewById(R.id.textt);

			Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
			        "GE.Thameen.Book.otf");
			text.setTypeface(tf);		
			textt.setTypeface(tf);
			
			text.setText("هناك حقول فارغة.");
 
			Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
			// if button is clicked, close the custom dialog
			
			dialogButton.setTypeface(tf);

			
			
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
 
			dialog.show();
			 
			
		}
			
			
		else { 

			new GetContacts().execute();
			final Dialog dialog = new Dialog(getActivity());
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

			dialog.setContentView(R.layout.customdialogesuar);


			TextView text = (TextView) dialog.findViewById(R.id.text);
			TextView textt = (TextView) dialog.findViewById(R.id.textt);

			Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
			        "GE.Thameen.Book.otf");
			text.setTypeface(tf);		
			textt.setTypeface(tf);
			
			text.setText("تم ارسالة الرسالة بنجاح ، شكراً لك");
 
			Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
			// if button is clicked, close the custom dialog
			
			dialogButton.setTypeface(tf);

			
			
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
 
			dialog.show();
			
		}
			
		
				
				
			}
		}) ;
		
	}
	

		private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			
			/*
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();
*/
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			 InputStream inputStream = null;
		        String result = "";	

	            // 1. create HttpClient
	            HttpClient httpclient = new DefaultHttpClient();
	 
	            // 2. make POST request to the given URL
	            HttpPost httpPost = new HttpPost(urlc);
	 
	            String json = "";
			
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
	            nameValuePairs.add((NameValuePair) new BasicNameValuePair("Name", pname));
	            nameValuePairs.add((NameValuePair) new BasicNameValuePair("Details", ptext));
	            nameValuePairs.add((NameValuePair) new BasicNameValuePair("Email", pemail));
	            nameValuePairs.add((NameValuePair) new BasicNameValuePair("Subject", pemail));

	            try {
					httpPost.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) nameValuePairs));
					  HttpResponse response = httpclient.execute(httpPost);
				         
			            HttpResponse httpResponse = httpclient.execute(httpPost);
			 
			            // 9. receive response as inputStream
			            inputStream = httpResponse.getEntity().getContent();
			            
			               result = convertInputStreamToString(inputStream);

				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	          
		//	ServiceHandler sh = new ServiceHandler();

		//	String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + result);

			if (result != null) {
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			
			/*
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			//ArrayAdapter<String> spinnerMenu = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, compa);
		  //  comp.setAdapter(spinnerMenu);
		
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

	
	


