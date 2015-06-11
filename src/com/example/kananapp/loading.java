package com.example.kananapp;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;



public class loading extends Activity{

	private Typeface tf;
	ProgressBar pgr ; 
	int progress=0 ;
	Handler h = new Handler() ;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.loading);
			//String fontPath = "fonts/JLTR.ttf";
			TextView lod = (TextView)findViewById(R.id.textView1) ;


			Typeface tf = Typeface.createFromAsset(getAssets(),
			        "GE.Thameen.Book.otf");
			lod.setTypeface(tf);	
			
			
			
			
			
			 //tf = Typeface.createFromAsset(getAssets(), fontPath);
			//  lod.setTypeface(tf);
			pgr = (ProgressBar)findViewById(R.id.progressBar1);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
			for(int i=0 ; i<100 ; i++) {
				progress+=1;
				
				h.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						pgr.setProgress(progress);
						if(progress==pgr.getMax()) {
	                    Intent i = new Intent(loading.this, langchoice.class);
	                    startActivity(i);
	                    finish();
						}
					
					}
				});
				try{
					
					Thread.sleep(70);
					
				}catch (InterruptedException e) {
					
					
				}
			}
					
					
					
				}
			}).start();
			
			
			
			
			
		}
	}
