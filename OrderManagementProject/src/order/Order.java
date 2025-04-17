import java.util.List;

public class Order {
    private int customerId;
    private List<OrderItem> items;

    public Order(int customerId, List<OrderItem> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public int getCustomerId() { return customerId; }
    public List<OrderItem> getItems() { return items; }

    public double calculateTotal(List<Product> productList) {
        double total = 0.0;
        for (OrderItem item : items) {
            for (Product product : productList) {
                if (product.getId() == item.getProductId()) {
                    total += product.getPrice() * item.getQuantity();
                }
            }
        }
        return total;
    }
}