package Electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {


        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
        //Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        //Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //Verify the text “Nokia Lumia 1020”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020");
        //Verify the price “$349.00”
        verifyExpectedAndActual(By.cssSelector("#price-value-20"),"$349.00");
        //Change quantity to 2
        clearText(By.cssSelector("#product_enteredQuantity_20"));
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"),"2");
        //Click on “ADD TO CART” tab
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
       mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
       Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        //Verify the message "Shopping cart"
       verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
      // Thread.sleep(3000);
        //Verify the quantity is 2
        verifyMessage("(2)", verifyVisibleText(By.xpath("//span[contains(text(),'(2)')]")));
      // verifyExpectedAndActual(By.xpath("//input[@id = 'itemquantity11232'][@value = '2']"),"2");
        //Verify the Total $698.00
       verifyExpectedAndActual(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"$698.00");
       //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //Verify the text “Register”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register')]"),"Register");
        //Fill the Mandatory fields
        //First name
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"James");
        //Last name
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Bond");
        //Email
        sendTextToElement(By.xpath("//input[@id='Email']"),"James24@gmail.com");
        //Password
        sendTextToElement(By.xpath("//input[@id='Password']"),"James@123");
        //Confirm Password
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"James@123");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //Verify the message “Your registration completed”
        verifyExpectedAndActual(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping cart”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //click on the ‘Login’ link
        clickOnElement(By.xpath("//a[text()='Log in']"));
        //Enter valid username
        sendTextToElement(By.xpath("//input[@id='Email']"),"James24@gmail.com");
        // Enter valid password
        sendTextToElement(By.xpath("//input[@id='Password']"),"James@123");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@type='submit' and text()='Log in']"));

        clickOnElement(By.id("termsofservice"));
        //clickOnElement(By.xpath("//input[@id='termsofservice']"));;
        clickOnElement(By.xpath("//button[@id='checkout']"));
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        Thread.sleep(2000);
        selectFromDropDown(By.id("BillingNewAddress_CountryId"), "United States");
        //selectByContainsTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United States");
        Thread.sleep(2000);
        clickOnElement(By.id("BillingNewAddress_StateProvinceId"));
        sendTextToElement(By.id("BillingNewAddress_StateProvinceId"), "California");
        sendTextToElement(By.id("BillingNewAddress_City"), "Florida");
        //clickOnElement(By.id("BillingNewAddress_City"));
        // action.sendKeys("London").perform();
        sendTextToElement(By.id("BillingNewAddress_Address1"), "12, East gate");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "ME7 5AT");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234566666");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text()='Continue']"));
        Thread.sleep(2000);
        clickOnElement(By.id("shippingoption_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectFromDropDown(By.id("CreditCardType"), "Visa");
        sendTextToElement(By.id("CardholderName"), "Mr Admin");
        sendTextToElement(By.id("CardNumber"), "4111 1111 1111 1111"); //no more than 22 digits
        selectFromDropDown(By.id("ExpireMonth"), "03");
        selectFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);
        compareTexts(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");
       // compareTexts(By.id("shippingoption_2"), "2nd Day Air ($0.00)");
        //verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]"),"2nd Day Air");

        compareTexts(By.xpath("//span[text()='$698.00']"), "$698.00");
        clickOnElement(By.xpath("//button[text()='Confirm']"));
        compareTexts(By.xpath("//h1[text()='Thank you']"), "Thank you");
        compareTexts(By.xpath("//strong[text()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[text()='Continue']"));
        compareTexts(By.xpath("//h2[text()='Welcome to our store']"), "Welcome to our store");
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));
        getCurrentUrl();
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }

}

