package automation.seek.job.pages.justjoin;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ThreeCityAreaPage extends BasePageObject {

    private String pageUrl = "https://justjoin.it/";
    private String argument = "window.open(arguments[0]);";

    // Position locators
    private By testingPositionLocator = By.xpath("//span[contains(text(),'Testing')]/..");

    // Area locators
    private By locationLocator = By.xpath("//span[contains(text(), 'Location')]");
    private By threeCityLocator = By.xpath("//span[contains(text(), 'Trójmiasto')]");

    // Experience locators
    private By moreFiltersButtonLocator = By.xpath("//div[@class='css-k422uy']/button[1]/span[1]");
    private By juniorLocator = By.xpath("//span[contains(text(), 'Junior')]");
    private By showOffersButtonLocator = By.xpath("//span[contains(text(), 'Show offers')]");


    public ThreeCityAreaPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Select position */
    public void positionSet() {
        click(testingPositionLocator);
    }

    /** Select area */
    public void areaSet() {
        click(locationLocator);
        click(threeCityLocator);
    }

    /** Select experience */
    public void experienceSet() {
        click(moreFiltersButtonLocator);
        click(juniorLocator);
        click(showOffersButtonLocator);
    }

    /** Open another tab */
    public LublinAreaPage anotherTabOpen() {
        anotherTab(argument, pageUrl);
        return new LublinAreaPage(driver, javascriptExecutor);
    }
}
