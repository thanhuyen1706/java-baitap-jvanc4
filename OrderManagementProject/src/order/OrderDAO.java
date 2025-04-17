import java.sql.*;
import java.util.List;

public class OrderDAO {
    public void addOrder(Order order) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            String insertOrder = "INSERT INTO orders (customer_id) VALUES (?)";
            PreparedStatement orderStmt = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, order.getCustomerId());
            orderStmt.executeUpdate();

            ResultSet rs = orderStmt.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) orderId = rs.getInt(1);

            String insertItem = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement itemStmt = conn.prepareStatement(insertItem);
            for (OrderItem item : order.getItems()) {
                itemStmt.setInt(1, orderId);
                itemStmt.setInt(2, item.getProductId());
                itemStmt.setInt(3, item.getQuantity());
                itemStmt.addBatch();
            }
            itemStmt.executeBatch();

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}