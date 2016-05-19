package Guru99Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Admin on 17.05.2016.
 */
public class PriceCompare extends Base {
    @Test
    public void testPriceCompare() {
        Random r = new Random();
        int number = r.nextInt(3);
        mobile.click();
        WebElement phone = productsInfo.get(number);
        String priceFromMainPage = phone.
                findElement(By.cssSelector("span[id^='product']")).getText();
        phone.findElement(By.cssSelector(".product-name")).click();
        String priceFromProductDetails = priceFromThisProductDetails.getText();
        System.out.println(priceFromMainPage + " / " + priceFromProductDetails);
        Assert.assertEquals(priceFromMainPage, priceFromProductDetails);

    }
}
