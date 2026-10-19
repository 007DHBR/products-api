package uk.ac.westminster.productsapi;
// A PhysicalProduct IS-A Product because it has an id, name and price like every product, plus shipping details, so it can be used anywhere a Product is expected.
// A ShoppingCart is not a Product, because a cart contains products rather than being one (HAS-A), so it would use a field, not extends.
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

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
}