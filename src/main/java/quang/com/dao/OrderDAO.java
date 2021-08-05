package quang.com.dao;

import quang.com.model.Order;
import quang.com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Applications_Oder";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private static final String INSERT_ORDER_SQL = "INSERT INTO Oders(cus_name, cus_phonenumber, address,product_name,product_price,status) VALUES(?, ?, ? , ? , ? , ?)";

    private static final String SELECT_ORDER_BY_ID = "select id,cus_name, cus_phonenumber, address,product_name,product_price,status from Oders where id =?";
    private static final String SELECT_ALL_ORDERS = "select * from Oders";
    private static final String DELETE_ORDERS_SQL = "delete from Oders where id = ?;";
    private static final String UPDATE_ORDERS_SQL = "update Oders set cus_name = ?,cus_phonenumber= ?, address = ? , product_name = ?, product_price = ?, status = ? where id = ?;";

    public OrderDAO() {
    }

    @Override
    public void insertOrder(Order order) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            preparedStatement.setString(1, order.getCus_name());
            preparedStatement.setString(2, order.getPhone());
            preparedStatement.setString(3, order.getAddress());
            preparedStatement.setString(4, order.getProduct_name());
            preparedStatement.setFloat(5, order.getProduct_price());
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           printSQLException(e);
        }
    }

    public User login(String user_name, String password){
        String query = "select * from user\n" +
                "where user_name = ?\n" +
                "and password = ?;";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user_name);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String userName = resultSet.getString("user_name");
                String passWord = resultSet.getString("password");
                User user1 = new User(userName,passWord);
                return user1;
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return null;
    }

    @Override
    public Order selectOrder(int id) {
        Order order = null;

        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String cus_name = rs.getString("cus_name");
                String cus_phonenumber = rs.getString("cus_phonenumber");
                String address = rs.getString("address");
                String product_name = rs.getString("product_name");
                float product_price = rs.getFloat("product_price");
                String status = rs.getString("status");

                order = new Order(id, cus_name, cus_phonenumber, address, product_name, product_price, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order;
    }

    @Override
    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String cus_name = rs.getString("cus_name");
                String cus_phonenumber = rs.getString("cus_phonenumber");
                String address = rs.getString("address");
                String product_name = rs.getString("product_name");
                float product_price = rs.getFloat("product_price");
                String status = rs.getString("status");

                orders.add(new Order(id, cus_name, cus_phonenumber, address, product_name, product_price, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orders;
    }

    @Override
    public boolean deleteOrder(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ORDERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean verifyUser(String userName, String password){
        String query = "select * from user\n" +
                "where user_name = ?\n" +
                "and password = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,userName);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            String rsUserName = null;
            String rsPassword = null;
            while (rs.next()){
                rsUserName = rs.getString("user_name");
                rsPassword =  rs.getString("password");
            }
            connection.close();
            if (rsUserName.equals(userName) && rsPassword.equals(password)){
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            printSQLException(ex.getNextException());
        }
        return false;
    }
    @Override
    public boolean updateOrder(Order order) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERS_SQL);) {
            statement.setString(1, order.getCus_name());
            statement.setString(2, order.getPhone());
            statement.setString(3, order.getAddress());
            statement.setString(4, order.getProduct_name());
            statement.setFloat(5, order.getProduct_price());
            statement.setString(6, order.getStatus());
            statement.setInt(7,order.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public List<Order> find(String keyWord) throws SQLException{
        final String FIND_DATA = "select * from Oders where cus_name like ?;";
        List<Order> orders = new ArrayList<>();
        String key = "%" + keyWord + "%";
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(FIND_DATA);) {
            statement.setString(1,key);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String cus_name = rs.getString("cus_name");
                String cus_phonenumber = rs.getString("cus_phonenumber");
                String address = rs.getString("address");
                String product_name = rs.getString("product_name");
                float product_price = rs.getFloat("product_price");
                String status = rs.getString("status");

                orders.add(new Order(id, cus_name, cus_phonenumber, address, product_name, product_price, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }
}
