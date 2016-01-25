package ua.com.anya.configs;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AtGoogleSearchPageWithCreatedDriver {

    public static WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @Before
    public void ensureGooglePageIsOpened(){
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
