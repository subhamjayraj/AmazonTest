package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	
	
	public void setUp(){
		System.out.println("----- inside SetUp -----");		
		Properties prop = new Properties();
	    try {
			prop.load( new FileInputStream("D:\\WORKSPACE\\latest1.0\\automation\\src\\test\\resources\\baseInput.properties") );
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	    String browser = prop.getProperty("browser");
	    if ( browser.equalsIgnoreCase("firefox")) {
	        this.driver = new FirefoxDriver();
	    }else if (browser.equalsIgnoreCase("chrome")) {	        	
	        System.setProperty("webdriver.chrome.driver", "D:\\WORKSPACE\\latest1.0\\automation\\src\\test\\resources\\chromedriver.exe");
	        this.driver = new ChromeDriver();
	    }else if (browser.equalsIgnoreCase("ie")) {	        	
	        System.setProperty("webdriver.ie.driver", "D:\\WORKSPACE\\latest1.0\\automation\\src\\test\\resources\\IEDriverServer.exe");
	        this.driver = new InternetExplorerDriver();    
	    }else {
	        driver = null; // bad choice
	    }
		
		
	    this.driver.get("https://www.amazon.in");
		System.out.println("----- outside SetUp -----");
	}
	
	
	public void  tearDown(){
		System.out.println("----- inside teraDown -----");
		this.driver.close();
		System.out.println("----- outside teraDown -----");
	}
	
}
