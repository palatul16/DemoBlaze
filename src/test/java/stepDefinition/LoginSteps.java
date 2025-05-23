package stepDefinition;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import demoblaze.utils.Base;
import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;
    LoginPage login;

    public LoginSteps() throws IOException {
        Base base = new Base();  
        this.driver = base.driver;  
        login = new LoginPage(driver);  
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws IOException {
        driver.get(Base.prop("url"));  
        login.getLoginshow().click();   
    }

    @When("I enter a valid email and password")
    public void iEnterValidEmailAndPassword() throws IOException {
        login.getEmailfield().sendKeys("vikas@gmail.com");
        login.getPasswordfield().sendKeys("12345" );
    }

    @When("I enter a valid email and an invalid password")
    public void iEnterValidEmailAndInvalidPassword() {
        login.getEmailfield().sendKeys( "atul@gmail");
        login.getPasswordfield().sendKeys("siudf");
    }

    @When("I enter an invalid email and a valid password")
    public void iEnterInvalidEmailAndValidPassword() {
        login.getEmailfield().sendKeys("rydf@example.com");
        login.getPasswordfield().sendKeys( "12345");
    }

    @When("I leave the email and password fields empty")
    public void iLeaveEmailAndPasswordFieldsEmpty() {
        login.getEmailfield().clear();
        login.getPasswordfield().clear();
    }

    @And("I click the login button")
    public void iClickOnTheLoginButton() {
        login.getLoginbtn().click();
    }

    @Then("I should see the \"Log out\" button")
    public void iShouldSeeTheLogOutButton() {
        Assert.assertTrue("Login failed!", login.getsuccess().isDisplayed());
    }

    @Then("I should see an alert message {string}")
    public void iShouldSeeAnAlertMessage(String expectedMessage) {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        Assert.assertEquals("Alert message mismatch!", expectedMessage, alertMessage);
    }
}
