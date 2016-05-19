package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 08.05.2016.
 */
public class BrokenLinksTest {
    public static void main(String[] args) {
        WebDriver wd = new FirefoxDriver();
        wd.get("http://localhost:8083/pageForTest/broken_links.html");
        List<WebElement> links = wd.findElements(By.tagName("a"));
        List<String> linksText = new ArrayList<>();
        for (WebElement l : links) {
            linksText.add(l.getText());
        }
        for (String l : linksText) {
            System.out.print(l);
            wd.findElement(By.linkText(l)).click();
            String pageSource = wd.getPageSource();
            System.out.println(pageSource.contains("Сервер не знайдено") ? " --> broken" : " --> good");
            wd.navigate().back();
        }
    }
}
