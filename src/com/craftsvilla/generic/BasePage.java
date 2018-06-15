package com.craftsvilla.generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	
	public static WebDriver driver = null;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verfiyTitle(String exp_title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleContains(exp_title));
			String act_title = driver.getTitle();
			Assert.assertEquals(act_title, exp_title);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(exp_title + "not found. Failed to load page");
		}
	}

	public void verifyElementPresent(WebElement wElem)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(wElem));
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void mouseHover(WebDriver driver, WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Unable to mouse Hover");
		}
	}
	
	public void handleAlert()
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("No Alerts found to switch");
		}
	}
	
	public void handleDropdown(WebElement driver, int index)
	{
		try
		{
			Select osel = new Select(driver);
			osel.selectByIndex(index);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Reporter.log("Option selected");
		}
		
		
	}
	
	public void handleDropdown(WebElement driver, String option)
	{
		try
		{
			Select osel = new Select(driver);
			osel.selectByValue(option);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Reporter.log("Option selected");
		}
		
		
	}
	
}
