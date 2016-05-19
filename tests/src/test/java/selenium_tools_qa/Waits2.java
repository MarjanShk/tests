package selenium_tools_qa;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by Admin on 02.05.2016.
 */
public class Waits2 {
    public static void main(String[] args) {
        WebDriver wd = new FirefoxDriver();
        wd.get("http://toolsqa.com/automation-practice-switch-windows/");
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(wd);
        wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS);
        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

            public Boolean apply(WebDriver wd) {
                String color = wd.findElement(By.id("colorVar")).getAttribute("style");
                System.out.println("Color is: " + color);
                if (color.equals("color: red;")) {
                    return true;
                }
                return false;
            }

        };
        wait.until(function);
        wd.quit();
    }
}
