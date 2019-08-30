package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller1 {
    public Button back1 = new Button();

    public BorderPane border1 = new BorderPane();
    public BorderPane border2 = new BorderPane();
    public BorderPane border3 = new BorderPane();
    public BorderPane border4 = new BorderPane();
    public BorderPane border5 = new BorderPane();
    public BorderPane border6 = new BorderPane();
    public BorderPane border7 = new BorderPane();
    public BorderPane border8 = new BorderPane();
    public BorderPane border9 = new BorderPane();

    public void goback1() throws IOException {
        Stage primaryStage = (Stage) back1.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
    public void goback2() throws IOException {
        border1.setVisible(true);
        border2.setVisible(false);
    }
    public void goback3() throws IOException {
        border2.setVisible(true);
        border3.setVisible(false);
    }
    public void goback4() throws IOException {
        border3.setVisible(true);
        border4.setVisible(false);
    }
    public void gonext1() throws IOException {
        border1.setVisible(false);
        border2.setVisible(true);
    }
    public void gonext2() throws IOException {
        border2.setVisible(false);
        border3.setVisible(true);
    }
    public void gonext3() throws IOException {
        border3.setVisible(false);
        border4.setVisible(true);
    }
    public void gonext4() throws IOException {
        border4.setVisible(false);
        border5.setVisible(true);
    }
    public void gonext5() throws IOException {
        border5.setVisible(false);
        border6.setVisible(true);
    }
    public void gonext6() throws IOException {
        border6.setVisible(false);
        border7.setVisible(true);
    }
    public void gonext7() throws IOException {
        border7.setVisible(false);
        border8.setVisible(true);
    }
    public void gonext8() throws IOException {
        border8.setVisible(false);
        border9.setVisible(true);
    }
    public void gonext9() throws IOException {
        Stage primaryStage = (Stage) back1.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
}
