package com.Mini_Project.Page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_New_Customer {

	WebDriver Driver;

	//Address of Web Elements

	@FindBy(name = "name")
	WebElement customer_Name;

	@FindBy(name = "rad1")
	WebElement customer_gender;

	@FindBy(name = "dob")
	WebElement customer_date;

	@FindBy(name = "city")
	WebElement customer_city;

	@FindBy(name = "addr")
	WebElement customer_address;

	@FindBy(name = "state")
	WebElement customer_state;

	@FindBy(name = "pinno")
	WebElement customer_pin ;

	@FindBy(name = "telephoneno")
	WebElement customer_phone_no ;

	@FindBy(name = "emailid")
	WebElement customer_email;

	@FindBy(name = "sub")
	WebElement customer_submit ;


	@FindBy(linkText = "New Customer")
	WebElement newCustomer;
	
	@FindBy(name = "password")
	WebElement pass;
	


	public Add_New_Customer(WebDriver driver) {
		this.Driver=driver;
		PageFactory.initElements(Driver, this);
	}

	public void add_Customer() {
		newCustomer.click();
	}
	public void s_name(String cname) {
		customer_Name.sendKeys(cname);
	}

	public void s_Gender() {
		customer_gender.click();
	}

	public void s_date(String c_month,String c_date,String c_year) {
		customer_date.sendKeys(c_month);
		customer_date.sendKeys(c_date);
		customer_date.sendKeys(c_year);
	}

	public void s_address(String c_addres) {
		customer_address.sendKeys(c_addres);
	}

	public void s_city(String c_city) {
		customer_city.sendKeys(c_city);
	}

	public void s_state(String c_state) {
		customer_state.sendKeys(c_state);
	}

	public void s_pin(String c_pin) {
		customer_pin.sendKeys(c_pin);
	}

	public void s_phone(String c_phone) {
		customer_phone_no.sendKeys(c_phone);
	}
	public void s_email(String c_email) {
		customer_email.sendKeys(c_email);
	}
	public void s_submit() {
		customer_submit.click();
	}
     
	public void s_pass(String password) {
		pass.sendKeys(password);
		
	}

}
