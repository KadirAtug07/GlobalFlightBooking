package e2e.utils;

import java.sql.*;

public class DBUtils {


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createDbConnection() {
        String dbUrl=ConfigReader.getPropertyValues("UrlDB");
        String userName=ConfigReader.getPropertyValues("username");
        String password=ConfigReader.getPropertyValues("password");

        try {
            connection= DriverManager.getConnection(dbUrl,userName,password);
            System.out.println("Database is connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeDbConnection() {
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet runQuery(String query) {
        try {
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }




}
