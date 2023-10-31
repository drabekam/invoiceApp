import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// This class provides a GUI application to handle and display invoices.
public class InvoiceApp {

    // GUI components
    private JFrame frame; // Main application window
    private JTextArea displayArea; // Area to display invoice details
    // Text fields
    private JTextField titleField, streetField, cityField, stateField, zipField, countryField, productNameField, unitPriceField, quantityField;
    private JButton addButton, displayButton;
    private Invoice invoice;

    //  initializes the GUI components and layout
    public InvoiceApp() {
        frame = new JFrame("Invoice App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application on window close
        frame.setSize(500, 500); // Set size of the application window

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));


        titleField = new JTextField(20);



        addButton = new JButton("Add Product to Invoice");
        addButton.addActionListener(e -> addProductToInvoice());

        displayButton = new JButton("Display Invoice");
        displayButton.addActionListener(e -> displayInvoice());


        displayArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }


    private void addProductToInvoice() {

        if (invoice == null) {
            invoice = new Invoice(titleField.getText(), new Address(streetField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), countryField.getText()));
            invoice.setOrderDetailsList(new ArrayList<>());
        }

        // Create a new product from input fields
        Product product = new Product(productNameField.getText(), Double.parseDouble(unitPriceField.getText()));

        // Create a new order detail with the product and quantity
        orderDetail detail = new orderDetail(product, Integer.parseInt(quantityField.getText()));

        // Add this order detail to the invoice's list
        invoice.getOrderDetailsList().add(detail);

        // Clear product-related input fields for next entry
        productNameField.setText("");
        unitPriceField.setText("");
        quantityField.setText("");
    }

    // Method to display the current invoice's details in the display area
    private void displayInvoice() {
        if (invoice != null) {
            StringBuilder output = new StringBuilder(); //talked about the string builder earlier
            output.append("Title: ").append(invoice.getTitle()).append("\n");
            displayArea.setText(output.toString());
        }
    }

    // Main method to launch
    public static void main(String[] args) {
        new InvoiceApp();
    }
}
