package automation.seek.job.pages.justjoin;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LublinAreaPage extends BasePageObject {

    // Position locators
    private By testingPositionLocator = By.xpath("//span[contains(text(),'Testing')]/..");

    // Area locators
    private By locationLocator = By.xpath("//span[contains(text(), 'Location')]");
    private By otherLocationLocator = By.xpath("//button[contains(text(), 'Other locations Poland')]");
    private By lublinLocator = By.xpath("//span[contains(text(), 'Lublin')]");

    // Experience locators
    private By moreFiltersButtonLocator = By.xpath("//div[@class='css-k422uy']/button[1]/span[1]");
    private By juniorLocator = By.xpath("//span[contains(text(), 'Junior')]");
    private By showOffersButtonLocator = By.xpath("//span[contains(text(), 'Show offers')]");


    public LublinAreaPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Select position */
    public void positionSet() {
        click(testingPositionLocator);
    }

    /** Select area */
    public void areaSet() {
        click(locationLocator);
        click(otherLocationLocator);
        click(lublinLocator);
    }

    /** Select experience */
    public void experienceSet() {
        click(moreFiltersButtonLocator);
        click(juniorLocator);
        click(showOffersButtonLocator);
    }
}
