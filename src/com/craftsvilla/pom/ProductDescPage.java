package com.craftsvilla.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.craftsvilla.generic.BasePage;

public class ProductDescPage extends BasePage
{
	public ProductDescPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id ='pincode_value']")
	private WebElement pincode;
	
	@FindBy(xpath = "//span[text() = 'Check']")
	private WebElement pinDelivery;
	
	@FindBy(xpath = "//h1[contains(text(),'Angelic Ten String Gold Plated Kundan')]")
	private WebElement productName;
	
	@FindBy(id = "buynow")
	private WebElement buy_now;
	
	@FindBy(xpath = "//span[text() = 'Add to Cart']")
	private WebElement addToCart;
	
	public void enterPincode()
	{
		verifyElementPresent(pincode);
		pincode.sendKeys("95020");
	}
	
	public void checkPinDelivery()
	{
		verifyElementPresent(pinDelivery);
		pincode.click();
	}
	
	public void verifyProductName()
	{
		verifyElementPresent(productName);
		String exp_product = "Craftsvilla Angelic Ten String Gold Plated Kundan Necklace Set For Women\r\n" + 
				"								";
		String prdName = productName.getText();
		Assert.assertEquals(prdName, exp_product);
		
	}
	
	public void clickBuyNow()
	{
		verifyElementPresent(buy_now);
		buy_now.click();
	}
	
	public void additionToCart()
	{
		verifyElementPresent(addToCart);
		addToCart.click();
	}
}
