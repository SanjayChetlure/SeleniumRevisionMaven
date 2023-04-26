package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy(xpath="//input[@class='input_error form_input']") private WebElement UN;  //private WebElement UN=driver.findElement(By.xpath(""))
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement PWD;     //private WebElement PWD=driver.findElement(By.xpath(""))
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;    //private WebElement loginBtn=driver.findElement(By.xpath(""))
	
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpSwagLabLoginPageUsername(String username) 
	{
		UN.sendKeys(username);
	}
	
	public void inpSwagLabLoginPagePassword(String password) 
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwagLabLoginPageLoginBtn()
	{
		loginBtn.click();
	}
}
