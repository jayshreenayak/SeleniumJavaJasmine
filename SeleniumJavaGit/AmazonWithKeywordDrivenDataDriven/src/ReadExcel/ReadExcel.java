package ReadExcel;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel
{
	public File file;
	public Workbook workbook;
	public String methodName;
	public int rowcount;
	public String methodname;
	public String FileName;
	//public XSSFSheet SheetForReport;
	public XSSFWorkbook workbook1;
	public int columnCount_DataSheet;
	//opens excel 
	public void readExcel(String filepath,String SheetName,int columnNo ) throws Exception
	{
		file = new File(filepath);	
		FileInputStream fi = new FileInputStream(file);
		if(filepath.endsWith(".xls"))
			workbook = new HSSFWorkbook(fi);
		else
			workbook = new XSSFWorkbook(fi);
		 rowcount = workbook.getSheet(SheetName).getLastRowNum()+1;
		 columnCount_DataSheet = workbook.getSheet(SheetName).getRow(1).getLastCellNum();
	}
	public void createExcel(String SheetName) throws Exception
	{
		workbook1 = new XSSFWorkbook(); 
	      //Create a blank sheet
		workbook1.createSheet(SheetName);
	}

	public void saveExcel(String SheetName) throws Exception
	{
		Date date = new Date();
		String time = date.toString().replace(":", "_").replace(".", "_");
		FileName = "E:\\New folder\\" + "TestReport_" + time +".xlsx";
	    FileOutputStream fo = new FileOutputStream(FileName);
	    workbook1.write(fo);
	    
	     XSSFCellStyle style = workbook1.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	    Font font = workbook1.createFont();

	    style.getBorderLeftEnum();
	    style.getBorderBottomEnum();
	    style.getBorderRightEnum();
	    style.getBorderTopEnum();
	   
	    fo.close();
	}
}
