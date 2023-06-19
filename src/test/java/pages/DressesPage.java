package pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage{
    private static final By dressesPageTitulo = By.cssSelector("span.cat-name");

    public String dressesPageTitulo(){
        return element(dressesPageTitulo).getText();
    }
}
