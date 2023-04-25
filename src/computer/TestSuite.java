package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBeticalOrder() {
        // Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //Verify the Product will arrange in Descending order.
        verifyExpectedAndActual(By.xpath("//option[contains(text(),'Name: Z to A')]"), "Name: Z to A");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        Thread.sleep(2000);
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//button[contains(text(), 'Add to cart')]"));
        //Verify the Text "Build your own computer" driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select"))).sendKeys("London");
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.cssSelector("#product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.cssSelector("#product_attribute_2"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.cssSelector("#product_attribute_3_7"));
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.cssSelector("#product_attribute_4_9"));
        Thread.sleep(2000);
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElements(By.cssSelector("#product_attribute_5_10"), By.cssSelector("#product_attribute_5_12"));
         Thread.sleep(2000);
        //Verify the price "$1,425.00"
        verifyExpectedAndActual(By.cssSelector("#price-value-1"),"$1,425.00");
        //Click on "ADD TO CARD" Button.
        clickOnElement(By.cssSelector("#add-to-cart-button-1"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        // MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        //Verify the message "Shopping cart"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        //Change the Qty to "2" and Click on "Update shopping cart"
        clearText(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]"));
        sendTextToElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //Verify the Total"$2,950.00"
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$2,850.00");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //Enter email
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "James");
        //Last name
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Bond");
        //Email
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "James@gmail.com");
        //company
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "Apple");
        //country
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        //state
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Alaska");
        //City
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Sitka");
        //Address 1
        sendTextToElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/input[1]"), "2 Lincoln St #1A");
        //Zip
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "AK 99835");
        //Phone number
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), " +1 907-966-2326");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.cssSelector("#shippingoption_1"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        //Click on Continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //Filling the card detail
        //Cardholder name
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "James Bond");
        //Card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        // Expiration Date
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "10");
        //Expiration Year
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        //Card code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "101");
        //Click on Continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");
        //Verify “Shipping Method” is “Next Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air");
        //Verify Total is “$2,950.00”
        verifyExpectedAndActual(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$2,850.00");
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        //Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
