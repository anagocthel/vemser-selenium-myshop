package pages;

import dtos.EnderecoDTO;
import org.openqa.selenium.By;

public class EnderecoPage extends BasePage{
    private static final By company= By.cssSelector("input#company");
    private static final By address1 = By.cssSelector("input#address1");
    private static final By city = By.cssSelector("input#city");
    private static final By state= By.cssSelector("select#id_state opion[value='3']");
    private static final By postcode= By.cssSelector("input#postcode");
    private static final By phone = By.cssSelector("input#phone");
    private static final By phoneMobile = By.cssSelector("input#phone_mobile");
    private static final By additionalInformation = By.cssSelector("input#other");
    private static final By title = By.cssSelector("input#alias");
    private static final By saveButton = By.cssSelector("button#submitAddress");

    public void novoEndereco(EnderecoDTO enderecoDTO){
        sendKeys(company,enderecoDTO.getCompany());
        sendKeys(address1, enderecoDTO.getAddress());
        sendKeys(city, enderecoDTO.getCity());
        click(state);
        sendKeys(postcode, enderecoDTO.getZipCode());
        sendKeys(phone, enderecoDTO.getHomePhone());
        saveButtonClick();
    }

    public void saveButtonClick(){
        click(saveButton);
    }

}
