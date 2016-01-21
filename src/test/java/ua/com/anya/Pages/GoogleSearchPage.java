package ua.com.anya.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ua.com.anya.helpers.CustomConditions.sizeOf;

public class GoogleSearchPage {
    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> results;

    public GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
    }

    public void find(String text){
        searchField.clear();
        searchField.sendKeys(text + Keys.ENTER);
    }

    public void openLink(int number){
        results.get(number).findElement(By.cssSelector(".r>a")).click();
    }

    public void findByTextAndOpenFirstResultLink(WebDriver driver, String text){
        WebDriverWait wait = new WebDriverWait(driver, 1000);

        find(text);
        wait.until(sizeOf(results, 10));
        results.get(0).findElement(By.cssSelector(".r>a")).click();
        wait.until(urlMatches("http://www.seleniumhq.org/"));
    }
}
