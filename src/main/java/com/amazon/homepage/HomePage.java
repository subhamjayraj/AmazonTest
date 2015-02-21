package com.amazon.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.signinpage.SignInPage;

public class HomePage {

	private final String AmazonHomeTitle = "Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	WebDriver driver;
	
	@FindBy(id="nav-your-account")	 
    WebElement signInButton ;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomePageBytitle(String title){
		if (title.equals(AmazonHomeTitle))
		   return true;
		else 
			   return false;		
	}
	
	public SignInPage ClickOnSignIn(){		
		signInButton.click();
		return new SignInPage(driver);
	}
}
