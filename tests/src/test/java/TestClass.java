import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Date;
import java.util.Random;


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
        Random r = new Random();
        int number = r.nextInt(3);
        int number2 = 0;
        switch (number) {
            case 0:
                number2 = 2;
                break;
            case 1:
                number2 = 0;
                break;
            case 2:
                number2 = 1;
                break;
        }
        System.out.println(number + "/" + number2);
        System.out.println(new Date().getTime());
        //146 367 446 1
    }
}
