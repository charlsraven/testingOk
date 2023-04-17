package ok.settings;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SettingsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckSurnameTest extends BaseTest {
    private SettingsPage settingsPage;
    static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    @Test
    public void surnameTest() {
        String info = settingsPage.getInfo().text();
        String gotName = settingsPage.clickInfo().getPopupName();
        String gotSurname = settingsPage.getPopupSurname();
        assertThat(info.replace(DATA.getName(), gotName).replace(DATA.getSurname(),
                gotSurname), equalTo(info));
    }

}
