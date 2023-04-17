package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.TopBarElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage extends TopBarElement {
    private static final By USERNAME = By.className("compact-profile_a");
    private static final By INFO = By.cssSelector(".user-settings_i_tx.textWrap");
    private static final By PERSONAL_LINK = By.cssSelector("[data-l=\"t,personal_link\"]");
    private static final By SETTING_VALUE = By.className("user-settings_i_tx");
    private static final String NAME_POPUP_NAME = "fr.name";
    private static final String NAME_POPUP_SURNAME = "fr.surname";
    private static final String ID_SAVE = "hook_FormButton_button_savePopLayerEditUserProfileNew";
    private static final String URL = "https://ok.ru/settings";

    public SettingsPage() {
        check();
    }

    private void check() {
        getUsername().shouldBe(Condition.visible.because("it is correct username"));
        getInfo().shouldBe(Condition.visible.because("it is correct info"));
        $(PERSONAL_LINK).shouldBe(Condition.visible.because("it is a container for id"));
    }

    public String getURL() {
        return URL;
    }

    public SelenideElement getUsername() {
        return $(USERNAME).shouldBe(Condition.visible);
    }

    public SelenideElement getId() {
        return $(PERSONAL_LINK).$(SETTING_VALUE).shouldBe(Condition.visible);
    }

    public SelenideElement getInfo() {
        return $(INFO).shouldBe(Condition.visible);
    }

    public SettingsPage clickInfo() {
        getInfo().click();
        return this;
    }

    public SelenideElement getNameElement() {
        return $(By.name(NAME_POPUP_NAME)).shouldBe(Condition.visible);
    }

    public SelenideElement getSurnameElement() {
        return $(By.name(NAME_POPUP_SURNAME)).shouldBe(Condition.visible);
    }

    public String getPopupName() {
        return getNameElement().getValue();
    }

    public String getPopupSurname() {
        return getSurnameElement().getValue();
    }

    public SettingsPage setName(String name) {
        getNameElement().clear();
        getNameElement().setValue(name);
        return this;
    }

    public SettingsPage setSurname(String surname) {
        getSurnameElement().clear();
        getSurnameElement().setValue(surname);
        return this;
    }

    public SelenideElement getSaveButton() {
        return $(By.id(ID_SAVE)).shouldBe(Condition.visible);
    }

    public void clickSave() {
        getSaveButton().click();
    }

}
