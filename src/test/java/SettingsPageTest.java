import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.SettingsPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SettingsPageTest {
    private SettingsPage settingsPage;
    static Data data = new Data();

    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @BeforeEach
    public void openSettingsPage() {
        new LoginPage().open().login(data.getOkEmail(), data.getOkPassword());
        settingsPage = new SettingsPage().open();
    }

    @Test
    public void visibilityTest() {
        settingsPage.getUsername().shouldBe(Condition.visible);
        settingsPage.getInfo().shouldBe(Condition.visible);
        settingsPage.getId().shouldBe(Condition.visible);
    }

    @Test
    public void getPopupPageTest() {
        settingsPage = settingsPage.clickInfo();
        settingsPage.getNameElement().shouldBe(Condition.visible);
        settingsPage.getSurnameElement().shouldBe(Condition.visible);
        settingsPage.getSaveButton().shouldBe(Condition.visible);
    }


    @Test
    public void correctInfoUsername() {
        String info = settingsPage.getInfo().text();
        assertThat(data.getUsername() + info.substring(info.indexOf(",")), equalTo(info));
    }

    @Test
    public void surnameTest() {
        String info = settingsPage.getInfo().text();
        String gotName = settingsPage.clickInfo().getPopupName();
        String gotSurname = settingsPage.getPopupSurname();
        assertThat(info.replace(data.getName(), gotName).replace(data.getSurname(), gotSurname), equalTo(info));
    }

    static Stream<String> namesProviderFactory() {
        return Stream.of("NEWNAME", data.getName());
    }

    @ParameterizedTest(name = "changed name to {0}")
    @MethodSource("namesProviderFactory")
    public void changeNameTest(String newName) {
        String id = settingsPage.getId().text();
        String info = settingsPage.getInfo().text();
        String username = settingsPage.getUsername().text();

        settingsPage.clickInfo().setName(newName);
        settingsPage.clickSave();
        refresh();

        assertThat(settingsPage.getId().text(), equalTo(id));
        assertThat(settingsPage.getUsername().text(),
                equalTo(newName + username.substring(username.indexOf(" "))));
        assertThat(settingsPage.getInfo().text(),
                equalTo(newName + info.substring(info.indexOf(" "))));
    }

    static Stream<String> surnamesProviderFactory() {
        return Stream.of("NEWSURNAME", data.getSurname());
    }

    @ParameterizedTest(name = "changed surname to {0}")
    @MethodSource("surnamesProviderFactory")
    public void changeSurnameTest(String newSurname) {
        String id = settingsPage.getId().text();
        String info = settingsPage.getInfo().text();
        String username = settingsPage.getUsername().text();

        settingsPage.clickInfo().setSurname(newSurname);
        settingsPage.clickSave();
        refresh();

        assertThat(settingsPage.getId().text(), equalTo(id));
        assertThat(settingsPage.getUsername().text(),
                equalTo(username.substring(0, username.indexOf(" ") + 1) + newSurname));
        assertThat(settingsPage.getInfo().text(),
                equalTo(info.substring(0, info.indexOf(" ") + 1) + newSurname + info.substring(info.indexOf(","))));
    }


    @Test
    public void changeNameAndSurnameTest() {
        String id = settingsPage.getId().text();
        String info = settingsPage.getInfo().text();

        String newName = data.getName().toLowerCase();
        String newSurname = data.getSurname().toLowerCase();
        settingsPage.clickInfo().setName(newName);
        settingsPage.setSurname(newSurname);
        settingsPage.clickSave();
        refresh();

        assertThat(settingsPage.getId().text(), equalTo(id));
        assertThat(settingsPage.getUsername().text(),
                equalTo(newName + " " + newSurname));
        assertThat(settingsPage.getInfo().text(),
                equalTo(newName + " " + newSurname + info.substring(info.indexOf(","))));
    }


}
