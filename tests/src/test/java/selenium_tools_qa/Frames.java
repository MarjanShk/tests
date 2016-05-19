package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Admin on 05.05.2016.
 */
public class Frames {
    public static void main(String[] args){
        WebDriver wd = new FirefoxDriver();
        wd.get("http://toolsqa.com/iframe-practice-page/");
        wd.manage().window().maximize();
        List<WebElement> iframes = wd.findElements(By.tagName("iframe"));
        for (WebElement el:iframes){
            System.out.println(el.getAttribute("name"));
        }
        wd.switchTo().frame(0);
        wd.findElement(By.id("sex-0")).click();
        wd.findElement(By.id("exp-0")).click();
        wd.switchTo().defaultContent();
    }
}
