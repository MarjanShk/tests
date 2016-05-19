package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Admin on 01.05.2016.
 */
public class NavigateCommands {
    public static void main(String[] args){
        WebDriver wd = new FirefoxDriver();
        wd.get("http://demoqa.com/");
        wd.manage().window().maximize();
        wd.findElement(By.xpath("//a[contains(@href, 'registration')]")).click();
        wd.navigate().back();
        wd.navigate().forward();
        wd.navigate().to("http://demoqa.com/");
        wd.navigate().refresh();
        wd.quit();
    }
}
