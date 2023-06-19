package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Elements extends Browser{
    public static WebElement element(By element) {

        return driver.findElement(element);
    }
    public static List<WebElement> elements(By element) {

        return driver.findElements(element);
    }
    public static void waitElement(By element) {

        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
