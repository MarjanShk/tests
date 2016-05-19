import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 * Created by Admin on 08.05.2016.
 */
public class TestClass {
    public static void main(String[] args) {
        /*
        WebDriver wd = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
        wd.get("https://www.google.com.ua/");
        wd.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
        String title = wd.getTitle();
        System.out.println(title);
        */
        System.out.println("$2,430.00".replaceAll("\\$", "").replaceAll(",", "").replaceAll("\\.00", ""));
        System.out.println("$150.00".replaceAll("\\$", "").replaceAll(",", "\\.").replaceAll("\\.00", ""));
    }
}
