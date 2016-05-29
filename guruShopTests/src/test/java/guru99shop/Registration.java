package guru99shop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 26.05.2016.
 */
public class Registration extends Base {

    @Test
    public void testRegistration() {
        long r = new Random().nextLong();
        account.click();
        actions.moveToElement(register).release(register).click().perform();
        registerSubmit.click();
        for (WebElement input : requiredInputs) {
            Assert.assertEquals(input.getCssValue("border-color"), "rgb(223, 40, 10)");
        }
        for (WebElement er : errorMessages) {
            Assert.assertEquals(er.getText(), "This is a required field.");
        }
        String firstnameData = "test_firstname";
        String lastnameData = "test_lastname";
        firstname.sendKeys(firstnameData);
        lastname.sendKeys(lastnameData);
        emailAddress.sendKeys("test" + r + "@gmail.com");
        password1.sendKeys("123456");
        password2.sendKeys("123456");
        registerSubmit.click();
                "Thank you for registering with Main Website Store.");
                "Hello, " + firstnameData + " " + lastnameData + "!");

    }
}
