package Assignment.WordPress;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyProfilePage;
import resources.base;

public class Myprofiletests extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriver driver;
	
	
	
	//Test Case 3: Verify My profile page is successfully loaded with correct first and last name
	@Test(dataProvider="getPageloaddata", priority=1)
	public void verifymyProfilepageload(String usrname, String pwd,String firstname, String lastname) throws IOException 
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
		
		MyProfilePage my = new MyProfilePage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Assert.assertTrue(my.verifyMyprofilepage(firstname, lastname));
		log.info("My profile page is successfully loaded with first and last name");
		
	}
	
	//Test Case 4: Verify User is able to update "Public display name" and "About me" on My profile page
	@Test(dataProvider="getDisplayNameandAboutMedata",priority=2)
	public void updateDisplaynameandaboutme(String usrname, String pwd,String displayname, String aboutme) throws IOException 
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
		MyProfilePage my = new MyProfilePage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		my.getdisplayname().clear();
		my.getdisplayname().sendKeys(displayname);
		log.info("Display name entered");
		my.getaboutme().clear();
		my.getaboutme().sendKeys(aboutme);
		log.info("About me description entered");
		my.getprofiledetailsbtn().click();
		log.info("Save Profile detail button clicked");
		
	}
	
	//Test Case 5: Verify Save profile detail button is disabled on My profile page load
		@Test(dataProvider="getDiabledSaveprofiledetailbutton",priority=3)
		public void verifydiabledSaveprofiledetailbutton(String usrname, String pwd) throws IOException 
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
			
			MyProfilePage my = new MyProfilePage(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			Assert.assertFalse(my.verifySaveprofilebtnisEnabled());	
			log.info("Save profile detail button is disabled");
			
			
		}
		
	//Test Case 6: Verify Save profile detail button is enabled on My profile page load when fields are edited.
		@Test(dataProvider="getenabledSaveprofiledetailbutton", priority=4)
		public void verifyenabledSaveprofiledetailbutton(String usrname, String pwd,String displayname, String aboutme) throws IOException 
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
			MyProfilePage my = new MyProfilePage(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			my.getdisplayname().clear();
			my.getdisplayname().sendKeys(displayname);
			log.info("Display name entered");
			my.getaboutme().clear();
			my.getaboutme().sendKeys(aboutme);
			log.info("About me description entered");
			driver.switchTo().activeElement().sendKeys(Keys.TAB);			
			Assert.assertTrue(my.verifySaveprofilebtnisEnabled());	
			log.info("Save profile detail button is enabled");
			my.getprofiledetailsbtn().click();
			log.info("Save Profile detail button clicked");
			
		}
		
		
		//Test Case 7: Verify user is able to Add URL
		@Test(dataProvider="getUrl", priority=5)
		public void addUrl(String usrname, String pwd,String url, String desc) throws IOException 
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
			
			MyProfilePage my = new MyProfilePage(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);			
			my.getAddbtn().click();
			log.info("Add button is clicked to add URL");
			Assert.assertTrue(my.verifyTooltipisdisplayed());
			log.info("Tool tip is displayed");
			my.getaddUrl().click();
			log.info("Add URL is clicked from tool tip");
			Assert.assertTrue(my.verifyaddUrlsectionisdisplayed());
			log.info("Add URL section is displayed");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			my.getenterURL().sendKeys(url);
			log.info("URL Entered");
			my.getenterDesc().sendKeys(desc);
			log.info("Description entered");
			my.getaddSitebtn().click();
			log.info("Add Site button is clicked");
			
			
			
		}
		//Test Case 8: Verify user is able to delete URL
				@Test(dataProvider="getUrl", priority=6)
				public void deleteUrl(String usrname, String pwd,String url, String desc) throws IOException 
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
					
					MyProfilePage my = new MyProfilePage(driver);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
					my.getdeleteSitebtn().click();
					log.info("URL is deleted");
					
					
					
					
				}
				
			//Test Case 9: Verify user is able to Add Site
				@Test(dataProvider="getUrl", priority=7)
				public void addSite(String usrname, String pwd,String url, String desc) throws IOException 
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
					
					MyProfilePage my = new MyProfilePage(driver);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);			
					my.getAddbtn().click();
					log.info("Add button is clicked to add URL");
					Assert.assertTrue(my.verifyTooltipisdisplayed());
					log.info("Tool tip is displayed");
					my.getaddWordpresssite().click();
					log.info("Add Word press site is clicked from tool tip");
					Assert.assertTrue(my.verifygetaddSitesectionisdisplayed());
					log.info("Add Site section is displayed");
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
					my.getselectSitecheckbox().click();
					log.info("Add Site checkbox is clicked");
					my.getaddSitebtn().click();
					log.info("Add Site button is clicked");			
					
					
					
				}
				
				//Test Case 10: Verify user is able to Add Site
				@Test(dataProvider="getUrl", priority=8)
				public void deleteSite(String usrname, String pwd,String url, String desc) throws IOException 
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
					
					MyProfilePage my = new MyProfilePage(driver);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
					my.getdeleteSitebtn().click();
					log.info("Site is deleted");
					
					
					
				}
				
				//Test Case 11: Verify Toggle Status on My Profile page load
				@Test(dataProvider="getPageloaddata", priority=9)
				public void verifyToggleonmyProfilepageload(String usrname, String pwd,String firstname, String lastname) throws IOException, InterruptedException 
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
					
					MyProfilePage my = new MyProfilePage(driver);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
					Assert.assertFalse(my.verifyToggleStaus());	
					log.info("gravatar toggle is disabled on page load");
					
					my.getgravatartoggle().click();	
					log.info("gravatar toggle is clicked");
					
					Assert.assertTrue(my.verifyToggleStaus());
					log.info("gravatar toggle is enabled");
					
					my.getgravatartoggle().click();
					log.info("gravatar toggle is clicked");
					
					
				}
		
		@DataProvider
		public Object[][] getUrl()
		{
			
			Object[][] data = new Object[1][4];		
					
			data[0][0] = "wpdemouser1";
			data[0][1] = "Tester123$";	
			data[0][2] = "www.test.com";
			data[0][3] = "Test";
			
			return data;
					
			
		}
		
		
		@DataProvider
		public Object[][] getDiabledSaveprofiledetailbutton()
		{
			
			Object[][] data = new Object[1][2];		
					
			data[0][0] = "wpdemouser1";
			data[0][1] = "Tester123$";	
			
			
			return data;
					
			
		}
	
	
	@DataProvider
	public Object[][] getenabledSaveprofiledetailbutton()
	{
		
		Object[][] data = new Object[1][4];		
				
		data[0][0] = "wpdemouser1";
		data[0][1] = "Tester123$";	
		data[0][2] = "wpdemouser1 Updated";
		data[0][3] = "Word Press about Me Updated";
		
		return data;
				
		
	}
	@DataProvider
	public Object[][] getDisplayNameandAboutMedata()
	{
		
		Object[][] data = new Object[1][4];		
				
		data[0][0] = "wpdemouser1";
		data[0][1] = "Tester123$";	
		data[0][2] = "wpdemouser1";
		data[0][3] = "Word Press about Me";
		
		return data;
				
		
	}
	@DataProvider
	public Object[][] getPageloaddata()
	{
		
		Object[][] data = new Object[1][4];		
				
		data[0][0] = "wpdemouser1";
		data[0][1] = "Tester123$";	
		data[0][2] = "Vivek";
		data[0][3] = "Sharma";
		
		return data;
				
		
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
	

}
