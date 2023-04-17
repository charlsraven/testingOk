package ok.feed;

import ok.BaseTest;
import ok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class CheckCountMenuTest extends BaseTest {
    private FeedPage feedPage;

    @BeforeEach
    public void beforeEach() {
        final Data data = new Data();
        feedPage = new LoginPage().login(data.getOkEmail(), data.getOkPassword());
    }

    @Disabled
    @Tag("Useless")
    @Test
    public void countingMenuElementsTest() {
        assertThat(feedPage.getMenuElements(), hasSize(10));
    }

}
