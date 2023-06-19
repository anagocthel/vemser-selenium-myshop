package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private static final By singInButton = By.cssSelector("a.login");
    private static final By cartButton = By.cssSelector("div.shopping_cart a");
    private static final By popularButton = By.cssSelector("a.homefeatured");
    private static final By bestSellersButton = By.cssSelector("a.blockbestsellers");
    private static final By alertInfo =By.cssSelector("li.alert.alert-info");
    private static final By adicionarButton = By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default");
    private static final By addProduto1BestSellerButton = By.cssSelector("ul#blockbestsellers>li:first-child a.button.ajax_add_to_cart_button.btn.btn-default");
    private static final By produto1BestSeller = By.cssSelector("ul#blockbestsellers>li:first-child");
    private static final By addProduto2BestSellerButton = By.cssSelector("ul#blockbestsellers>li:nth-child(2) a.button.ajax_add_to_cart_button.btn.btn-default");
    private static final By produto2BestSeller = By.cssSelector("ul#blockbestsellers>li:nth-child(2)");
    private static final By productPrice = By.cssSelector("span.price.product-price");
    private static final By productPrice2 = By.cssSelector("ul#blockbestsellers>li:nth-child(2) span.price.product-price");
    private static final By dressesButton = By.cssSelector("ul.sf-menu.clearfix.menu-content>li:nth-child(2) a[title='Dresses']");
    private static final By tShirtsButton = By.cssSelector("ul.sf-menu.clearfix.menu-content>li:nth-child(3) a[title='T-shirts']");
    private static final By blogButton = By.cssSelector("ul.sf-menu.clearfix.menu-content>li:nth-child(4) a[title='Blog']");
    private static final By userPageButton = By.cssSelector("div.header_user_info");


    public void bestSellersButtonClick(){
        actions.scrollToElement(element(bestSellersButton));
        click(bestSellersButton);
    }

    public void dressesButtonClick(){
        click(dressesButton);
    }

    public void tShirtsButtonClick(){
        click(tShirtsButton);
    }
    public void blogButtonClick(){
        click(blogButton);
    }
    public void singInButtonClick(){
        click(singInButton);
    }
    public void moveToProduto1BestSeller(){
        actions.scrollToElement(element(produto1BestSeller));
        actions.moveToElement(element(produto1BestSeller)).perform();
    }
    public void moveToProduto2BestSeller(){
        actions.moveToElement(element(produto2BestSeller)).perform();
    }

    public void adicionarProduto1ButtonClick(){
        actions.scrollToElement(element(addProduto1BestSellerButton));
        click(addProduto1BestSellerButton);
    }
    public void adicionarProduto2ButtonClick(){
        actions.scrollToElement(element(addProduto2BestSellerButton));
        click(addProduto2BestSellerButton);
    }

    public Boolean adicionarButton(){
        return elements(adicionarButton).size() > 0;
    }
    public void cartButtonClick(){
        actions.scrollToElement(element(cartButton));
        click(cartButton);
    }
    public void popularButtonClick(){
        actions.scrollToElement(element(popularButton));
        click(popularButton);
    }
    public String alertInfo(){
        return element(alertInfo).getText();
    }
    public Integer product1Price(){
        return Integer.valueOf(element(productPrice).getText().replaceAll("[\\D]", ""));
    }
    public Integer product2Price(){
        return Integer.valueOf(element(productPrice2).getText().replaceAll("[\\D]", ""));
    }
}
