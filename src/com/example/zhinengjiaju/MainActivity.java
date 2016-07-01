package com.example.zhinengjiaju;

import java.io.IOException;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Intent Socketservice_intent =new Intent(this,Socketservice.class);
        startService(Socketservice_intent);
        
        final Intent Read_intent =new Intent(this,Read.class);
        startService(Read_intent);
       
        Switch switchTest1 = (Switch) findViewById(R.id.switch1);   //灯
        switchTest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {  
                    @Override  
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    	if(isChecked == true)
                    	{
                    		try {
                    			if(Socketservice.connect_ok!=0)
								Socketservice.send_data("denon");
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
                    			if(Socketservice.connect_ok!=0)
								Socketservice.send_data("denof");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    }  
                });
        

        Switch switchTest2 = (Switch) findViewById(R.id.switch2);   //窗帘
        switchTest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {  
                    @Override  
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    	if(isChecked == true)
                    	{
                    		try {
                    			if(Socketservice.connect_ok!=0)
								Socketservice.send_data("chuon");
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
                    			if(Socketservice.connect_ok!=0)
								Socketservice.send_data("chuof");
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
                    			if(Socketservice.connect_ok!=0)
                    				Socketservice.send_data("diaon");
                    			
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
                    			if(Socketservice.connect_ok!=0)
								Socketservice.send_data("diaof");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(MainActivity.this, "something wrong",
										Toast.LENGTH_SHORT).show();
							}
                    	}
                    }  
                });
        
       
        //不停地读数据
        TextView test1 = (TextView) findViewById(R.id.textView1); 
        TextView test2 = (TextView) findViewById(R.id.textView2);
        
    	if(Socketservice.connect_ok != 0)
    	{
        String data = Read.read();
    
        String panduan = data.substring(0, 2); //判断前三个字符是什么例如tem25
        
        //读温度
        if(panduan == "tem")
        {
            String num = data.substring(3);
            int a = Integer.parseInt(num);
    		test1.setText(getString(R.string.tem, a));  
        }


        //读湿度
        if(panduan == "wat")
        {
            String num = data.substring(3);
            int a = Integer.parseInt(num);
    		test2.setText(getString(R.string.water, a));  
        }
        
        if(panduan == "chu")
        {
        	String status = data.substring(3);
        	if(status == "on")
        	{
        		switchTest2.setChecked(true);
        	}
        	else
        	{
        		switchTest2.setChecked(false);
        	}
        }
        
        if(panduan == "den")
        {
        	String status = data.substring(3);
        	if(status == "on")
        	{
        		switchTest1.setChecked(true);
        	}
        	else
        	{
        		switchTest1.setChecked(false);
        	}
        }
        
        if(panduan == "dia")
        {
        	String status = data.substring(3);
        	if(status == "on")
        	{
        		switchTest3.setChecked(true);
        	}
        	else
        	{
        		switchTest3.setChecked(false);
        	}
        }
    	}
    }

    public void choosemode(View v)
    {
    	Intent intent = new Intent();
    	intent.setClass(this,ModeActivity.class);
    	startActivity(intent);
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
