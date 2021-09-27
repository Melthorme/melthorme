package automation.seek.job.pages.nofluff;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NoFluffMainPage extends BasePageObject {

    private String pageUrl = "https://nofluffjobs.com/pl";

    private By acceptingCookies = By.xpath("//button[contains(text(), ' Wyrażam zgodę ')]");

    // Category locators
    private By categoryLocator = By.xpath("//span[contains(text(), 'Kategoria')]/..");
    private By testingLocator = By.xpath("//button[contains(text(), ' Testing')]");
    private By acceptCategoryLocator = By.xpath("//button[contains(text(), ' Zatwierdź ')]");

    // Area locators
    private By locationsLocator = By.xpath("//span[contains(text(), ' Lokalizacje')]/..");
    private By remoteLocator = By.xpath("//button[contains(text(), ' Zdalnie')]");
    private By threeCityLocator = By.xpath("//button[contains(text(), ' Trójmiasto')]");
    private By lublinLocator = By.xpath("//button[contains(text(), ' Lublin')]");
    private By acceptLocalizationLocator = By.xpath("//button[contains(text(), ' Zatwierdź ')]");

    // Experience locators
    private By experienceLocator = By.xpath("//span[contains(text(), 'Doświadczenie')]/..");
    private By traineeLocator = By.xpath("//span[contains(text(), 'Stażysta')]");
    private By juniorLocator = By.xpath("//span[contains(text(), 'Junior')]");
    private By acceptExperienceLocator = By.xpath("//button[contains(text(), ' Zatwierdź ')]");

    public NoFluffMainPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Open main page */
    public void openPage() {
        openUrl(pageUrl);
    }

    /** Accept cookies */
    public void acceptCookies() {
        click(acceptingCookies);
    }

    /** Set category preferences */
    public void categorySet() {
        click(categoryLocator);
        click(testingLocator);
        click(acceptCategoryLocator);
    }

    /** Set location preferences */
    public void locationSet() {
        click(locationsLocator);
        click(remoteLocator);
        click(threeCityLocator);
        click(lublinLocator);
        click(acceptLocalizationLocator);
    }

    /** Set experience preferences */
    public void experienceSet() {
        click(experienceLocator);
        click(traineeLocator);
        click(juniorLocator);
        click(acceptExperienceLocator);
    }
}
