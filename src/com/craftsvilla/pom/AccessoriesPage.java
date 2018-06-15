package com.craftsvilla.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class AccessoriesPage extends BasePage  //extending as we want to use the base class methods and add more methods to this class
{

	public AccessoriesPage(WebDriver driver)
	{
		super(driver); // calls parent class constructor (basePage constructor)
		PageFactory.initElements(driver, this); // ????????
	}
	
	@FindBy(linkText = "Kundan Jewellery")
	private WebElement kundanJewellery;
	
	@FindBy(xpath = "//a[text() = 'Watches']")
	private WebElement watches;
	
	@FindBy(linkText = "Temple Jewellery")
	private WebElement templeJewellery;
	
	@FindBy(linkText = "Pendants")
	private WebElement pendants;
	
	public void gotoKundanJewellery()
	{
		verifyElementPresent(kundanJewellery);
		kundanJewellery.click();
	}
	
	public void gotoWatches()
	{
		verifyElementPresent(watches);
		watches.click();
	}
	
	public void gotoTempleJewellery()
	{
		verifyElementPresent(templeJewellery);
		templeJewellery.click();
	}
	
	public void gotoPendants()
	{
		verifyElementPresent(pendants);
		pendants.click();
	}
}
