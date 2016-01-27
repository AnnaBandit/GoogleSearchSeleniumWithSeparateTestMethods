package ua.com.anya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.core.CustomConditions;

import java.util.List;

public class BasePage {

    public WebElement get(int index, List<WebElement> elements, WebDriver driver) {
        new WebDriverWait(driver, 10).until(CustomConditions.listHasSizeMoreThan(elements, index));
        return elements.get(index);
    }
}
