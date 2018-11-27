package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefination {
	
	
	WebDriver driver;
	
	@Given("^User is on login Page$")
	public void user_is_on_login_Page() throws Throwable {
	   
	     driver= new FirefoxDriver();
		driver.get("D:\\Practice\\SpringWebServices\\HotelBookingDemo\\login.html");
		System.out.println("page loaded in browser");
	}

	@When("^Username Password is blank$")
	public void username_Password_is_blank() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  WebElement userNameTxt=driver.findElement(By.name("userName"));
	  userNameTxt.sendKeys("");
	  
	  WebElement loginBtn=driver.findElement(By.className("btn"));
	  loginBtn.click();
	  
	  
	}

	@Then("^Dispay Error Message 'Please enter Username'$")
	public void dispay_Error_Message_Please_enter_Username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement divEle=driver.findElement(By.id("userErrMsg"));
		String actualErrorMessage= divEle.getText();
		String expErrorMsg="* Please enter userName.";
		Assert.assertEquals(expErrorMsg,actualErrorMessage);
	    
	}



}
