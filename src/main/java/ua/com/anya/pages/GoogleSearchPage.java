package ua.com.anya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.core.CustomConditions;

import java.util.List;

public class GoogleSearchPage {

    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> results;

    public void search(String text){
        searchField.sendKeys(text + Keys.ENTER);
    }

    public void openNthLinkInList(int number, List<WebElement> list, WebDriver driver){
        new WebDriverWait(driver, 10).until(CustomConditions.NthElementIsEnabled(list, number));
        results.get(number).findElement(By.cssSelector(".r>a")).click();
    }

    public static void ensureGooglePageIsOpened(WebDriver driver){
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
    }
}

