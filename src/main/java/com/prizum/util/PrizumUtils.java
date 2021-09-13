package com.prizum.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrizumUtils {

	public WebDriver login(String un , String ps){
		WebDriver driver = new ChromeDriver();//creates object of webdriver
		driver.manage().window().maximize();//to maximize window
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);//implict wait 
		driver.get("https://dev-prizim.taazaahost.com/");
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(un);
		WebDriverWait w = new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(ps);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		return driver;
	}
	
	public void logout(WebDriver driver){
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

}
