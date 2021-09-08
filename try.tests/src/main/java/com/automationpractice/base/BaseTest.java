package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected WebElement element;

    @Parameters({ "browser"})
    @BeforeMethod
    public void setUp(@Optional("edge") String browser) {

        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
