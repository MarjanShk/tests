package coupons;

public class CouponData {
    private  String name;
    private  String discount_amount;
    private  String valid_date;
    private  String coupon_amount;

    public CouponData(String name, String discount_amount, String valid_date, String coupon_amount) {
        this.name = name;
        this.discount_amount = discount_amount;
        this.valid_date = valid_date;
        this.coupon_amount = coupon_amount;
    }

    public String getName() {
        return name;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public String getValid_date() {
        return valid_date;
    }

    public String getCoupon_amount() {
        return coupon_amount;
    }
}
