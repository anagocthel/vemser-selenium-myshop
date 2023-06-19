package pages;

import org.openqa.selenium.By;

public class TShirtsPage extends BasePage{
    private static final By tShirtsPageTitulo = By.cssSelector("span.cat-name");

    public String tShirtsPageTitulo(){
        return element(tShirtsPageTitulo).getText();
    }
}

