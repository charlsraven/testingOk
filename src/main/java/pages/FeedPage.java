package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.TopBarElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FeedPage extends TopBarElement {
    private final By MENU_ELEMENT = By.className("nav-side_i-w");
    private static final By USERNAME = By.cssSelector("[data-l=\"t,userPage\"]");

    public SelenideElement getNameSign() {
        return $(USERNAME).shouldBe(Condition.visible);
    }

    public List<SelenideElement> getMenuElements() {
        return $$(MENU_ELEMENT);
    }

}