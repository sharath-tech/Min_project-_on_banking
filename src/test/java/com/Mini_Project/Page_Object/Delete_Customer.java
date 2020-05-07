package com.Mini_Project.Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete_Customer {

	WebDriver Driver;
	
	public Delete_Customer(WebDriver driver) {
		this.Driver=driver;
		
	}
	
	public void delete_Link() {
		Driver.findElement(By.linkText("Delete Customer")).click();
	}
	
	public void send_Custid(String id) {
		Driver.findElement(By.name("cusid")).sendKeys(id);
	}
	
	public void click_Sub() {
		Driver.findElement(By.name("AccSubmit")).click();
	}
	
}
