package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 {
    public Button back1;
    public Button next;
    public BorderPane border1;
    public BorderPane border2;
    public BorderPane border3;
    public BorderPane border4;
    public BorderPane border5;
    public BorderPane border6;
    public BorderPane border7;
    public void goback1() throws IOException {
        Stage primaryStage = (Stage) back1.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
    public void goback2() {
        border1.setVisible(true);
        border2.setVisible(false);
    }
    public void goback3() {
        border2.setVisible(true);
        border3.setVisible(false);
    }
    public void goback4() {
        border3.setVisible(true);
        border4.setVisible(false);
    }
    public void goback5() {
        border4.setVisible(true);
        border5.setVisible(false);
    }
    public void goback6() {
        border5.setVisible(true);
        border6.setVisible(false);
    }
    public void goback7() {
        border6.setVisible(true);
        border7.setVisible(false);
    }
    public void gonext1() {
        border1.setVisible(false);
        border2.setVisible(true);
    }
    public void gonext2() {
        border2.setVisible(false);
        border3.setVisible(true);
    }
    public void gonext3() {
        border3.setVisible(false);
        border4.setVisible(true);
    }
    public void gonext4() {
        border4.setVisible(false);
        border5.setVisible(true);
    }
    public void gonext5() {
        border5.setVisible(false);
        border6.setVisible(true);
    }
    public void gonext6() {
        border6.setVisible(false);
        border7.setVisible(true);
    }

}
