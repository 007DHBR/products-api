package uk.ac.westminster.productsapi;

public class Product {

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    private Long id;
    private String name;
    private double price;

    public Product() {}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }

    // Without a public getName(), Jackson skips the name field: the JSON still returns 200 with no error,
    // so in a class with fifteen fields I'd only notice by checking the response against the expected fields.
    public String getName() { return name; }

    public double getPrice() { return price; }
}
