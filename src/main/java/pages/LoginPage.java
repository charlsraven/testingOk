package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage{

    private static final By USERNAME_LOCATOR = By.id("field_email");
    private static final By PASSWORD_LOCATOR = By.id("field_password");
    private static final By LOGIN_BUTTON_LOCATOR = By
            .xpath("/html/body/div[10]/div[5]/div[3]/div[1]/div/div/div/div[1]/div[3]/div/div/main/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/input");
    //перестал работать без полного xpath
    //поэтому патч временный

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public SelenideElement getUsernameElement() {
        return $(USERNAME_LOCATOR);
    }

    public SelenideElement getPasswordElement() {
        return $(PASSWORD_LOCATOR);
    }

    public SelenideElement getLoginButtonElement() {
        return $(LOGIN_BUTTON_LOCATOR);
    }

    public void setUsername(String username) {
        getUsernameElement().setValue(username);
    }

    public void submitUsername() {
        getUsernameElement().pressTab();
    }

    public void setAndSubmitUsername(String username) {
        setUsername(username);
        submitUsername();
    }

    public void setPassword(String password) {
        getPasswordElement().setValue(password);
    }

    public void setAndSubmitPassword(String password) {
        getPasswordElement().setValue(password).pressEnter();
    }

    public void clickLogin() {
        getLoginButtonElement().click();
    }

    public FeedPage login(String username, String password) {
        setAndSubmitUsername(username);
        setAndSubmitPassword(password);
        return page(FeedPage.class);
    }

    public FeedPage loginWithButton(String username, String password) {
        setAndSubmitUsername(username);
        setPassword(password);
        clickLogin();
        return page(FeedPage.class);
    }
}