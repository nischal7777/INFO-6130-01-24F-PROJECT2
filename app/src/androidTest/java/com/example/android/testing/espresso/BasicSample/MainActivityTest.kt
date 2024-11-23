import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.testing.espresso.BasicSample.MainActivity
import com.example.android.testing.espresso.BasicSample.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testChangeText() {
        Espresso.onView(ViewMatchers.withId(R.id.editUserTextInput))
            .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.TextChangeButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.TextToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }


    @Test
    fun testOpenActivityAndChangeText() {
        Espresso.onView(ViewMatchers.withId(R.id.editUserTextInput))
            .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.activityChangeTextBtn)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }


    @Test
    fun testEmptyInput() {
        Espresso.onView(ViewMatchers.withId(R.id.editUserTextInput))
            .perform(ViewActions.clearText(), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.TextChangeButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.TextToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}
