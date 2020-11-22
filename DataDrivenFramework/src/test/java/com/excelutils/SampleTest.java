package com.excelutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest {
	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	XSSFRow XSSFRow;
	DataFormatter formatter;
	
@Test(dataProvider = "dataP")	
public void method(String val) {
	
	System.out.println("get from dataprovider "+val);
	
}

@Test(dataProvider = "excel")	
public void methodone(String val,String val1,String val2) {
	
	System.out.println("get from dataprovider "+val+" "+val1+" "+val2);
	
}
	
	//dataprovider inbuilt function from TESTNG
	//mainly used for parameterization purpose	
	//foremost point datadriven use
	//return object data
	
	@DataProvider(name="dataP")
	public Object[][] anyname(){
		
		Object[][] data= new Object[2][1];
		data[0][0]="valueone";
		data[1][0]="valuetwo";
		
		//return new Object[][] {{"valueone"},{"valuetwo"}};//2rows 1columns
	return data;	
	}
	
	
	@DataProvider(name="excel")
	public Object[][] excelread() throws IOException{
		
	
		FileInputStream fis=new FileInputStream(new File("D:\\Framework_allkind\\DataDrivenFramework\\Datadrivensheet.xlsx"));
		XSSFWorkbook wrkbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=wrkbook.getSheetAt(0);
		
		int getrow=sheet.getPhysicalNumberOfRows();
		
		XSSFRow row=sheet.getRow(0);
		int getcell=row.getLastCellNum();
		
		Object[][] data= new Object[getrow-1][getcell];//decide how much time it wil run
		
		for(int i=1;i<getrow;i++) {
			
			XSSFRow rowinside=sheet.getRow(i);
			for(int j=0;j<getcell;j++) {
				
				
				data[i-1][j]=rowinside.getCell(j).getStringCellValue();
			}
			
			
		}
		
		
		
		return data;
			}
	
	
	


}
