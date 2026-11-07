package uk.ac.westminster.productsapi;
// A PhysicalProduct IS-A Product because it has an id, name and price like every product, plus shipping details, so it can be used anywhere a Product is expected.
// A ShoppingCart is not a Product, because a cart contains products rather than being one (HAS-A), so it would use a field, not extends.
public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct(){
    }
    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions){
        super(id,name,price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }
    public String getDimensions(){
        return dimensions;
    }

    @Override
    public String getSummary(){
        return "Physical: " + getName()
                + " | Weight: " + weightKg + " kg";
    }

    @Override
    public void applyDiscount(double rate) {
        // Shipping is never discounted, so the rate is capped at 20%.
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
