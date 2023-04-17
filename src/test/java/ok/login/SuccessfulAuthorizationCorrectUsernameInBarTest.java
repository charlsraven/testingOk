package ok.login;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessfulAuthorizationCorrectUsernameInBarTest extends BaseTest {

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
    public void successfulAuthorizationCorrectUsernameInBarTest() {
        FeedPage feedPage = loginPage.open().login(okEmail, okPassword);
        assertEquals(username, feedPage.getNameOnDropDownMenu().innerText());
    }
}
