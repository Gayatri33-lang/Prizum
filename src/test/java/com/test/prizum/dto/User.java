//pojo - plan old java object
//dto : data transmission object 
// they are used for simply holding data (getter , setter - which further we use in any ds)

package com.test.prizum.dto;

public class User {


	private String username; //each property has 2 methods : get& set which are public methods
	private String password;
	
	public void setusername(String uname){
		this.username = uname;
	}
	
	public String getusername(){
		return this.username;
	}
	
	public void setpassword(String pass){
		this.password=pass;
	}
	
	public String getpassword(){
		return this.password;
	}
}
