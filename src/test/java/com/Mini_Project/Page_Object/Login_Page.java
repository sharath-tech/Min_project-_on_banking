package com.Mini_Project.Page_Object;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver driver;
	
	//Address of user id
	@FindBy(name = "uid")
	WebElement UserID;

	//Address of password
	@FindBy(name = "password")
	WebElement Password;
	
	//Address of login
	@FindBy(name = "btnLogin")
	WebElement  login_button;
	
	@FindBy(linkText ="Log out")
	WebElement log_out_button ;
	
	

	//Constructor   
	public Login_Page(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		this.driver=driver;
      PageFactory.initElements(driver, this);
	}

	public void sending_ID(String Id) throws InterruptedException {	
		UserID.sendKeys(Id);

	}

	public void sending_Pass(String pass) throws InterruptedException {
	
		Password.sendKeys(pass);
	}

	public void login_click() throws InterruptedException {
	
		login_button.click();
	}

	public void log_Out() {
		log_out_button.sendKeys(Keys.RETURN);
	}


}
