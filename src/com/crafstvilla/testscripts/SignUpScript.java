package com.crafstvilla.testscripts;

import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.generic.ReadExcel;
import com.craftsvilla.pom.HomePage;
import com.craftsvilla.pom.SignUpPage;

public class SignUpScript extends BaseTest {

	public HomePage hp = null;
	public SignUpPage sp = null;
	
	@Test
	public void SignUp()
	{
		hp = new HomePage(driver);
		sp = new SignUpPage(driver);
		
		String[][] credentials = ReadExcel.getData(filePath, "New_User");
		System.out.println(credentials.length);
		
		for(int i=1; i<=credentials.length ; i++)
		{
			String eId = credentials[i][0];
			String passw = credentials[i][1];
			
			hp.signUp();
			sp.enterEmail(eId);
			sp.continueBtn();
			sp.enterPassword(passw);
			sp.clickChk_box();
			sp.clickRegister();
			hp.goToAccount();
			hp.logout();
		}
	}
}
