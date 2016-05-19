package coupons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 15.03.2016.
 */
public class AppManager {
    ChromeDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("http://ec2-52-31-177-160.eu-west-1.compute.amazonaws.com/open-eshop-2.0.1/oc-panel/auth/login");
        login("demo@open-eshop.com", "demo");
    }

    protected void logout() {
        wd.findElement(By.xpath("//div[@class='header-container']/div[2]/a[2]")).click();
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'logout')]")));
        wd.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();
    }

    protected WebElement submitCouponCreation() {
        return wd.findElement(By.xpath("//*[@name='submit']"));
    }

    protected void fillCouponForm(CouponData couponData) {
        wd.findElement(By.id("name")).clear();
        wd.findElement(By.id("name")).sendKeys(couponData.getName());
        wd.findElement(By.id("discount_amount")).clear();
        wd.findElement(By.id("discount_amount")).sendKeys(couponData.getDiscount_amount());
        wd.findElement(By.name("valid_date")).clear();
        wd.findElement(By.name("valid_date")).sendKeys(couponData.getValid_date());
        wd.findElement(By.id("number_coupons")).clear();
        wd.findElement(By.id("number_coupons")).sendKeys(couponData.getCoupon_amount());
    }

    protected void initCouponCreation() {
        wd.findElement(By.xpath("//a[contains(@href, 'Coupon/create')]")).click();
    }

    protected void goToCouponsPage() {
        wd.findElement(By.cssSelector("h4.panel-title > a")).click();
        wd.findElement(By.xpath("//a[contains(@href, 'coupon')]")).click();
    }

    protected boolean isElementPresent(By element) {
        try {
            wd.findElement(element);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected void login(String user, String password) {
        wd.findElement(By.cssSelector("section#page > form.auth input[placeholder='Email']")).click();
        wd.findElement(By.cssSelector("section#page > form.auth input[placeholder='Email']")).clear();
        wd.findElement(By.cssSelector("section#page > form.auth input[placeholder='Email']")).sendKeys(user);
        wd.findElement(By.cssSelector("section#page > form.auth input[placeholder='Password']")).click();
        wd.findElement(By.cssSelector("section#page > form.auth input[placeholder='Password']")).clear();
        wd.findElement(By.cssSelector("section#page > form.auth input[placeholder='Password']")).sendKeys(password);
        wd.findElement(By.cssSelector("section#page > form.auth button[type='submit']")).click();
    }


    protected void findCoupon(String coupon_name) {
        wd.findElement(By.xpath("//input[@name='name']")).clear();
        wd.findElement(By.xpath("//input[@name='name']")).sendKeys(coupon_name);
        wd.findElement(By.xpath("//button[text()='Search']")).click();

        WebDriverWait wait = new WebDriverWait(wd, 20);

        wait.until(ExpectedConditions.urlToBe("http://ec2-52-31-177-160.eu-west-1.compute.amazonaws.com/open-eshop-2.0.1/oc-panel/coupon?name=" + coupon_name));
    }

    protected void deleteCoupon() {
        wd.findElement(By.xpath("//td[text()='my_coupon123']/following-sibling::td/a[contains(@href, 'delete')]")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert showSweetAlert visible']")));
        //Thread.sleep(2000);
        wd.findElement(By.xpath("//button[text()='Yes, definitely!']")).click();
    }

    @AfterMethod
    public void tearDown() {
        logout();
        wd.quit();
    }
}
