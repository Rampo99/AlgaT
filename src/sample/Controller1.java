package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.Heap;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Controller1 {
    public Button back1;

    public BorderPane border1;
    public BorderPane border2;
    public BorderPane border3;
    public BorderPane border4;
    public BorderPane border5;
    public GridPane tipovf;
    public GridPane tipoinserisci;
    public GridPane tiposelezione;
    public Label lb1;
    public Label lberror1;
    public Label b4label;
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public Image img1;
    public ImageView imgview;
    public ToggleGroup Quiz;
    public Button keep;
    public Button bcreateheap;
    public Button binsert;
    public Button bfindmin;
    public Button bfindmax;
    public Button bsize;
    private String rispSelezione;
    public Heap heap;
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

    public void fcreateheap(){
        bcreateheap.setDisable(true);
        bfindmax.setDisable(false);
        bfindmin.setDisable(false);
        bsize.setDisable(false);
        binsert.setDisable(false);
        heap = new Heap();
        b4label.setVisible(true);
        b4label.setText("Hai creato un heap vuoto!");

    }
    public void ffindmin(){

    }
    public void ffindmax(){

    }
    public void fsize(){
        b4label.setText("Il numero di elementi del tuo heap: " + heap.size());

    }
    public void finsert(){
        heap.insert(5);
        b4label.setText("Hai aggiunto l'elemento 5 all'Heap!");
    }
    public void gonext4()  throws IOException,ParseException{
        border4.setVisible(false);
        border5.setVisible(true);
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("D:\\GitHub Desktop Repositories\\AlgaT\\src\\sample\\domande1.json"));
        Iterator it = a.iterator();
        JSONObject jitem = (JSONObject) it.next();
        load(jitem);

        keep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                RadioButton p = (RadioButton) Quiz.getSelectedToggle();
                String v = p.getText();
                if (!rispSelezione.equals(v)) {
                    lberror1.setVisible(true);
                } else {
                    if(it.hasNext()) {
                        it.next();
                        lberror1.setVisible(false);
                        load((JSONObject)it.next());
                    }else{
                        keep.setDisable(false);
                    }

                }
            }
        });
        }

    public void load(JSONObject item) {

            lb1.setText((String) item.get("testo"));
            // img1 = new Image(new FileInputStream((String)item.get("immagine")));
            // imgview = new ImageView(img1);
            String tipo = (String) item.get("tipo");
            int selez = tipo.compareTo("Selezione");
            int verof = tipo.compareTo("VeroFalso");
            int inser = tipo.compareTo("Inserimento");
            if (selez == 0) {
                tiposelezione.setVisible(true);
                tipovf.setVisible(false);
                tipoinserisci.setVisible(false);
                rb1.setText((String) item.get("r1"));
                rb2.setText((String) item.get("r2"));
                rb3.setText((String) item.get("r3"));
                rb4.setText((String) item.get("r4"));
                rispSelezione = (String) item.get("true");
            }
            if (verof == 0) {
                tiposelezione.setVisible(false);
                tipovf.setVisible(true);
                tipoinserisci.setVisible(false);
            }
            if (inser == 0) {
                tiposelezione.setVisible(false);
                tipovf.setVisible(false);
                tipoinserisci.setVisible(true);
            }


        }


    public void gonext9() throws IOException {
        Stage primaryStage = (Stage) back1.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
}
