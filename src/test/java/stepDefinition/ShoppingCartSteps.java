package stepDefinition;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.ShoppingCartPage;
import demoblaze.utils.Base;

public class ShoppingCartSteps extends Base {
    ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
    String alertMessage;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get("https://www.demoblaze.com/");
    }

    @When("I select the product {string}")
    public void i_select_the_product(String productName) {
        shoppingCart.selectProduct(productName);
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        shoppingCart.addToCart();
        alertMessage = shoppingCart.getAlertMessage();
    }

    @Then("I should see an alert with message {string}")
    public void i_should_see_an_alert_with_message(String expectedMessage) {
        Assert.assertTrue(alertMessage.contains(expectedMessage), "Alert message verification failed!");
    }

    @Then("I should see {string} in the cart")
    public void i_should_see_in_the_cart(String productName) {
        shoppingCart.openCart();
        Assert.assertTrue(shoppingCart.isProductInCart(productName), productName + " not found in cart!");
    }

    @When("I navigate back to home")
    public void i_navigate_back_to_home() {
        shoppingCart.navigateToHome();
    }

    @When("I open the cart")
    public void i_open_the_cart() {
        shoppingCart.openCart();
    }

    @When("I remove the product")
    public void i_remove_the_product() {
        shoppingCart.removeProduct();
    }

    @Then("I should not see {string} in the cart")
    public void i_should_not_see_in_the_cart(String productName) {
        Assert.assertFalse(shoppingCart.isProductInCart(productName), productName + " was not removed from cart!");
    }
}