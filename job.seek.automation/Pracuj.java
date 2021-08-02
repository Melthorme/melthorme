package JobSeek;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pracuj {

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
    public void pracuj() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // opening site and accepting cookies
        driver.get("https://www.pracuj.pl/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Akceptuj wszystkie']"))).click();
        driver.switchTo().activeElement();

        // setting preferences
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slider--2fq-O"))).click();
        Actions actions = new Actions(driver);
        actions.sendKeys("tester manualny").perform();
        driver.findElement(By.className("slider--2rGn_")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("new-remote-work-filter__label"))).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Poziom stanowiska')]")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//span[contains(text(), 'Praktykant / Stażysta')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Asystent')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Młodszy specjalista (Junior)')]")).click();

        driver.findElement(By.className("form-send__element")).click();


    }
}