public class Product {
    private String name;
    private double unitPrice;

    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Unit Price: $" + unitPrice;
    }
}

