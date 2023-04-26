package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class SwagLabHomePage 
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement header;
	@FindBy(xpath="//div[@class='bm-burger-button']") private WebElement openMenu;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement filter;
	
	
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getSwagLabHomePageHeader()
	{
		 String actResult = header.getText();
		 return actResult;
	}
	
	public void clickSwagLabHomePageOpenMenu()
	{
		 openMenu.click();
	}
	
	
	public void selectSwagLabHomePageFilter()
	{		
		UtilityClass.selectOption(filter, 1);
	}

}
