
package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CheckoutPage {

WebDriver driver;


	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	private WebElement placeOrderButton;

	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "country")
	private WebElement countryField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "card")
	private WebElement creditCardField;

	@FindBy(id = "month")
	private WebElement monthField;

	@FindBy(id = "year")
	private WebElement yearField;

	@FindBy(xpath = "//button[normalize-space()='Purchase']")
	private WebElement purchaseButton;

	@FindBy(xpath = "//div[contains(@class,'showSweetAlert visible')]")
	private WebElement successMessage;

	// Method to click "Place Order"
	public void clickPlaceOrder() {
	    placeOrderButton.click();
	}

	// Method to fill checkout details
	public void fillCheckoutDetails(String name, String country, String city, String card, String month, String year) {
	    nameField.sendKeys(name);
	    countryField.sendKeys(country);
	    cityField.sendKeys(city);
	    creditCardField.sendKeys(card);
	    monthField.sendKeys(month);
	    yearField.sendKeys(year);
	}

	// Method to complete purchase
	public void completePurchase() {
	    purchaseButton.click();
	}

	// Method to verify order success
	public boolean isOrderSuccessful() {
	    return successMessage.isDisplayed();
	}
	
	 public String isErrorMessageDisplayed() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        String message = alert.getText();
	        alert.accept();
	        return message;
	    }

}
