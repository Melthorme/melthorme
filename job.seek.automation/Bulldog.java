package JobSeek;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Bulldog {

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
    public void bulldog() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://bulldogjob.pl");

        // dismissing all the windows
        driver.findElement(By.className("confirm")).click();
        driver.findElement(By.className("fa-times")).click();
        driver.findElement(By.xpath("//*[@id='zarw-close-small']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ue_push_dialog']/span"))).click();

        // navigating to the job section
        driver.findElement(By.className("btn-search")).click();

        // setting preferences
        driver.findElement(By.xpath("//input[@id='city_trójmiasto']/..")).click();
        driver.findElement(By.xpath("//input[@id='filters_remote']/..")).click();
        driver.findElement(By.xpath("//input[@id='role_qa']/..")).click();
        driver.findElement(By.xpath("//input[@id='role_tester']/..")).click();
        driver.findElement(By.xpath("//input[@id='exp_level_junior']/..")).click();
    }
}
