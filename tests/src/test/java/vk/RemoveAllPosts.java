package vk;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 28.05.2016.
 */
public class RemoveAllPosts {
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        WebDriver wd = new FirefoxDriver();
        wd.get("https://vk.com/");
        wd.findElement(By.id("quick_email")).clear();
        wd.findElement(By.id("quick_email")).sendKeys("380964970735");
        wd.findElement(By.id("quick_pass")).clear();
        wd.findElement(By.id("quick_pass")).sendKeys("zxcvbnmko430524$!");
        wd.findElement(By.id("quick_login_button")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("myprofile")));
        wd.findElement(By.id("myprofile")).click();
        Robot r = new Robot();
        for (int i = 0; i < 12; i++) {
            r.keyPress(KeyEvent.VK_END);
            r.keyRelease(KeyEvent.VK_END);
            Thread.sleep(1500);
        }
        List<WebElement> removes = wd.findElements(By.cssSelector("*[id^='post_delete']"));
        for (WebElement el : removes) {
            el.click();
        }
    }
}
