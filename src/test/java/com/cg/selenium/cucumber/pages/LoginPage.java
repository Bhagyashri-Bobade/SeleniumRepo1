package com.cg.selenium.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement name;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement pass;
	
	@FindBy(xpath="//button[@id='login']")
	public WebElement login;
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	 
	
	public void enterUsername(String username)
	{
		name.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		pass.sendKeys(password);
	}
	public void login()
	{
		login.click();
	}

}
