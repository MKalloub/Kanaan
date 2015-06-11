package com.example.kananapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class postions extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.postions, container, false);
		((MainActivity) getActivity())
        .setActionBarTitlee(R.drawable.icon);	
      
		
		return view ;
	}
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		  ImageView loc =(ImageView) getView().findViewById(R.id.imageView1)	;	
	        
	        
	        loc.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					

					Fragment newFragmentapp = new abouthilaion();
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
	

}
