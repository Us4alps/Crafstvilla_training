package com.craftsvilla.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class HomePage extends BasePage {

	//Declaration
	@FindBy(xpath = "//a[text() = 'ACCESSORIES ']")
	private WebElement accessories;
	
	@FindBy(xpath = "//span[text() = 'Sign In']")
	private WebElement signIn;
	
	@FindBy(linkText = "CRAFTSVILLA BRANDS")
	private WebElement craftsvillaBrands;
	
	@FindBy(xpath = "//i[@class='icon first_arrow hidden-xs']")
	private WebElement account;
	
	@FindBy(xpath = "//i[@class='icon logout']")
	private WebElement logout;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void gotoAccessories()
	{
		verifyElementPresent(accessories);
		mouseHover(driver, accessories);
	}
	
	public void gotoCraftsvillabrands()
	{
		verifyElementPresent(craftsvillaBrands);
		mouseHover(driver, craftsvillaBrands);
	}
	
	public void signUp()
	{
		verifyElementPresent(signIn);
		signIn.click();
	}
	
	public void goToAccount()
	{
		verifyElementPresent(account);
		mouseHover(driver, account);
	}

	public void logout()
	{
		verifyElementPresent(logout);
		logout.click();
	}
	
}
