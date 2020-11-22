package com.roughwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sampletest {
	
	
	//Dataprovider//testNG in built function
	//external , 2times
	//apache poi,dataprovider
	
	
	@DataProvider(name="dataP")
	public Object[][] anyname(){
		
		Object[][] data=new Object[2][1];
		data[0][0]="valueone";
		data[1][0]="valuetwo";
		
		
		return data;		
			}
	
	@Test(dataProvider = "dataP",enabled=false)
	public void simplemethod(String value) {
		
		System.out.println("from the dataprovider "+value);
	}
	
	@DataProvider(name="excel")
	public Object[][] excelread() throws IOException{
		
		//fileinput
		FileInputStream fis=new FileInputStream(new File("D:\\Framework_allkind\\DataDrivenFramework\\Datadrivensheet.xlsx"));
		XSSFWorkbook wrkbook =new XSSFWorkbook(fis);
		XSSFSheet sheet=wrkbook.getSheetAt(0);
		
		
		int rows=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int cells=row.getLastCellNum();
		
		Object[][] data=new Object[rows-1][cells];
		
		for(int i=1;i<rows;i++) {
			XSSFRow rowinside=sheet.getRow(i);
			for(int j=0;j<cells;j++) {
				
			data[i-1][j]=	rowinside.getCell(j).getStringCellValue();
			}
			
			
		}
		
		
		
		
		
		return data;
			}
	
	@Test(dataProvider = "excel")
	public void methodexcel(String val1,String value2,String val3) {
		
	System.out.println("print 1 "+ val1+" "+value2+" "+val3);	
		
	}

}
