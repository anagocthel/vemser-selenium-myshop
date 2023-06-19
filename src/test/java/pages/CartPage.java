package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    private static final  By alertWaring = By.cssSelector("p.alert.alert-warning");
    private static final By productPrice1 = By.cssSelector("tr.cart_item.first_item address_0.odd span#total_product_price_2_7_0");
    private static final By productPrice2 = By.cssSelector("tr.cart_item.last_item.address_0.even span#total_product_price_2_7_0");
    private static final By proccedToCheckoutButton = By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium");

    public String alertWarningCartEmpty(){
        return element(alertWaring).getText();
    }
    public Integer productPrice1(){
        return Integer.valueOf(element(productPrice1).getText().replaceAll("[\\D]", ""));
    }
    public Integer productPrice2(){
        return Integer.valueOf(element(productPrice2).getText().replaceAll("[\\D]", ""));
    }

    public void proccedToCheckoutButton(){

        click(proccedToCheckoutButton);
    }
}
