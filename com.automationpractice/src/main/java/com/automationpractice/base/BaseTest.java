package com.automationpractice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected WebElement element;
    protected Logger log;

    @Parameters({ "browser"})
    @BeforeMethod
    public void setUp(@Optional("edge") String browser, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();

        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void tearDown() {
//        log.info("Close driver");
//        driver.quit();
//    }
}
