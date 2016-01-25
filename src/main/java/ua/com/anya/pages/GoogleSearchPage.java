package ua.com.anya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchPage {

    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> results;

    public void search(String text){
        searchField.sendKeys(text + Keys.ENTER);
    }

    public void openNthLink(int number){
        results.get(number).findElement(By.cssSelector(".r>a")).click();
    }
}

