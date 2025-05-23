package demoblaze.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import demoblaze.utils.Base;
import pages.ShoppingCartPage;

public class ShoppingCart extends Base{

	  
	@Test
    public void validateAddToCartWithoutLogin() {
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.selectProduct("Samsung galaxy s6");
        shoppingCart.addToCart();

        String alertMessage = shoppingCart.getAlertMessage();
        System.out.println("Alert Message: " + alertMessage);

        Assert.assertTrue(alertMessage.contains("Product added"), "Alert message verification failed!");

        shoppingCart.openCart();
        Assert.assertTrue(shoppingCart.isProductInCart("Samsung galaxy s6"), "Product not found in cart!");
    }

    @Test
    public void addMultipleProductsToCart() {
    	ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.selectProduct("Samsung galaxy s6");
        shoppingCart.addToCart();

        shoppingCart.navigateToHome();

        shoppingCart.selectProduct("Sony vaio i5");
        shoppingCart.addToCart();

        shoppingCart.openCart();

        Assert.assertTrue(shoppingCart.isProductInCart("Samsung galaxy s6"), "Samsung Galaxy S6 not found in cart!");
        Assert.assertTrue(shoppingCart.isProductInCart("Sony vaio i5"), "Sony vaio i5 not found in cart!");
    }

    @Test
    public void removeProductFromCart() throws InterruptedException {
    	ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.selectProduct("Samsung galaxy s6");
        shoppingCart.addToCart();
        shoppingCart.openCart();

        shoppingCart.removeProduct();
        Thread.sleep(2000);  

        Assert.assertFalse(shoppingCart.isProductInCart("Samsung galaxy s6"), "Product was not removed from cart!");
    }
}
