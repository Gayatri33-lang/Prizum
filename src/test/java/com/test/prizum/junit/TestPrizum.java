package com.test.prizum.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.prizum.util.Constants;
import com.test.prizum.dto.User;
import com.test.prizum.service.PrizumService;
import com.test.prizum.service.ReadData;

public class TestPrizum {
	
	@Test
	public void testLogin() throws IOException{
		PrizumService ps = new PrizumService();
		ReadData rd = new ReadData();
		List<User> user = rd.getcredentials(Constants.FILE_PATH);//list of users
		for (int i = 0 ; i<user.size(); i++){
			User data = user.get(i);
			
			int responsecode =ps.loginuser(data.getusername(),data.getpassword());
			System.out.println(responsecode);
			assertEquals("valid username password" , responsecode , 200 );
			//assertEquals("invalid username password",  responsecode, 302);
		}
		
		
	
	}
	
}
