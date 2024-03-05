public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int days, Season season, DiscountType discountType) {
        double price = pricePerDay * days;
        price *= season.getMultiplier();
        price = price * (100 - discountType.getDiscount()) / 100.0;

        return price;
    }
}
