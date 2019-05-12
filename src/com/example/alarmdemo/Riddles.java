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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Riddles extends Activity implements OnClickListener,OnCheckedChangeListener {

	
	SharedPreferences sharedpreferences;
	SharedPreferences.Editor editor;
	public static final String MY_PREFS_NAME = "MyPrefs" ;
	MediaPlayer ring;
	Button stop;
	RadioGroup func;
	RadioButton answer1;
	RadioButton answer2;
	RadioButton answer3;
	TextView question;
	TextView wrong;
	int solution=0;
	int r;
	String qu[]={"What is greater than God,more evil than the devil,the poor have it,the rich need it,and if you eat it, you'll die?",
			"If you look at the number on my face you won't find thirteen anyplace.",
			"Tear one off and scratch my head what was red is black instead",
			"The eight of us go forth not back to protect our king from a foes attack",
			"What room can no one enter?","What is it that's always coming but never arrives? ",
			"What can travel around the world while staying in a corner?","What gets wetter and wetter the more it dries?",
			"If you have me, you want to share me. If you share me, you haven't got me. What am I?",
			"What gets broken without being held?","Feed me and I live, yet give me a drink and I die",
			};
	String ans[][]={{"Nothing","hungry","happiness"},
			{"clock","sea","nothing"},
			{"ballon","A matchstick","game"},{"knight","rook","pawns"},
			{"wooden room","mushroom","steel room"}
			,{"tomorrow","bike","car"},{"stamp","light","darkness"},{"fruit","towel","water"}
			,{"terrorist","nothing","secret"},{"promise","glass","plastic"}
			,{"rat","cat","fire"}};
	int sol[]={1,1,2,3,2,1,1,2,3,1,3};
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        	WindowManager.LayoutParams.FLAG_FULLSCREEN);
	  
		setContentView(R.layout.riddles);
	    init();
        start(); 
	    func.setOnCheckedChangeListener(this);
        stop.setOnClickListener(this);
        
	}


	private void start() {
		// TODO Auto-generated method stub
		r=(int) ((Math.random()*100)%11);
		question.setText(qu[r]);
		question.setVisibility(0);
        answer1.setText(ans[r][0]);
        answer2.setText(ans[r][1]);
        answer3.setText(ans[r][2]);
    }


	private void init() {
		// TODO Auto-generated method stub
	stop=(Button)findViewById(R.id.rStopAlarm);
	func=(RadioGroup)findViewById(R.id.rgRiddles);
	question=(TextView)findViewById(R.id.questionRiddle);
	answer1=(RadioButton)findViewById(R.id.rans1);
	answer2=(RadioButton)findViewById(R.id.rans2);
	answer3=(RadioButton)findViewById(R.id.rans3);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.rStopAlarm:
			
			if(sol[r]==solution)
			{
			Toast.makeText(Riddles.this,"Correct answer",Toast.LENGTH_LONG).show();
		        
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
				Toast.makeText(Riddles.this,"wrong answer",Toast.LENGTH_LONG).show();
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
	case R.id.rans1:
		solution=1;
		break;
	case R.id.rans2:
		solution=2;
		break;
	case R.id.rans3:
		solution=3;
		break;
	}
	
	}
	
	

}
