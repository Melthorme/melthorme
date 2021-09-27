package automation.seek.job;

import automation.seek.job.base.BaseTest;
import automation.seek.job.pages.nofluff.NoFluffMainPage;
import org.junit.Test;

public class NoFluff extends BaseTest {


    @Test
    public void noFluff() {

        // Open main page
        NoFluffMainPage mainPage = new NoFluffMainPage(driver, javascriptExecutor);
        mainPage.openPage();

        // Accept cookies
        mainPage.acceptCookies();

        // Set category
        mainPage.categorySet();

        // Set location
        mainPage.locationSet();

        // Set experience
        mainPage.experienceSet();

    }
}
