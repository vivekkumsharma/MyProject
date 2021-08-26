package Assignment.WordPress;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class Logintests extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriver driver;
	
	
	//Test Case 1: Verify user is able to successfully login with valid credentials
	@Test(dataProvider="getSuccessfullogindata", priority=1)
	public void loginSuccess(String usrname, String pwd) throws IOException 
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to base URL");
		LoginPage lp = new LoginPage(driver);
		lp.getuserid().sendKeys(usrname);
		log.info("Userid entered");
		lp.getcontinuebtn().click();
		log.info("continue button clicked");
		lp.getpassword().sendKeys(pwd);
		log.info("password entered");
		lp.getcontinuebtn().click();
		log.info("continue button clicked");
		
	}
	
	//Test Case 2: Verify user is not able to login with invalid credentials
	
	@Test(dataProvider="getUnsuccessfullogindata",priority=2)
	public void loginFailure(String usrname, String pwd) throws IOException 
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to base URL");
		LoginPage lp = new LoginPage(driver);
		lp.getuserid().sendKeys(usrname);
		log.info("Userid entered");
		lp.getcontinuebtn().click();
		log.info("continue button clicked");
		lp.getpassword().sendKeys(pwd);
		log.info("password entered");
		lp.getcontinuebtn().click();
		log.info("continue button clicked");		
		Assert.assertTrue(lp.verifyalertmsg());
		log.info("Correct error message is displayed");
		
		
		
	}
	
	
	
	@BeforeMethod
	public void initialize() throws IOException 
	{	
	
	driver = initializeDriver();
	log.info("Driver initialized");
	
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
		log.info("Browser Closed");
		
	}
	
	
	@DataProvider
	public Object[][] getSuccessfullogindata()
	{
		
		Object[][] data = new Object[1][2];
		
		//valid user		
		data[0][0] = "wpdemouser1";
		data[0][1] = "Tester123$";
		
		//invalid data
		//data[1][0] = "wpdemouser2";
		//data[1][1] = "Tester123";
		
		return data;
		
				
		
	}
	
	@DataProvider
	public Object[][] getUnsuccessfullogindata()
	{
		
		Object[][] data = new Object[1][2];
		
		//valid user		
		data[0][0] = "wpdemouser1";
		data[0][1] = "invalid";		
		
		return data;
		
				
		
	}
	

}
