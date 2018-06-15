package com.craftsvilla.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class KundanJewelleryPage extends BasePage 
{

	public KundanJewelleryPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src = 'https://img3.craftsvilla.com/image/upload/w_300,h_450,c_lfill,f_auto/C/V/CV-MSATY81858797240--Satyam_Jewellery_NX_-Craftsvilla_1.jpg']")
	private WebElement kundan;
	
	@FindBy(xpath = "//img[@src = 'https://img3.craftsvilla.com/image/upload/w_300,h_450,c_lfill,f_auto/C/V/CV-MSUKK39716402640--Sukkhi_Fashion-Craftsvilla_1.jpg']")
	private WebElement necklace;
	
	public void chooseKundan()
	{
		verifyElementPresent(kundan);
		kundan.click();
	}

	public void chooseNecklace()
	{
		verifyElementPresent(necklace);
		necklace.click();
	}


}
