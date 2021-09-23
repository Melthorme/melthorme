package com.automationpractice.cartfunctiontests;

import com.automationpractice.base.BaseTest;
import com.automationpractice.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CartFunctionTest extends BaseTest {

    @Parameters({"expectedPrice"})
    @Test
    public void cartFunction(String expectedPrice) {
        log.info("Start cart function test");

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // going to "Casual Dresses" section
        CasualDressesPage casualDressesPage = welcomePage.goIntoCasualDresses();

        // selecting "Printed Dress"
        PrintedDressPage printedDressPage = casualDressesPage.printedDressDetails();

        // setting quantity, size and adding to cart
        CartPage cartPage = printedDressPage.setPreferences();
        cartPage.continueShopping();


        // going into "Summer Dresses" section
        SummerDressesPage summerDressesPage = printedDressPage.goIntoSummerDresses();

        // selecting 'Printed Chiffon Dress" and proceeding to checkout
        CartPage goToCheckoutPage = summerDressesPage.selectPrintedChiffonDress();
        CheckoutPage checkoutPage = goToCheckoutPage.goToCheckout();

        // verifying total price
        String actualPrice = checkoutPage.getActualPrice();

        Assert.assertEquals(actualPrice, expectedPrice, "Actual price: '" + actualPrice + "' does not equal expected price: '" + expectedPrice + "'.");

    }
}
