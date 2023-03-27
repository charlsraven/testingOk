package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.TopBarElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FeedPage extends TopBarElement {
    private final By MENU_ELEMENT = By.className("nav-side_i-w");
    private static final By USERNAME = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    public SelenideElement getNameSign() {
        return $(USERNAME);
    }

    public List<SelenideElement> getMenuElements() {
        return $$(MENU_ELEMENT);
    }

    public SettingsPage openSettingsPage(){
        Selenide.open("https://ok.ru/settings");
        return Selenide.page(SettingsPage.class);
    }

}