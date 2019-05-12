package com.example.alarmdemo;

import android.app.Activity;
import android.content.Intent;
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

public class ImageCount extends Activity implements OnClickListener,OnCheckedChangeListener{

	ImageView image;
	TextView question;
	RadioGroup rans;
	RadioButton answer1;
	RadioButton answer2;
	RadioButton answer3;
	Button stop;
	int solution;
	String qu[]={"pink","red","violet","blue","black","yellow","red","green","blue","black"};
	String imageId[]={"i1","i1","i1","i1","i1","i2","i2","i2","i2","i2","i2"};
	String ans[][]={{"4","5","6"},{"3","4","5"},{"0","2","4"},{"6","9","10"},{"0","1","2"}
	,{"6","9","2"},{"7","8","2"},{"2","3","8"},{"4","8","9"},{"2","6","7"}};
	int sol[]={2,1,2,2,3,2,1,3,1,1};
	int r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        	WindowManager.LayoutParams.FLAG_FULLSCREEN);
	   setContentView(R.layout.imagecount);
		
		
		init();
        start(); 
        rans.setOnCheckedChangeListener(this);
        stop.setOnClickListener(this);
        
	}
	private void start() {
		// TODO Auto-generated method stub
		r=(int) ((Math.random()*100)%10);
		String s="No of "+qu[r]+" color objects present in the image?";
		question.setText(s);
		question.setVisibility(0);
        answer1.setText(ans[r][0]);
        answer2.setText(ans[r][1]);
        answer3.setText(ans[r][2]);
        int id = getResources().getIdentifier(imageId[r],"drawable", getPackageName() );
        image.setImageResource(id);
		
	}
	private void init() {
		
		// TODO Auto-generated method stub
		image=(ImageView)findViewById(R.id.iImageView);
		stop=(Button)findViewById(R.id.iStopAlarm);
		rans=(RadioGroup)findViewById(R.id.iAnswers);
		question=(TextView)findViewById(R.id.iQuestion);
		answer1=(RadioButton)findViewById(R.id.iAnswer1);
		answer2=(RadioButton)findViewById(R.id.iAnswer2);
		answer3=(RadioButton)findViewById(R.id.iAnswer3);

	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId)
		{
		case R.id.iAnswer1:
			solution=1;
			break;
		case R.id.iAnswer2:
			solution=2;
			break;
		case R.id.iAnswer3:
			solution=3;
			break;
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.iStopAlarm:
			
			if(sol[r]==solution)
			{
				Toast.makeText(ImageCount.this,"Correct answer",Toast.LENGTH_LONG).show();
		        
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
				Toast.makeText(ImageCount.this,"wrong answer",Toast.LENGTH_LONG).show();
		        answer1.setChecked(false);
		        answer2.setChecked(false);
		        answer3.setChecked(false);
		        start();
			}
		}

	}

	
}
