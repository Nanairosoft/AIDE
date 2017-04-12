package com.nanairosoft.android.nanairotter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
	implements NavigationView.OnNavigationItemSelectedListener {

	static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		if (!TwitterUtils.hasAccessToken(this)) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
		
		// Toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		// DrawerToggle
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		
		// NavigationView Listener
		NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
		navigationView.setNavigationItemSelectedListener(this);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.action_settings:
				Log.d(TAG, "Settings Selected!");
				break;
		}
		return true;
	}
	
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menu_item1:
				Log.d(TAG, "Item 1 Selected!");
				break;
			case R.id.menu_item2:
				Log.d(TAG, "Item 2 Selected!");
				break;
			case R.id.menu_item3:
				Log.d(TAG, "Item 3 Selected!");
				break;
			case R.id.menu_item4:
				Log.d(TAG, "Item 4 Selected!");
				break;
		}
		
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
