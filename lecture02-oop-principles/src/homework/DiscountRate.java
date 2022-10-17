package homework;

public class DiscountRate {

    private static final double SERVICE_DISCOUNT_PREMIUM = 0.2;
    private static final double SERVICE_DISCOUNT_GOLD = 0.15;
    private static final double SERVICE_DISCOUNT_SILVER = 0.1;
    private static final double PRODUCT_DISCOUNT_PREMIUM = 0.1;
    private static final double PRODUCT_DISCOUNT_GOLD = 0.1;
    private static final double PRODUCT_DISCOUNT_SILVER = 0.1;

    public static double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return SERVICE_DISCOUNT_PREMIUM;
            case "Gold":
                return SERVICE_DISCOUNT_GOLD;
            case "Silver":
                return SERVICE_DISCOUNT_SILVER;
            default:
                throw new IllegalArgumentException("wrong service type specified");
        }
    }

    public static double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return PRODUCT_DISCOUNT_PREMIUM;
            case "Gold":
                return PRODUCT_DISCOUNT_GOLD;
            case "Silver":
                return PRODUCT_DISCOUNT_SILVER;
            default:
                throw new IllegalArgumentException("wrong service type specified");
        }
    }

}
