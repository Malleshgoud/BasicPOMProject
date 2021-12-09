package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass
{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	
	public void logintest()
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignin();
		Action.implicitWait(driver,10);
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualurl=homePage.getCurrUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualurl, expectedUrl);
	}
	
	
	
}
