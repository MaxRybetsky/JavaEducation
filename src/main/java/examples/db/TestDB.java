package examples.db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class TestDB {
    public static void main(String[] args) throws IOException {
        try {
            runTest();
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }
    }

    public static void runTest()
            throws IOException, SQLException {
        try (Connection connection = getConnection();
             Statement stat = connection.createStatement()) {
            stat.executeUpdate("create table greetings "
                    + "(message varchar(20))");
            stat.executeUpdate("insert into greetings(message)"
                    + "values ('Hello, World!');"
                    + "insert into type(name) values('Alocohol')");
            try (ResultSet res = stat.executeQuery("select * from Greetings")) {
                if (res.next()) {
                    System.out.println(res.toString());
                }
            }
            //stat.executeUpdate("drop table Greetings");
        }
    }

    public static Connection getConnection()
            throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(
                Paths.get("data/database.properties"))) {
            properties.load(in);
        }
        String drivers = properties.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}
