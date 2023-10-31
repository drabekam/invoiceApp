public class orderDetail {
    private Product product;
    private int quantity;

    public orderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and settersa
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double calculateTotal() {
        return product.getUnitPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.toString() + ", Quantity: " + quantity + ", Total: $" + calculateTotal();
    }
}

