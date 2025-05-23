package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 

public class ShoppingCartPage {
	  WebDriver driver;

	    public ShoppingCartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(linkText = "Cart")
	    private WebElement cartLink;

	    @FindBy(xpath = "//a[normalize-space()='PRODUCT STORE']")
	    private WebElement homeLink;

	    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
	    private WebElement addToCartButton;

	    @FindBy(xpath = "//a[normalize-space()='Delete']")
	    private WebElement deleteButton;

	    // Method to select a product by name
	    public void selectProduct(String productName) {
	        driver.findElement(By.linkText(productName)).click();
	    }

	    public void addToCart() {
	        addToCartButton.click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();  
	    }

	    // Method to navigate to home page
	    public void navigateToHome() {
	        homeLink.click();
	    }

	    // Method to open cart
	    public void openCart() {
	        cartLink.click();
	    }

	    // Method to check if product is in cart
	    public boolean isProductInCart(String productName) {
	        return driver.findElements(By.xpath("//td[contains(text(), '" + productName + "')]")).size() > 0;
	    }

	    // Method to remove product from cart
	    public void removeProduct() {
	        deleteButton.click();
	    }

	    // Method to get alert message
	    public String getAlertMessage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        String message = alert.getText();
	        alert.accept();
	        return message;
	    }
}
