package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.Elements;

public class BasePage extends Elements {
    public static void sendKeys(By by, String text){
        waitElement(by);
        element(by).sendKeys(text);
    }
    public static void moveAndSendKeys(By by, String text){
        waitElement(by);
        element(by).sendKeys(text);
    }

    public static void click(By by) {
        waitElement(by);
        element(by).click();
    }
    public static void moveAndclick(By by) {
        waitElement(by);
        actions.moveToElement(element(by)).click();
    }
    public static void clear(By by){
        waitElement(by);
        element(by).clear();
    }
    public static void moveAndclear(By by){
        waitElement(by);
        actions.moveToElement(element(by));
        element(by).clear();
    }
}
