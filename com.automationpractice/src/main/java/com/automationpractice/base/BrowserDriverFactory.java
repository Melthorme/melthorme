package com.automationpractice.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public  WebDriver createDriver() {
        // Create a driver
        log.info("Create driver: " + browser);

        switch(browser) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "E:/itprojects/com.automationpractice/src/main/resources/msedgedriver.exe");
                driver.set(new EdgeDriver());
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "E:/itprojects/com.automationpractice/src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "E:/itprojects/com.automationpractice/src/main/resources/geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Do not know how to start " + browser + ", starting Edge instead.");
                System.setProperty("webdriver.edge.driver", "E:/itprojects/com.automationpractice/src/main/resources/msedgedriver.exe");
                driver.set(new EdgeDriver());
                break;
        }

        return driver.get();
    }
}
