package com.Mini_project_Test_Case;




import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mini_Project.Page_Object.Edit_Customer;
import com.Mini_Project.Page_Object.Login_Page;

public class Edit_customer_test extends Base_Class {
	

	@Test
	public void edit() throws InterruptedException {
		
		
		Login_Page log=new Login_Page(driver);
		
		
		logger.info("typing the id");
		log.sending_ID(id);
		
		logger.info("typing the password");
		log.sending_Pass(password);
		
		logger.info("Clicking on login");
		log.login_click();
		
		
		Edit_Customer edit_c=new Edit_Customer(driver);
	
		
		logger.info("Clicking on login");
		edit_c.edit_Customer();
		
		logger.info("typing the customer id");
		edit_c.customer_id(C_id);
		
		logger.info("Clicking on submit");
		edit_c.sub();
		
		logger.info("Editing  the City");
		edit_c.c_city("Kushalanagar"); 
		
		logger.info("Editing  the State");
		edit_c.c_State("Karnataka");
		
		edit_c.sub_edit();
		
	boolean heading=driver.getPageSource().contains("Customer details updated Successfully!!!");
		if(heading==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		
	}

}
