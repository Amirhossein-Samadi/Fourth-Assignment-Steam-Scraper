import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UserInterface extends Application
{
    public static void showUserPage()
    {
        Stage stage = new Stage();
        stage.setTitle("Video Games");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);


        TableView<Game> gameTableView = new TableView<>();

        TableColumn<Game, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Game, Double> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        TableColumn<Game, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<Game> gameObservableList = FXCollections.observableArrayList(Parser.games);

        gameTableView.getColumns().addAll(nameColumn, ratingColumn, priceColumn);

        gameTableView.setItems(gameObservableList);

        gridPane.add(gameTableView, 1, 1);

        Scene scene = new Scene(gridPane, 1450, 800);
        stage.setScene(scene);

        stage.show();

    }


    @Override
    public void start(Stage stage) throws Exception {}
}
