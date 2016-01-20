package ua.com.anya;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.Pages.GoogleSearchPage;

import static org.junit.Assert.assertEquals;
import static ua.com.anya.helpers.Helpers.sizeOf;

public class GoogleSearchSeleniumTest {

    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 1000);

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
        if (!"Google".equals(driver.getTitle())){
            driver.get("https://www.google.com/ncr");
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void testGoogleSearch(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.find("Selenium automates browsers");
        wait.until(sizeOf(googleSearchPage.searchResults, 10));
        googleSearchPage.assertFirstLinkContains("Selenium automates browsers");
}

    @Test
    public void testOpenFirstResultLink(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.findByTextAndOpenFirstResultLink(driver, "Selenium automates browsers");
        assertEquals("Selenium - Web Browser Automation", driver.getTitle());
    }
}
