package vk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 28.05.2016.
 */
public class VkAddPosts {
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {

        WebDriver wd = new FirefoxDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wd.get("https://vk.com/");
        wd.findElement(By.id("quick_email")).clear();
        wd.findElement(By.id("quick_email")).sendKeys("380991967324");
        wd.findElement(By.id("quick_pass")).clear();
        wd.findElement(By.id("quick_pass")).sendKeys("zxcvbnmko430524$!");
        wd.findElement(By.id("quick_login_button")).click();
        Thread.sleep(3000);

        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\res.csv")));
        ArrayList<String> hrefs = new ArrayList<>();
        String href = reader.readLine();
        while (href != null) {
            hrefs.add(href);
            href = reader.readLine();
        }
        reader.close();

        for (String h : hrefs) {
            System.out.println(h);
            wd.get(h);
            if (wd.findElements(By.xpath("//a[contains(@onclick, 'Wall.likeShareCustom')]")).size() != 0) {
                wd.findElement(By.xpath("//a[contains(@onclick, 'Wall.likeShareCustom')]")).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("like_share_send")));
                wd.findElement(By.id("like_share_send")).click();
                Thread.sleep(5000);
            } else {
                wd.findElement(By.id("pv_share")).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("like_share_send")));
                wd.findElement(By.id("like_share_send")).click();
                Thread.sleep(5000);
            }

        }

    }
}
