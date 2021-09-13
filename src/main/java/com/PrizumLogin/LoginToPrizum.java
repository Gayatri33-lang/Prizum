package com.PrizumLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prizum.util.PrizumUtils;

public class LoginToPrizum {
	
	public static void main(String[] args) throws InterruptedException{
		PrizumUtils pu = new PrizumUtils();
		WebDriver driver  =pu.login("prizimadmin@yopmail.com", "Pass@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Users']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Gayatri");
		driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("Arora");
		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("QA");
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("gayatri.aroraa@yopmail.com");
		Thread.sleep(1000);
		WebElement e = driver.findElement(By.xpath("//select[@formcontrolname='role']"));
	    Select role = new Select(e);
		//role.selectByValue("Admin");
		//role.selectByIndex(1);
		role.selectByVisibleText("Admin");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//em[@class='fas fa-caret-down']")).click();
		Thread.sleep(3000);
		pu.logout(driver);
		Thread.sleep(3000);
		//System.out.println(driver.getTitle());
		//driver.close();
		//driver.quit();
	}

}
