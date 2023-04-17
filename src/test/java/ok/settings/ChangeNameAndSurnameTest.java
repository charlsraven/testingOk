package ok.settings;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SettingsPage;

import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChangeNameAndSurnameTest extends BaseTest {
    private SettingsPage settingsPage;
    static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    @Test
    public void changeNameAndSurnameTest() {
        String id = settingsPage.getId().text();
        String info = settingsPage.getInfo().text();

        String newName = DATA.getName().toLowerCase();
        String newSurname = DATA.getSurname().toLowerCase();
        settingsPage.clickInfo().setName(newName).setSurname(newSurname).clickSave();

        refresh();
        settingsPage = new SettingsPage();

        assertThat(settingsPage.getId().text(), equalTo(id));
        assertThat(settingsPage.getUsername().text(),
                equalTo(newName + " " + newSurname));
        assertThat(settingsPage.getInfo().text(),
                equalTo(newName + " " + newSurname + info.substring(info.indexOf(","))));
    }

}
