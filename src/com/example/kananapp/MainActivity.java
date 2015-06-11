package com.example.kananapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem("الرئيسية", R.drawable.home));
		dataList.add(new DrawerItem("مواقع أثرية", R.drawable.locations));
		dataList.add(new DrawerItem("عن كنعان", R.drawable.about));
		dataList.add(new DrawerItem("فريق العمل", R.drawable.team));
		dataList.add(new DrawerItem("اتصل بنا", R.drawable.contactus));
		dataList.add(new DrawerItem("English", R.drawable.settingicon));


		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		ColorDrawable colorDrawable = new ColorDrawable();

		android.app.ActionBar actionBar = getActionBar();
		colorDrawable.setColor(0xff533628);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setBackgroundDrawable(colorDrawable);
		

		
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			SelectItem(0);
		}

	}

	
	public void SelectItem(int possition) {

		Bundle args = new Bundle();
		switch (possition) {
		case 0:
			Fragment newFragmentaone = new PlaceholderFragmentt();
			FragmentTransaction transactionappo = getFragmentManager().beginTransaction();
			//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transactionappo.replace(R.id.content_frame, newFragmentaone);
			transactionappo.addToBackStack(null);

			// Commit the transaction
			transactionappo.commit();	
			break;
		case 1:

				Fragment newFragmentapp = new postions();
				FragmentTransaction transactionapp = getFragmentManager().beginTransaction();
				//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack
				transactionapp.replace(R.id.content_frame, newFragmentapp);
				transactionapp.addToBackStack(null);

				// Commit the transaction
				transactionapp.commit();	
			
			//getActionBar().setTitle("Appointments");
			
			
			
			
			break;
		case 2:
			
			
				Fragment newFragmentmy = new about();
				FragmentTransaction transactionmy = getFragmentManager().beginTransaction();
				//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack
				transactionmy.replace(R.id.content_frame, newFragmentmy);
				transactionmy.addToBackStack(null);

				// Commit the transaction
				transactionmy.commit();	
				
			
			
			
			break;
		case 3:
			
	
			Fragment newFragments = new contactus();
			FragmentTransaction transactions = getFragmentManager().beginTransaction();
			//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transactions.replace(R.id.content_frame, newFragments);
			transactions.addToBackStack(null);

			// Commit the transaction
			transactions.commit();	
		
			
			break;
		case 4:
			
			Fragment newFragment = new contactemail();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			//transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transaction.replace(R.id.content_frame, newFragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();	
			
		
			
			break;
		
case 5:
			
			Intent vv = new Intent (MainActivity.this , MainActivityeng.class) ;
			startActivity(vv) ;
			finish() ;
		
			
			break;	
			
			
			
		default:
			break;
		}

		

		mDrawerList.setItemChecked(possition, true);
		//setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	
	

	

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SelectItem(position);

		}
	}

	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	      getMenuInflater().inflate(R.menu.main, menu);
	      return super.onCreateOptionsMenu(menu);
	    }
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Pass the event to ActionBarDrawerToggle, if it returns
	        // true, then it has handled the app icon touch event
	        if (mDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	        }
	        // Handle your other action bar items...
	        
	        return super.onOptionsItemSelected(item);
	    }

	 
	    public void setActionBarTitle(String title) {
	        getSupportActionBar().setTitle(title);
	    }
	    
	    
	    public void setActionBarTitlee(int yocclickar) {
		      //  getSupportActionBar().setTitle(yocclickar);
		        getSupportActionBar().setIcon(yocclickar);

		    }  
  
	    
	    
	    
	    
	    
	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event)  {
	        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	            if( this.getFragmentManager().getBackStackEntryCount() != 0 ){
	                this.getFragmentManager().popBackStack();
	                return true;
	            }
	            // If there are no fragments on stack perform the original back button event
	        }

	        return super.onKeyDown(keyCode, event);
	    }
	    
		}
	

