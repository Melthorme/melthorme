package com.automationpractice.pages.searchfunction;

import com.automationpractice.pages.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePageObject {

    private By messageLocator = By.xpath("//span[contains(text(), '1 result has been found.')]");

    public ResultPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get message */
    public String getMessageText() {
        log.info("Reading actual message.");
        waitForVisibilityOfLocator(messageLocator);
        return find(messageLocator).getText();
    }
}
