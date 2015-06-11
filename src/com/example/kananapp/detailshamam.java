package com.example.kananapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class detailshamam extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		
		View view = inflater.inflate(R.layout.hamam, container, false);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		
	TextView a = (TextView) getView().findViewById(R.id.textView1)	;
	TextView b = (TextView) getView().findViewById(R.id.textView2)	;
	TextView c = (TextView) getView().findViewById(R.id.textView3)	;
	TextView d = (TextView) getView().findViewById(R.id.textView4)	;
	TextView e = (TextView) getView().findViewById(R.id.textView5)	;
	TextView f = (TextView) getView().findViewById(R.id.textView6)	;
	
	Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
	        "GE.Thameen.Book.otf");
	a.setTypeface(tf);	
	b.setTypeface(tf);	
	c.setTypeface(tf);	
	d.setTypeface(tf);		
	e.setTypeface(tf);		
	f.setTypeface(tf);		

	
	
	
	
	a.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Bundle bundle = new Bundle();

			bundle.putString("Name", "»—ﬂ…  Ã„Ì⁄ «·„Ì«Â");
			bundle.putString("Idd", "31");

			
			
			
			Fragment newFragmentapp = new sectiondetails();
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

b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Bundle bundle = new Bundle();

			bundle.putString("Name", "«·€—›… «·»«—œ… «·›‰«¡");
			bundle.putString("Idd", "32");

			
			
			
			Fragment newFragmentapp = new sectiondetails();
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

	
	
	
c.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Bundle bundle = new Bundle();

		bundle.putString("Name", "€—›… «· –«ﬂ—");
		bundle.putString("Idd", "33");

		
		
		
		Fragment newFragmentapp = new sectiondetails();
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

		
d.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Bundle bundle = new Bundle();

		bundle.putString("Name", "«·€—› «·”«Œ‰… ··Õ„«„ «·Ã‰Ê»Ì");
		bundle.putString("Idd", "25");

		
		
		
		Fragment newFragmentapp = new sectiondetails();
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
	
e.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Bundle bundle = new Bundle();

		bundle.putString("Name", "«·€—›… «·Ê”ÿ");
		bundle.putString("Idd", "28");

		
		
		
		Fragment newFragmentapp = new sectiondetails();
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
f.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Bundle bundle = new Bundle();

		bundle.putString("Name", "œÊ—«  „Ì«Â Ã«—Ì…");
		bundle.putString("Idd", "30");

		
		
		
		Fragment newFragmentapp = new sectiondetails();
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
	
	}
	
	
	
	

}
