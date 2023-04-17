package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.SettingsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TopBarElement {
    private static final String DROPDOWN_MENU_CLASS = "toolbar_ucard";
    private static final String SETTINGS_SELECTOR = "[data-l=\"t,settings\"]";
    private static final String DROPDOWN_NAME_CLASS = "toolbar_accounts-user_name";

    public SelenideElement getDropdownMenu() {
        return $(By.className(DROPDOWN_MENU_CLASS));
    }

    public TopBarElement clickDropdown(){
        getDropdownMenu().click();
        return this;
    }

    private SelenideElement getSettingsOnDropDownMenu() {
        return $(By.cssSelector(SETTINGS_SELECTOR));
    }

    private SelenideElement getDropdownName() {
        return $(By.className(DROPDOWN_NAME_CLASS));
    }
    public SelenideElement getNameOnDropDownMenu() {
        return clickDropdown().getDropdownName();
    }

    public SettingsPage openSettingsPage() {
        clickDropdown().getSettingsOnDropDownMenu().click();

        var p = page(SettingsPage.class);
        p.getUsername();
        return p;
    }

}
