package ua.com.anya.configs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.Configuration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, Configuration.timeout);

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
