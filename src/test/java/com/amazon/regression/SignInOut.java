package com.amazon.regression;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

import com.amazon.base.Base;
import com.amazon.dashboardpage.DashboardPage;
import com.amazon.homepage.HomePage;

public class SignInOut extends Base {
  
  @BeforeTest
  public void beforeTest() {
	  setUp();
  }

  @Test
  public void f() {		  
	  HomePage homepage = new HomePage(driver);
	      Assert.assertTrue(homepage.verifyHomePageBytitle(driver.getTitle()), "Home page is not opened correctly");
	  DashboardPage dashboardpage= homepage.ClickOnSignIn().loginToAmazon("subhamjayraj@gmail.com", "escort335tag");	  
	      Assert.assertTrue(dashboardpage.verifyDashboardPageTitle(driver.getTitle()), "Dashboard page is not opened correctly");
  }
  

@AfterTest
  public void afterTest() {
	  tearDown();
  }  

}
