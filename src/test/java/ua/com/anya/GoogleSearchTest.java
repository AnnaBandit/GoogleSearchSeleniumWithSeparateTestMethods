package ua.com.anya;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ua.com.anya.configs.AtGoogleSearchPageWithCreatedDriver;
import ua.com.anya.pages.GoogleSearchPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.sizeOf;

public class GoogleSearchTest extends AtGoogleSearchPageWithCreatedDriver {

    GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

    @Test
    public void testGoogleSearch(){
        googleSearchPage.search("Selenium automates browsers");
        wait.until(listNthElementHasText(googleSearchPage.results, 0, "Selenium automates browsers"));
        wait.until(sizeOf(googleSearchPage.results, 10));
    }

    @Test
    public void testOpenFirstResultLink(){
        googleSearchPage.search("Selenium automates browsers");
        wait.until(listNthElementHasText(googleSearchPage.results, 0, "Selenium automates browsers"));
        googleSearchPage.openNthLink(0);
        wait.until(titleIs("Selenium - Web Browser Automation"));
    }
}