package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.TopBarElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SettingsPage extends TopBarElement {
    private static final By USERNAME = By.className("compact-profile_a");
    private static final By INFO = By.xpath("//*[@id=\"hook_Block_UserConfigMRB\"]/div[2]/div[2]/a[1]/div[2]/div");
    private static final By ID = By.xpath("//*[@id=\"hook_Block_UserConfigMRB\"]/div[2]/div[2]/div/div[2]/div");
    private static final String NAME_POPUP_NAME = "fr.name";
    private static final String NAME_POPUP_SURNAME = "fr.surname";
    private static final String ID_SAVE = "hook_FormButton_button_savePopLayerEditUserProfileNew";


    public SettingsPage open() {
        Selenide.open("https://ok.ru/settings");
        return page(SettingsPage.class);
    }

    public SelenideElement getUsername() {
        return $(USERNAME);
    }

    public SelenideElement getId() {
        return $(ID);
    }

    public SelenideElement getInfo() {
        return $(INFO);
    }

    public SettingsPage clickInfo() {
        getInfo().click();
        return this;
    }

    public SelenideElement getNameElement() {
        return $(By.name(NAME_POPUP_NAME));
    }


    public SelenideElement getSurnameElement() {
        return $(By.name(NAME_POPUP_SURNAME));
    }

    public String getPopupName() {
        return getNameElement().getValue();
    }

    public String getPopupSurname() {
        return getSurnameElement().getValue();
    }

    public void setName(String name) {
        getNameElement().clear();
        getNameElement().setValue(name);
    }

    public void setSurname(String surname) {
        getSurnameElement().clear();
        getSurnameElement().setValue(surname);
    }

    public SelenideElement getSaveButton() {
        return $(By.id(ID_SAVE));
    }

    public void clickSave() {
        getSaveButton().click();
    }

}
