import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CorrectUsername extends TypeSafeMatcher<String> {

    private String s;

    public CorrectUsername(String s) {
        this.s = s;
    }

    @Override
    protected boolean matchesSafely(String s) {
        return s.toLowerCase().equals(s) && s.matches(".+ .+");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("correct username");
    }

    public static Matcher<String> correctUsername(String s) {
        return new CorrectUsername(s);
    }
}
