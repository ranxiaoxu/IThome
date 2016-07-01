package com.example.zhinengjiaju;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import android.app.IntentService;
import android.content.Intent;
import android.widget.TextView;

public class Read extends IntentService{

	public static BufferedReader br;
	public Socket s=null;
	
	
	
	public Read() {
		super("Read");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		System.out.println("kai shi du lou");
		// TODO Auto-generated method stub
		s=null;
	    br = null;
		s=Socketservice.s;
		Socketservice.start_new_Socket=1;
		
		try {
			//chu shi hua shu chu liu
			br=new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fku");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fku");
		}
		
		
			String content = null;
			
			while((content=read())!=null){
			  
			  Socketservice.data=content;
			  
			  System.out.println("du dao data li le");
			  
			  Socketservice.read_ok=0;
			  while(Socketservice.read_ok==0);
			  
			}
			
			
	
	}
	
	
	// shi ji shang shi ta zai du
    public static String read(){
    	try{
    	
    		return br.readLine();
    		
    	} catch(IOException e){
    		
    		//Socketservice.socketList.remove(s);
    	}
    	return null;
    }
    
    
}


