package com.automationpractice.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CasualDressesPage extends BasePageObject {

    private By printedDressLocator = By.xpath("//*[@title='Printed Dress']");
    private By printedDressDetailsLocator = By.xpath("//span[contains(text(), 'More')]");

    public CasualDressesPage(WebDriver driver, Logger log) { super(driver, log); }

    public PrintedDressPage printedDressDetails() {
        log.info("Selecting 'more' on Printed Dress.");
        waitForVisibilityOfLocator(printedDressLocator);
        hoverOver(printedDressLocator);
        click(printedDressDetailsLocator);
        return new PrintedDressPage(driver, log);
    }

}
