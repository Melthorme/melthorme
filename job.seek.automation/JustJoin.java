package automation.seek.job;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class JustJoin extends BaseTest {

    String url = "https://justjoin.it/";

    @Test
    public void justJoin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // the long duration time is mainly caused by the performance of my computer :)
        driver.get(url);

        // closing cookies
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'OK')]/.."))).click();

        // setting preferences
        driver.findElement(By.xpath("//span[contains(text(),'Testing')]/..")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Location')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Remote Poland')]"))).click();

        // opening new tab
        javascriptExecutor.executeScript("window.open(arguments[0]);", url);

        // getting new tab visible
        String firstTab = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(firstTab);

        String secondTab = String.valueOf(handles.iterator().next());

        driver.switchTo().window(secondTab);

        // setting preferences
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Testing')]/.."))).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Location')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Trójmiasto')]")).click();

        // opening another tab
        javascriptExecutor.executeScript("window.open(arguments[0]);", url);

        // getting new tab visible
        String secondTabClose = driver.getWindowHandle();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println(tabs.size());

        driver.switchTo().window((String) tabs.get(2));


        // setting preferences
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Testing')]/.."))).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Location')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Other locations Poland')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Lublin')]")).click();

    }
}
