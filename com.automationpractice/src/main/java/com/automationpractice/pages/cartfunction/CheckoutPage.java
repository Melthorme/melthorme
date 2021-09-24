package com.automationpractice.pages.cartfunction;

import com.automationpractice.pages.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePageObject {

    private By priceLocator = By.xpath("//span[@id='total_price']");

    public CheckoutPage(WebDriver driver, Logger log) { super(driver, log); }

    public String getActualPrice() {
        log.info("Getting the actual price.");
        waitForVisibilityOfLocator(priceLocator);
        return find(priceLocator).getText();
    }

}
