package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignin() {
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(driver, myStoreLogo);
	
	}
	
	public String getMyStoreTitle()
	{
		String myStoretitle=driver.getTitle();
		return myStoretitle; 
	}
	
	public SearchResultPage searchProduct(String productName)
	{
		Action.fluentWait(driver, myStoreLogo, 10);
		Action.findElement(driver, myStoreLogo);
		Action.type(searchProductBox, productName);
		Action.click(driver,searchButton);
		return new SearchResultPage();
	}
	
	
	

}
