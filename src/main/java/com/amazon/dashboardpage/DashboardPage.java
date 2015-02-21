package com.amazon.dashboardpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	
	@FindBy(id="nav-signin-text")	 
    WebElement userNameText ;
	
	private String dashboardPageTitle= "Amazon.in - Your Account";
	
	public DashboardPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDashboardPageUserName(){
		return userNameText.getText();
	}
	
	public boolean verifyDashboardPageTitle(String title){
		if (title.equals(dashboardPageTitle))
			return true;
		else 
			return false;
	}
}
