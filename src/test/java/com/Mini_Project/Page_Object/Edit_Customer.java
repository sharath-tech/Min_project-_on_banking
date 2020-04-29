package com.Mini_Project.Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Customer {
	
	WebDriver Driver;
	
	//Address of edit_customer link
	@FindBy(linkText = "Edit Customer")
	WebElement edit;
	
	//Address of Customer id text box
	@FindBy(name = "cusid")
	WebElement cutomer_id_A;
	
	//Address of customer state box
	@FindBy(name = "state")
	WebElement c_State_A;
	
	//Address of customer city box
	@FindBy(name = "city")
	WebElement c_city_A;	
	
	//Address of customer DOB box
	@FindBy(name = "dob")
	WebElement c_dob_A;
	
	@FindBy(name = "AccSubmit")
	WebElement c_sub_A;
	
	@FindBy(name = "sub")
	WebElement c_sub_edit_A;
	public Edit_Customer(WebDriver driver) {
		this.Driver=driver;
		PageFactory.initElements(Driver, this);
	}

	public void edit_Customer() {
		edit.click();
	}
	
	public void customer_id(String cid) {
		cutomer_id_A.sendKeys(cid);
	}
	
	public void sub() {
		c_sub_A.click();
	}
	public void sub_edit() {
		c_sub_edit_A.click();
	}
	
	public void c_State(String state) {
		c_State_A.sendKeys(state);
	}
	
	public void c_city(String city) {
		c_city_A.sendKeys(city);
	}
	
	public void c_DOB(String c_Year,String c_month,String c_Day) {
		c_dob_A.sendKeys(c_Year);
		c_dob_A.sendKeys(c_month);
		c_dob_A.sendKeys(c_Day);
	}
	
}
