import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.charset.StandardCharsets;


public class Parser
{
    static List<Game> games = new ArrayList<>();

    public static List<Game> sortByName(List<Game> games)
    {
        List<Game> sortedByName = new ArrayList<>(Parser.games);

        // Bubble Sort
        {
            for (int i = 0; i < sortedByName.size() - 1; i++)
            {
                for (int j = 0; j < sortedByName.size() - i - 1; j++)
                {
                    if (sortedByName.get(j).getName().compareTo(sortedByName.get(j + 1).getName()) > 0)
                    {
                        Game temp = sortedByName.get(j);
                        sortedByName.set(j, sortedByName.get(j + 1));
                        sortedByName.set(j + 1, temp);
                    }
                }
            }
        }

        return  sortedByName;
    }

    public static List<Game> sortByRating(List<Game> games)
    {
        List<Game> sortedByRating = new ArrayList<>(games);

        // Bubble Sort
        {
        for (int i = 0; i < sortedByRating.size() - 1; i++)
        {
            for (int j = 0; j < sortedByRating.size() - i - 1; j++)
            {
                if (sortedByRating.get(j).getRating() < sortedByRating.get(j + 1).getRating())
                {
                    Game temp = sortedByRating.get(j);
                    sortedByRating.set(j, sortedByRating.get(j + 1));
                    sortedByRating.set(j + 1, temp);
                }
            }
        }
    }

        return sortedByRating;
    }

    public static List<Game> sortByPrice(List<Game> games)
    {
        List<Game> sortedByPrice = new ArrayList<>(games);

        // Bubble Sort
        for (int i = 0; i < sortedByPrice.size() - 1; i++) {
            for (int j = 0; j < sortedByPrice.size() - i - 1; j++) {
                if (sortedByPrice.get(j).getPrice() > sortedByPrice.get(j + 1).getPrice()) {
                    Game temp = sortedByPrice.get(j);
                    sortedByPrice.set(j, sortedByPrice.get(j + 1));
                    sortedByPrice.set(j + 1, temp);
                }
            }
        }

        return sortedByPrice;
    }

    public static void setUp(File file) throws IOException {

        File input = new File("src/Resources/Video_Games.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements gameElements = doc.getElementsByClass("game");

        for (Element game : gameElements) {
            String name = game.getElementsByClass("game-name").text();

            String rating = game.getElementsByClass("game-rating").text();
            String firstRate = rating.split("/")[0];
            double rateDouble = Double.parseDouble(firstRate);

            String price = game.getElementsByClass("game-price").text();
            String firstPrice = price.split(" ")[0];
            int priceInt = Integer.parseInt(firstPrice);

            games.add(new Game(name, rateDouble, priceInt));
        }
    }

    public static void printGames(List<Game> games) {
        games.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        File htmlFile = new File("src/Resources/Video_Games.html");
        Parser.setUp(htmlFile);

        System.out.println("\n--- Sorted by Name ---");
        Parser.printGames(Parser.sortByName(games));

        System.out.println("\n--- Sorted by Rating ---");
        Parser.printGames(Parser.sortByRating(games));

        System.out.println("\n--- Sorted by Price ---");
        Parser.printGames(Parser.sortByPrice(games));
    }
}
