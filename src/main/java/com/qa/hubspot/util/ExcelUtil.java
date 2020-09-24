package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private  static String excelFilePath="C:\\Users\\Vanji\\eclipse-workspace1\\AppHubspotMavenProject\\src\\main\\java\\com\\qa\\hubspot\\testdata\\Hubspot.TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	              
	public static Object[][] getTestDataFromExcel(String sheetName) {
		Object data[][]=null;
		try {
			FileInputStream ip=new FileInputStream(excelFilePath);
			book=WorkbookFactory.create(ip);
			sheet=book.getSheet(sheetName);
			
			data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(j).getLastCellNum();j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	
}
