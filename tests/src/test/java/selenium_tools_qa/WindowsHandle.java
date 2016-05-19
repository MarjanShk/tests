package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Set;

/**
 * Created by Admin on 04.05.2016.
 */
public class WindowsHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new InternetExplorerDriver();
        System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\IdeaProjects\\tests\\src\\test\\resources\\IEDriverServer.exe");
        wd.get("http://demoqa.com/frames-and-windows/");
        wd.manage().window().maximize();

        wd.findElement(By.id("ui-id-2")).click();
        wd.findElement(By.xpath("//a[text()='Open New Seprate Window']")).click();

        String mainWindow = wd.getWindowHandle();
        System.out.println("Main window: " + mainWindow);
        Set<String> windows = wd.getWindowHandles();
        Object[] windowsA = windows.toArray();
        wd.switchTo().window(String.valueOf(windowsA[1]));
        wd.close();
    }
}
