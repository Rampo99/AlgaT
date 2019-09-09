package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.Heap;

import java.io.*;
import java.util.Iterator;

public class Controller2 {
    public Button back1;
    public Button next;
    public Button hp;
    public Button bh;
    public Button add;
    public RadioButton ve1;
    public RadioButton ve2;
    public RadioButton ve3;
    public RadioButton fa1;
    public RadioButton fa2;
    public RadioButton fa3;
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    private String risp1;
    private String risp2;
    private String risp3;
    public TextField ins;
    public TextField tinserisci;
    public BorderPane border1;
    public BorderPane border2;
    public BorderPane border3;
    public BorderPane border4;
    public BorderPane border5;
    public BorderPane border6;
    public BorderPane border7;
    public BorderPane tipovf;
    public BorderPane tipoinserisci;
    public BorderPane tiposelezione;
    public Label lb1;
    public Label lberror1;
    public Label lerror;
    public Label lr1;
    public Label lr2;
    public Label lr3;
    private int selez;
    private int verof;
    private int inser;
    public ImageView imgview1;
    public ImageView imgview2;
    public ImageView imgview3;
    public ImageView imgview4;
    public ImageView imgview5;
    private ToggleGroup Quiz = new ToggleGroup();
    private ToggleGroup vf1 = new ToggleGroup();
    private ToggleGroup vf2 = new ToggleGroup();
    private ToggleGroup vf3 = new ToggleGroup();
    private Iterator it;
    public Heap<Integer> heap = new Heap<>();
    public Circle c1;
    public Circle c2;
    public Circle c3;
    public Circle c4;
    public Circle c5;
    public Circle c6;
    public Rectangle r1;
    public Rectangle r2;
    public Rectangle r3;
    public Rectangle r4;
    public Rectangle r5;
    public Rectangle r6;
    public StackPane sp1;
    public StackPane sp2;
    public StackPane sp3;
    public StackPane sp4;
    public StackPane sp5;
    public StackPane sp6;
    public StackPane sp11;
    public StackPane sp12;
    public StackPane sp13;
    public StackPane sp14;
    public StackPane sp15;
    public StackPane sp16;
    public Line l1;
    public Line l2;
    public Line l3;
    public Line l4;
    public Line l5;
    private int a = 1;
    private int i;
    private int m = 0;
    private int k = 0;
    private boolean u = false;
    private boolean o = false;
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

    public void hinsert() {
        int z;
        if (!ins.getText().isEmpty()) {
            String p = ins.getText();
            ins.setText("");
            if (p.matches("[0-9]+")){
                z = Integer.parseInt(p);

                if (a < 7) {
                    heap.insert2(z);
                    lerror.setVisible(true);
                    lerror.setText("Hai aggiunto l'elemento " + z + " all'Heap!");
                    fixing();
                    a++;
                    if(a==7){
                        bh.setDisable(false);
                    }
                } else {
                    lerror.setText("Hai raggiunto il numero massimo di elementi!");
                }
            } else {
                lerror.setText("Hai inserito un carattere non consensito!");
            }
        } else {
            lerror.setText("Devi inserire un numero!");
        }
        i = heap.size()-1;
    }
    public void fixing() {
        Text txt1, txt2, txt3, txt4, txt5, txt6;
        Text txt11, txt12, txt13, txt14, txt15, txt16;
        if (heap.size() == 1) {
            txt1 = new Text("" + heap.getElement(0));
            txt11 = new Text("" + heap.getElement(0));
            sp1.getChildren().addAll(c1, txt1);
            sp11.getChildren().addAll(r1, txt11);
            r1.setVisible(true);
            c1.setVisible(true);

        }
        if (heap.size() == 2) {
            txt2 = new Text("" + heap.getElement(1));
            txt12 = new Text("" + heap.getElement(1));
            sp2.getChildren().addAll(c2, txt2);
            sp12.getChildren().addAll(r2, txt12);
            l1.setVisible(true);
            r2.setVisible(true);
            c2.setVisible(true);
        }
        if (heap.size() == 3) {
            txt3 = new Text("" + heap.getElement(2));
            txt13 = new Text("" + heap.getElement(2));
            sp3.getChildren().addAll(c3, txt3);
            sp13.getChildren().addAll(r3, txt13);
            l2.setVisible(true);
            r3.setVisible(true);
            c3.setVisible(true);
        }
        if (heap.size() == 4) {
            txt4 = new Text("" + heap.getElement(3));
            txt14 = new Text("" + heap.getElement(3));
            sp14.getChildren().addAll(r4, txt14);
            sp4.getChildren().addAll(c4, txt4);
            l3.setVisible(true);
            r4.setVisible(true);
            c4.setVisible(true);
        }
        if (heap.size() == 5) {
            txt5 = new Text("" + heap.getElement(4));
            txt15 = new Text("" + heap.getElement(4));
            sp5.getChildren().addAll(c5, txt5);
            sp15.getChildren().addAll(r5, txt15);
            l4.setVisible(true);
            r5.setVisible(true);
            c5.setVisible(true);
        }
        if (heap.size() == 6) {
            String a,b,c,d,e,f;
            sp1.getChildren().clear();
            sp2.getChildren().clear();
            sp3.getChildren().clear();
            sp4.getChildren().clear();
            sp5.getChildren().clear();
            sp6.getChildren().clear();
            sp11.getChildren().clear();
            sp12.getChildren().clear();
            sp13.getChildren().clear();
            sp14.getChildren().clear();
            sp15.getChildren().clear();
            sp16.getChildren().clear();
            txt1 = new Text("" + heap.getElement(0));
            txt11 = new Text("" + heap.getElement(0));
            sp1.getChildren().addAll(c1, txt1);
            sp11.getChildren().addAll(r1, txt11);
            txt2 = new Text("" + heap.getElement(1));
            txt12 = new Text("" + heap.getElement(1));
            sp2.getChildren().addAll(c2, txt2);
            sp12.getChildren().addAll(r2, txt12);
            txt3 = new Text("" + heap.getElement(2));
            txt13 = new Text("" + heap.getElement(2));
            sp3.getChildren().addAll(c3, txt3);
            sp13.getChildren().addAll(r3, txt13);
            txt4 = new Text("" + heap.getElement(3));
            txt14 = new Text("" + heap.getElement(3));
            sp14.getChildren().addAll(r4, txt14);
            sp4.getChildren().addAll(c4, txt4);
            txt5 = new Text("" + heap.getElement(4));
            txt15 = new Text("" + heap.getElement(4));
            sp5.getChildren().addAll(c5, txt5);
            sp15.getChildren().addAll(r5, txt15);
            txt6 = new Text("" + heap.getElement(5));
            txt16 = new Text("" + heap.getElement(5));
            sp6.getChildren().addAll(c6, txt6);
            sp16.getChildren().addAll(r6, txt16);
            l5.setVisible(true);
            r6.setVisible(true);
            c6.setVisible(true);

        }
    }
    public void buildheap(){
        if(!o) {
            heap.sort1();
            fixing();
            hp.setDisable(true);
            o=true;
        } else {
            lerror.setVisible(true);
            lerror.setText("Hai gia' eseguito il BuildHeap!");
        }
    }
    public void heapify(){
        if(!u && i!=0) {

            heap.sort2(i);
            fixing();
            lerror.setVisible(true);
            lerror.setText("Hai eseguito il ciclo n. "+ m + " dell'Heapify");
            if(i==0) u=true;
            i--;
            m++;
        } else {
            lerror.setVisible(true);
            lerror.setText("Hai gia' eseguito l'Heapify!");
        }
    }

    public void gonext6() throws IOException, ParseException,NullPointerException {
        border6.setVisible(false);
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("src\\sample\\domande2.json"));
        it = a.iterator();
        JSONObject jitem = (JSONObject) it.next();
        load(jitem);
        border7.setVisible(true);
    }

    public void keep() {
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
                    lberror1.setText("Hai risposto correttamente a tutte le domande! Clicca su avanti per tornare al menu' lezioni");
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
                    lberror1.setText("Hai risposto correttamente a tutte le domande! Hai completato il corso! Clicca su avanti per tornare al menu' lezioni");
                }
            }
        }
    }

    public void load(JSONObject item) {

        lb1.setText((String) item.get("testo"));
        if(k==0)imgview1.setVisible(true);
        if(k==1){
            imgview1.setVisible(false);
            imgview2.setVisible(true);
        }
        if(k==2){
            imgview2.setVisible(false);
            imgview3.setVisible(true);
        }
        if(k==3){
            imgview3.setVisible(false);
            imgview4.setVisible(true);
        }
        if(k==4){
            imgview4.setVisible(false);
            imgview5.setVisible(true);
        }
        k++;
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

    public void gonext7() throws IOException {
        Stage primaryStage = (Stage) back1.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getScene().setRoot(newRoot);
    }

}
