package ok.settings;

import com.codeborne.selenide.SelenideElement;
import ok.BaseTest;
import ok.Data;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.SettingsPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChangeSurnameTest extends BaseTest {
    private SettingsPage settingsPage;
    static final Data DATA = new Data();

    @BeforeEach
    public void openSettingsPage() {
        settingsPage = new LoginPage().open().login(DATA.getOkEmail(), DATA.getOkPassword())
                .openSettingsPage();
    }

    static @NotNull Stream<String> surnamesProviderFactory() {
        return Stream.of("NEWSURNAME", DATA.getSurname());
    }

    @ParameterizedTest(name = "changed surname to {0}")
    @MethodSource("surnamesProviderFactory")
    public void changeSurnameTest(String newSurname) {
        String id = settingsPage.getId().text();
        String info = settingsPage.getInfo().text();
        String username = settingsPage.getUsername().text();

        settingsPage.clickInfo().setSurname(newSurname).clickSave();

        refresh();
        SelenideElement idElement = settingsPage.getId();

        assertThat(idElement.text(), equalTo(id));
        assertThat(settingsPage.getUsername().text(),
                equalTo(username.substring(0, username.indexOf(" ") + 1) + newSurname));
        assertThat(settingsPage.getInfo().text(),
                equalTo(info.substring(0, info.indexOf(" ") + 1) + newSurname + info.substring(info.indexOf(","))));
    }

}
