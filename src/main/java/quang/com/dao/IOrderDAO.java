package quang.com.dao;

import quang.com.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
    public void insertOrder(Order order) throws SQLException;

    public Order selectOrder(int id);

    public List<Order> selectAllOrders();

    public boolean deleteOrder(int id) throws SQLException;

    public boolean updateOrder(Order order) throws SQLException;
}
