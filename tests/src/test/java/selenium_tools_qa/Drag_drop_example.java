package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * Created by Admin on 05.05.2016.
 */
public class Drag_drop_example {
    public static void main(String[] args){
        WebDriver wd = new FirefoxDriver();
        wd.get("http://demoqa.com/droppable/");
        wd.manage().window().maximize();
        Actions action = new Actions(wd);
        action.dragAndDrop(wd.findElement(By.id("draggableview")), wd.findElement(By.id("droppableview"))).perform();
        Assert.assertEquals(wd.findElement(By.cssSelector("#droppableview>p")).getText(), "Dropped!");
    }
}
