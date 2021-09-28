package automation.seek.job.pages.pracuj;

import automation.seek.job.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PracujMainPage extends BasePageObject {

    private String pageUrl = "https://www.pracuj.pl/";
    private By acceptCookiesLocator = By.xpath("//*[@title='Akceptuj wszystkie']");

    // Position locators
    private By searchBoxLocator = By.xpath("//div[@class='slider--wAy8Z']/div[1]/input[1]");
    private By searchButtonLocator = By.xpath("//div[@class='slider--269Rf']/button[1]");
    private String searchedFraze = "tester oprogramowania";

    // Area locators
    private String searchThreeCity = "Trójmiasto";
    private String searchLublin = "Lublin";
    private By areaBoxLocator = By.xpath("//div[@class='slider--2SDzi']/div/div/input");
    private By distanceBoxLocator = By.xpath("//div[@class='slider--2fMJ1']/button");
    private By zeroDistanceLocator = By.xpath("//button[contains(text(), '+ 0 km')][1]");




    public PracujMainPage(WebDriver driver, JavascriptExecutor javascriptExecutor) { super(driver, javascriptExecutor); }

    /** Open main page */
    public void openPage() {
        openUrl(pageUrl);
    }

    /** Accept cookies */
    public void acceptCookies() {
        click(acceptCookiesLocator);
    }

    /** Set preferences for remote search */
    public RemoteAreaPage searchForRemote() {
        type(searchBoxLocator, searchedFraze);
        click(searchButtonLocator);
        return new RemoteAreaPage(driver, javascriptExecutor);
    }

    /** Set preferences for ThreeCity search */
    public ThreeCityAreaPage searchForThreeCity() {
        type(searchBoxLocator, searchedFraze);
        type(areaBoxLocator, searchThreeCity);
        click(distanceBoxLocator);
        click(zeroDistanceLocator);
        click(searchButtonLocator);
        return new ThreeCityAreaPage(driver, javascriptExecutor);
    }

    /** Set preferences for ThreeCity search */
    public LublinAreaPage searchForLublin() {
        type(searchBoxLocator, searchedFraze);
        type(areaBoxLocator, searchLublin);
        click(distanceBoxLocator);
        click(zeroDistanceLocator);
        click(searchButtonLocator);
        return new LublinAreaPage(driver, javascriptExecutor);
    }


}

