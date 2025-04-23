import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection dBConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\my data\\AP\\Fourth-Assignment-Steam-Scraper\\src\\main\\java\\GamesDb.db";
            conn = DriverManager.getConnection(url);
             System.out.println("اتصال به دیتابیس برقرار شد.");
        } catch (SQLException e) {
            System.out.println("خطا در اتصال به دیتابیس: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        dBConnection();
    }

}