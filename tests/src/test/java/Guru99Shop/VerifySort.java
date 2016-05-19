package Guru99Shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 16.05.2016.
 */
public class VerifySort extends Base {

    @Test
    public void testVerifySort() {
        Assert.assertTrue(title.getText().contains("THIS IS DEMO SITE FOR"));
        mobile.click();
        Assert.assertTrue(wd.getTitle().equals("Mobile"));
        Select sortBy = new Select(select);
        sortBy.selectByVisibleText("Name");
        //sortBy.selectByVisibleText("Price");
        List<String> productsNames = new ArrayList<>();
        for (WebElement p : products) {
            productsNames.add(p.getText());
        }
        List<String> productsNamesSorted = new ArrayList<>(productsNames);
        Collections.sort(productsNamesSorted);
        Assert.assertEquals(productsNames, productsNamesSorted);
    }
}
