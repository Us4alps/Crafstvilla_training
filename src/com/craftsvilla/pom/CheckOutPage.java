package com.craftsvilla.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.craftsvilla.generic.BasePage;

public class CheckOutPage extends BasePage{

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id = 'address-email']")
	private WebElement email;
	
	@FindBy(xpath = "//label[text() = 'First Name']")
	private WebElement fname;
	
	@FindBy(xpath = "//label[text() = 'Last Name']")
	private WebElement lname;
	
	@FindBy(xpath = "//p[@class = 'pure-u-20-24 order-details product-name ellipsis  ']")
	private WebElement orderCheck;
	
	public void enterUser(String usr)
	{
		verifyElementPresent(email);
		email.sendKeys(usr);
	}
	
	public void enterFirstName(String fn)
	{
		verifyElementPresent(fname);
		fname.sendKeys(fn);
	}
	
	public void enterLastName(String ln)
	{
		verifyElementPresent(lname);
		lname.sendKeys(ln);
	}
	
	public void verifyOrder()
	{
		verifyElementPresent(orderCheck);
		String exp_order = "Craftsvilla Angelic Ten String Gold Plated Kundan Necklace Set For Women ";
		String act_order = orderCheck.getText();
		Assert.assertEquals(act_order, exp_order);
		System.out.println("Checkout order exists");
	}
	
}
