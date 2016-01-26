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

    WebDriver driver;

    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> results;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String text){
        searchField.sendKeys(text + Keys.ENTER);
    }

    public WebElement getNthElementFromTheList(int index, List<WebElement> elements) {
        new WebDriverWait(driver, 10).until(CustomConditions.NthElementIsEnabled(index, elements));
        return elements.get(index);
    }

    public void openNthLinkInList(int index, List<WebElement> elements){
        getNthElementFromTheList(index, elements).findElement(By.cssSelector(".r>a")).click();
    }

    public void ensureGooglePageIsOpened(){
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
    }
}

