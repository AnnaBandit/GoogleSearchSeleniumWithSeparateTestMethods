package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomConditions{

    public static ExpectedCondition<Boolean> listNthElementHasText(final List<WebElement> elements, final int index, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return elements.get(index).getText().contains(expectedText);
                } catch (IndexOutOfBoundsException ex) {
                    return false;
                }
            }

            public String toString() {
                return String.format("There is no '%s' text on the element number %s.", expectedText, index);
            }
        };
    }

    public static ExpectedCondition<Boolean> sizeOf(final List<WebElement> elements, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            public Boolean apply(WebDriver driver) {
                listSize = elements.size();
                return listSize == expectedSize;
            }

            public String toString(){
                return String.format("Actual size of the list is %s,\nexpected size is %s", listSize, expectedSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> NthElementIsEnabled(final List<WebElement> elements, final int index) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return elements.get(index).isEnabled();
                } catch (IndexOutOfBoundsException ex) {
                    return false;
                }
            }

            public String toString(){
                return String.format("There is no element number %s in the list", index);
            }
        };
    }

}