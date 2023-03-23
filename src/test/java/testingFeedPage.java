import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class testingFeedPage {
    private FeedPage feedPage;
    private final Data data = new Data();
    private final String okEmail = data.getOkEmail();
    private final String okPassword = data.getOkPassword();


    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
    }

    @BeforeEach
    public void beforeEach() {
        feedPage = new LoginPage().open()
                .login(okEmail, okPassword);
    }

    @Test
    public void countingMenuElements() {
        assertThat(feedPage.getMenuElements(), hasSize(9));
    }
}
