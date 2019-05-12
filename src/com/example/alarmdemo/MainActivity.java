package com.example.alarmdemo;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,OnCheckedChangeListener{
    
	AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private CheckBox checkBox1;
    private static MainActivity inst;
    private TextView alarmText;
    private Button set;
    RadioGroup functionality;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static String func=null;
    static int ind=-1;
    SharedPreferences.Editor editor;
    static int index=0;
    public final String fu[]={"Puzzle","ImageCount","ColorChecking","Riddles"};
    public static MainActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmTimePicker=(TimePicker)findViewById(R.id.timePicker1);
        set=(Button)findViewById(R.id.set_alarm);
        functionality=(RadioGroup)findViewById(R.id.functionality);
     sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        functionality.setOnCheckedChangeListener(this);
        set.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void setAlarmText(String s)
    {
    	alarmText.setText(s);
    	alarmText.setVisibility(0);
    }

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId) 
		{
		case R.id.puzzle:
		
			index=0;
			break;
			
		case R.id.image_count:
			index=1;
	        break;
		case R.id.color_checking:
			index=2;
	        break;
		case R.id.riddle:
			index=3;
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		Log.d("MyActivity", "Alarm On");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
        String s=alarmTimePicker.getCurrentHour()+" : "+alarmTimePicker.getCurrentMinute();
       // Bundle basket=new Bundle();
        //basket.putString("time",s);
        Intent i=new Intent(MainActivity.this,Show.class);
        //i.putExtra("time",s);
        //i.putExtras(basket);
        Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
        
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    //    startActivityForResult(i,0);	
        ind++;
        editor.putString("time", s);
        editor.putInt("index", index);
        editor.putString("function",fu[index]);
        
        editor.commit();
        Toast.makeText(MainActivity.this,"alarm added",Toast.LENGTH_LONG).show();
        startActivity(i);
        
	}

	public void goAlert() {
		// TODO Auto-generated method stub
		Class ourClass;
		try {
			ourClass = Class.forName("com.example.alarmdemo."+fu[index]);
			Intent in=new Intent(MainActivity.this,ourClass);
			startActivity(in);
			finish();
	     
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
