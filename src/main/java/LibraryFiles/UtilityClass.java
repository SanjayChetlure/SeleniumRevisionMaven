package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass
{
	
	public static String getTD(int rowIndex, int colInex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\workspaceFor28thJan23\\SeleniumRevisionMaven\\TestData\\RevisionSession.xlsx");
	    Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colInex).getStringCellValue();
		return value;
	}
	
	
	public static void selectOption(WebElement ele, int index) 
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	public static void selectOptionText(WebElement ele, String visibleText) 
	{
		Select s=new Select(ele);
		s.selectByVisibleText(visibleText);
	}
	
	
	public static void selectOptionValue(WebElement ele, String value) 
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	
	public static void captureSS(WebDriver driver,int TestCaseID) throws IOException 
	{
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest=new File("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\workspaceFor28thJan23\\SeleniumRevisionMaven\\FailedTCesSS\\TCID"+TestCaseID+ ".jpg");
		 FileHandler.copy(src, dest);
	}
	
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\workspaceFor28thJan23\\SeleniumRevisionMaven\\propertyFile.properties");
	
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
	}
	
	

}
