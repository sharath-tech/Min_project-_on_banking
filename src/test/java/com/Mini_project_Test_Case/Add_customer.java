package com.Mini_project_Test_Case;





import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mini_Project.Page_Object.Add_New_Customer;
import com.Mini_Project.Page_Object.Login_Page;



public class Add_customer extends Base_Class{

	@Test
	public void details() throws InterruptedException {


		Login_Page lg=new Login_Page(driver);

		logger.info("Loading user ID");
		lg.sending_ID(id);

		logger.info("Loading user password");
		lg.sending_Pass(password);

		logger.info("Clicking on Login button");
		lg.login_click();


		Add_New_Customer add=new Add_New_Customer(driver);

		logger.info("clicking on ADD Customer");
		add.add_Customer();

		logger.info("Typing the Name");
		add.s_name("Sharath");

		logger.info("Selecting the Gender");
		add.s_Gender();

		logger.info("Typing the DOB");
		add.s_date("29", "10","1997");

		logger.info("Typing the Address");
		add.s_address("INDIA");

		logger.info("Typing the City");
		add.s_city("Kushalanagar");

		logger.info("Typing the  State");
		add.s_state("Karnataka");

		logger.info("Typing the PIN no");
		add.s_pin("571234");

		logger.info("Typing the Phone no");
		String phone_no=random_number();
		add.s_phone(phone_no);

		logger.info("Typing the Email");
		String email= random_Email()+"@gmail.com";		
		add.s_email(email);

		logger.info("Typing the name");
		add.s_pass(password);

		logger.info("clicking on ADD Customer");
		add.s_submit();

		boolean	 heading=driver.getPageSource().contains(" ");
		if(heading==true) {
			Assert.assertTrue(true);

		}
		else {
			Assert.assertTrue(false);
		}

	}


}
