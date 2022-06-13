package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase 
{
	public static WebDriver driver;
	public static String appURL = "http://damp-sands-8561.herokuapp.com/";
	
	@BeforeTest
	public static void launchApplication()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
		
	}
	
	@AfterTest
	public static void closeApp()
	{
		driver.close();
	}

}
