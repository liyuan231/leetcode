package designPattern.strategy;

public class CouponDiscountService {
    public double discountAMount(int type, double typeContent, double skuPrice, double typeExt) {
        //1.直减券
        if (type == 1) {
            return skuPrice - typeContent;
        }
        //2.满减券
        if (2 == type) {
            if (skuPrice < typeExt) {
                return skuPrice;
            }
            return skuPrice - typeContent;
        }
        //3.折扣券
        if (3 == type) {
            return skuPrice * typeContent;
        }
        //4.n元购
        if (4 == type) {
            return typeContent;
        }
        return 0d;
    }
}
