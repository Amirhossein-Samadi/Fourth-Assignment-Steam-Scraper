import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser
{
    static List<Game> games = new ArrayList<>();

    public List<Game> sortByName()
    {
        List<Game> sortedByName = new ArrayList<>(games);

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

    public List<Game> sortByRating()
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

    public List<Game> sortByPrice()
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

    public void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        //TODO

        // Extract data from the HTML
        //TODO

        // Iterate through each Game div to extract Game data
        //TODO
    }

    public static void main(String[] args) {
        //you can test your code here before you run the unit tests
    }
}
