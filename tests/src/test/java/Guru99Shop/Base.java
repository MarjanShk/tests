package Guru99Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.List;

/**
 * Created by Admin on 16.05.2016.
 */
public class Base {
    static WebDriver wd;
    @FindBy(tagName = "h2")
    WebElement title;
    @FindBy(xpath = "//a[text()='Mobile']")
    WebElement mobile;
    @FindBy(xpath = "//select[@title='Sort By']")
    WebElement select;
    @FindBy(xpath = "//h2[@class='product-name']")
    List<WebElement> productsNames;
    @FindBy(css = ".product-name")
    WebElement productsName;
    @FindBy(css = ".product-info")
    List<WebElement> products;
    @FindBy(css = ".product-essential span[id^='product']")
    WebElement priceFromThisProductDetails;
    By addToCartButton = By.cssSelector("button[title='Add to Cart']");
    By productName = By.cssSelector("h2.product-name>a");
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
    By compare = By.cssSelector(".link-compare");
    @FindBy(css = ".success-msg span")
    WebElement successMsg;
    @FindBy(css = "ol#compare-items")
    WebElement compareItems;
    @FindBy(xpath = "//*[text()='Compare']")
    WebElement compareSelectedProducts;
    @FindBy(xpath = "//span[text()='Close Window']")
    WebElement closeCompareWindow;
    @FindBy(xpath = "//a[text()='Clear All']\n")
    WebElement clearComparedItems;
    @FindBy(xpath = "//div[@class='account-cart-wrapper']//span[text()='Account']")
    WebElement account;
    @FindBy(css = "a[href$='account/create/']")
    WebElement register;
    @FindBy(xpath = "//span[text()='Register']")
    WebElement registerSubmit;
    @FindBy(id = "firstname")
    WebElement firstname;
    @FindBy(id = "lastname")
    WebElement lastname;
    @FindBy(id = "email_address")
    WebElement emailAddress;
    @FindBy(id = "password")
    WebElement password1;
    @FindBy(id = "confirmation")
    WebElement password2;
    @FindBy(css = "a[href$='/tv.html']")
    WebElement tv;


    @BeforeSuite
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("http://live.guru99.com");
        wd.manage().window().maximize();
    }

    @BeforeClass
    public void pf() {
        PageFactory.initElements(wd, this);
    }


    @AfterSuite
    public void tearDown() {
        wd.quit();
    }

}
