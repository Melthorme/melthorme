package automation.seek.job.pages.pracuj;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FirstResultPage extends BasePageObject {

    private By popupWindowLocator = By.xpath("//button[contains(text(), 'Rozumiem')]");

    // Experience locators
    private By experienceLocator = By.xpath("//button[contains(text(), 'Poziom stanowiska')]");
    private By traineeLocator = By.xpath("//span[contains(text(), 'Praktykant / Stażysta')]");
    private By assistantLocator = By.xpath("//span[contains(text(), 'Asystent')]");
    private By juniorLocator = By.xpath("//span[contains(text(), 'Młodszy specjalista (Junior)')]");

    // Area locators
    private By areaLocator = By.xpath("//button[@data-test='work-modes-filter-button']");
    private By remoteLocator = By.xpath("//label[@for='home-office']");
    private By hybridLocator = By.xpath("//label[@for='hybrid']");
    private By showOffersButtonLocator = By.xpath("//button[@class='form-send__element']");

    public FirstResultPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Close popup window */
    public void closeWindow() {
        click(popupWindowLocator);
    }

    /** Set experience preferences */
    public void experienceSet() {
        click(experienceLocator);
        click(traineeLocator);
        click(assistantLocator);
        click(juniorLocator);
    }

    /** Set area preferences */
    public void areaSet() {
        click(areaLocator);
        click(remoteLocator);
        click(hybridLocator);
        click(showOffersButtonLocator);
    }
}
