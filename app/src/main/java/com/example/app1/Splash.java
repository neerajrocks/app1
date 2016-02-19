package com.example.app1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Splash extends Activity {
	MediaPlayer song;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		song=MediaPlayer.create(Splash.this,R.raw.f);
		song.start();
	    Thread t1=new Thread()
	    {
	    	public void run()
	    	{
	    		try
	    		{
	    			sleep(3000);
	    		}
	    		catch(Exception e)
	    		{
	    			
	    		}
	    		finally
	    		{
					Intent obj = new Intent(Splash.this,MainActivity.class);
					startActivity(obj);
	    		}
	    	}
	    };
	    t1.start();
	
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
	
	

	
}
