package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public Button bheap = new Button();
    public Button bheapsort = new Button();
    public void heap1() throws IOException {
        Stage primaryStage = (Stage) bheap.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Heap.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
    public void heapsort1() throws IOException {
        Stage primaryStage = (Stage) bheapsort.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Heapsort.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
}
