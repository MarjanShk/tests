package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Admin on 01.05.2016.
 */
public class Selects {
    public static void main(String[] args){
        WebDriver wd = new FirefoxDriver();
        wd.get("http://toolsqa.com/automation-practice-form/");
        Select continents = new Select(wd.findElement(By.id("continents")));
        List<WebElement> options = continents.getOptions();
        for (WebElement el:options){
            System.out.println(el.getText());
        }
        Select commands = new Select(wd.findElement(By.id("selenium_commands")));
        if(commands.isMultiple()){
            commands.selectByVisibleText("Browser Commands");
            commands.selectByIndex(4);
        }
        commands.deselectAll();
    }
}
