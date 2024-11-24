import jlin2.examples.localtesting.EmailValidator
import org.junit.Assert
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun testValidEmail() {
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun testValidEmailWithSubdomain() {
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun testInvalidEmailWithoutTLD() {
        Assert.assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun testInvalidEmailWithDoubleDots() {
        Assert.assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }


}