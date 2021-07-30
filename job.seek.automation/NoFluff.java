package JobSeek;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NoFluff {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;


    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", "resources/edge-web-driver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        javascriptExecutor = ((JavascriptExecutor) driver);
    }

    @Test
    public void noFluff() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://nofluffjobs.com/pl");

        // accepting cookies
        driver.findElement(By.xpath("//button[contains(text(), ' Wyrażam zgodę ')]")).click();

        // setting preferences
        // industry
        driver.findElement(
                By.xpath("/html/body/nfj-root/nfj-layout/nfj-controls-toolbar/div/div/div/nfj-filters/div/nfj-filter-trigger[2]/div/button")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//button[contains(text(), ' Testing')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Zatwierdź ')]")).click();

        // localization
        driver.findElement(
                By.xpath("/html/body/nfj-root/nfj-layout/nfj-controls-toolbar/div/div/div/nfj-filters/div/nfj-filter-trigger[3]/div/button")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//button[contains(text(), ' Zdalnie')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Trójmiasto')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Zatwierdź ')]")).click();

        // experience
        driver.findElement(
                By.xpath("/html/body/nfj-root/nfj-layout/nfj-controls-toolbar/div/div/div/nfj-filters/div/nfj-filter-trigger[5]/div/button")).click();
        driver.switchTo().activeElement();
        driver.findElement(
                By.xpath("/html/body/nfj-root/nfj-layout/nfj-controls-toolbar/div/div/div/nfj-filters/div/nfj-filter-trigger[5]/popover-content/div/div[4]/nfj-filters-wrapper/div/div/nfj-filter-universal-section/section/div/nfj-filter-control[1]/nfj-checkbox/label")).click();
        driver.findElement(
                By.xpath("/html/body/nfj-root/nfj-layout/nfj-controls-toolbar/div/div/div/nfj-filters/div/nfj-filter-trigger[5]/popover-content/div/div[4]/nfj-filters-wrapper/div/div/nfj-filter-universal-section/section/div/nfj-filter-control[2]/nfj-checkbox/label")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Zatwierdź ')]")).click();

    }
}
