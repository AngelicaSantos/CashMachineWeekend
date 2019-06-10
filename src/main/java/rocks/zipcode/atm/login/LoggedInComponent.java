package rocks.zipcode.atm.login;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import rocks.zipcode.atm.CashMachine;
import rocks.zipcode.atm.CashMachineApp;
import rocks.zipcode.atm.bank.Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * This class works similarly to Kavya's LogInComponent.
 * We need to recreate this site using multiple "scenes" to make transitions between
 * pages possible.
 *
 * This code will recreate the original UI that we started with, except it will not
 * have the log in button because we have a working login page now.
 */

public class LoggedInComponent {
    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    public List<Node> getLoginElements() {
        List<Node> elements = new ArrayList<>();

        TextArea areaInfo = new TextArea();

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            Float amount = Float.valueOf(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            Float amount =  Float.valueOf(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });

        FlowPane flowpane = new FlowPane();

        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);

        elements.add(field);
        elements.add(flowpane);
        elements.add(areaInfo);
        return elements;
    }

}