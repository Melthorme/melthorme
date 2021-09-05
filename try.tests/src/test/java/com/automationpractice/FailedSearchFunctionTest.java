package com.automationpractice;

import com.automationpractice.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedSearchFunctionTest extends BaseTest {


    @Test
    public void searchFunction2() {
        driver.get("http://automationpractice.com/");

        element = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        element.sendKeys("tshirt", Keys.ENTER);

        String search = "1 result has been found.";
        String actualSearch = driver.findElement(By.xpath("//span[contains(text(), '1 result has been found.')]")).getText();

        Assert.assertEquals(search, actualSearch);
    }
}