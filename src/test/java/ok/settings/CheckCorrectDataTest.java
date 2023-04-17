package ok.settings;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SettingsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckCorrectDataTest extends BaseTest {
    private SettingsPage settingsPage;
    static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    @Test
    public void checkCorrectDataTest() {
        assertEquals(DATA.getUsername(), settingsPage.getUsername().text());
        String info = settingsPage.getInfo().text();
        assertEquals(DATA.getUsername(), info.substring(0, info.indexOf(",")));
        assertEquals(DATA.getId(), settingsPage.getId().innerText());
    }
}
