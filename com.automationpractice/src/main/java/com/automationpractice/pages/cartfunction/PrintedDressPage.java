package com.automationpractice.pages.cartfunction;

import com.automationpractice.pages.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintedDressPage extends BasePageObject {

    private By quantityLocator = By.xpath("//*[@class='icon-plus']");
    private By sizesLocator = By.xpath("//*[@id='group_1']");
    private By mSizeLocator = By.xpath("//*[@value='2']");
    private By addToCartLocator = By.xpath("//span[contains(text(), 'Add to cart')]");

    private By menuLocator = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
    private  By summerDressesLocator = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a");

    public PrintedDressPage(WebDriver driver, Logger log) { super(driver, log); }

    public CartPage setPreferences() {
        log.info("Choosing quantity and size, then adding to cart.");
        waitForVisibilityOfLocator(quantityLocator);
        click(quantityLocator);
        click(sizesLocator);
        click(mSizeLocator);
        click(addToCartLocator);
        return new CartPage(driver, log);
    }

    public SummerDressesPage goIntoSummerDresses() {
        log.info("Selecting 'Summer Dresses' from the menu.");
        waitForVisibilityOfLocator(menuLocator);
        hoverOver(menuLocator);
        click(summerDressesLocator);
        return new SummerDressesPage(driver, log);
    }


}
