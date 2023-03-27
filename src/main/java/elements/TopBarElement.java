package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopBarElement {
    private static final By SETTINGS_MENU = By.xpath("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/div[1]");
    private static final By GOTO_SETTINGS = By.xpath("//*[@id=\"user-dropdown-menu\"]/div[1]/div/div[2]/ul/li[1]/a");

    public SelenideElement getSettingsMenu() {
        return $(SETTINGS_MENU);
    }

    public SelenideElement getGotoSettings() {
        return $(GOTO_SETTINGS);
    }

    public TopBarElement clickSettings() {
        getSettingsMenu().click();
        return this;
    }

}
