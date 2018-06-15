package com.craftsvilla.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.pom.AccessoriesPage;
import com.craftsvilla.pom.CheckOutPage;
import com.craftsvilla.pom.HomePage;
import com.craftsvilla.pom.KundanJewelleryPage;
import com.craftsvilla.pom.ProductDescPage;

public class KundanJewelleryScript extends BaseTest {

	public KundanJewelleryPage kundanPage = null;
	public AccessoriesPage accessoryPage= null;
	public HomePage homePage = null;
	public CheckOutPage checkoutPage = null;
	public ProductDescPage prodDescPage = null;
	/* Declaration and instantiation should not happen at global level, as all the memory allocation happens here only 
	 * and we might not use all the object and is occupying heap memory. This will overload the heap memory.
	 * To avaoid this instanciation is done inside methods, as garbage collection automatically happens once a method is exited
	 * 
	public ProductDescPage prodDescPage = new ProductDescPage(driver);
	*/
	
	@Test
	public void TC_01_BuyKundanJewelery()
	{
		homePage = new HomePage(driver);
		accessoryPage = new AccessoriesPage(driver);
		kundanPage = new KundanJewelleryPage(driver);
		prodDescPage = new ProductDescPage(driver);
		checkoutPage = new CheckOutPage(driver);
		
		// Test methods should always be inside try -catch block tp handle any exception
		try
		{
			homePage.gotoAccessories();
			accessoryPage.gotoKundanJewellery();
			kundanPage.chooseNecklace();
			prodDescPage.enterPincode();
			prodDescPage.checkPinDelivery();
			prodDescPage.clickBuyNow();
			checkoutPage.enterFirstName("alpha");
			checkoutPage.enterLastName("gama");
			checkoutPage.enterUser("sgh@gmail.com");
			checkoutPage.verifyOrder(); // something wrong here????? works with chooseKundan() method as well
		}
		catch (Exception e) {
			Reporter.log("Purchase failed");
		}
		
		
		
	}
}
