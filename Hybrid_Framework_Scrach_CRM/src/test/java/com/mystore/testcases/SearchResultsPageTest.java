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
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Malli
 *
 */
public class SearchResultsPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;

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
	public void productAvailabityTest() throws Throwable
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
	
		boolean results=searchResultPage.isProductAvailable();
		Assert.assertTrue(results);
		
		
	}

}
