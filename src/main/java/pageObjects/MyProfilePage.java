package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProfilePage {
	
	public WebDriver driver;
	
	By firstname =By.id("first_name");
	By lastname =By.id("last_name");
	By displayname =By.id("display_name");
	By aboutme =By.id("description");
	By Saveprofiledetailsbtn =By.cssSelector("button[type='submit']");
	//By gravatartoggle =By.id("inspector-toggle-control-0");
	By gravatartoggle =By.xpath("//fieldset[@class='form-fieldset']/div/div/span");
	
	By Addbtn =By.xpath("//span[contains(text(),'Add')]");
	By tooltip = By.xpath("//div[@class='popover__inner']");
	By addUrl =By.xpath("//button[contains(text(),'Add URL')]");
	By addWordpresssite =By.xpath("//button[contains(text(),'Add WordPress Site')]");
	By addUrlsection =By.cssSelector("form[class='profile-links-add-other']");
	By addSitesection =By.cssSelector("form[class='profile-links-add-wordpress']");
	
	By enterURL =By.xpath("//input[@name='value']");
	By enterDesc =By.xpath("//input[@name='title']");
	By addSitebtn =By.xpath("//button[contains(text(),'Add Site')]");
	By deleteSitebtn =By.xpath("//*[@id=\"primary\"]/main/div[4]/div/ul/li/button");
	
	By selectSite =By.xpath("//ul[@class='profile-links-add-wordpress__list']/li/input");
	
	
	
	
	

	
	
	
	
	public MyProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getfirstname()
	{
		return driver.findElement(firstname);
	}
	public WebElement getlastname()
	{
		return driver.findElement(lastname);
	}
	public WebElement getdisplayname()
	{
		return driver.findElement(displayname);
	}
	
	public WebElement getaboutme()
	{
		return driver.findElement(aboutme);
	}
	
	public WebElement getprofiledetailsbtn()
	{
		return driver.findElement(Saveprofiledetailsbtn);
	}
	
	public WebElement getgravatartoggle()
	{
		return driver.findElement(gravatartoggle);
	}
	public WebElement getAddbtn()
	{
		return driver.findElement(Addbtn);
	}
	public WebElement getTooltip()
	{
		return driver.findElement(tooltip);
	}
	
	public WebElement getaddUrl()
	{
		return driver.findElement(addUrl);
	}
	public WebElement getaddWordpresssite()
	{
		return driver.findElement(addWordpresssite);
	}
	public WebElement getaddUrlsection()
	{
		return driver.findElement(addUrlsection);
	}
	public WebElement getaddSitesection()
	{
		return driver.findElement(addSitesection);
	}
	
	public WebElement getenterURL()
	{
		return driver.findElement(enterURL);
	}
	public WebElement getenterDesc()
	{
		return driver.findElement(enterDesc);
	}
	public WebElement getaddSitebtn()
	{
		return driver.findElement(addSitebtn);
	}
	public WebElement getdeleteSitebtn()
	{
		return driver.findElement(deleteSitebtn);
	}
	
	public WebElement getselectSitecheckbox()
	{
		return driver.findElement(selectSite);
	}
	
	
	
	
	public boolean verifyMyprofilepage(String fn, String ln)
	
	{		
		    
			String FN = getfirstname().getAttribute("value");
			String LN = getlastname().getAttribute("value");
			if (FN.equalsIgnoreCase(fn)&&LN.equalsIgnoreCase(ln))
			{
				return true;
			}
			else
			{
				return false;
				
			}	
		
		
	}	

public boolean verifySaveprofilebtnisEnabled()

{			

		if (getprofiledetailsbtn().isEnabled())
		{
			return true;
		}
		else
		{
			return false;
			
		}	
	
	
}
public boolean verifyTooltipisdisplayed()

{			

		if (getTooltip().isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
			
		}	
	
	
}
public boolean verifyaddUrlsectionisdisplayed()

{			

		if (getaddUrlsection().isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
			
		}	
	
	
}
public boolean verifygetaddSitesectionisdisplayed()

{			

		if (getaddSitesection().isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
			
		}	
	
	
}

public boolean verifyToggleStaus()
{			

	if (getgravatartoggle().getAttribute("class").contains("checked"))
	{
		return true;
	}
	else
	{
		return false;
		
	}

}
	

}
