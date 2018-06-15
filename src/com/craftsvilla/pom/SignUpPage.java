package com.craftsvilla.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class SignUpPage extends BasePage{

	public SignUpPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[text() = 'Enter Your Email']")
	private WebElement emailId;
	
	@FindBy(id = "continueBtn")
	private WebElement continue_btn;
	
	@FindBy(xpath = "//input[@id = 'set-password']")
	private WebElement pwd;
	
	//@FindBy(xpath = "//span[@class = 'term-checkbox']")
	@FindBy(className = "term-checkbox")
	private WebElement chkBox;
	
	@FindBy(xpath = "//div[text()='Register']")
	private WebElement register_btn;
	
	public void enterEmail(String eId)
	{
		verifyElementPresent(emailId);
		emailId.sendKeys(eId);
	}
	
	public void enterPassword(String passw)
	{
		verifyElementPresent(pwd);
		pwd.sendKeys(passw);
	}
	
	public void continueBtn()
	{
		verifyElementPresent(continue_btn);
		continue_btn.click();
	}
	
	public void clickChk_box()
	{
		verifyElementPresent(chkBox);
		chkBox.click();
	}
	
	public void clickRegister()
	{
		verifyElementPresent(register_btn);
		register_btn.click();
	}
}

