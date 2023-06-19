package pages;

import org.openqa.selenium.By;

public class WomenPage extends BasePage{
    private static final By addProduto1WomenButton = By.cssSelector("ul.product_list.grid.row>li:first-child a.button.ajax_add_to_cart_button.btn.btn-default");
    private static final By produto1Women = By.cssSelector("ul.product_list.grid.row>li:first-child");
    private static final By womenButton = By.cssSelector("a[title='Women']");
    public void womenButtonClick(){
        click(womenButton);
    }
    public void moveToProduto1Women(){
        actions.scrollToElement(element(produto1Women));
        actions.moveToElement(element(produto1Women)).perform();
    }
    public void adicionarProduto1WomenButtonClick(){
        actions.scrollToElement(element(addProduto1WomenButton));
        click(addProduto1WomenButton);
    }
}
