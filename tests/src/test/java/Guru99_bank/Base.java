package Guru99_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Admin on 16.05.2016.
 */
public class Base {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new FirefoxDriver();
        wd.get("http://www.demo.guru99.com/V4/");
        wd.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
