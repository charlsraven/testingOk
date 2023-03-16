package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    private static final By USERNAME = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    public SelenideElement getNameSign() {
        return $(USERNAME);
    }

}