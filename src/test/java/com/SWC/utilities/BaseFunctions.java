package com.SWC.utilities;
//import java.util.List;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunctions {
	
	static WebDriver driver = null;
	ReadPropertyFiles propertyObj; 
	ReadExcelFiles excelObj;
	List<WebElement> linkList; 
	
	public void openApp(String bName){
		
		if(bName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(readConfig("url"));
			driver.manage().window().maximize();
			wait(3000);
		}
	}
	
	public void enterData(String oName, String value){
		driver.findElement(By.xpath(oName)).clear();
		driver.findElement(By.xpath(oName)).sendKeys(value);
	}
	
	public void click(String oName){
		wait(2000);
		driver.findElement(By.xpath(oName)).click();
		wait(2000);
	}
	
	public boolean validate(String oName, String expectedResult){
		boolean rtype = false;
		String actualResult = driver.findElement(By.xpath(oName)).getText();
		
		if(actualResult.contains(expectedResult)){
			rtype = true;
		}	
		return rtype;
	}
	
	public void backPage(){
		driver.navigate().back();
	}
	
	public void closeApp(){
		wait(3000);
		driver.quit();
	}
	
	public void wait(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isPostPresent(String text){
		boolean rtype = false;	
		 try{
	            rtype = driver.getPageSource().contains(text);
	            rtype = true;
	        }
	        catch(Exception e){
	        }			
		 
		 return rtype;
	}
	
	public boolean checkFooterLinks(String link){
		boolean rtype = false;
		linkList = driver.findElements(By.xpath(link));
		
		for(int i = 0; i<linkList.size(); i++){
			WebElement targetLink = driver.findElement(By.xpath(link+"["+(i+1)+"]"));
			String ExpResult = targetLink.getText();
			
			targetLink.click();
			wait(4000);
			String ActualResult=null;
			
			ActualResult = driver.findElement(By.xpath("//h3")).getText();
			if(ActualResult.contains("SITEDESCRIPTION")){
				rtype = true;
			}else{
				if(ExpResult.contains(ActualResult)){
					rtype = true;					
				}else{
					rtype = false;
					break;
				}
			}
			backPage();
			wait(4000);
		}
		return rtype;
	}

	
	public String readConfig(String keyInput){
		propertyObj = new ReadPropertyFiles();
		String output = propertyObj.ReadSingle(keyInput);
		return output;	
	}
	
	public void readExcel(String worksheet){
		excelObj = new ReadExcelFiles();
		excelObj.readXLSX(worksheet);
	}
	
	

}
