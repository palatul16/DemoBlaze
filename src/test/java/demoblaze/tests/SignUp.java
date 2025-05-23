package demoblaze.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import demoblaze.utils.Base;
import demoblaze.utils.JavaUtility;
import pages.SignUpPage;

public class SignUp extends Base {
	
	@Test(priority = 1)
	public void SignUpWithValidDetails() throws IOException, InterruptedException {
	    SignUpPage signUp = new SignUpPage(driver);
	    signUp.getSignUpLink().click();
	    signUp.getUsernameField().sendKeys(JavaUtility.getNewUser());
	    signUp.getPasswordfield().sendKeys(prop("password"));
	    signUp.getSignUpButton().click();

	    String mess = JavaUtils.popup(driver);
	    System.out.println(mess);
	    // Assertion: Verify alert message
	    Assert.assertTrue(mess.contains(mess), "Alert message verification failed! Expected  " + mess);
	    
	}
	
	@Test(priority = 2)
	public void SignUpWithExistingUsername() throws IOException, InterruptedException {
	    SignUpPage signUp = new SignUpPage(driver);
	    signUp.getSignUpLink().click();
	    signUp.getUsernameField().sendKeys(prop("userName"));  
	    signUp.getPasswordfield().sendKeys(prop("password"));
	    signUp.getSignUpButton().click();

	    String mess = JavaUtils.popup(driver);
	    System.out.println(mess);
	    // Assertion: Verify alert message
	    Assert.assertTrue(mess.contains(mess), "Alert message verification failed! Expected  " + mess);
	}
	
	@Test(priority = 3)
	public void SignUpWithEmptyUsername() throws IOException, InterruptedException {
	    SignUpPage signUp = new SignUpPage(driver);
	    signUp.getSignUpLink().click();
	    signUp.getUsernameField().sendKeys(""); 
	    signUp.getPasswordfield().sendKeys("12345");
	    signUp.getSignUpButton().click();

	    // Handle alert

	    String mess = JavaUtils.popup(driver);
	    System.out.println(mess);
	    // Assertion: Verify alert message
	    Assert.assertTrue(mess.contains(mess), "Alert message verification failed! Expected  " + mess);
	}
	
	@Test(priority = 4)
	public void SignUpWithEmptyPassword() throws IOException, InterruptedException {
	    SignUpPage signUp = new SignUpPage(driver);
	    signUp.getSignUpLink().click();
	    signUp.getUsernameField().sendKeys(JavaUtility.getNewUser());
	    signUp.getPasswordfield().sendKeys(""); // Leave password empty
	    signUp.getSignUpButton().click();

	    String mess = JavaUtils.popup(driver);
	    System.out.println(mess);
	    // Assertion: Verify alert message
	    Assert.assertTrue(mess.contains(mess), "Alert message verification failed! Expected  " + mess);
 	}

	@Test(priority = 5)
	public void SignUpWithEmptyFields() throws IOException, InterruptedException {
	    SignUpPage signUp = new SignUpPage(driver);
	    signUp.getSignUpLink().click();
	    signUp.getUsernameField().sendKeys("");  
	    signUp.getPasswordfield().sendKeys("");
	    signUp.getSignUpButton().click();

	    String mess = JavaUtils.popup(driver);
	    System.out.println(mess);
	    // Assertion: Verify alert message
	    Assert.assertTrue(mess.contains(mess), "Alert message verification failed! Expected  " + mess);
	}

}
