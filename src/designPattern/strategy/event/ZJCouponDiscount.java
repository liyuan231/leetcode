package designPattern.strategy.event;

import designPattern.strategy.ICouponDiscount;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal subtract = skuPrice.subtract(new BigDecimal(couponInfo));
        if (subtract.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return subtract;
    }
}
