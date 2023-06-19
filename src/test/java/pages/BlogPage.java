package pages;

import org.openqa.selenium.By;

public class BlogPage extends BasePage{
    private static final By pageBlog = By.cssSelector("div.page-blog");

    public Boolean blogPage(){
        return element(pageBlog).isDisplayed();
    }
}
