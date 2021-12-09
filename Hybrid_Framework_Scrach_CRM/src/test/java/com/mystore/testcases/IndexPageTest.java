/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author Malli
 *
 */
public class IndexPageTest extends BaseClass {

	IndexPage indexpage=new IndexPage();
	
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
	
	@Test(enabled = false)
	
	public void verifyLogo() {
		
		boolean result=indexpage.validateLogo();
		Assert.assertTrue(result);
	}
	
@Test
	
	public void verifiTitle() {
		
		String actTitle=indexpage.getMyStoreTitle();
		System.out.println("title..."+actTitle);
		Assert.assertEquals(actTitle,"My Store");
	}
	
	
}
