package com.automationpractice.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePageObject {

    private By continueShoppingLocator = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span");
    private By proceedToCheckoutLocator = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a");

    public CartPage(WebDriver driver, Logger log) { super(driver, log); }

    public PrintedDressPage continueShopping() {
        log.info("Selecting 'Continue Shopping'.");
        waitForVisibilityOfLocator(continueShoppingLocator);
        click(continueShoppingLocator);
        return new PrintedDressPage(driver, log);
    }

    public CheckoutPage goToCheckout() {
        log.info("Going to checkout.");
        waitForVisibilityOfLocator(proceedToCheckoutLocator);
        click(proceedToCheckoutLocator);
        return new CheckoutPage(driver, log);
    }
}
