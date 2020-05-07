package com.Mini_project_Test_Case;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mini_Project.Page_Object.Delete_Customer;
import com.Mini_Project.Page_Object.Login_Page;

public class Delete_customer_test extends Base_Class{

	@Test
	public void actual_Delete_Test() throws InterruptedException {

		

		Login_Page login=new Login_Page(driver);
		
		logger.info("Entered ID");
		login.sending_ID(id);
		
		logger.info("Entered Password");
		login.sending_Pass(password);
		
		
		logger.info("button is clicked");
		login.login_click();

		Delete_Customer dele=new Delete_Customer(driver);

		logger.info("clicking on delete customer link");
		dele.delete_Link();

		logger.info("Entering on delete customer ID");
		dele.send_Custid(C_id);

		logger.info("clicking on Submit button");
		dele.click_Sub();

		logger.info("handling the alert");

		Alert alert= driver.switchTo().alert();
		alert.accept();

		boolean text=alert.getText().contains("Customer deleted Successfully");
		 System.out.println(alert.getText());  
		 
		
		if(text==true) {
			alert.accept();
		}
		else {
			Assert.assertTrue(false);
		}



	}


}
