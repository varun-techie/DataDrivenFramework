package com.excelutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadObjects {
	
	
	public String readlocator(String identifylocator) throws IOException {
		

		FileInputStream fis= new FileInputStream(new File("D:\\Framework_allkind\\DataDrivenFramework\\objects.properties"));
		
		Properties prop= new Properties();
		prop.load(fis);
		
		String value=prop.getProperty(identifylocator);
		//System.out.println(prop.getProperty("username"));
		//System.out.println(prop.getProperty("password"));
		
		return value;

	}

}
