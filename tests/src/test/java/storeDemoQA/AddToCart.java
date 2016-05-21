package storeDemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


/**
 * Created by Admin on 07.05.2016.
 */
public class AddToCart {
    WebDriver wd;

    @FindBy(id = "menu-item-33")
    WebElement toProductCategory;
    @FindBy(xpath = "//*[@id='menu-item-33']//ul/li/a")
    List<WebElement> productsList;
    @FindBy(xpath = "//*[@id='menu-item-33']//ul/li/a[text()='iPhones']")
    WebElement iPhones;
    @FindBy(xpath = "//span[contains(text(), 'You just added ')]")
    WebElement choise;
    @FindBy(linkText = "Go to Checkout")
    WebElement goToCheckout;
    @FindBy(xpath = "//div[@id='header_cart']/a/em[@class='count']")
    WebElement headerCart;
    @FindBy(xpath = "//input[@name='quantity' and not(@type='hidden')]")
    WebElement quantity;
    @FindBy(css = ".wpsc_product_price>span>span")
    WebElement totalPrice;
    @FindBy(css = ".yourtotal>span")
    WebElement subTotal;
    @FindBy(xpath = "//input[@value='Update']")
    WebElement updateTotal;
    @FindBy(xpath = "//input[@value='Remove']")
    WebElement removeButton;

    //TODO: check
//    privatte WebElement tt = wd.findElement(By.xpath("\"//div[@id='header_cart']/a/em[@class='count']\""));

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("http://store.demoqa.com/");
        wd.manage().window().maximize();
        PageFactory.initElements(wd, this);
    }

    @Test
    public void testAddToCart() {
        Random r = new Random();
        int number = r.nextInt(3);
        int r2 = r.nextInt(10) + 1;
        Actions action = new Actions(wd);
        action.moveToElement(toProductCategory).perform();
        String products_s = "";
        for (WebElement product : productsList) {
            products_s += product.getText();
        }
        assertEquals(products_s, "AccessoriesiMacsiPadsiPhonesiPodsMacBooks");
        action.moveToElement(iPhones).click().perform();
        List<WebElement> iPhones_list = wd.findElements(By.cssSelector(".default_product_display"));
        List<Product> products = new ArrayList<>();
        for (WebElement el : iPhones_list) {
            products.add(new Product().
                    withName(el.findElement(By.cssSelector("a.wpsc_product_title")).getText()).
                    withPrice(Double.parseDouble(el.findElement(By.cssSelector("span[class*='currentprice']")).
                            getText().replaceAll("\\$", ""))).
                    withSubmit(el.findElement(By.cssSelector("input[name='Buy']"))));
        }
        //////////////////////////////////////////////////////
        for (Product p : products) {
            System.out.println(p);
            System.out.println(p.getSubmit().getLocation());
        }
        //////////////////////////////////////////////////////
        double priceFromProductsPage = products.get(number).getPrice();
        products.get(number).getSubmit().click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(choise));
        goToCheckout.click();
        System.out.println(priceFromProductsPage);
        wait.until(ExpectedConditions.urlToBe("http://store.demoqa.com/products-page/checkout/"));
        assertEquals(headerCart.getText(), "1");
        double priceFromCartPage = Double.parseDouble(wd.findElement(By.xpath("//td[4]")).getText().replaceAll("\\$", ""));
        assertEquals(priceFromProductsPage, priceFromCartPage);
        quantity.clear();
        quantity.sendKeys(String.valueOf(r2));
        updateTotal.click();
        double expectTotal = priceFromCartPage * r2;
        Assert.assertEquals(Double.parseDouble(totalPrice.getText().replaceAll("\\$", "").
                replaceAll(",", "").replaceAll("\\.00", "")), expectTotal);
        Assert.assertEquals(Double.parseDouble(subTotal.getText().replaceAll("\\$", "").
                replaceAll(",", "").replaceAll("\\.00", "")), expectTotal);
        removeButton.click();
        Assert.assertEquals(wd.findElement(By.cssSelector(".entry-content")).getText(),
                "Oops, there is nothing in your cart.");
        Assert.assertTrue(headerCart.getText().equals("0"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // wd.quit();
    }

}
