package com.Mini_project_Test_Case;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Mini_Project.Page_Object.Login_Page;
import com.Mini_Project.Utiliti.Login_Data_Driver_Utilites;

public class Login_Data_Driver extends Base_Class {


	@Test(dataProvider = "Data_Driver")
	public void actual_test(String user,String pass) throws InterruptedException, IOException {
		Login_Page lp=new Login_Page(driver);
		lp.sending_ID(user);
		logger.info("User name is provided");
		lp.sending_Pass(pass);
		logger.info("Password is provided");
		lp.login_click();
		logger.info("login button is clicked");

		if(isAlert_Present()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			capture_Screen( driver, "Login_Data_Driver");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.log_Out();
			driver.switchTo().alert().accept();//this will close the logout alert
			driver.switchTo().defaultContent();

		}

	}


	public boolean isAlert_Present() {  //user defined method used to check weather alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}


	}



	@DataProvider(name="Data_Driver")
	public Object[][] data_Provider(){

		String path="G:\\seleniumWorkspace\\Mini_Project_Selenium\\src\\test\\java\\com\\Mini_Project_Test_Data\\data.xlsx";
		String shet="Sheet1";
		Object data[][]=collector(path, shet);
		return data;
	}




	public Object[][] collector(String path,String shet){

		Login_Data_Driver_Utilites test_Data=new Login_Data_Driver_Utilites(path, shet);

		int ro=	test_Data.getRow_Count();
		int co=test_Data.getColumn_Count();
		Object provider[][]=new Object[ro-1][co];

		for(int i=1;i<ro;i++) {

			for(int j=0;j<co;j++) {
				Object dat=test_Data.get_Cell_Data(i, j);

				provider[i-1][j]=dat;
			}
		}
		return provider;


	}

}
