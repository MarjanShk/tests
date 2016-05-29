package vk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Admin on 28.05.2016.
 */
public class VkCopyPosts {
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("page_wall_header")));
        wd.findElement(By.id("page_wall_header")).click();
        Thread.sleep(5000);
        Robot r = new Robot();
        for (int i = 0; i < 10; i++) {
            r.keyPress(KeyEvent.VK_END);
            r.keyRelease(KeyEvent.VK_END);
            Thread.sleep(1500);
        }
        java.util.List<WebElement> elements = wd.findElements(By.cssSelector("a.published_by_date.sm"));
        ArrayList<String> hrefs = new ArrayList<>();
        for (WebElement el : elements) {
            hrefs.add(el.getAttribute("href"));
        }
        FileWriter writer = new FileWriter(new File("C:\\Users\\Admin\\Desktop\\hrefsVk.csv"));
        for (String h : hrefs) {
            System.out.println(h);
            writer.write(h+"\n");
        }
        System.out.println(elements.size());
        System.out.println(hrefs.size());
        // //a[contains(@onclick, 'Wall.likeShareCustom')]
        // id="like_share_send"
        writer.close();
    }
}
