package com.example.alarmdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Puzzle extends Activity implements OnClickListener,OnCheckedChangeListener {

	
	SharedPreferences sharedpreferences;
	SharedPreferences.Editor editor;
	public static final String MY_PREFS_NAME = "MyPrefs" ;
	Button stop;
	RadioGroup func;
	RadioButton answer1;
	RadioButton answer2;
	RadioButton answer3;
	ImageView image;
	TextView question;
	int solution=0;
	int r;
	String ans[][]={{"1,2,3,4","4,5,6,9","4,5,3,2"},
			{"4,5,2,3,6,9","1,2,3,4,5,6,7,9","4,7,8,9"},
			{"1,4,5,6,9","1,2,3,6,9","1,2,5,6,9"},{"4,5,6,9","4,7,8,9","4,1,2,3,6,9"},
			{"4,7,8,9","4,5,6,9","4,1,2,3,6,9"}
			,{"4,5,2,3,6,9","4,5,6,9","4,7,8,9"},{"4,5,6,9","4,7,8,9","4,7,8,5,6,9"},
			{"1,2,3,6,9","1,2,5,8,9","1,4,7,8,9"}
			,{"7,8,9","7,4,1,2,5,6,9","7,4,5,6,9"},{"7,4,1,2,3,6,9","7,8,9","7,4,5,6,9"}
			,{"4,7,8,5,6,9","4,7,8,9","4,5,6,9"},{"1,2,3,6,9","1,4,5,6,9","1,2,5,6,9"}};
	int sol[]={2,1,1,3,2,1,3,2,2,1,1,3};
	String imageId[]={"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11","p12"};
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        	WindowManager.LayoutParams.FLAG_FULLSCREEN);
	  
		setContentView(R.layout.puzzle);
	    init();
        start(); 
	    Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }

        
        func.setOnCheckedChangeListener(this);
        
        stop.setOnClickListener(this);
        
	}


	private void start() {
		// TODO Auto-generated method stub
		r=(int) ((Math.random()*100)%12);
		answer1.setText(ans[r][0]);
        answer2.setText(ans[r][1]);
        answer3.setText(ans[r][2]);
    
        int id = getResources().getIdentifier(imageId[r],"drawable", getPackageName() );
        image.setImageResource(id);
	    image.setVisibility(View.VISIBLE);	
	}
	


	private void init() {
		// TODO Auto-generated method stub
	stop=(Button)findViewById(R.id.pStopAlarm);
	func=(RadioGroup)findViewById(R.id.pAnswers);
	answer1=(RadioButton)findViewById(R.id.pAnswer1);
	answer2=(RadioButton)findViewById(R.id.pAnswer2);
	answer3=(RadioButton)findViewById(R.id.pAnswer3);
	image=(ImageView)findViewById(R.id.pImageView);
	question=(TextView)findViewById(R.id.pQuestion);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.pStopAlarm:
			
			if(sol[r]==solution)
			{
				Toast.makeText(Puzzle.this,"CORRECT ANSWER",Toast.LENGTH_LONG).show();
		        
			new AlarmReceiver().rel();
			Intent startMain = new Intent(Intent.ACTION_MAIN);
			startMain.addCategory(Intent.CATEGORY_HOME);
			startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(startMain);
			finish();
			break;
			}
			else
			{
				Toast.makeText(Puzzle.this,"wrong answer",Toast.LENGTH_LONG).show();
		        answer1.setChecked(false);
		        answer2.setChecked(false);
		        answer3.setChecked(false);
		        start();
			}
		}
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
	switch(checkedId)
	{
	case R.id.pAnswer1:
		solution=1;
		break;
	case R.id.pAnswer2:
		solution=2;
		break;
	case R.id.pAnswer3:
		solution=3;
		break;
	}
	
	}
	
	

}
