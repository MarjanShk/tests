package coupons.tests;

import coupons.AppManager;
import coupons.CouponData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCouponTest extends AppManager {

    @Test
    public void testAddCoupon() {

        Assert.assertTrue(isElementPresent(By.xpath("//h1[text()='Welcome admin']")));

        goToCouponsPage();
        initCouponCreation();
        fillCouponForm(new CouponData("my_coupon123", "20", "2016-09-09", "3"));
        submitCouponCreation().click();

        Assert.assertTrue(isElementPresent(By.xpath("//h4[@class='alert-heading'][contains(text(), 'Success')]")));
    }

}
