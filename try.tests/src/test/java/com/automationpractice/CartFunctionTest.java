package com.automationpractice;

import com.automationpractice.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartFunctionTest extends BaseTest {


    @Test
    public void cartFn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/");

        // going to "Casual Dresses" section
        element = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")).click();

        // selecting "Printed Dress"
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Printed Dress']")));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//span[contains(text(), 'More')]")).click();

        // setting quantity, size and adding to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='icon-plus']"))).click();
        driver.findElement(By.xpath("//*[@id='group_1']")).click();
        driver.findElement(By.xpath("//*[@value='2']")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Add to cart')]")).click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"))).click();

        // going to "Summer Dresses" section
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")).click();

        // selecting 'Printed Chiffon Dress" and proceeding to checkout
        element = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[3]/div/div[1]/div/a[1]/img"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"))).click();

        // verifying total price
        String expectedPrice = "$70.40";
        WebElement value1 = driver.findElement(By.xpath("//span[@id='total_price']"));
        String actualPrice = value1.getText();
        Assert.assertEquals("$70.40", actualPrice, expectedPrice);


    }
}
