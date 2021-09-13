// Main buisness logic we write in service class i.e we ll write many methods here 

package com.test.prizum.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


import com.prizum.util.Constants;

import sun.nio.cs.StandardCharsets;

public class PrizumService {

	
	public int loginuser(String uname, String pas) throws IOException{
		URL url = new URL(Constants.LOGIN_URL); // whenever we create URL - add checked exception
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		con.setDoOutput(true);// to allow sending request data along with the request
		String encusername = URLEncoder.encode(uname,"UTF-8");
		String encpassword = URLEncoder.encode(pas, "UTF-8");
		String htmlInputString  = "Username="+encusername+"&Password="+encpassword+"&button=login&__RequestVerificationToken=CfDJ8EX49_GpMIdAvuYySs78SaQLB2FkxeXidITwa6yLkghobkHp33mxMXXIjFUX8BWtxLK1FKDJmhiq7WgQ2eoRVEiHWIMCU5Sl9yULq1YBISE-rXlrh_oUuPjtWYEZyjb4N0OeKfR-BgnEb5vb4ju1t_E"; 
		try(OutputStream os = con.getOutputStream()) { //advance try - no need to close streams
		    byte[] input = htmlInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);		
		}
		con.connect(); //send request/hit url
		int responsecode =con.getResponseCode();
		return responsecode;
	}
}
