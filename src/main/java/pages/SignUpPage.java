package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class SignUpPage {
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(linkText = "Sign up")
	private WebElement signUpLink;
	

	@FindBy(id = "sign-username")
	private WebElement usernameField;
	
	@FindBy(id="sign-password")
	private WebElement passwordField;
	
	
	@FindBy(xpath = "//button[@type='button' and normalize-space() = 'Sign up']")
	private WebElement signUpButton;
	
	
	public WebElement getSignUpLink() {
		return signUpLink;
	}
	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordfield() {
		return passwordField;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}
	
	

	    // Complete Sign Up process
	   
}
