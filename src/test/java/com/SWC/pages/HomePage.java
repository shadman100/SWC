package com.SWC.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.SWC.utilities.BaseFunctions;


public class HomePage {
	//String lastLoginLabel="//*[@id='sticky']/div[1]/div[2]/h5";
	
		//post a message
		String postMessageTextBox="//*[@id='logoform']/div/div[1]/div";
		String postMessageButton="//*[@id='logoform']/div/div[2]/div[3]/input[2]";
		
		//footer xpaths
		String homePageFooterLink="html/body/div[1]/div[5]/footer/div/div/div[1]/ul/li";
		
		BaseFunctions seleniumFunc = new BaseFunctions();
		List<WebElement> postList;
		
		public void writePost(){			
			String postMessage = seleniumFunc.readConfig("post");
			seleniumFunc.enterData(postMessageTextBox, postMessage);
		}
		
		public void clickElement(String input){
			if(input.contains("Post button")){
				seleniumFunc.click(postMessageButton);
			}else{
				System.out.println("Couldn't find the page");
			}
		}
		
		public boolean validate(){
			boolean rtype = false;
			String postMessage = seleniumFunc.readConfig("post");
			if(seleniumFunc.isPostPresent(postMessage)){
				rtype=true;
			}
			return rtype;
		}
		

		public boolean homeFooterLink(){
			return seleniumFunc.checkFooterLinks(homePageFooterLink);
			
		}
}
