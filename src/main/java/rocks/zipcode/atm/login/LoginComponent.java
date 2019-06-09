package rocks.zipcode.atm.login;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rocks.*;

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
import rocks.zipcode.atm.CashMachineApp;
import rocks.zipcode.atm.bank.AccountData;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LoginComponent {
    private CashMachine cashMachine;// = new CashMachine(new Bank());

    Stage stage2 = new Stage();

public List<Node> getLoginElements(Stage stage, Scene scene1, CashMachine cashMachine) {
    this.cashMachine = cashMachine;
    List<Node> elements = new ArrayList<>();
    Text loginHeader = new Text("DRAGON BANK UNITED");
    loginHeader.setFont(Font.font("Verdana",30));
    loginHeader.setTextAlignment(TextAlignment.RIGHT);
    loginHeader.setFill(Color.DARKRED);
    Image logo = null;
    try {
        logo = new Image(new FileInputStream("/Users/angelicasantos/Desktop/ZipCodeAS/CashMachineWeekend/src/images/dragonLogo.jpg"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    ImageView finalPic = new ImageView(logo);
    finalPic.setFitHeight(500);
    finalPic.setFitWidth(500);
    //finalPic.setX(300);
    //finalPic.setY(300);


    Label accountIdLabel = new Label("Account ID : ");

    TextField accountIdTextField = new TextField();

    Button btnLogin = new Button("ENTER");
    Button btnCreateAccount = new Button("Create Account");

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
    gridPane.add(finalPic, 1,1,3,3);
    gridPane.setStyle("-fx-background-color: #ffffff");
    gridPane.add(accountIdLabel, 0, 3);
    gridPane.add(accountIdTextField, 1, 3);
    gridPane.add(btnLogin, 2, 3);
    gridPane.add(btnCreateAccount,4,4);


    elements.add(textFlowPane);
    elements.add(gridPane);

    // Login Logic validate login maybe ? * //
    btnLogin.setOnAction(e -> {
        int id = Integer.parseInt(accountIdTextField.getText());
        this.cashMachine.login(id);
        System.out.println(this.cashMachine.toString());

        //set values
        TextField accountId = (TextField) scene1.lookup("#accountId");
        accountId.setText("" + cashMachine.getAccountData().getId());

        TextField name = (TextField) scene1.lookup("#accountName");
        name.setText(cashMachine.getAccountData().getName());

        TextField email = (TextField) scene1.lookup("#email");
        email.setText(cashMachine.getAccountData().getEmail());

        TextField balance = (TextField) scene1.lookup("#balance");
        balance.setText("" + cashMachine.getAccountData().getBalance());


        stage.setScene(scene1);
        stage.show();
        accountIdTextField.clear();

    });

    return elements;

    }
}
