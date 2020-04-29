package com.Mini_project_Test_Case;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Mini_Project.Utiliti.Read_Config;

import net.bytebuddy.utility.RandomString;




public class Base_Class {

	Read_Config  read_config=new Read_Config();

	WebDriver driver;
	String C_id=read_config.getCustomer_id();
	String id=read_config.getApplication_id();
	String password=read_config.getApplication_password();
	String url=read_config.getApplication_URL();
	        

	Logger logger;

	@Parameters("Browser")
	@BeforeClass
	public void setUp(String br ) {
		logger= LogManager.getLogger(Base_Class.class);

		if(br.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}

		else if(br.equalsIgnoreCase("fire")) {
			driver=new FirefoxDriver();
			driver.get(url);
		}

		else if(br.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}


	}

	@AfterClass
	public void tearDown() {

	
	}
	
	public void capture_Screen(WebDriver driver,String tname) throws IOException {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot pic=(TakesScreenshot)driver;
      File PicFile= pic.getScreenshotAs(OutputType.FILE);
      
      File target=new File("G:\\seleniumWorkspace\\Mini_Project_Selenium\\ScreenShot"+tname+".png"+timestamp);
      FileUtils.copyFile(PicFile, target);
      System.out.println("ScreenShot Taken");
		
	}
	public String random_Email() {
		
		String random=RandomString.make(5);
		return random;
	}
    
	public String random_number() {
		Random mixed=new Random();
		 int upperbound=10; //generate random values from 0-9
		 int mixed_number=mixed.nextInt(upperbound);
		 String mixedString=Integer.toString(mixed_number);
		 return mixedString;
		
	}
	
}
