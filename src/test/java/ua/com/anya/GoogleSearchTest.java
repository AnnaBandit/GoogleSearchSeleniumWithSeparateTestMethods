package ua.com.anya;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ua.com.anya.configs.BaseTest;
import ua.com.anya.pages.GoogleSearchPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.sizeOf;

public class GoogleSearchTest extends BaseTest{

    GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

    @Before
    public void atGooglePage(){
        googleSearchPage.ensureGooglePageIsOpened();
    }

    @Test
    public void testGoogleSearch(){
        googleSearchPage.search("Selenium automates browsers");
        wait.until(listNthElementHasText(googleSearchPage.results, 0, "Selenium automates browsers"));
        wait.until(sizeOf(googleSearchPage.results, 10));

        googleSearchPage.openNthLinkInList(0);
        wait.until(titleIs("Selenium - Web Browser Automation"));
    }

    @Test
    public void testFollowLink(){
        googleSearchPage.search("Selenium automates browsers");
        googleSearchPage.openNthLinkInList(6);
        wait.until(titleIs("Selenium Tutorial For Beginners"));
    }
}