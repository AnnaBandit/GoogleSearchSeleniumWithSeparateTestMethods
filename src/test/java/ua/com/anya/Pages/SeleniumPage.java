package ua.com.anya.Pages;

import org.openqa.selenium.WebDriver;

public class SeleniumPage {

    public String headerText(WebDriver driver){
        return driver.getTitle();
    }
}
