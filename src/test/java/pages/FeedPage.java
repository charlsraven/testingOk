package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class FeedPage {
    private final By MENU_ELEMENT = By.className("nav-side_i-w");
    private static final By USERNAME = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    public SelenideElement getNameSign() {
        return $(USERNAME);
    }

    public List<SelenideElement> getMenuElements() {
        return $$(MENU_ELEMENT);
    }

}