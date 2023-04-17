package ok.login;

import com.codeborne.selenide.Condition;
import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessfulAuthorizationWithButtonTest extends BaseTest {
    private LoginPage loginPage;
    private final Data data = new Data();
    private final String okEmail = data.getOkEmail();
    private final String okPassword = data.getOkPassword();
    private final String username = data.getUsername();

    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
    }

    @Test
    public void successfulAuthorizationButtonTest() {
        loginPage.getLoginButtonElement().shouldBe(Condition.visible);
        assertEquals(username, loginPage.loginWithButton(okEmail, okPassword)
                .getNameSign().text());
    }
}
