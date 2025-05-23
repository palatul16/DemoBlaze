package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	private WebElement loginshowbtn;
	
	@FindBy(linkText="Log out")
	private WebElement logout;
	
	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement username;
	
	
	@FindBy(id = "loginpassword")
	private WebElement password;
	
	@FindBy(xpath = "(//button[@type='button' and normalize-space()='Log in' ])")
	private WebElement loginbtn;

	public WebElement getLoginshow() {
		return loginshowbtn;
	}
	public WebElement getEmailfield() {
		return username;
	}

	public WebElement getPasswordfield() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public WebElement getsuccess() {
		return logout;
	}


	 
	public WebDriver getDriver() {
		return driver;
	}
	
	

}
