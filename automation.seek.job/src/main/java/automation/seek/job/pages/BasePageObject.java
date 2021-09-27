package automation.seek.job.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class BasePageObject {

    protected WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;

    public BasePageObject(WebDriver driver, JavascriptExecutor javascriptExecutor) {
        this.driver = driver;
        this.javascriptExecutor = javascriptExecutor;
    }

    /** Open main page with given Url */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /** Find element by given locator */
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    /** Click on the element by given locator */
    protected void click(By locator) {
        waitForVisibilityOfLocator(locator);
        find(locator).click();
    }

    /** Type given text into element with given locator */
    protected void type(By locator, String text) {
        waitForVisibilityOfLocator(locator);
        find(locator).sendKeys(text);
    }

    /** Wait for visibility of given locator */
    protected void waitForVisibilityOfLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Open new tab */
    protected void newTab(String argument, String url) {
        javascriptExecutor.executeScript(argument, url);

        String firstTab = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(firstTab);

        String secondTab = String.valueOf(handles.iterator().next());

        driver.switchTo().window(secondTab);
    }

    /** Open another tab */
    public void anotherTab(String argument, String url) {
        javascriptExecutor.executeScript(argument, url);

        String secondTabClose = driver.getWindowHandle();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println(tabs.size());

        driver.switchTo().window((String) tabs.get(2));
    }

}
