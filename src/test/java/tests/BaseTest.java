package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest extends Browser {
    @BeforeMethod
    public void abrirNavegador(){
        browserUp("http://www.automationpractice.pl/index.php");
    }

    @AfterMethod
    public void fecharNavegador(){
        browserDown();
    }

}
