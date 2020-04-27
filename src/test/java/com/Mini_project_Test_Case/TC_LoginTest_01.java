 package com.Mini_project_Test_Case;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mini_Project.Page_Object.Login_Page;

public class TC_LoginTest_01 extends Base_Class{
	
	@Test
	public void login_Test() throws InterruptedException, IOException {
		
	    logger.info("URL Loading");
	
		Login_Page login=new Login_Page(driver);
	
		logger.info("Entered ID");
		login.sending_ID(id);
		
		logger.info("Entered Password");
		login.sending_Pass(password);
		
		
		logger.info("button is clicked");
		login.login_click();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
		}
		else {
			capture_Screen( driver,"Tc_Login_Test");
			Assert.assertTrue(false);
		}
	

	}
	

}
