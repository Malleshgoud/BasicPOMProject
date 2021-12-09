/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Malli
 *
 */
public class AccountCreationPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;

@BeforeMethod
	
	public void setup()
	{
		launchApp();
	}
	

	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	
	public void verifyCreateAccountPage() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignin();
		accountCreationPage=loginPage.createNewAccount("testemail@xyz.com");
		boolean verifyaccountname=accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(verifyaccountname);
	}
	
}
