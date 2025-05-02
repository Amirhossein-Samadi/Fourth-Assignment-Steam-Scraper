import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertGame {

    public static void insertGame(Connection conn, String name, double rating, double price) throws SQLException {

        String sql = "INSERT INTO VideoGames(name,rating,price) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setDouble(2, rating);
        ps.setDouble(3, price);

        ps.executeUpdate();
    }

    public static void main(String[] args)
    {
        File htmlFile = new File("src/Resources/Video_Games.html");
        try {
            Parser.setUp(htmlFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
