package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.Heap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;


public class Controller1 {
    public Button back1;
    public Button next;
    public Button bcreateheap;
    public Button binsert;
    public Button bextractmax;
    public Button bfindmax;
    public Button bsize;
    public RadioButton ve1;
    public RadioButton ve2;
    public RadioButton ve3;
    public RadioButton fa1;
    public RadioButton fa2;
    public RadioButton fa3;
    public BorderPane border1;
    public BorderPane border2;
    public BorderPane border3;
    public BorderPane border4;
    public BorderPane border5;
    public BorderPane tipovf;
    public BorderPane tipoinserisci;
    public BorderPane tiposelezione;
    public Label lb1;
    public Label lberror1;
    public Label b4label;
    public Label lr1;
    public Label lr2;
    public Label lr3;
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public Image img1;
    public ImageView imgview;
    public StackPane sp1;
    public StackPane sp2;
    public StackPane sp3;
    public StackPane sp4;
    public StackPane sp5;
    public StackPane sp6;
    public StackPane sp7;
    public ToggleGroup Quiz = new ToggleGroup();
    public ToggleGroup vf1 = new ToggleGroup();
    public ToggleGroup vf2 = new ToggleGroup();
    public ToggleGroup vf3 = new ToggleGroup();
    public Circle c1;
    public Circle c2;
    public Circle c3;
    public Circle c4;
    public Circle c5;
    public Circle c6;
    public Circle c7;
    public Line l1;
    public Line l2;
    public Line l3;
    public Line l4;
    public Line l5;
    public Line l6;
    private String risp1;
    private String risp2;
    private String risp3;
    public Heap<Integer> heap;
    public StackPane sc1;
    public Iterator it;
    public TextField tinserisci;
    public TextField hins;
    public int selez;
    public int verof;
    public int inser;
    public int a = 1;
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
        bextractmax.setDisable(false);
        bsize.setDisable(false);
        binsert.setDisable(false);
        heap = new Heap<Integer>();
        b4label.setVisible(true);
        b4label.setText("Hai creato un heap vuoto!");

    }
    public void fextractmax(){
        if(heap.size()==0){
            b4label.setText("Non puoi estrarre il massimo perché l'heap é vuoto!");

        } else{
            b4label.setText("Hai appena estratto il numero piú grande: " + heap.extractMax());
            a--;
            fixing();
        }

    }
    public void ffindmax(){
        if(heap.size()==0){
            b4label.setText("L'Heap é vuoto non é presente il massimo!");
        } else {
            b4label.setText("Il numero piú grande: " + heap.getMax());
        }
    }
    public void fsize(){
        b4label.setText("Il numero di elementi del tuo heap: " + heap.size());
    }
    public void finsert() {
        int z;
        if (!hins.getText().isEmpty()) {
            String p = hins.getText();
            hins.setText("");
            if (p.matches("[0-9]+")){
                z = Integer.parseInt(p);

                if (a < 8) {
                    heap.insert(z);
                    b4label.setText("Hai aggiunto l'elemento " + z + " all'Heap!");
                    fixing();
                    a++;
                } else {
                    b4label.setText("Hai raggiunto il numero massimo di elementi!");
                }
            } else {
                b4label.setText("Hai inserito un carattere non consensito!");
            }
        } else {
            b4label.setText("Devi inserire un numero!");
        }
    }
    public void fixing() {
        sp1.getChildren().clear();
        sp2.getChildren().clear();
        sp3.getChildren().clear();
        sp4.getChildren().clear();
        sp5.getChildren().clear();
        sp6.getChildren().clear();
        sp7.getChildren().clear();
        Text txt1, txt2, txt3, txt4, txt5, txt6, txt7;

        if (heap.size() == 1) {
            txt1 = new Text("" + heap.getElement(0));
            sp1.getChildren().addAll(c1, txt1);
            c1.setVisible(true);
            c2.setVisible(false);
            l1.setVisible(false);
        }
        if (heap.size() == 2) {
            txt1 = new Text("" + heap.getElement(0));
            txt2 = new Text("" + heap.getElement(1));
            sp1.getChildren().addAll(c1, txt1);
            sp2.getChildren().addAll(c2, txt2);
            l1.setVisible(true);
            l2.setVisible(false);
            c2.setVisible(true);
            c3.setVisible(false);
        }
        if (heap.size() == 3) {
            txt1 = new Text("" + heap.getElement(0));
            txt2 = new Text("" + heap.getElement(1));
            txt3 = new Text("" + heap.getElement(2));
            sp1.getChildren().addAll(c1, txt1);
            sp2.getChildren().addAll(c2, txt2);
            sp3.getChildren().addAll(c3, txt3);
            l2.setVisible(true);
            l3.setVisible(false);
            c3.setVisible(true);
            c4.setVisible(false);
        }
        if (heap.size() == 4) {
            txt1 = new Text("" + heap.getElement(0));
            txt2 = new Text("" + heap.getElement(1));
            txt3 = new Text("" + heap.getElement(2));
            txt4 = new Text("" + heap.getElement(3));
            sp1.getChildren().addAll(c1, txt1);
            sp2.getChildren().addAll(c2, txt2);
            sp3.getChildren().addAll(c3, txt3);
            sp4.getChildren().addAll(c4, txt4);
            l3.setVisible(true);
            l4.setVisible(false);
            c4.setVisible(true);
            c5.setVisible(false);
        }
        if (heap.size() == 5) {
            txt1 = new Text("" + heap.getElement(0));
            txt2 = new Text("" + heap.getElement(1));
            txt3 = new Text("" + heap.getElement(2));
            txt4 = new Text("" + heap.getElement(3));
            txt5 = new Text("" + heap.getElement(4));
            sp1.getChildren().addAll(c1, txt1);
            sp2.getChildren().addAll(c2, txt2);
            sp3.getChildren().addAll(c3, txt3);
            sp4.getChildren().addAll(c4, txt4);
            sp5.getChildren().addAll(c5, txt5);
            l4.setVisible(true);
            l5.setVisible(false);
            c5.setVisible(true);
            c6.setVisible(false);
        }
        if (heap.size() == 6) {
            txt1 = new Text("" + heap.getElement(0));
            txt2 = new Text("" + heap.getElement(1));
            txt3 = new Text("" + heap.getElement(2));
            txt4 = new Text("" + heap.getElement(3));
            txt5 = new Text("" + heap.getElement(4));
            txt6 = new Text("" + heap.getElement(5));
            sp1.getChildren().addAll(c1, txt1);
            sp2.getChildren().addAll(c2, txt2);
            sp3.getChildren().addAll(c3, txt3);
            sp4.getChildren().addAll(c4, txt4);
            sp5.getChildren().addAll(c5, txt5);
            sp6.getChildren().addAll(c6, txt6);
            l5.setVisible(true);
            l6.setVisible(false);
            c6.setVisible(true);
            c7.setVisible(false);

        }
        if (heap.size() == 7) {
            txt1 = new Text("" + heap.getElement(0));
            txt2 = new Text("" + heap.getElement(1));
            txt3 = new Text("" + heap.getElement(2));
            txt4 = new Text("" + heap.getElement(3));
            txt5 = new Text("" + heap.getElement(4));
            txt6 = new Text("" + heap.getElement(5));
            txt7 = new Text("" + heap.getElement(6));
            sp1.getChildren().addAll(c1, txt1);
            sp2.getChildren().addAll(c2, txt2);
            sp3.getChildren().addAll(c3, txt3);
            sp4.getChildren().addAll(c4, txt4);
            sp5.getChildren().addAll(c5, txt5);
            sp6.getChildren().addAll(c6, txt6);
            sp7.getChildren().addAll(c7, txt7);
            l6.setVisible(true);
            c7.setVisible(true);
        }
    }
    public void gonext4()  throws IOException,ParseException,NullPointerException{
        border4.setVisible(false);
        border5.setVisible(true);
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("D:\\GitHub Desktop Repositories\\AlgaT\\src\\sample\\domande1.json"));
        it = a.iterator();
        JSONObject jitem = (JSONObject) it.next();
        load(jitem);
    }

    public void keep() throws FileNotFoundException{
        String v1 = "";
        String v2 = "";
        String v3 = "";
        if(selez == 00) {
            RadioButton p = (RadioButton) Quiz.getSelectedToggle();
            v1 = p.getText();
        }
        if(verof == 00){
            RadioButton p = (RadioButton) vf1.getSelectedToggle();
            v1 = p.getText();
            RadioButton q = (RadioButton) vf2.getSelectedToggle();
            v2 = q.getText();
            RadioButton r = (RadioButton) vf3.getSelectedToggle();
            v3 = r.getText();
        }
        if(inser == 00){
            v1 = tinserisci.getText();
            tinserisci.setText("");
        }
        if(inser == 00 || selez == 00){
            if (!risp1.equals(v1)) {
                lberror1.setVisible(true);
            } else {
                lberror1.setVisible(false);
                if (it.hasNext()) {
                    load((JSONObject) it.next());
                } else {
                    next.setDisable(false);
                    next.setVisible(true);
                    lberror1.setVisible(true);
                    lberror1.setText("Hai risposto correttamente a tutte le domande! Clicca su avanti per tornare al menú lezioni");
                }
            }
        } else {
            if (!risp1.equals(v1)) {
                lberror1.setVisible(true);
            } else if(!risp2.equals(v2)){
                lberror1.setVisible(true);
            } else if(!risp3.equals(v3)){
                lberror1.setVisible(true);
            } else {
                lberror1.setVisible(false);
                if (it.hasNext()) {
                    load((JSONObject) it.next());
                } else {
                    next.setDisable(false);
                    next.setVisible(true);
                    lberror1.setVisible(true);
                    lberror1.setText("Hai risposto correttamente a tutte le domande! Clicca su avanti per tornare al menú lezioni");
                }
            }
        }
    }

    public void load(JSONObject item) {
            lb1.setText((String) item.get("testo"));
            //Image image = new Image(getClass().getResourceAsStream((String)item.get("immagine")));
          //  imgview.setImage(image);
            String tipo = (String) item.get("tipo");
            selez = tipo.compareTo("Selezione");
            verof = tipo.compareTo("VeroFalso");
            inser = tipo.compareTo("Inserimento");
            if (selez == 0) {
                rb1.setToggleGroup(Quiz);
                rb2.setToggleGroup(Quiz);
                rb3.setToggleGroup(Quiz);
                rb4.setToggleGroup(Quiz);
                rb1.setText((String) item.get("r1"));
                rb2.setText((String) item.get("r2"));
                rb3.setText((String) item.get("r3"));
                rb4.setText((String) item.get("r4"));
                tiposelezione.setVisible(true);
                tipovf.setVisible(false);
                tipoinserisci.setVisible(false);
                risp1 = (String) item.get("true");


            }
            if (verof == 0) {
                ve1.setToggleGroup(vf1);
                fa1.setToggleGroup(vf1);
                ve2.setToggleGroup(vf2);
                fa2.setToggleGroup(vf2);
                ve3.setToggleGroup(vf3);
                fa3.setToggleGroup(vf3);
                lr1.setText((String) item.get("r1"));
                lr2.setText((String) item.get("r2"));
                lr3.setText((String) item.get("r3"));
                tiposelezione.setVisible(false);
                tipovf.setVisible(true);
                tipoinserisci.setVisible(false);
                risp1 = (String) item.get("a1");
                risp2 = (String) item.get("a2");
                risp3 = (String) item.get("a3");
            }
            if (inser == 0) {
                tiposelezione.setVisible(false);
                tipovf.setVisible(false);
                tipoinserisci.setVisible(true);
                risp1 = (String) item.get("true");
            }


        }


    public void gonext9() throws IOException {
        Stage primaryStage = (Stage) back1.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }
}
