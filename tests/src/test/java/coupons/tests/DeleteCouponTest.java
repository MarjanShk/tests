package coupons.tests;

import coupons.AppManager;
import org.testng.annotations.Test;

/**
 * Created by Admin on 15.03.2016.
 */
public class DeleteCouponTest extends AppManager {

    @Test
    public void testDeleteCoupon() {
        goToCouponsPage();
        findCoupon("my_coupon123");
        deleteCoupon();
        //      Assert.assertFalse(isElementPresent(By.xpath("//div[@class='table-responsive']/table/tbody/td")));
    }

}
