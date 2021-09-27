package automation.seek.job;

import automation.seek.job.base.BaseTest;
import automation.seek.job.pages.pracuj.FirstResultPage;
import automation.seek.job.pages.pracuj.PracujMainPage;
import org.junit.Test;

public class Pracuj extends BaseTest {


    @Test
    public void pracuj() {

        // Open main page
        PracujMainPage pracujMainPage = new PracujMainPage(driver, javascriptExecutor);
        pracujMainPage.openPage();
        pracujMainPage.acceptCookies();

        // Set preferences
        FirstResultPage firstResultPage = pracujMainPage.searchFor();
        firstResultPage.closeWindow();
        firstResultPage.experienceSet();
        firstResultPage.areaSet();
    }
}
