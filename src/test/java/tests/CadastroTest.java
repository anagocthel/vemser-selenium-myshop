package tests;

import dataFactory.CadastroDataFactory;
import dtos.CadastroDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CadastroPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class CadastroTest extends BaseTest{

    CadastroDataFactory cadastroDataFactory = new CadastroDataFactory();
    CadastroPage cadastroPage = new CadastroPage();
    HomePage homePage = new HomePage();

    @Test
    public void testValidarCriacaoDeUsuarioComUsuarioValido(){

        CadastroDTO usuarioValido = cadastroDataFactory.cadastroValido();
        homePage.singInButtonClick();
        cadastroPage.registrarUsuario(usuarioValido);
        String texto = cadastroPage.getSuccesAlert();
        Assert.assertEquals(texto,"Your account has been created.");
    }
    @Test
    public void testValidarEnvioDeEmailVazioPreCadastro(){
        homePage.singInButtonClick();
        cadastroPage.submitEmailCreateButton();
        String texto = cadastroPage.errorAlertEmailPreCadastro();

        Assert.assertEquals(texto,"Invalid email address.");
    }
    @Test
    public void testValidarCriacaoDeUsuarioVazio(){

        String email = cadastroDataFactory.emailValido();
        homePage.singInButtonClick();
        cadastroPage.enviarEmail(email);
        cadastroPage.submitEmailCreateButton();
        cadastroPage.submitAccountButton();
        List<String> erros = cadastroPage.getErrorAlert();
        System.out.println(erros);
        Assert.assertEquals(erros.get(0), "lastname is required.");
        Assert.assertEquals(erros.get(1), "firstname is required.");
        Assert.assertEquals(erros.get(2), "passwd is required.");
    }
    @Test
    public void testValidarCriacaoDeUsuarioSemPrimeiroNome(){

        CadastroDTO usuarioValido = cadastroDataFactory.cadastroSemPrimeiroNome();
        homePage.singInButtonClick();
        cadastroPage.registrarUsuario(usuarioValido);
        List<String> erros = cadastroPage.getErrorAlert();
        System.out.println(erros);
        Assert.assertEquals(erros.get(0), "firstname is required.");
        Assert.assertEquals(erros.size(),1);
    }
    @Test
    public void testValidarCriacaoDeUsuarioSemSobrenome(){
        CadastroDTO usuarioValido = cadastroDataFactory.cadastroSemSobrenome();
        homePage.singInButtonClick();
        cadastroPage.registrarUsuario(usuarioValido);
        List<String> erros = cadastroPage.getErrorAlert();
        System.out.println(erros);
        Assert.assertEquals(erros.get(0), "lastname is required.");
        Assert.assertEquals(erros.size(),1);
    }
    @Test
    public void testValidarCriacaoDeUsuarioSemSenha(){
        CadastroDTO usuarioValido = cadastroDataFactory.cadastroSemSenha();
        homePage.singInButtonClick();
        cadastroPage.registrarUsuario(usuarioValido);
        List<String> erros = cadastroPage.getErrorAlert();
        Assert.assertEquals(erros.get(0), "passwd is required.");
        Assert.assertEquals(erros.size(),1);
    }

}
