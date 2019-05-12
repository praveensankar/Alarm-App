package com.example.alarmdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String s[]={"add alarm","Show alarm"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1, s));
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		
	super.onCreateOptionsMenu(menu);
	MenuInflater myMenu=getMenuInflater();
	myMenu.inflate(R.menu.main,menu);
	return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String clicked=null;
		switch(position)
		{
		case 0: clicked="MainActivity";
				break;
		case 1: clicked="Show";
				break;
		case 2:clicked="Riddles";
		break;
		case 3:clicked="ImageCount";
		break;
		case 4:clicked="Puzzle";
		break;
		case 5:clicked="ColorChecking";
		break;
		}
		try{
			Class ourClass=Class.forName("com.example.alarmdemo."+clicked);
			Intent ourIntent=new Intent(Menu.this,ourClass);
			startActivity(ourIntent);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.Settings:
			Intent i=new Intent("com.example.alarmdemo.SETTINGS");
			startActivity(i);
			break;
		case R.id.Exit:
			finish();
			break;
		
		}
		return false;
	}

	public void End()
	{
		finish();
	}

}
