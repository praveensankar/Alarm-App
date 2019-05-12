package com.example.alarmdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class ColorChecking extends Activity implements OnClickListener,OnCheckedChangeListener {

	TextView Question;
	//Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,stop;
	Button b[]=new Button[15];
	Button stop;
	int r,rr;
	int i,j,k,x,count=0;
	String color[]={"RED","BLACK","BLUE","CYAN","DKGRAY",
			"GRAY","GREEN","LTGRAY","MAGENTA","YELLOW"};
	int f[]=new int[15];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        	WindowManager.LayoutParams.FLAG_FULLSCREEN);
	  
		setContentView(R.layout.colorchecking);
	    init();
	    start();
	    
	}

	private void start() {
		// TODO Auto-generated method stub
		//no of background changes
		r=(int)((Math.random()*100)%10);
		x=(int)((Math.random()*1000)%10);
		String s="Choose "+color[x]+"color ";
		Question.setText(s);
		
		
		for(i=0;i<r;i++)
		{
			rr=(int)((Math.random()*100)%15);
				union(rr);
			switch(x)
			{
			case 0:b[rr].setBackgroundColor(Color.RED);break;
			case 1:b[rr].setBackgroundColor(Color.BLACK);break;
			case 2:b[rr].setBackgroundColor(Color.BLUE);break;
			case 3:b[rr].setBackgroundColor(Color.CYAN);break;
			case 4:b[rr].setBackgroundColor(Color.DKGRAY);break;
			case 5:b[rr].setBackgroundColor(Color.GRAY);break;
			case 6:b[rr].setBackgroundColor(Color.GREEN);break;
			case 7:b[rr].setBackgroundColor(Color.LTGRAY);break;
			case 8:b[rr].setBackgroundColor(Color.MAGENTA);break;
			case 9:b[rr].setBackgroundColor(Color.YELLOW);break;
			}
			
				
		}
		for(r=0;r<15;r++)
		{
			if(f[r]==0)
			{
			i=(int)((Math.random()*100)%10);
			if(i==x)
			{
				if(i==9)
					i=8;
				else
					i=i+1;
			}
			switch(i)
			{
			case 0:b[r].setBackgroundColor(Color.RED);break;
			case 1:b[r].setBackgroundColor(Color.BLACK);break;
			case 2:b[r].setBackgroundColor(Color.BLUE);break;
			case 3:b[r].setBackgroundColor(Color.CYAN);break;
			case 4:b[r].setBackgroundColor(Color.DKGRAY);break;
			case 5:b[r].setBackgroundColor(Color.GRAY);break;
			case 6:b[r].setBackgroundColor(Color.GREEN);break;
			case 7:b[r].setBackgroundColor(Color.LTGRAY);break;
			case 8:b[r].setBackgroundColor(Color.MAGENTA);break;
			
			case 9:b[r].setBackgroundColor(Color.YELLOW);break;
			}
		
			}
		}
		check();
	}

	private void check() {
		// TODO Auto-generated method stub
		for(int i=0;i<15;i++)
			b[i].setOnClickListener(this);
		stop.setOnClickListener(this);
	}

	private void union(int r2) {
		// TODO Auto-generated method stub
		f[r2]=1;
	}

	private void init() {
		// TODO Auto-generated method stub
		Question=(TextView)findViewById(R.id.cQuestion);
		stop=(Button)findViewById(R.id.cStopAlarm);
	    b[0]=(Button)findViewById(R.id.cb1);
		b[1]=(Button)findViewById(R.id.cb2);
		b[2]=(Button)findViewById(R.id.cb3);
		b[3]=(Button)findViewById(R.id.cb4);
		b[4]=(Button)findViewById(R.id.cb5);
		b[5]=(Button)findViewById(R.id.cb6);
		b[6]=(Button)findViewById(R.id.cb7);
		b[7]=(Button)findViewById(R.id.cb8);
		b[8]=(Button)findViewById(R.id.cb9);
		b[9]=(Button)findViewById(R.id.cb10);
		b[10]=(Button)findViewById(R.id.cb11);
		b[11]=(Button)findViewById(R.id.cb12);
		b[12]=(Button)findViewById(R.id.cb13);
		b[13]=(Button)findViewById(R.id.cb14);
		b[14]=(Button)findViewById(R.id.cb15);
	    for(int i=0;i<15;i++)
	    	f[i]=0;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.cb1:
			if(f[0]==1)
			{	f[0]=0;
			b[0].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			break;
		

		case R.id.cb2:
			if(f[1]==1)
			{	f[1]=0;
			b[1].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			break;

		case R.id.cb3:
			if(f[2]==1)
			{	f[2]=0;
			b[2].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			break;
		

		case R.id.cb4:
			if(f[3]==1)
			{	f[3]=0;
			b[3].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			break;

		case R.id.cb5:
			if(f[4]==1)
			{	f[4]=0;
			b[4].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb6:
			if(f[5]==1)
			{	f[5]=0;
			b[5].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb7:
			if(f[6]==1)
			{	f[6]=0;
			b[6].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb8:
			if(f[7]==1)
			{	f[7]=0;
			b[7].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb9:
			if(f[8]==1)
			{	f[8]=0;
			b[8].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb10:
			if(f[9]==1)
			{	f[9]=0;
			b[9].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb11:
			if(f[10]==1)
			{	f[10]=0;
			b[10].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb12:
			if(f[11]==1)
			{	f[11]=0;
			b[11].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb13:
			if(f[12]==1)
			{	f[12]=0;
			b[12].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb14:
			if(f[13]==1)
			{	f[13]=0;
			b[13].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;

		case R.id.cb15:
			if(f[14]==1)
			{	f[14]=0;
			b[14].setBackgroundColor(Color.WHITE);
			}	
			else
			{
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
		    }
			
			break;
		
		
		case R.id.cStopAlarm:
			restart();
			break;
	}
	}
	private void restart() {
		// TODO Auto-generated method stub
		int flag=0;
		for(int i=0;i<15;i++)
		{
			if(f[i]==1){
				Toast.makeText(ColorChecking.this,"wrong answer",Toast.LENGTH_LONG).show();
			    flag=1;
			}
		}
		if(flag==0)
		{
			Toast.makeText(ColorChecking.this,"Correct answer",Toast.LENGTH_LONG).show();
		    
			new AlarmReceiver().rel();
			Intent startMain = new Intent(Intent.ACTION_MAIN);
			startMain.addCategory(Intent.CATEGORY_HOME);
			startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(startMain);
			finish();
			
		}
	}

	
}
