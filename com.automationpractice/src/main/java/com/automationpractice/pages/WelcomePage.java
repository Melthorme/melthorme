package com.automationpractice.pages;

import com.automationpractice.pages.cartfunction.CasualDressesPage;
import com.automationpractice.pages.searchfunction.ResultPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePage extends BasePageObject {


    private String pageUrl = "http://automationpractice.com/";

    private By searchBoxLocator = By.xpath("//*[@id='search_query_top']");
    private By menuLocator = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
    private By casualDressesLocator = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");


    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open main page */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /** Execute search */
    public ResultPage searchForItem(String searchedItem) {
        log.info("Executing search with '" + searchedItem + "' parameter.");
        waitForVisibilityOfLocator(searchBoxLocator);
        type(searchedItem, searchBoxLocator);
        pressEnter(searchBoxLocator);
        return new ResultPage(driver, log);
    }

    /** Go to Casual Dresses section in the menu */
    public CasualDressesPage goIntoCasualDresses() {
        log.info("Selecting 'Casual Dresses' section from the menu.");
        waitForVisibilityOfLocator(menuLocator);
        hoverOver(menuLocator);
        click(casualDressesLocator);
        return new CasualDressesPage(driver, log);
    }

}

