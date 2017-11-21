package DriverScript;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import GenericMethods.Generic;
import ReadExcel.ReadExcel;

public class Driver {
	public static WebDriver driver;
	public static String filepath = "C:\\Users\\welcome\\workspace\\AmazonWithKeywordDrivenDataDriven\\src\\TestSuite\\TestCase.xlsx";
	public static String SheetName = "Sheet1";
	public static int columnNo = 2;
	public static Method methods[]= null;
	public static String methodname;
	public static String methodnameinlibrary;
	public static String para;
	public static String ElementName;
	public static String casename;
	public static String para1;
	public static String para2;
	public static double TestCaseNo;
	public static String TestCasename;
	public static String sheetname = "TestReport";
	public static XSSFRow row;
	public static XSSFSheet SheetForReport;
	//public static boolean bFlag=false;

	
	
	@Test
	public static void excuteTest() throws Exception {

		Generic functions = new Generic(driver);
		methods = functions.getClass().getDeclaredMethods();
		int sizeofGeneric = methods.length;
		ReadExcel excelobj = new ReadExcel();
		excelobj.readExcel(filepath, SheetName, columnNo);
		int rowcount = excelobj.rowcount;
		//columnCount_DataSheet = excelobj.columnCount_DataSheet;
		
		excelobj.createExcel(sheetname);
		
		SheetForReport = excelobj.workbook1.getSheet(sheetname);
		for(int i=1;i<rowcount;i++)
		{
			TestCaseNo = excelobj.workbook.getSheet(SheetName).getRow(i).getCell(0).getNumericCellValue();
			TestCasename = excelobj.workbook.getSheet(SheetName).getRow(i).getCell(1).getStringCellValue();
			methodname = excelobj.workbook.getSheet(SheetName).getRow(i).getCell(2).getStringCellValue();
			para = excelobj.workbook.getSheet(SheetName).getRow(i).getCell(3).getStringCellValue();
			//Create report header 
			SheetForReport.createRow(0).createCell(0).setCellValue("slno");
			SheetForReport.getRow(0).createCell(1).setCellValue("TCName");
			SheetForReport.getRow(0).createCell(2).setCellValue("Keywords");
			SheetForReport.getRow(0).createCell(3).setCellValue("TestData");
			SheetForReport.getRow(0).createCell(4).setCellValue("Result");
			
			
			row = SheetForReport.createRow(i);

			if(TestCaseNo!=0.0)
			{
			row.createCell(0).setCellValue(TestCaseNo);
			}
			row.createCell(1).setCellValue(TestCasename);
			row.createCell(2).setCellValue(methodname);
			row.createCell(3).setCellValue(para);
			
				
			
			for(int j=0;j < sizeofGeneric; j++)
			{		
				methodnameinlibrary = methods[j].getName();	
				System.out.println(methodname);
				if(methodname.equalsIgnoreCase (methodnameinlibrary))
				{ 
					if (para == "")
						{
							methods[j].invoke(functions);
						}
					else if(para.contains(">"))
						{
							para1= para.split(">")[0];
							para2=para.split(">")[1];
							methods[j].invoke(functions, para1,para2);
						}
					else 
						{
							methods[j].invoke(functions, para);
						}
					if (functions.bFlag == true)
					{
						row.createCell(4).setCellValue("Passed");
					}
					else{row.createCell(4).setCellValue("Failed");}
				}
			}
			if(i== (rowcount-1)){
				excelobj.saveExcel(sheetname);
			}
				

		}
		
		
	}

}
