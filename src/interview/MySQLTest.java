package interview;

import java.sql.*;

public class MySQLTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8","root","123456");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(username, password) values (?,?)",Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1,"李源"+i);
            preparedStatement.setString(2,"123456->"+i);
            boolean execute = preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        }
    }
}
