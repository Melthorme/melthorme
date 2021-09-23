package com.automationpractice.searchfunctiontests;

import com.automationpractice.base.BaseTest;
import com.automationpractice.pages.ResultPage;
import com.automationpractice.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchFunctionTest extends BaseTest {

    @Parameters({"searchedItem", "expectedMessage"})
    @Test
    public void searchFunction(String searchedItem, String expectedMessage) {
        log.info("Starting searchFunction test with " + searchedItem + " as a search item value.");

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Search for an item
        ResultPage resultPage = welcomePage.searchForItem(searchedItem);

        // Verification
        String actualTextMessage = resultPage.getMessageText();

        Assert.assertEquals(actualTextMessage,
                expectedMessage, "Expected message: [" + expectedMessage + "] does not equal actual message: [" + actualTextMessage + "].");
    }
}
