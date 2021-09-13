package com.test.prizum.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.prizum.util.Constants;
import com.test.prizum.dto.User;

public class ReadData {

	

	public List<User> getcredentials(String filepath) throws FileNotFoundException {
		File f = new File(filepath);
		Scanner s = new Scanner(f);
		List<User> listofuser = new ArrayList<User>();
		s.nextLine(); // to start from 2nd line in file if first is of no use 
		while (s.hasNextLine()) {
			String filelines = s.nextLine();
			String[] credsarray = filelines.split(",");

			User user = new User();
			user.setusername(credsarray[0]);
			user.setpassword(credsarray[1]);

			listofuser.add(user);
		}

		return listofuser;

	}
}
