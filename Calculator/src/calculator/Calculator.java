package calculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator extends Application {
    // Creating the buttons
    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button b0 = new Button("0");
    Button equal = new Button("=");
    Button add = new Button("+");
    Button sub = new Button("-");
    Button div = new Button("/");
    Button mult = new Button("*");
    Button clear = new Button("Cl");
    Button save = new Button("Save");
    Button load = new Button("Load");
    TextArea history = new TextArea();
    TextField input = new TextField();

    @Override
public void start(Stage primaryStage) {

    HBox root = new HBox();
    VBox left = new VBox();
    VBox right = new VBox();
    
    // Setting width constraints for each button
    b1.setPrefWidth(70);
    b2.setPrefWidth(70);
    b3.setPrefWidth(70);
    b4.setPrefWidth(70);
    b5.setPrefWidth(70);
    b6.setPrefWidth(70);
    b7.setPrefWidth(70);
    b8.setPrefWidth(70);
    b9.setPrefWidth(70);
    b0.setPrefWidth(70);
    equal.setPrefWidth(70);
    add.setPrefWidth(70);
    clear.setPrefWidth(70);
    sub.setPrefWidth(70);
    div.setPrefWidth(70);
    mult.setPrefWidth(70);
    input.setPrefWidth(280);

    history.setEditable(false);
    input.setEditable(false);

// Calculator (left) side layout        
    // top row
    HBox top = new HBox();
    top.getChildren().add(input);
    // first row
    HBox hbox1 = new HBox(0);
    hbox1.getChildren().addAll(b7, b8, b9, add);
    // second row
    HBox hbox2 = new HBox(0);
    hbox2.getChildren().addAll(b4, b5, b6, sub);
    // third row
    HBox hbox3 = new HBox(0);
    hbox3.getChildren().addAll(b1, b2, b3, div);
    // fourth row
    HBox hbox4 = new HBox(0);
    hbox4.getChildren().addAll(b0, equal, mult, clear);

    // Left side gets the rows for calcultor
    left.getChildren().addAll(top, hbox1, hbox2, hbox3, hbox4);

// History and save/load (right) side layout 
    // History "ticker"
    HBox box = new HBox();
    box.getChildren().add(history);
    // Save and load buttons
    HBox bottom = new HBox();
    bottom.getChildren().addAll(save, load);

    // Right side vbox adds the hbox's created for the right 
    // Side of application
    right.getChildren().addAll(box, bottom);

    // Root hbox gets the left and right vbox's
    root.getChildren().addAll(left, right);
    Scene scene = new Scene(root, 800, 200);

    primaryStage.setTitle("Calculator v 0.1");
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();

    //lambda expresison for all number buttons and operators
    b0.setOnAction(event -> {
        input.appendText("0");
    });
    b1.setOnAction(event -> {
        input.appendText("1");
    });
    b2.setOnAction(event -> {
        input.appendText("2");
    });
    b3.setOnAction(event -> {
        input.appendText("3");
    });
    b4.setOnAction(event -> {
        input.appendText("4");
    });
    b5.setOnAction(event -> {
        input.appendText("5");
    });
    b6.setOnAction(event -> {
        input.appendText("6");
    });
    b7.setOnAction(event -> {
        input.appendText("7");
    });
    b8.setOnAction(event -> {
        input.appendText("8");
    });
    b9.setOnAction(event -> {
        input.appendText("9");
    });
    add.setOnAction(event -> {
        input.appendText(" + ");
    });
    sub.setOnAction(event -> {
        input.appendText(" - ");
    });
    mult.setOnAction(event -> {
        input.appendText(" * ");
    });
    div.setOnAction(event -> {
        input.appendText(" / ");
    });
    clear.setOnAction(event -> {
        input.setText("");
    });

    // Calculates the total by properly handling the string in the text field with engine eval
    equal.setOnAction(event -> {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        try {
            System.out.println(engine.eval(input.getText()));
            input.setText(engine.eval(input.getText()).toString());
        } catch (ScriptException ex) {
            ex.printStackTrace();
            input.setText("Error");
        }

    });
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
