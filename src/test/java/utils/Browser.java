package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {

    public static WebDriver driver;

    public static WebDriverWait wait;
    public static Actions actions;

    public void browserUp(String url){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
        actions= new Actions(driver);

        driver.get(url);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void browserDown(){
        driver.quit();
    }
}
