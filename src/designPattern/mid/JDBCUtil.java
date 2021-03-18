package designPattern.mid;

import java.sql.*;

public class JDBCUtil {
    //    private static Logger logger = LoggerFac
    public static final String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8";
    public static final String user = "root";
    public static final String password = "123456";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users;");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(username + " - " + password);
        }
    }
}
