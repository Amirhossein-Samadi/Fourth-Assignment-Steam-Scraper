import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadGames
{
    public static Game loadGames() throws SQLException
    {
        String sql = "SELECT * FROM VideoGames";

        try (
                Statement stmt = DBConnection.dBConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                String name = rs.getString("name");
                double rating = rs.getDouble("rating");
                double price = rs.getDouble("price");

                Game game = new Game(name, rating, price);

                return game;
            }
        } catch (Exception e)
        {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
        return null;
    }

}
