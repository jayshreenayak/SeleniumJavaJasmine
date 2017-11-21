package ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class LoadProperty {
	

	Properties prop;
	public String fpath ="C://Users//welcome//workspace//AmazonWithKeywordDrivenDataDriven//src//ObjectRepository//Property.properties" ;
	public Properties loadrepository(String fpath) throws IOException
	{
		File f = new File(fpath);
		InputStream fs = new FileInputStream(f);
		prop = new Properties();
		prop.load(fs);
		//System.out.println(prop.getProperty("signinbutton"));
		return prop;
	}
	
}
