package com.example.zhinengjiaju;

import java.io.IOException;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Intent Socketservice_intent =new Intent(this,Socketservice.class);
        startService(Socketservice_intent);
        
        Switch switchTest1 = (Switch) findViewById(R.id.switch1);
        switchTest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {  
                    @Override  
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    	if(isChecked == true)
                    	{
                    		try {
                    			while(Socketservice.connect_ok==0);
								Socketservice.send_data("light_on");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    	else
                    	{
                    		try {
								Socketservice.send_data("light_off");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    }  
                });
        

        Switch switchTest2 = (Switch) findViewById(R.id.switch2);
        switchTest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {  
                    @Override  
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    	if(isChecked == true)
                    	{
                    		try {
                    			while(Socketservice.connect_ok==0);
								Socketservice.send_data("window_on");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    	else
                    	{
                    		try {
								Socketservice.send_data("window_on");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    }  
                });
        
        Switch switchTest3 = (Switch) findViewById(R.id.switch3);
        switchTest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {  
                    @Override  
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    	if(isChecked == true)
                    	{
                    		try {
                    			while(Socketservice.connect_ok==0);
								Socketservice.send_data("tv_on");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    	else
                    	{
                    		try {
								Socketservice.send_data("tv_on");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
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
        return super.onOptionsItemSelected(item);
    }
}
