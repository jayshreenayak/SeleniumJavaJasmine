package Reports;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;

public class WriteToExcel 
{
public File f;
public Workbook wb;
 public String fpath = "C:\\Users\\welcome\\workspace\\AmazonWithKeywordDrivenDataDriven\\src\\Reports\\ReportFolder\\TestCase.xlsx";
	
	public void writeExcel(String sheetname) throws Exception{
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		//fo.flush();
		fo.close();
	}
}
