package ok.login;

import ok.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckLoginButtonTextTest extends BaseTest {
    private LoginPage loginPage;
    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
    }
    @Test
    public void findLoginButtonTest() {
        assertEquals("Log in to OK", loginPage.open().getLoginButtonElement().getValue());
    }
}
