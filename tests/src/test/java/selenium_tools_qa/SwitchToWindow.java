package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

/**
 * Created by Admin on 02.05.2016.
 */
public class SwitchToWindow {
    public static void main(String[] args){

        WebDriver wd = new FirefoxDriver();
        wd.get("http://toolsqa.com/automation-practice-switch-windows/");
        wd.manage().window().maximize();
        String mainWindow = wd.getWindowHandle();
        System.out.println(mainWindow);
        wd.findElement(By.xpath("//*[@onclick='newMsgWin()']")).click();
        Set<String> windows = wd.getWindowHandles();
        for (String w:windows){
            wd.switchTo().window(w);
        }
        wd.close();
    }
}
