package automation.seek.job.pages.justjoin;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RemoteAreaPage extends BasePageObject {

    private String pageUrl = "https://justjoin.it/";
    private String argument = "window.open(arguments[0]);";

    private By acceptCookiesLocator = By.xpath("//span[contains(text(), 'OK')]/..");

    // Position locators
    private By testingPositionLocator = By.xpath("//span[contains(text(),'Testing')]/..");

    // Area locators
    private By locationLocator = By.xpath("//span[contains(text(), 'Location')]");
    private By remoteAreaLocator = By.xpath("//span[contains(text(), 'Remote Poland')]");

    // Experience locators
    private By moreFiltersButtonLocator = By.xpath("//div[@class='css-k422uy']/button[1]/span[1]");
    private By juniorLocator = By.xpath("//span[contains(text(), 'Junior')]");
    private By showOffersButtonLocator = By.xpath("//span[contains(text(), 'Show offers')]");


    public RemoteAreaPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Open main page */
    public void openPage() {
        openUrl(pageUrl);
    }

    /** Accept cookies */
    public void acceptCookies() {
        click(acceptCookiesLocator);
    }

    /** Select position */
    public void positionSet() {
        click(testingPositionLocator);
    }

    /** Select area */
    public void areaSet() {
        click(locationLocator);
        click(remoteAreaLocator);
    }

    /** Select experience */
    public void experienceSet() {
        click(moreFiltersButtonLocator);
        click(juniorLocator);
        click(showOffersButtonLocator);
    }

    /** Open new tab */
    public ThreeCityAreaPage newTabOpen() {
        newTab(argument, pageUrl);
        return new ThreeCityAreaPage(driver, javascriptExecutor);
    }
}
