package elements;

import com.codeborne.selenide.Condition;
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
        return $(By.className(DROPDOWN_MENU_CLASS)).shouldBe(Condition.visible);
    }

    public TopBarElement clickDropdown(){
        getDropdownMenu().click();
        return this;
    }

    public SelenideElement getSettingsOnDropDownMenu() {
        return $(By.cssSelector(SETTINGS_SELECTOR));
    }

    public SelenideElement getNameOnDropDownMenu() {
        return $(DROPDOWN_NAME_CLASS);
    }

    public SettingsPage openSettingsPage() {
        clickDropdown().getSettingsOnDropDownMenu().click();

        var p = page(SettingsPage.class);
        p.getUsername();
        return p;
    }

}
