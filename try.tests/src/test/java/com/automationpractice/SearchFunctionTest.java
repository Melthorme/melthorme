package com.automationpractice;

import com.automationpractice.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchFunctionTest extends BaseTest {

    @Parameters({"searchedItem", "expectedMessage"})
    @Test
    public void searchFunction(String searchedItem, String expectedMessage) {
        System.out.println("Starting searchFunction test with " + searchedItem + " as a search item value.");

        driver.get("http://automationpractice.com/");

        element = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        element.sendKeys(searchedItem, Keys.ENTER);

        String expectedSearchMessage = expectedMessage;
        String actualSearch = driver.findElement(By.xpath("//span[contains(text(), '1 result has been found.')]")).getText();

        Assert.assertEquals(expectedSearchMessage, actualSearch);
    }
}
