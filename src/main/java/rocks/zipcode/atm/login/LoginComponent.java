package rocks.zipcode.atm.login;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import rocks.zipcode.atm.CashMachine;
import rocks.zipcode.atm.bank.Bank;

import java.util.ArrayList;
import java.util.List;

public class LoginComponent {
    private CashMachine cashMachine = new CashMachine(new Bank());

    Stage stage2 = new Stage();

public List<Node> getLoginElements(Stage stage, Scene scene1) {
    List<Node> elements = new ArrayList<>();
    Text loginHeader = new Text("DRAGON BANK UNITED");
    loginHeader.setFont(Font.font("Verdana",30));
    loginHeader.setTextAlignment(TextAlignment.RIGHT);
    loginHeader.setFill(Color.PURPLE);

    Label accountIdLabel = new Label("Account ID : ");

    TextField accountIdTextField = new TextField();

    Button btnLogin = new Button("LOGIN");

    TextFlow textFlowPane = new TextFlow();
    textFlowPane.setTextAlignment(TextAlignment.CENTER);
    textFlowPane.setPrefSize(400, 20);
    textFlowPane.setPadding(new Insets(10, 10, 10, 10));
    textFlowPane.getChildren().addAll(loginHeader);

    GridPane gridPane = new GridPane();
    gridPane.setMinSize(400, 200);
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    gridPane.setVgap(30);
    gridPane.setHgap(30);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.add(accountIdLabel, 0, 3);
    gridPane.add(accountIdTextField, 1, 3);
    gridPane.add(btnLogin, 1, 4);

    elements.add(textFlowPane);
    elements.add(gridPane);

    // Login Logic validate login maybe ? * //
    btnLogin.setOnAction(e -> {
        int id = Integer.parseInt(accountIdTextField.getText());
        cashMachine.login(id);
        System.out.println(cashMachine.toString());

        stage.setScene(scene1);
        stage.show();


    });

    return elements;

    }
}
