package automation.seek.job.pages.bulldog;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JobOffersSectionPage extends BasePageObject {

    // Area locators
    private By placeMoreLocator = By.xpath("//*[@id='jobs-search-form']/div[1]/div/ul/li[9]/a");
    private By remoteLocator = By.xpath("//input[@id='filters_remote']/..");
    private By threeCityLocator = By.xpath("//input[@id='city_trójmiasto']/..");
    private By lublinLocator = By.xpath("//input[@id='city_lublin']/..");

    // Position locators
    private By positionMoreLocator = By.xpath("//*[@id='jobs-search-form']/div[2]/div/ul/li[9]/a");
    private By testerLocator = By.xpath("//input[@id='role_tester']/..");
    private By qaLocator = By.xpath("//input[@id='role_qa']/..");

    // Experience locator
    private By juniorLocator = By.xpath("//input[@id='exp_level_junior']/..");


    public JobOffersSectionPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Select area */
    public void setArea() {
        click(placeMoreLocator);
        click(remoteLocator);
        click(threeCityLocator);
        click(lublinLocator);
    }

    /** Select position */
    public void setPosition() {
        click(positionMoreLocator);
        click(testerLocator);
        click(qaLocator);
    }

    /** Select experience */
    public void setExperience() {
        click(juniorLocator);
    }

}
