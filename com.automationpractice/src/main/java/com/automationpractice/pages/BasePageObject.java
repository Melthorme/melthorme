package com.automationpractice.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /** Open main page with given Url */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /** Find element using given locator */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Click on the element with given locator when its visible */
    protected void click(By locator) {
        find(locator).click();
    }

    /** Hover over element using given locator */
    protected void hoverOver(By locator) {
       WebElement element = find(locator);
       Actions actions = new Actions(driver);
       actions.moveToElement(element).build().perform();
    }

    /** Press ENTER key */
    protected void pressEnter(By locator) {
        find(locator).sendKeys(Keys.ENTER);
    }

    /** Type given text into element with given locator */
    protected void type(String text, By locator) {
        find(locator).sendKeys(text);
    }


    /** Wait for visibility of given locator */
    protected void waitForVisibilityOfLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
