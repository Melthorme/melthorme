package automation.seek.job.pages.pracuj;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PracujMainPage extends BasePageObject {

    private String pageUrl = "https://www.pracuj.pl/";
    private String searchedFraze = "tester oprogramowania";

    private By acceptCookiesLocator = By.xpath("//*[@title='Akceptuj wszystkie']");
    private By searchBoxLocator = By.xpath("//div[@class='slider--wAy8Z']/div[1]/input[1]");
    private By searchButtonLocator = By.xpath("//div[@class='slider--269Rf']/button[1]");


    public PracujMainPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Open main page */
    public void openPage() {
        openUrl(pageUrl);
    }

    /** Accept cookies */
    public void acceptCookies() {
        click(acceptCookiesLocator);
    }

    /** Type searched fraze */
    public FirstResultPage searchFor() {
        type(searchBoxLocator, searchedFraze);
        click(searchButtonLocator);
        return new FirstResultPage(driver, javascriptExecutor);
    }
}
