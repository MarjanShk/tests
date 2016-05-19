package Guru99Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

/**
 * Created by Admin on 16.05.2016.
 */
public class Base {
    WebDriver wd;
    @FindBy(tagName = "h2")
    WebElement title;
    @FindBy(xpath = "//a[text()='Mobile']")
    WebElement mobile;
    @FindBy(xpath = "//select[@title='Sort By']")
    WebElement select;
    @FindBy(xpath = "//h2[@class='product-name']")
    List<WebElement> products;
    @FindBy(css = ".product-info")
    List<WebElement> productsInfo;
    @FindBy(css = ".product-essential span[id^='product']")
    WebElement priceFromThisProductDetails;
    By addToCartButton = By.cssSelector("button[title='Add to Cart']");
    By productName = By.cssSelector("h2.product-name");
    @FindBy(css = "input[name^='cart']")
    WebElement qty;
    @FindBy(css = "*[title='Update']")
    WebElement updateQTY;
    @FindBy(css = "p.item-msg")
    WebElement pError;
    @FindBy(css = "li.error-msg>ul>li")
    WebElement spanErrorMessage;
    @FindBy(xpath = "//span[text()='Empty Cart']")
    WebElement emptyCartButton;

    @BeforeClass
    //@BeforeSuite
    public void setUp() {
        wd = new FirefoxDriver();
        wd.get("http://live.guru99.com");
        PageFactory.initElements(wd, this);
        wd.manage().window().maximize();
    }

    @AfterClass
    //@AfterSuite
    public void tearDown() {
        wd.quit();
    }

}
