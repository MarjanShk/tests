package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Admin on 05.05.2016.
 */
public class SelectableElements {
    public static void main(String[] args) {
        WebDriver wd = new FirefoxDriver();
        wd.get("http://demoqa.com/selectable/");
        wd.manage().window().maximize();
        Actions actions = new Actions(wd);
        wd.findElement(By.id("ui-id-3")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='feedback']/span[1]"), "You’ve selected:"));
        actions.keyDown(Keys.LEFT_CONTROL).perform();
        List<WebElement> list = wd.findElements(By.cssSelector("#selectable-serialize>li"));
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                list.get(i).click();
            }
        }
        Assert.assertEquals(wd.findElement(By.id("select-result")).getText(), "#1#3#5");
    }
}
