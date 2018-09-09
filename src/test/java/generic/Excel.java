package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Excel 
{
	public static String getData(String path,String key)
	{
		String data="";
		Properties p=new Properties();
		try
		{
			p.load(new FileInputStream(path));
			data=p.getProperty(key);
		}
		catch(Exception e)
		{
			Reporter.log("data file path is invalid "+e,true);
			Assert.fail();
		}
		return data;
	}
	
	public static String getExcel(String path,String sheet,int row,int cell)
	{
		String value="";
		try 
		{
		   FileInputStream fis=new FileInputStream(path);
		   Workbook wb= WorkbookFactory.create(fis);
		   Sheet sh=wb.getSheet(sheet);
		   Row r=sh.getRow(row);
		   Cell c=r.getCell(cell);
		   value=c.toString();
		} catch (Exception e) 
		{
			Reporter.log("excel path is invalid "+e,true);
			Assert.fail();
		}
		return value;
	}

}
