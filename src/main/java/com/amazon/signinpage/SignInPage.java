package com.amazon.signinpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.dashboardpage.DashboardPage;

public class SignInPage {

	WebDriver driver;
	
	@FindBy(id="ap_email")	 
    WebElement emailTextField ;
	
	@FindBy(id="ap_password")	 
    WebElement passwordTextField ;
	
	@FindBy(id="signInSubmit-input")	 
    WebElement signInSubmit ;
	
	public SignInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String strEmail){	 
		emailTextField.sendKeys(strEmail);
	}
	
    public void setPassword(String strPassword){
    	passwordTextField.sendKeys(strPassword);		
	}
    
    public void clickSignIn(){
    	signInSubmit.click();		
	}
    
    public String getSighInPageTitle(){
		return driver.getTitle();
    	
    }
    
    public DashboardPage loginToAmazon(String email,String pwd){
    	this.setEmail(email);
    	this.setPassword(pwd);
    	this.clickSignIn();
		return new DashboardPage(driver);
    }
}
