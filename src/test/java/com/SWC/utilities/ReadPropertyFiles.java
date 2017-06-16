package com.SWC.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

public class ReadPropertyFiles {
	Properties property;
	FileInputStream fileInput;
	String key;
	String value;
	
	public String ReadSingle(String keyInput){
																		
		try {
			fileInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\SWC\\resources\\config.properties");
			property = new Properties();
			property.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = property.keys();
			while (enuKeys.hasMoreElements()) {
				key = (String) enuKeys.nextElement();
				value = property.getProperty(key);
				
				if(key.contains(keyInput)){
					return value;
				}
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	} 
}
