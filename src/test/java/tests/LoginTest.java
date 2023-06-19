package tests;

import dataFactory.CadastroDataFactory;
import dtos.CadastroDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class LoginTest extends BaseTest{

    LoginPage loginPage= new LoginPage();
    HomePage homePage = new HomePage();

    CadastroDataFactory cadastroDataFactory = new CadastroDataFactory();

    @Test
    public void testValidarLoginComUsuarioValido(){
        homePage.singInButtonClick();
        loginPage.login("teste@teste.com","12345678");
        loginPage.submitButtonClick();
        String text = loginPage.sucessText();
        Assert.assertEquals(text, "Welcome to your account. Here you can manage all of your personal information and orders.");
    }
    @Test
    public void testValidarMensagemDeErroLoginComSenhaInvalida(){
        homePage.singInButtonClick();
        loginPage.login("teste@teste.com","aaaaaa");
        loginPage.submitButtonClick();
        List<String> text = loginPage.errorText();
        Assert.assertEquals(text.get(0), "Authentication failed.");

    }
    @Test
    public void testValidarMensagemDeErroLoginVazio(){
        homePage.singInButtonClick();
        loginPage.submitButtonClick();
        List<String> text = loginPage.errorText();
        Assert.assertEquals(text.get(0), "An email address required.");
        Assert.assertEquals(text.get(1), "An passwd is required.");

    }
}
