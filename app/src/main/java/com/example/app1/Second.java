package com.example.app1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends Activity {
    EditText et1,et2;
    TextView tv1;
    MediaPlayer song;
    GridView gv1;
    ListView lv1;
    String[] num={"Red","Green","Blue","Black","Yellow","Violet","Orange","White","Brown"};
    ArrayAdapter aa3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		song=MediaPlayer.create(Second.this,R.raw.f);
		song.start();
		gv1=(GridView)findViewById(R.id.gridView1);
		lv1=(ListView)findViewById(R.id.listView1);
		aa3=new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,num);
		gv1.setAdapter(aa3);
		lv1.setAdapter(aa3);
		//bundl();
	gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() 
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(),((TextView) view).getText(),Toast.LENGTH_SHORT).show();
		}		
		});	
	}
	
	public void bundl()
	{
		Bundle bun=getIntent().getExtras();
		final EditText et1=(EditText)findViewById(R.id.et1);
		final EditText et2=(EditText)findViewById(R.id.et2);
		final TextView tv1=(TextView)findViewById(R.id.tv1);
		String str=bun.getString("a1");
		String str1=bun.getString("a2");
		String str2=bun.getString("a3");
		et1.setText(str);
		et2.setText(str1);
		tv1.setText(str2);
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
	}
}
