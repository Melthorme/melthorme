package com.automationpractice.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummerDressesPage extends BasePageObject {

    private By printedChiffonDressLocator = By.xpath("//*[@id='center_column']/ul/li[3]/div/div[1]/div/a[1]/img");
    private By addToCart = By.xpath("//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]/span");

    public SummerDressesPage(WebDriver driver, Logger log) { super(driver, log); }

    public CartPage selectPrintedChiffonDress() {
        log.info("Adding Printed Chiffon Dress to the cart.");
        waitForVisibilityOfLocator(printedChiffonDressLocator);
        hoverOver(printedChiffonDressLocator);
        click(addToCart);
        return new CartPage(driver, log);
    }
}
