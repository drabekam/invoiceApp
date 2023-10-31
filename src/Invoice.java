import java.util.List;

/**
 * creating a class for the invoice
 */
public class Invoice {

    // creating hte private variables for the invoice class
    private String title;
    private Address customerAddress;
    private List<orderDetail> orderDetailsList;


    public Invoice(String title, Address customerAddress) {
        this.title = title;
        this.customerAddress = customerAddress;
    }

    // Getter setter metjods

    public String getTitle() {
        return title;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public List<orderDetail> getOrderDetailsList() {
        return orderDetailsList;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setOrderDetailsList(List<orderDetail> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }


    public double calculateTotalAmountDue() {
        double total = 0.0;
        if (orderDetailsList != null) {
            for (orderDetail detail : orderDetailsList) {
                total += detail.calculateTotal();
            }
        }
        return total;
    }

    //sb is used to concat the strings this is a string builder class
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice Title: ").append(title).append("\n");
        sb.append("Customer Address: ").append(customerAddress.toString()).append("\n");
        sb.append("Order Details:\n");
        if (orderDetailsList != null) {
            for (orderDetail detail : orderDetailsList) {
                sb.append(detail.toString()).append("\n");
            }
        }
        sb.append("Total Amount Due: $").append(calculateTotalAmountDue());
        return sb.toString();
    }
}
