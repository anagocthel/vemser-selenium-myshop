package pages;

import dtos.CadastroDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CadastroPage extends BasePage{

    HomePage homePage = new HomePage();
    private static final By emailCreate = By.cssSelector("input#email_create");
    private static final By submitEmailCreateButton = By.cssSelector("button#SubmitCreate");
    private static final By firstName = By.cssSelector("input#customer_firstname");
    private static final By lastName = By.cssSelector("input#customer_lastname");
    private static final By password = By.cssSelector("input#passwd");
    private static final By selectDay30Birth = By.cssSelector("select#days option[value='30']");
    private static final By selectDay1Birth = By.cssSelector("select#days option[value='1']");
    private static final By selectMonthBirth = By.cssSelector("select#months option[value='2']");
    private static final By selectYear2000Birth = By.cssSelector("select#years option[value='2000']");
    private static final By submitAccountButton = By.cssSelector("button#submitAccount");
    private static final By successAlert = By.cssSelector("p.alert.alert-success");
    private static final By errorAlertCadastro = By.cssSelector("div.alert.alert-danger li");
    private static final By errorAlertEmailPreCadastro = By.cssSelector("div#create_account_error ol>li:first-child");



    public void enviarEmail(String text){
        sendKeys(emailCreate, text);
    }
    public String getSuccesAlert(){
       return element(successAlert).getText();
    }

    public List<String> getErrorAlert(){
        List<String> erroLista = new ArrayList<>();
         for (WebElement elementos : elements(errorAlertCadastro)){
            erroLista.add(elementos.getText());
         };
         return erroLista;
    }
    public String errorAlertEmailPreCadastro(){
        return element(errorAlertEmailPreCadastro).getText();
    }
    public void registrarUsuario(CadastroDTO cadastroDTO){

        enviarEmail(cadastroDTO.getEmailCreate());
        submitEmailCreateButton();
        registrarUserSendKeys(cadastroDTO);
        click(selectDay1Birth);
        click(selectMonthBirth);
        click(selectYear2000Birth);
        submitAccountButton();
    }

    public CadastroDTO registrarUsuarioAniversarioInvalido(CadastroDTO cadastroDTO){
        registrarUserSendKeys(cadastroDTO);
        click(selectDay30Birth);
        click(selectMonthBirth);
        click(selectYear2000Birth);
        return cadastroDTO;
    }
    public void registrarUserSendKeys(CadastroDTO cadastroDTO){
        sendKeys(firstName, cadastroDTO.getFirstName());
        sendKeys(lastName, cadastroDTO.getLastName());
        sendKeys(password, cadastroDTO.getPassword());
    }


    public void submitEmailCreateButton(){

        click(submitEmailCreateButton);
    }

    public void submitAccountButton(){

        click(submitAccountButton);
    }
}
