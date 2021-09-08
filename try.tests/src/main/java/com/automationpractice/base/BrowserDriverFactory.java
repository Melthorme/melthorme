package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public  WebDriver createDriver() {
        // Create a driver
        System.out.println("Create driver: " + browser);

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
