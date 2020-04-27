package com.Mini_Project.Utiliti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_Config {

	Properties pro;

	public Read_Config() {

		File scr=new File("./Configaration/config.properties");

		FileInputStream fis;
		try {
			fis = new FileInputStream(scr);
		

		pro=new Properties();

		pro.load(fis);
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getApplication_URL(){

		String URL=pro.getProperty("url");
		return URL;
	}

	public String getApplication_password(){

		String pass=pro.getProperty("password");
		return pass;
	}
	public String getApplication_id(){

		String ID=pro.getProperty("id");
		return ID;
	}

}
