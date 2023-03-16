import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class OkTest {

    private LoginPage loginPage;
    private final Data data = new Data();
    private final String okEmail = data.getOkEmail();
    private final String okPassword = data.getOkPassword();
    private final String username = data.getUsername();


    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
    }

    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @Test
    public void successfulAuthorizationTabEnterTest() {
        loginPage.open()
                .login(okEmail, okPassword)
                .getNameSign()
                .shouldHave(Condition.text(username));
    }

    @Test
    public void successfulAuthorizationButtonTest() {
        loginPage.open()
                .loginWithButton(okEmail, okPassword)
                .getNameSign()
                .shouldHave(Condition.text(username));
    }

}