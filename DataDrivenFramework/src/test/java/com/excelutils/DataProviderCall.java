package com.excelutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderCall {
	
	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	XSSFRow XSSFRow;
	DataFormatter formatter;
	

	@DataProvider(name = "fetchAll")
	public Object[][] getData() throws IOException{
	
		
		//String methodname=m.getName();
		FileInputStream fileInputStream= new FileInputStream(new File("D:\\Framework_allkind\\DataDrivenFramework\\Datadrivensheet.xlsx")); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheetAt(0);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         

            for(int i=1; i<RowNum; i++) //Loop work for Rows
            {  
                XSSFRow row= worksheet.getRow(i);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            //String value=formatter.formatCellValue(cell);
                            String value=cell.getStringCellValue();         
                             Data[i-1][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                           
                           
                        }
                    }
                }
            }
 
        return Data;

	}

}
