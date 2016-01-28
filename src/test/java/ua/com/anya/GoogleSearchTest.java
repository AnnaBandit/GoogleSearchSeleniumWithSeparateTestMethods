package ua.com.anya;

import org.junit.Before;
import org.junit.Test;
import ua.com.anya.pages.GoogleSearchPage;
import ua.com.anya.testconfigs.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.sizeOf;
import static ua.com.anya.core.Helpers.assertThat;

public class GoogleSearchTest extends BaseTest{

    GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

    @Before
    public void atGooglePage(){
        googleSearchPage.ensureGooglePageIsOpened();
    }

    @Test
    public void testSearch(){
        googleSearchPage.search("Selenium automates browsers");
        assertThat(listNthElementHasText(googleSearchPage.results, 0, "Selenium automates browsers"), driver);
        assertThat(sizeOf(googleSearchPage.results, 10), driver);
    }

    @Test
    public void testFollowLink(){
        googleSearchPage.search("Selenium automates browsers");
        googleSearchPage.openNthLinkInList(1);
        assertThat(titleIs("Introduction — Selenium Documentation"), driver);
    }
}