package ok.settings;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SettingsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckCorrectInfoUsernameTest extends BaseTest {
    private SettingsPage settingsPage;
    static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().open().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    @Test
    public void correctInfoUsernameTest() {
        String info = settingsPage.getInfo().text();
        assertThat(DATA.getUsername() + info.substring(info.indexOf(",")), equalTo(info));
    }

}
