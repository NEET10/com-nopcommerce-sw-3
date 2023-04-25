package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        //method to click on the menu
        clickOnElement(By.linkText(menu));

    }
    @Test
    public void verifyPageNavigation() {
        //verifyPageNavigation
        selectMenu("Computers");
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals("Error message not displayed","Computers", actualMessage);
    }
    @After
    public void tearDown(){
       closeBrowser();
    }
}