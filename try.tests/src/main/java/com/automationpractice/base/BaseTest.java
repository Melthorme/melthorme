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
        switch(browser) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "E:/itprojects/com.automationpractice/src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "E:/itprojects/com.automationpractice/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "E:/itprojects/com.automationpractice/src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Do not know how to start " + browser + ", starting Edge instead.");
                System.setProperty("webdriver.edge.driver", "E:/itprojects/com.automationpractice/src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
