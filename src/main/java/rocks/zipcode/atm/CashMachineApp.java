package rocks.zipcode.atm;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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

    public static void main (String[]args){
        launch(args);
    }

    Stage window;
    Scene login, accountPage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


        Label msgLogin = new Label("Please Login");
        Button btAccountPage = new Button("Go to accountPage");
        btAccountPage.setOnAction(e -> window.setScene(accountPage));

        //Login
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(msgLogin, btAccountPage);
        login = new Scene(layout1, 400, 400);

        //btLogin
        Button btLogin = new Button("Go back to login");
        btLogin.setOnAction(e -> window.setScene(login));


        //Layout for AccountPage
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(btLogin);
        accountPage = new Scene(layout2, 600, 300);

        window.setScene(new Scene(createLogin()));
        window.setScene(new Scene(getLoginElements()));

 //      window.setScene(login);
 //       window.setScene(accountPage);
        window.setTitle("Dragon Bank United");
        window.show();



    }


 private Parent createLogin() {
 //login layout
 VBox vbox = new VBox(10);
 vbox.setPrefSize(600, 600);
 //vbox.getChildren().addAll(field, flowpane, areaInfo);
 LoginComponent loginComponent = new LoginComponent();
 List<Node> list = loginComponent.getLoginElements();
 Node[] nodes = list.toArray(new Node[]{});getLoginElements;
 vbox.getChildren().addAll(nodes);
 return vbox;
 }

}

//
// @Override
// public void start(Stage stage) throws Exception {
// stage.setScene(new Scene(createContent()));
// stage.show();
// }
