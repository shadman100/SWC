package com.SWC.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelFiles {

	public void readXLSX(String worksheet){
		String location = System.getProperty("user.dir")+"\\src\\test\\java\\com\\SocialWareCucumber\\resources\\Book.xlsx";
		File excel = new File(location);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(worksheet);
		int rowNum = sheet.getLastRowNum()+1;
		int colNum = sheet.getRow(0).getLastCellNum();
		String [][] data = new String [rowNum][colNum];
		
		for(int i = 0; i<rowNum; i++){
			XSSFRow row = sheet.getRow(i);
				for(int j = 0; j<colNum; j++){
					XSSFCell cell = row.getCell(j);
					String value = cellToString(cell);
					data[i][j] = value;
					System.out.println("The value is "+value);
				}
			}
	}
	
	@SuppressWarnings("deprecation")
	private static String cellToString(XSSFCell cell) {
		int type;
		Object result; 
		type = cell.getCellType();
		
		if(type==0){
			result = cell.getNumericCellValue();
		}else{
			if(type==1){
				result = cell.getStringCellValue();
			}else{
				throw new RuntimeException("don't support");
			}
		}
		
		return result.toString();
	}
}
