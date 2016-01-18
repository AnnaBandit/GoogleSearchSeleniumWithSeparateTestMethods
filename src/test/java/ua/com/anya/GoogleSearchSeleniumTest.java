package ua.com.anya;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.Pages.GoogleSearchPage;
import ua.com.anya.Pages.SeleniumPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleSearchSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        if (!"Google".equals(driver.getTitle())){
            this.driver.get("https://www.google.com/ncr");
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testGoogleSearch(){

        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        googleSearchPage.find("Selenium automates browsers");
        assertEquals(10, googleSearchPage.searchResults.size());

        googleSearchPage.assertFirstLinkContains("Selenium automates browsers");

        SeleniumPage seleniumPage = googleSearchPage.openFirstLink();

        new WebDriverWait(driver, 1000).until(ExpectedConditions.urlMatches("http://www.seleniumhq.org/"));
        System.out.print(seleniumPage.headerText(driver));
        Assert.assertEquals(seleniumPage.headerText(driver), "Selenium - Web Browser Automation");
    }

}
