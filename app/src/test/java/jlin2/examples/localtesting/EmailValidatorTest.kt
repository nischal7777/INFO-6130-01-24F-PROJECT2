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
    @Test
    fun testInvalidEmailWithoutUsername() {
        Assert.assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun testInvalidEmailWithoutDomain() {
        Assert.assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun testEmptyEmail() {
        Assert.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun testNullEmail() {
        Assert.assertFalse(EmailValidator.isValidEmail(null))
    }

}