package JobSeek;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class JustJoin {

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
    public void justJoin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // the long duration time is mainly caused by the performance of my computer :)
        driver.get("https://justjoin.it/");

        // closing cookies
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[1]/button"))).click();

        WebElement testingButton = driver.findElement(By.linkText("Testing"));
        WebElement localButton =
                driver.findElement(By.cssSelector("#root > div.css-ixnbwj > div > div.css-plb9h9 > div.css-plb9h9 > button > span.MuiButton-label"));

        // setting preferences
        testingButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(localButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Remote Poland"))).click();


        // opening new tab
        javascriptExecutor.executeScript("window.open('https://justjoin.it/');");

        // getting new tab visible
        String originalWindow = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(originalWindow);

        String nextWindow = String.valueOf(handles.iterator().next());

        driver.switchTo().window(nextWindow);

        // setting preferences
        WebElement testingButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Testing")));
        testingButton1.click();
        WebElement localButton1 =
                driver.findElement(By.cssSelector("#root > div.css-ixnbwj > div > div.css-plb9h9 > div.css-plb9h9 > button > span.MuiButton-label"));
        localButton1.click();
        driver.findElement(By.linkText("Trójmiasto")).click();


    }
}
