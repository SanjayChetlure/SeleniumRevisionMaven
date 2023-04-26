package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabOpenMenuPage;

public class SwagLabLoginTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	int TCID;

		
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{	
	    initializeBrowser();
		
		 login=new SwagLabLoginPage(driver);
		 home=new SwagLabHomePage(driver);
		 menu=new SwagLabOpenMenuPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(2000);
		login.inpSwagLabLoginPageUsername(UtilityClass.getPFData("UN"));
		login.inpSwagLabLoginPagePassword(UtilityClass.getPFData("PWD"));
		login.clickSwagLabLoginPageLoginBtn();	
	}
	
	@Test(priority = 1)
	public void verifyHeader() throws EncryptedDocumentException, IOException 
	{		
		TCID=101;
		String actResult = home.getSwagLabHomePageHeader();
		String expResult=UtilityClass.getTD(0, 2);
		Assert.assertEquals(actResult, expResult,"Failed: both results are diff- ");
	}
		
	
	@Test(priority = 2)
	public void selectOptionFromFilter() throws EncryptedDocumentException, IOException 
	{		
		TCID=102;
		home.selectSwagLabHomePageFilter();
	}
	

	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
		
		Thread.sleep(2000);
		home.clickSwagLabHomePageOpenMenu();
		Thread.sleep(2000);
		menu.clickSwagLabOpenMenuPageLogoutBtn();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
