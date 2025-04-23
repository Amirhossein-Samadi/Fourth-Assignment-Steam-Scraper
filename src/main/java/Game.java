import java.util.Objects;

public class Game {

    private String name;
    private double rating;
    private int price;

    public Game(String name, double rating, int price)
    {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Rating: %.1f | Price: $%.2f", name, rating, price);
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.rating, rating) == 0 && Double.compare(game.price, price) == 0 && Objects.equals(name, game.name);
    }

}
