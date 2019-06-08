package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
    private TextField name = new TextField();
    private TextField email = new TextField();
    private TextField amount = new TextField();
    private TextField balance = new TextField();


    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(900, 900);



        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Set Account ID");
        btnSubmit.setStyle("-fx-background-color: #ff0000; ");
        btnSubmit.setMaxWidth(100);
        btnSubmit.setPrefWidth(100);
        btnSubmit.setOnAction(e -> {

            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });




        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });



        FlowPane flowpane = new FlowPane();
        flowpane.setHgap(20);
        flowpane.setVgap(20);

        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(field, flowpane, areaInfo);
        return vbox;
    }

    /*******************************************************/


    Scene login, accountPage;


    @Override
    public void start(Stage stage) throws Exception {
        Label backToLogin = new Label("Back to Login");
        Button toLogin = new Button("Back to Login");
        toLogin.setOnAction(e -> stage.setScene(login));

        stage.setScene(new Scene(createContent()));
        stage.show();


    }





    public static void main(String[] args) {
        launch(args);
    }
}
