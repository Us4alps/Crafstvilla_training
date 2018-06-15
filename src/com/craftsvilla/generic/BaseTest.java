package com.craftsvilla.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements AutoConst {
	
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	@BeforeMethod
	public void OpenApp()
	{
		System.setProperty(chrome_key, chrome_value);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.craftsvilla.com/");		
	}
	
	@AfterMethod
	public void CloseApp()
	{
		driver.quit();
	}
	
	

}
