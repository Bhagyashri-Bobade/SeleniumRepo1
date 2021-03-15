package com.cg.selenium.cucumber.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.selenium.cucumber.pages.HomePage;
import com.cg.selenium.cucumber.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

	WebDriver driver;
	
	LoginPage loginpage;
	HomePage homePage;

	@Before
	public void setenv()
	{
		System.out.println("inside setenv meth");
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\ChromeDriver\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void teardown()
	{
		System.out.println("I am inside tear down");
		driver.close();
		driver.quit();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {

		//System.setProperty("webdriver.chrome.driver","C:\\Softwares\\ChromeDriver\\chromedriver.exe"); 
		//driver = new ChromeDriver();
		
		driver.navigate().to("https://example.testproject.io/web");
		//driver.manage().window().maximize();


	}
	
	//@When("user enters <username> and <password>") [didn work]
	//@When("^user enters ([^\"]*) and ([^\"]*)$")
	//@When("user enters {string} and {string}") [single set of data]
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		
		  loginpage = new LoginPage(driver);
		  loginpage.enterUsername(username);
		  loginpage.enterPassword(password);
		 //loginpage.name.sendKeys("raghav");
		 //loginpage.pass.sendKeys("12345");
		 
		//driver.findElement(By.id("name")).sendKeys(username);
		//driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		loginpage.login();
	    
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
	   homePage = new HomePage(driver);
	   homePage.logout();
	   System.out.println("logout");
	}

	

}
