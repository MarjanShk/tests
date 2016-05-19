package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 02.05.2016.
 */
public class Waits {
    public static void main(String[] args) {
        WebDriver wd = new FirefoxDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.get("http://toolsqa.com/automation-practice-switch-windows/");
        wd.findElement(By.id("timingAlert")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();

    }
}
