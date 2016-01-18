package ua.com.anya.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage {
    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> searchResults;

    private WebDriver driver;

    public GoogleSearchPage find(String text){
        searchField.sendKeys(text + Keys.ENTER);
        return this;
    }

    public GoogleSearchPage assertFirstLinkContains(String text){
        searchResults.get(0).getText().contains(text);
        return this;
    }

    public SeleniumPage openFirstLink(){
        searchResults.get(0).findElement(By.cssSelector(".r>a")).click();
        return PageFactory.initElements(driver, SeleniumPage.class);
    }


}
