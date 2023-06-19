package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.DressesPage;
import pages.HomePage;
import pages.TShirtsPage;

public class HomeTest extends BaseTest {
    HomePage homePage = new HomePage();
    TShirtsPage tShirtsPage = new TShirtsPage();
    DressesPage dressesPage = new DressesPage();
    BlogPage blogPage = new BlogPage();

    @Test
    public void testValidandoPopularNaHomeAlertandoVazioOuExibindoProdutos(){
        homePage.popularButtonClick();
        String text = homePage.alertInfo();
        if(!text.isEmpty()){
            Assert.assertEquals(text, "No featured products at this time.");
        }
        else{
            Assert.assertTrue(homePage.adicionarButton());
        }
    }
    @Test
    public void testValidandoBestSellersNaHomeAlertandoVazioOuExibindoProdutos(){
        homePage.bestSellersButtonClick();
        String text = homePage.alertInfo();
        if(!text.isEmpty()){
            Assert.assertEquals(text, "No featured products at this time.");
        }
        else{
            Assert.assertTrue(homePage.adicionarButton());
        }
    }
    @Test
    public void testValidandoSeOButtonTShirtsAbreAPagina(){
        homePage.tShirtsButtonClick();
        String text = tShirtsPage.tShirtsPageTitulo();

        Assert.assertEquals(text, "T-SHIRTS ");

    }

    @Test
    public void testValidandoSeOButtonDressesAbreAPagina(){
        homePage.dressesButtonClick();
        String text = dressesPage.dressesPageTitulo();

        Assert.assertEquals(text, "DRESSES ");
    }
    @Test
    public void testValidandoSeOButtonBlogAbreAPagina(){
        homePage.blogButtonClick();
        Assert.assertTrue(blogPage.blogPage());
    }
}
