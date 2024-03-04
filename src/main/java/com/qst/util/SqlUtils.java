package qst.util;

import java.sql.*;

public class SqlUtils {
    private SqlUtils() {
    }

    private static final String URL = "jdbc:mysql://localhost:3306/imdb?serverTimezone=GMT";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "pp18001476164";
    private static Connection connection;
    private static Statement statement;

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet executeQuery(String sql) {
        if (connection == null) {
            getConnection();
        }
        try {
            statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 查询
     *
     * @param sql
     * @param obj
     * @return
     */
    public static ResultSet executeQuery(String sql, Object... obj) {
        if (connection == null) {
            getConnection();
        }
        try {
            //select * from output limit ?,?
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject(i + 1, obj[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     */
    public static void close() {
        try {
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
