package automation.seek.job;

import automation.seek.job.base.BaseTest;
import automation.seek.job.pages.pracuj.LublinAreaPage;
import automation.seek.job.pages.pracuj.RemoteAreaPage;
import automation.seek.job.pages.pracuj.PracujMainPage;
import automation.seek.job.pages.pracuj.ThreeCityAreaPage;
import org.junit.Test;

public class Pracuj extends BaseTest {


    @Test
    public void pracuj() {

        // Open main page
        PracujMainPage pracujMainPage = new PracujMainPage(driver, javascriptExecutor);
        pracujMainPage.openPage();
        pracujMainPage.acceptCookies();

        // Set preferences
        RemoteAreaPage remoteAreaPage = pracujMainPage.searchForRemote();
        remoteAreaPage.closeWindow();
        remoteAreaPage.experienceSet();
        remoteAreaPage.areaSet();

        // Open new tab
        remoteAreaPage.openNewTab();

        // Set preferences
        ThreeCityAreaPage threeCityAreaPage = pracujMainPage.searchForThreeCity();
        threeCityAreaPage.experienceSet();

        // Open another tab
        threeCityAreaPage.openAnotherTab();

        // Set preferences
        LublinAreaPage lublinAreaPage = pracujMainPage.searchForLublin();
        lublinAreaPage.experienceSet();
    }
}
