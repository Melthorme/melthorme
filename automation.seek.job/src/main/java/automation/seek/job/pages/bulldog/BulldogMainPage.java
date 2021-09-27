package automation.seek.job.pages.bulldog;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BulldogMainPage extends BasePageObject {

    private String pageUrl = "https://bulldogjob.pl";
    private By acceptingCookiesLocator = By.className("confirm");
    private By popupWindowLocator = By.xpath("//*[@id='ue_push_dialog']/span");
    private By jobOffersLocator = By.className("btn-search");


    public BulldogMainPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Open main page */
    public void openPage() {
        openUrl(pageUrl);
    }

    /** Accept cookies */
    public void acceptCookies() {
        click(acceptingCookiesLocator);
    }

    /** Dismiss popup window */
    public void popupWindow() {
        click(popupWindowLocator);
    }

    /** Navigate to job offers section */
    public JobOffersSectionPage jobSectionPage() {
        click(jobOffersLocator);
        return new JobOffersSectionPage(driver, javascriptExecutor);
    }
}
