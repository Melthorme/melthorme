package automation.seek.job;


import automation.seek.job.base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Bulldog extends BaseTest {


    @Test
    public void bulldog() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://bulldogjob.pl");

        // dismissing all the windows
        driver.findElement(By.className("confirm")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ue_push_dialog']/span"))).click();

        // navigating to the job section
        driver.findElement(By.className("btn-search")).click();

        // setting preferences

        // selecting area
        driver.findElement(By.xpath("//input[@id='city_trójmiasto']/..")).click();
        driver.findElement(By.xpath("//input[@id='filters_remote']/..")).click();
        driver.findElement(By.xpath("//*[@id='jobs-search-form']/div[1]/div/ul/li[9]/a")).click();
        driver.findElement(By.xpath("//input[@id='city_lublin']/..")).click();

        // selecting position
        driver.findElement(By.xpath("//*[@id='jobs-search-form']/div[2]/div/ul/li[9]/a")).click();
        driver.findElement(By.xpath("//input[@id='role_qa']/..")).click();
        driver.findElement(By.xpath("//input[@id='role_tester']/..")).click();

        // selecting experience
        driver.findElement(By.xpath("//input[@id='exp_level_junior']/..")).click();
    }
}
