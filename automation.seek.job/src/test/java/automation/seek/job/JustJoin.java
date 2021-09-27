package automation.seek.job;

import automation.seek.job.base.BaseTest;
import automation.seek.job.pages.justjoin.LublinAreaPage;
import automation.seek.job.pages.justjoin.RemoteAreaPage;
import automation.seek.job.pages.justjoin.ThreeCityAreaPage;
import org.junit.Test;

public class JustJoin extends BaseTest {


    @Test
    public void justJoin() {

        // Open main page
        RemoteAreaPage remoteAreaPage = new RemoteAreaPage(driver, javascriptExecutor);
        remoteAreaPage.openPage();

        // Accept cookies
        remoteAreaPage.acceptCookies();

        //Set preferences
        remoteAreaPage.positionSet();
        remoteAreaPage.areaSet();
        remoteAreaPage.experienceSet();

        // Open new tab
        ThreeCityAreaPage threeCityPage = remoteAreaPage.newTabOpen();

        // Set preferences
        threeCityPage.positionSet();
        threeCityPage.areaSet();
        threeCityPage.experienceSet();

        // Open another tab
        LublinAreaPage lublinAreaPage = threeCityPage.anotherTabOpen();

        // Set preferences
        lublinAreaPage.positionSet();
        lublinAreaPage.areaSet();
        lublinAreaPage.experienceSet();

    }
}
