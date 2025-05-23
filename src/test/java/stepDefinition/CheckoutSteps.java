package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import demoblaze.utils.Base;
import io.cucumber.java.en.*;
import pages.CheckoutPage;
import pages.ShoppingCartPage;

public class CheckoutSteps {

	  
    private WebDriver driver = Base.driver;
    private ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
    private CheckoutPage checkout = new CheckoutPage(driver);

    @Given("I add {string} to the cart")
    public void i_add_product_to_the_cart(String productName) {
        shoppingCart.selectProduct(productName);
        shoppingCart.addToCart();
        shoppingCart.openCart();
    }

    @Given("I add multiple products {string} and {string} to the cart")
    public void i_add_multiple_products_to_the_cart(String product1, String product2) {
        shoppingCart.selectProduct(product1);
        shoppingCart.addToCart();
        shoppingCart.navigateToHome();
        shoppingCart.selectProduct(product2);
        shoppingCart.addToCart();
        shoppingCart.openCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        checkout.clickPlaceOrder();
    }

    @When("I enter valid details {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_enter_valid_checkout_details(String name, String country, String city, String card, String month, String year) {
        checkout.fillCheckoutDetails(name, country, city, card, month, year);
    }

    @When("I enter invalid card details {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_enter_invalid_card_details(String name, String country, String city, String card, String month, String year) {
        checkout.fillCheckoutDetails(name, country, city, card, month, year);
    }

    @When("I enter expired card details {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_enter_expired_card_details(String name, String country, String city, String card, String month, String year) {
        checkout.fillCheckoutDetails(name, country, city, card, month, year);
    }

    @When("I confirm the purchase")
    public void i_confirm_the_purchase() {
        checkout.completePurchase();
    }

    @Then("the order should be completed successfully")
    public void the_order_should_be_completed_successfully() {
        Assert.assertTrue(checkout.isOrderSuccessful());
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertNotNull(checkout.isErrorMessageDisplayed());
    }
}
