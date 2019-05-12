package com.example.alarmdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class AlarmAlert extends Activity implements OnClickListener{

	SharedPreferences sharedpreferences;
	SharedPreferences.Editor editor;
	public static final String MY_PREFS_NAME = "MyPrefs" ;
	MediaPlayer ring;
	Button stop;
	public final String fu[]={"Puzzle","ImageCount","ColorChecking","Riddles"};
    int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sharedpreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); 
    	index=sharedpreferences.getInt("index",3);
		Class ourClass;
		try {
			ourClass = Class.forName("com.example.alarmdemo."+fu[index]);
			Intent in=new Intent(AlarmAlert.this,ourClass);
			
			startActivity(in);
			finish();
	     
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	}
}
