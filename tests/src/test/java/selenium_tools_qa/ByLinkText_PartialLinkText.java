package selenium_tools_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by Admin on 01.05.2016.
 */
public class ByLinkText_PartialLinkText {
    public static void main(String[] args) throws IOException {
        WebDriver wd = new FirefoxDriver();
        wd.get("http://toolsqa.com/automation-practice-form/");
        wd.manage().window().maximize();
        String linkTitle = wd.findElement(By.partialLinkText("Partial")).getAttribute("title");
        System.out.println(linkTitle);
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("testName");
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("testSecondName");
        WebElement radioMale = wd.findElement(By.id("sex-0"));
        if(!radioMale.isSelected()){
            radioMale.click();
        }
        List<WebElement> profession = wd.findElements(By.name("profession"));
        for (WebElement element:profession){
            element.click();
        }
        Select continents = new Select(wd.findElement(By.id("continents")));
        continents.selectByVisibleText("Europe");
        wd.findElement(By.id("submit")).submit();
        String currentUrl = wd.getCurrentUrl();
        System.out.println(currentUrl);
        String pageSource = wd.getPageSource();
        Writer writer = new FileWriter(new File("C:\\Users\\Admin\\Desktop\\pagesource.html"));
        writer.write(pageSource);
        writer.close();
    }
}
