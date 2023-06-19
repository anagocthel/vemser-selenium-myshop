package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage{
    private static final By email = By.cssSelector("input#email");
    private static final By password = By.cssSelector("input#passwd");
    private static final By submitButton = By.cssSelector("button#SubmitLogin");
    private static final By sucessText = By.cssSelector("p.info-account");
    private static final By errorText = By.cssSelector("div.alert.alert-danger li");

    public void login(String emailText, String passwordText){
        sendKeys(email, emailText);
        sendKeys(password, passwordText);
    }
    public void submitButtonClick(){
        click(submitButton);
    }
    public String sucessText(){
        return element(sucessText).getText();
    }
    public List<String> errorText(){
        List<String> erroLista = new ArrayList<>();
        for (WebElement elementos : elements(errorText)){
            erroLista.add(elementos.getText());
        };
        return erroLista;
    }
}
