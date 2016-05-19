package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Admin on 05.05.2016.
 */
public class ActionsClass {
    public static void main(String[] args) {
        WebDriver wd = new FirefoxDriver();
        wd.get("https://api.checklist.com/login");
        wd.manage().window().maximize();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("shkurdamarjan@gmail.com");
        wd.findElement(By.name("j_password")).clear();
        wd.findElement(By.name("j_password")).sendKeys("jfnxlzuv1");
        wd.findElement(By.xpath("//button[text()='Log in']")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Private']")));
        wd.findElement(By.xpath("//span[text()='Private']")).click();
        Actions action = new Actions(wd);
        List<WebElement> dragablePrivateTasks = wd.findElements(By.xpath("//li//div[@class='handle']/*"));
        WebElement from = dragablePrivateTasks.get(0);
        WebElement to = dragablePrivateTasks.get(1);
        action.dragAndDrop(from, to).perform();
        //action.clickAndHold(from).moveToElement(to).release(to).build().perform();
    }
}
