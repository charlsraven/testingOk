package ok.feed;

import com.codeborne.selenide.WebDriverRunner;
import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;
import pages.SettingsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GotoSettingsTest extends BaseTest {
    private FeedPage feedPage;

    @BeforeEach
    public void beforeEach() {
        final Data data = new Data();
        feedPage = new LoginPage().open().login(data.getOkEmail(), data.getOkPassword());
    }

    @Test
    public void gotoSettingsTest() {
        SettingsPage settingsPage = feedPage.openSettingsPage();
        assertEquals(settingsPage.getURL(), WebDriverRunner.url());
    }

}
