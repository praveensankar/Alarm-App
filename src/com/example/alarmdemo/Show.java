package com.example.alarmdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.DigitalClock;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Show extends Activity{

	Bundle getTime;
	String time;
	String form="null";
	String MY_PREFS_NAME="MyPrefs";
	int ind=0;
	String fun="puzzle";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); 
		  String time = prefs.getString("time", "No name defined");//"No name defined" is the default value.
		  String fun=prefs.getString("function","");
		 LinearLayout mainLayout =(LinearLayout)findViewById(R.id.scroll_layout);
		  ind=prefs.getInt("index", 0);
		   TextView ti=(TextView)findViewById(R.id.alarm_time);
		   TextView func=(TextView)findViewById(R.id.function);
		   ToggleButton tb=(ToggleButton)findViewById(R.id.tg1);
		   ti.setText(time);
		   func.setText(fun);
		   tb.setChecked(true);
		   ti.setVisibility(0);
		   func.setVisibility(0);
		   tb.setVisibility(View.INVISIBLE);
		   //mainLayout.addView(ti);
		   //mainLayout.addView(func);
		   //mainLayout.addView(tb);
		   //sv.addView(mainLayout);
		   //dc.setText(time);
	}
}
