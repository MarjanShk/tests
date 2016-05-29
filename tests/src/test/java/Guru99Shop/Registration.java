package Guru99Shop;

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
        Actions actions = new Actions(wd);
        actions.moveToElement(register).release(register).click().perform();
        Assert.assertEquals(wd.findElement(By.tagName("h1")).getText(), "CREATE AN ACCOUNT");
        registerSubmit.click();
        List<WebElement> requiredInputs = wd.findElements(By.cssSelector(".input-text.required-entry.validation-failed"));
        List<WebElement> errorMessages = wd.findElements(By.className("validation-advice"));
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
        Assert.assertEquals(wd.findElement(By.cssSelector(".success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");
        Assert.assertEquals(wd.findElement(By.cssSelector(".welcome-msg strong")).getText(),
                "Hello, " + firstnameData + " " + lastnameData + "!");

    }
}
