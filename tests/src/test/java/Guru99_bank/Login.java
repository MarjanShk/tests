package Guru99_bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 16.05.2016.
 */
public class Login extends Base {
    @FindBy(name = "uid")
    WebElement user;
    @FindBy(name = "password")
    WebElement pass;
    @FindBy(name = "btnLogin")
    WebElement loginButton;
    @FindBy(xpath = "//a[@href='Logout.php']")
    WebElement logout;

    @Test(enabled = true)
    public void loginTestValid() {
        PageFactory.initElements(wd, this);
        user.sendKeys("mngr37302");
        pass.sendKeys("UgEtEbA");
        loginButton.click();
        Assert.assertEquals(wd.findElement(By.tagName("marquee")).getText(), "Welcome To Manager's Page of Guru99 Bank");
        logout.click();

    }
    @Test
    public void loginTestPassNotValid(){
        PageFactory.initElements(wd, this);
        user.sendKeys("mngr37302");
        pass.sendKeys("notValid");
        loginButton.click();
        Assert.assertEquals(wd.switchTo().alert().getText(), "User or Password is not valid");
        wd.switchTo().alert().accept();
    }
    @Test
    public void loginTestUserNotValid(){
        PageFactory.initElements(wd, this);
        user.sendKeys("notValid");
        pass.sendKeys("UgEtEbA");
        loginButton.click();
        Assert.assertEquals(wd.switchTo().alert().getText(), "User or Password is not valid");
        wd.switchTo().alert().accept();
    }
    @Test
    public void loginTestUserAndPassNotValid(){
        PageFactory.initElements(wd, this);
        user.sendKeys("notValid");
        pass.sendKeys("notValid");
        loginButton.click();
        Assert.assertEquals(wd.switchTo().alert().getText(), "User or Password is not valid");
        wd.switchTo().alert().accept();
    }
}
