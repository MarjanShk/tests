package Guru99Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Admin on 19.05.2016.
 */
public class CompareProductsTest extends Base {

    @Test
    public void testCompareProducts() {
        Random r = new Random();
        int number = r.nextInt(3);
        int number2 = 0;
        switch (number) {
            case 0:
                number2 = 2;
                break;
            case 1:
                number2 = 0;
                break;
            case 2:
                number2 = 1;
                break;
        }
        System.out.println(number + "/" + number2);
        WebDriverWait wait = new WebDriverWait(wd, 10);
        mobile.click();

        products.get(number).findElement(compare).click();
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        String firstProductName = products.get(number).findElement(productName).getAttribute("title");
        Assert.assertTrue(successMsg.getText().
                equalsIgnoreCase("The product " + firstProductName + " has been added to comparison list."));

        products.get(number2).findElement(compare).click();
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        String secondProductName = products.get(number2).findElement(productName).getAttribute("title");
        Assert.assertTrue(successMsg.getText().
                equalsIgnoreCase("The product " + secondProductName + " has been added to comparison list."));
        String mainWindow = wd.getWindowHandle();
        compareSelectedProducts.click();
        Set<String> windowHandles = wd.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                wd.switchTo().window(childWindow);
            }
        }
        System.out.println(firstProductName);
        System.out.println(secondProductName);
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='"+firstProductName+"']")).isDisplayed());
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='"+secondProductName+"']")).isDisplayed());
        closeCompareWindow.click();
        wd.switchTo().window(mainWindow);
        clearComparedItems.click();
        Assert.assertEquals(wd.switchTo().alert().getText(),
                "Are you sure you would like to remove all products from your comparison?");
        wd.switchTo().alert().accept();
    }
}
