package automation.seek.job;


import automation.seek.job.base.BaseTest;
import automation.seek.job.pages.bulldog.JobOffersSectionPage;
import automation.seek.job.pages.bulldog.BulldogMainPage;
import org.junit.Test;

public class Bulldog extends BaseTest {


    @Test
    public void bulldog() {
        // Open main page
        BulldogMainPage mainPage = new BulldogMainPage(driver, javascriptExecutor);

        // Dismiss windows
        mainPage.openPage();
        mainPage.acceptCookies();
        mainPage.popupWindow();

        // Select job offers section
        JobOffersSectionPage jobOffersSectionPage = mainPage.jobSectionPage();

        // Set area preferences
        jobOffersSectionPage.setArea();

        // Set position
        jobOffersSectionPage.setPosition();

        // Set experience
        jobOffersSectionPage.setExperience();

    }
}
