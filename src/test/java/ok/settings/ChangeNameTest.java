package ok.settings;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.SettingsPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChangeNameTest extends BaseTest {
    private SettingsPage settingsPage;
    static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    static Stream<String> namesProviderFactory() {
        return Stream.of("NEWNAME", DATA.getName());
    }

    @ParameterizedTest(name = "changed name to {0}")
    @MethodSource("namesProviderFactory")
    public void changeNameTest(String newName) {
        String id = settingsPage.getId().text();
        String info = settingsPage.getInfo().text();
        String username = settingsPage.getUsername().text();

        settingsPage.clickInfo().setName(newName).clickSave();

        refresh();
        settingsPage = new SettingsPage();

        assertThat(settingsPage.getId().text(), equalTo(id));
        assertThat(settingsPage.getUsername().text(),
                equalTo(newName + username.substring(username.indexOf(" "))));
        assertThat(settingsPage.getInfo().text(),
                equalTo(newName + info.substring(info.indexOf(" "))));
    }

}
