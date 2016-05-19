package Guru99Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Admin on 18.05.2016.
 */
public class AddToCart1000Products extends Base {

    @Test
    public void testAddToCart1000Products() {
        Random r = new Random();
        int number = r.nextInt(3);
        mobile.click();
        WebElement phone = productsInfo.get(number);
        String phoneName = phone.findElement(productName).getText();
        phone.findElement(addToCartButton).click();
        String expectMessage = phoneName + " was added to your shopping cart.";
        Assert.assertTrue(expectMessage.
                equalsIgnoreCase(wd.findElement(By.cssSelector("li.success-msg>ul>li")).getText()));
        qty.clear();
        qty.sendKeys("1000");
        updateQTY.click();
        Assert.assertTrue(pError.getText().contains("* The maximum quantity allowed for purchase is 500."));
        Assert.assertEquals(spanErrorMessage.getText(), "Some of the products cannot be ordered in requested quantity.");
        emptyCartButton.click();
        Assert.assertEquals(wd.findElement(By.tagName("h1")).getText(), "SHOPPING CART IS EMPTY");
    }
}
