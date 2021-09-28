package automation.seek.job.pages.pracuj;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LublinAreaPage extends BasePageObject {


    // Experience locators
    private By experienceLocator = By.xpath("//button[contains(text(), 'Poziom stanowiska')]");
    private By traineeLocator = By.xpath("//span[contains(text(), 'Praktykant / Stażysta')]");
    private By assistantLocator = By.xpath("//span[contains(text(), 'Asystent')]");
    private By juniorLocator = By.xpath("//span[contains(text(), 'Młodszy specjalista (Junior)')]");
    private By showOffersButtonLocator = By.xpath("//button[@class='form-send__element']");

    public LublinAreaPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }


    /** Set experience preferences */
    public void experienceSet() {
        click(experienceLocator);
        click(traineeLocator);
        click(assistantLocator);
        click(juniorLocator);
        click(showOffersButtonLocator);
    }
}
