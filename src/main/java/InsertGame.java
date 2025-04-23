import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertGame {

    public static void insertGame(Connection conn, String name, String rating, String price) throws SQLException {

        String sql = "INSERT INTO VideoGames(name,rating,price) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, rating);
        ps.setString(3, price);

        ps.executeUpdate();
    }
}
