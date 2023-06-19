package tests;

import dataFactory.CadastroDataFactory;
import dataFactory.EnderecoDataFactory;
import dtos.CadastroDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest{
    CadastroDataFactory cadastroDataFactory = new CadastroDataFactory();
    EnderecoDataFactory enderecoDataFactory = new EnderecoDataFactory();
    CadastroPage cadastroPage = new CadastroPage();
    CartPage cartPage = new CartPage();
    HomePage homePage = new HomePage();
    WomenPage womenPage = new WomenPage();
    EnderecoPage enderecoPage= new EnderecoPage();

    @Test
    public void testValidandoCarrinhoVazioNovoUsuario(){
        CadastroDTO cadastroDTO = cadastroDataFactory.cadastroValido();
        homePage.singInButtonClick();
        cadastroPage.registrarUsuario(cadastroDTO);
        homePage.cartButtonClick();
        String text = cartPage.alertWarningCartEmpty();
        Assert.assertEquals(text, "Your shopping cart is empty.");
    }
    @Test
    public void testValidandoProdutoAdicionadoPelaHomeBestSeller(){
        homePage.bestSellersButtonClick();
        homePage.moveToProduto1BestSeller();
        Integer priceHome = homePage.product1Price();
        homePage.adicionarProduto1ButtonClick();
        homePage.cartButtonClick();
        Integer priceCart = cartPage.productPrice1();

        Assert.assertEquals(priceCart, priceHome);
    }
    @Test
    public void testValidandoProdutoAdicionadoPelaTelaWomen(){
        womenPage.womenButtonClick();
        womenPage.moveToProduto1Women();
        Integer priceHome = homePage.product1Price();
        womenPage.adicionarProduto1WomenButtonClick();
        homePage.cartButtonClick();
        Integer priceCart = cartPage.productPrice1();

        Assert.assertEquals(priceCart, priceHome);
    }
    @Test
    public void testValidandoMaisDeUmProdutoAdicionadoPelaTelaHome(){
        homePage.bestSellersButtonClick();
        homePage.moveToProduto1BestSeller();
        Integer priceHome1 = homePage.product1Price();
        homePage.adicionarProduto1ButtonClick();
        homePage.moveToProduto2BestSeller();
        Integer priceHome2 = homePage.product2Price();
        homePage.adicionarProduto2ButtonClick();
        homePage.cartButtonClick();
        Integer priceCart1 = cartPage.productPrice1();
        Integer priceCart2 = cartPage.productPrice2();

        Assert.assertEquals(priceCart1, priceHome1);

        Assert.assertEquals(priceCart2, priceHome2);
    }
    @Test
    public void testValidandoFinalizandoCompraContornandoErro(){
        CadastroDTO cadastroDTO = cadastroDataFactory.cadastroValido();
        homePage.bestSellersButtonClick();
        String url = driver.getCurrentUrl();
        homePage.moveToProduto1BestSeller();
        homePage.adicionarProduto1ButtonClick();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get(url);
        homePage.cartButtonClick();
        cartPage.proccedToCheckoutButton();
        cadastroPage.registrarUsuario(cadastroDTO);
        enderecoPage.novoEndereco(enderecoDataFactory.enderecoValido());
        cartPage.proccedToCheckoutButton();

    }

}
