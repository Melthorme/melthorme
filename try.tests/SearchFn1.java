package TryTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class SearchFn1 {

    WebDriver driver;
    WebElement element;


    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", "resources/edge-web-driver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchFunction1() {
        driver.get("http://automationpractice.com/");

        element = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        element.sendKeys("t-shirt", Keys.ENTER);

        String search = "1 result has been found.";
        String actualSearch = driver.findElement(By.xpath("//span[contains(text(), '1 result has been found.')]")).getText();

        Assert.assertEquals(search, actualSearch);
    }
}
