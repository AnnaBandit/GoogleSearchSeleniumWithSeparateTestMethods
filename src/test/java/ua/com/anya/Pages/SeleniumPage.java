package ua.com.anya.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumPage {

    @FindBy(css = "#header h1 a")
    public WebElement headerLinkOnSeleniumPage;

    public String headerText(WebDriver driver){
        return driver.getTitle();
    }

}
