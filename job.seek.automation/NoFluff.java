package automation.seek.job;

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
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
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
        // category
        driver.findElement(
                By.xpath("//span[contains(text(), 'Kategoria')]/..")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//button[contains(text(), ' Testing')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Zatwierdź ')]")).click();

        // localization
        driver.findElement(
                By.xpath("//span[contains(text(), ' Lokalizacje')]/..")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//button[contains(text(), ' Zdalnie')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Trójmiasto')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Lublin')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Zatwierdź ')]")).click();

        // experience
        driver.findElement(
                By.xpath("//span[contains(text(), 'Doświadczenie')]/..")).click();
        driver.switchTo().activeElement();
        driver.findElement(
                By.xpath("//span[contains(text(), 'Stażysta')]")).click();
        driver.findElement(
                By.xpath("//span[contains(text(), 'Junior')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), ' Zatwierdź ')]")).click();

    }
}
