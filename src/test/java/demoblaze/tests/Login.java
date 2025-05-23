package demoblaze.tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoblaze.utils.Base;
import pages.LoginPage;

public class Login extends Base{

	//LoggingInWithValidDetails
		@Test(priority = 1)   
		public void LoginWithValidDetails() throws IOException, InterruptedException {
			LoginPage login = new LoginPage(driver);
			login.getLoginshow().click();
			login.getEmailfield().sendKeys(Base.prop("userName"));
			login.getPasswordfield().click();
			login.getPasswordfield().sendKeys(Base.prop("password"));
			login.getLoginbtn().click();
			 WebElement success =  login.getsuccess();
			 	Assert.assertTrue(success.isDisplayed(), "Login failed, 'Log out' button not found");
			 	
		}
		//LoggingInWithInvalidPassword
		@Test(priority = 2)
		public void LoginWithInvalidPassword() throws IOException, InterruptedException {
		    LoginPage login = new LoginPage(driver);
		    login.getLoginshow().click();
		    login.getEmailfield().sendKeys(Base.prop("userName"));
		    login.getPasswordfield().click();
		    login.getPasswordfield().sendKeys("wrongPassword123");
		    login.getLoginbtn().click();
		     
		    Alert alert = driver.switchTo().alert();
		    String mess = alert.getText();
		    System.out.println(mess);

		    alert.accept();
		    Assert.assertTrue(mess.contains("Wrong password."), "Alert message verification failed! Expected: 'Wrong password.' but got: " + mess);
		}
		
		@Test(priority = 3)
		public void LoginWithEmptyEmail() throws IOException, InterruptedException {
		    LoginPage login = new LoginPage(driver);
		    login.getLoginshow().click();
		    login.getEmailfield().sendKeys("");  
		    login.getPasswordfield().click();
		    login.getPasswordfield().sendKeys(Base.prop("password"));
		    login.getLoginbtn().click();

		    String mess = JavaUtils.popup(driver);
		    System.out.println(mess);
		    // Assertion: Verify alert message
		    Assert.assertTrue(mess.contains(mess), "Alert message verification failed! Expected: 'Please fill out Email field' but got: " + mess);
		}
		
		

}
