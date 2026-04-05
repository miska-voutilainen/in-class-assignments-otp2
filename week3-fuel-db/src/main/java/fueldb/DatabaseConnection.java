package fueldb;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static String url;
    private static String user;
    private static String password;

    static {
        Properties props = new Properties();
        try (InputStream is = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (is != null) {
                props.load(is);
                url = props.getProperty("db.url", "jdbc:mysql://localhost:3306/fuel_calculator_localization");
                user = props.getProperty("db.user", "root");
                password = props.getProperty("db.password", "root");
            } else {
                url = "jdbc:mysql://localhost:3306/fuel_calculator_localization";
                user = "root";
                password = "root";
            }
        } catch (IOException e) {
            url = "jdbc:mysql://localhost:3306/fuel_calculator_localization";
            user = "root";
            password = "root";
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
