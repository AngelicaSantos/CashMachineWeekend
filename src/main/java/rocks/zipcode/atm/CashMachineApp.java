package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//package rocks.zipcode.atm;

import javafx.geometry.Pos;
import javafx.scene.Node;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import rocks.zipcode.atm.login.LoginComponent;

import java.util.List;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Scene scene1, scene2;

    /* this is Kayva login screen */
    private Parent createLogin(Stage stage, Scene scene1) {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        //vbox.getChildren().addAll(field, flowpane, areaInfo);
        LoginComponent loginComponent = new LoginComponent();
        List<Node> list = loginComponent.getLoginElements(stage, scene1);
        Node[] nodes = list.toArray(new Node[]{});
        vbox.getChildren().addAll(nodes);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Erick code ?
//        LoginComponent loginScreen = new LoginComponent();
//        loginScreen.getLoginElements(stage, scene1);





     //Account field
        Label labelId = new Label("Account ID");
        TextField id = new TextField("getId");

     //Name field
        Label labelName = new Label("Name");
        TextField name = new TextField("getName");

        //Email field
        Label labelEmail = new Label("Email");
        TextField email = new TextField("getEmail");

        //Balance field
        Label labelBalance = new Label("Acccout Balance");
        TextField balance = new TextField("getBalance");

        //Transaction field
        Label labelTransaction = new Label("Transaction Amount");
        TextField transaction = new TextField("getTransaction");

        //Button Deposit
        Button btDeposit = new Button("Deposit");

        //Button Withdraw
        Button btWithdraw = new Button("Withdraw");

        //Button Login
        Button btLogin = new Button("Logout");
        btLogin.setOnAction(e -> stage.setScene(new Scene(createLogin(stage, scene1))));


    //Grid layout
        GridPane.setConstraints(labelId, 0 , 0);
        GridPane.setConstraints(id, 1, 0);
        GridPane.setConstraints(labelName, 0 , 1);
        GridPane.setConstraints(name, 1, 1);
        GridPane.setConstraints(labelEmail, 0 , 2);
        GridPane.setConstraints(email, 1, 2);
        GridPane.setConstraints(labelBalance, 0 , 3);
        GridPane.setConstraints(balance, 1, 3);
        GridPane.setConstraints(labelTransaction, 0 , 5);
        GridPane.setConstraints(transaction, 1, 5);
        GridPane.setConstraints(btDeposit, 3, 4);
        GridPane.setConstraints(btWithdraw, 3, 5);
        GridPane.setConstraints(btLogin, 3, 8);

     //Layout accountPage
        GridPane accountPage = new GridPane();
        accountPage.setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        accountPage.setPadding(new Insets(10, 10, 10, 10));
        accountPage.getChildren().addAll(btLogin, labelId, id, name, labelName, labelEmail, email,
                labelTransaction, transaction, labelBalance, balance, btDeposit, btWithdraw);
        accountPage.setVgap(10);
        accountPage.setHgap(10);

        scene2 = new Scene(accountPage, 480, 350);
        scene1 =  new Scene(createLogin(stage, scene2));
        stage.setTitle("Dragon Bank United");
        stage.setResizable(false);
        stage.setScene(scene1);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}