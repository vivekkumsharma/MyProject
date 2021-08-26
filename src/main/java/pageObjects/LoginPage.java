package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By userid =By.id("usernameOrEmail");
	By continuebtn = By.xpath("//button[@type='submit']");
	By password =By.id("password");
	By alert = By.cssSelector("div[role='alert']");
	String expectedAlert = "Oops, that's not the right password. Please try again!";
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getuserid()
	{
		return driver.findElement(userid);
	}
	
	public WebElement getcontinuebtn()
	{
		return driver.findElement(continuebtn);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getalert()
	{
		return driver.findElement(alert);
	}
	
	public boolean verifyalertmsg()
	
	{			
			WebElement alertmsg = getalert();
			String actualAlert = alertmsg.getText();		
			if (actualAlert.equalsIgnoreCase(expectedAlert))
			{
				return true;
			}
			else
			{
				return false;
				
			}	
		
		
	}	

}
