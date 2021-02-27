package designPattern.strategy;

import designPattern.strategy.event.NYGCouponDiscount;

import java.math.BigDecimal;

public class Context<T> {
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }


    public static void main(String[] args) {
        Context<Double> context = new Context<>(new NYGCouponDiscount());
        System.out.println(context.discountAmount(6d, new BigDecimal(100)));
    }
}
