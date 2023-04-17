package ok.settings;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SettingsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckUsernameOnPopupTest extends BaseTest {
    private SettingsPage settingsPage;
    private static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    @Test
    public void checkUsernameOnPopupTest() {
        settingsPage = settingsPage.clickInfo();
        assertEquals(DATA.getName(), settingsPage.getNameElement().getValue());
        assertEquals(DATA.getSurname(), settingsPage.getSurnameElement().getValue());
    }
}
