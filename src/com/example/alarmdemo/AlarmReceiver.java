package com.example.alarmdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.view.Window;
import android.view.WindowManager;

public class AlarmReceiver extends WakefulBroadcastReceiver {
	 MediaPlayer ring1; 
	@Override
	    public void onReceive(final Context context, Intent intent) {
	        //this will update the UI with message
	       final MainActivity inst = MainActivity.instance();
	       Thread t=new Thread(){
	    	 public void run()
	    	 {
	    		 inst.goAlert();
	    	 }
	       };
	        //this will sound the alarm tone
	        //this will sound the alarm once, if you wish to
	        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
	        //Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
	        //ringtone.play();
	       Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
	        if (alarmUri == null) {
	            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
	        }

	        
	       ring1=MediaPlayer.create(context, alarmUri);
	        ring1.setLooping(true);
	        ring1.start();
              
	        
	        //this will send a notification message
	        ComponentName comp = new ComponentName(context.getPackageName(),
	                AlarmService.class.getName());
	        startWakefulService(context, (intent.setComponent(comp)));
	        setResultCode(Activity.RESULT_OK);
	        //rel();
	         
	 }

	public void rel(){
		
		ring1.stop();
		ring1.release();
		System.exit(0);
	}
}
