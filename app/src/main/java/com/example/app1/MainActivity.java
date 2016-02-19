package com.example.app1;


import java.util.ArrayList;


import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.text.InputType;

import android.view.Menu;

import android.view.MenuItem;

import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.AutoCompleteTextView;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Spinner;

import android.widget.TextView;

import android.widget.Toast;

import android.widget.ToggleButton;



public class MainActivity extends Activity {

	
Button b1,b2;
	TextView t1;
	Spinner sp1,sp2;
	EditText tb1,tb2;
	ToggleButton tg1;
	
//AutoCompleteTextView ab1;
    //static String[] contain={"India","Pakistan","Australia","Africa","Indonesia"};
	//ArrayList a1=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tb2=(EditText)findViewById(R.id.et3);
        final ToggleButton tg1=(ToggleButton)findViewById(R.id.toggleButton1);
        //AutoCompleteTextView ab1=(AutoCompleteTextView)findViewById(R.id.et3);
        //ArrayAdapter aa2=new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,contain);
        //ab1.setAdapter(aa2);
        final Button b1=(Button)findViewById(R.id.b1);
        final TextView t1=(TextView)findViewById(R.id.l1);
        final Spinner sp1=(Spinner)findViewById(R.id.spn1);
        final Spinner sp2=(Spinner)findViewById(R.id.sp2);
        final EditText tb1=(EditText)findViewById(R.id.tb1);
        ArrayList a1=new ArrayList();
        a1.add("Male");
        a1.add("Female");
        ArrayAdapter a2=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item ,a1);
        sp2.setAdapter(a2);
       
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				//if(tb1.getText().toString())
				int n=Integer.parseInt(tb1.getText().toString());
				t1.setText("Square ="+n*n);
				Bundle b=new Bundle();
				b.putString("a1", tb1.getText().toString());
				b.putString("a2", t1.getText().toString());
				b.putString("a3", sp1.getSelectedItem().toString());
				Intent obj = new Intent(MainActivity.this,Second.class);
				obj.putExtras(b); //passing bundle
				startActivity(obj); 				
			}
		});
        
        tg1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tg1.isChecked())
				{
			      tb2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);	  
				}
				else
				{
					tb2.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.item1) {
			//Toast.makeText(getApplicationContext(),"Google",Toast.LENGTH_SHORT).show();
        	Intent obj = new Intent(MainActivity.this,Second.class);
			startActivity(obj);
        	return true;
        }

        if (id == R.id.item2) {
			Toast.makeText(getApplicationContext(),"About Us",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.item3) {
        	Toast.makeText(getApplicationContext(),"Status",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.item4) {
        	Toast.makeText(getApplicationContext(),"Facebook",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
