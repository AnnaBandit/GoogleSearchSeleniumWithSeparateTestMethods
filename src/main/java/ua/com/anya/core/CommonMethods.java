package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.Configuration;

import java.util.List;

import static ua.com.anya.core.CustomConditions.listHasSizeMoreThan;

public class CommonMethods {

    public static WebElement get(List<WebElement> elements, int index, WebDriver driver) {
        return get(elements, index, driver, Configuration.timeout);
    }

    public static WebElement get(List<WebElement> elements, int index, WebDriver driver, int timeout) {
        new WebDriverWait(driver, timeout).until(listHasSizeMoreThan(elements, index));
        return elements.get(index);
    }
}
