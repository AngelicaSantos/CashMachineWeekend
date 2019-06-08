package rocks.zipcode.atm;

import javafx.scene.layout.*;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Parent createLogin() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        //vbox.getChildren().addAll(field, flowpane, areaInfo);
        LoginComponent loginComponent = new LoginComponent();
        List<Node> list = loginComponent.getLoginElements();
        Node[] nodes = list.toArray(new Node[]{});
        vbox.getChildren().addAll(nodes);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
//        stage.setScene(new Scene(createLogin()));

        //Button Login
        Button btLogin = new Button("Go back to Login");
        btLogin.setOnAction(e -> stage.setScene(new Scene(createLogin())));

        //Layout accountPage
        StackPane accountPage = new StackPane();
        accountPage.getChildren().addAll(btLogin);
        scene2 = new Scene(accountPage, 900, 900);


        stage.setScene(scene2);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}