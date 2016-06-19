package com.example.zhinengjiaju;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.IntentService;
import android.content.Intent;

public class Socketservice extends IntentService {
    // save all socket
	public static ArrayList<Socket> socketList =new ArrayList<Socket>();
	public ServerSocket ss;
	public static Socket s;
	public static int start_new_Socket=0;
	public static String data;
	public static int read_ok;
	public static int connect_ok=0;
	
	
	public Socketservice() {
		super("Socketservice");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		
		System.out.println("kai shi lou");
		// TODO Auto-generated method stub
		try {
				
				s=new Socket("192.168.1.105",3000);
				
				System.out.println("lianshanglou");
				//xia man da kai read xian cheng
			
				Intent intent = new Intent(this,Read.class);		
				startService(intent);
				//while(start_new_Socket==0);
				//start_new_Socket=0;
				connect_ok=1;	
				send_data("di yi tiao");
				send_data("di er tiao");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// du shu ju yong de
	  
	public  static String read_data(){
		 read_ok=1;
		 String p_data=null;
		 p_data=data;
		 data=null;
		 System.out.println("ba data li de du chulai le");
		 
		 return p_data;
		
	}
	
	public static String send_data(String data) throws IOException{
		
			try{
				
				OutputStream os =s.getOutputStream();
				os.write((data+"\n").getBytes("utf-8"));
				
				return "send ok" ;
				
			}catch(SocketException e){
				
			 e.printStackTrace();
		
			 System.out.println("gua le");
			 
			}

		return "ma dan chu chuo";
		
	}
}
