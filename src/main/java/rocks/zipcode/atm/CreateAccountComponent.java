package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import rocks.zipcode.atm.bank.Bank;
import rocks.zipcode.atm.login.LoginComponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountComponent {

    private CashMachine cashMachine;// = new CashMachine(new Bank());

    Stage stage2 = new Stage();

    public List<Node> getCreateAccountElements(Stage stage, Scene scene1, CashMachine cashMachine, Scene scene2, ComboBox accountIdCombo) {

        this.cashMachine = cashMachine;
        List<Node> elements = new ArrayList<>();
        Text loginHeader = new Text("DRAGON BANK UNITED");
        loginHeader.setFont(Font.font("Verdana",30));
        loginHeader.setTextAlignment(TextAlignment.RIGHT);
        loginHeader.setFill(Color.DARKRED);

        Label nameLabel = new Label("Name : ");
        TextField nameTextField = new TextField();

        Label emailLabel = new Label("Email : ");
        TextField emailTextField = new TextField();


        Label accountTypeLabel = new Label("Account Type : ");
        ComboBox accountTypeField = new ComboBox();
        accountTypeField.getItems().addAll("Basic", "Premium");
//        TextField accountTypeField = new TextField();

        Label depositLabel = new Label("Deposit Amount : ");
        TextField depositField = new TextField();

        Button btnCreateAccount = new Button("Create Account");
        btnCreateAccount.setOnAction(e ->{
            Bank bank = cashMachine.getBank();

            if(accountTypeField.getValue().toString().equals("Basic")){
                System.out.println(nameTextField.getText());
                if(nameTextField.getText().length() > 0 && emailTextField.getText().length() > 0){
                    if(Integer.parseInt(depositField.getText()) > 0)
                       accountIdCombo.getItems().add(bank.insertBasic(nameTextField.getText(), emailTextField.getText(), depositField.getText() ));
                    else
                        accountIdCombo.getItems().add(bank.insertBasic(nameTextField.getText(), emailTextField.getText(), "0" ));



                    //switch scene
                    VBox vbox = new VBox(10);
                    vbox.setPrefSize(600, 600);
                    LoginComponent a = new LoginComponent();

                    List<Node> list = a.getLoginElements(stage, scene1, cashMachine, scene2, accountIdCombo);
                    Node[] nodes = list.toArray(new Node[]{});
                    vbox.getChildren().addAll(nodes);

                    stage.setScene(new Scene(vbox));
                    stage.show();
                }
            } else if(accountTypeField.getValue().toString().equals("Premium")) {
                System.out.println(nameTextField.getText());
                if(Integer.parseInt(depositField.getText()) > 0)
                    accountIdCombo.getItems().add(bank.insertPremium(nameTextField.getText(), emailTextField.getText(), depositField.getText() ));
                else
                    accountIdCombo.getItems().add(bank.insertPremium(nameTextField.getText(), emailTextField.getText(), "0" ));

                //switch scene
                VBox vbox = new VBox(10);
                vbox.setPrefSize(600, 600);
                LoginComponent a = new LoginComponent();

                List<Node> list = a.getLoginElements(stage, scene1, cashMachine, scene2, accountIdCombo);
                Node[] nodes = list.toArray(new Node[]{});
                vbox.getChildren().addAll(nodes);

                stage.setScene(new Scene(vbox));
                stage.show();
            }
        });


        Button backToLogin = new Button("Back");
        backToLogin.setOnAction(e -> {
            VBox vbox = new VBox(10);
            vbox.setPrefSize(600, 600);
            LoginComponent a = new LoginComponent();

            List<Node> list = a.getLoginElements(stage, scene1, cashMachine, scene2, accountIdCombo);
            Node[] nodes = list.toArray(new Node[]{});
            vbox.getChildren().addAll(nodes);

            stage.setScene(new Scene(vbox));
            stage.show();
        });

        TextFlow textFlowPane = new TextFlow();
        textFlowPane.setTextAlignment(TextAlignment.CENTER);
        textFlowPane.setPrefSize(400, 20);
        textFlowPane.setPadding(new Insets(10, 10, 10, 10));
        textFlowPane.getChildren().addAll(loginHeader);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 300);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #ffffff");
        gridPane.add(nameLabel, 0, 2);
        gridPane.add(nameTextField, 1, 2);
        gridPane.add(emailLabel, 0, 3);
        gridPane.add(emailTextField, 1, 3);
        gridPane.add(accountTypeLabel, 0, 4);
        gridPane.add(accountTypeField, 1, 4);
        gridPane.add(depositLabel, 0, 5);
        gridPane.add(depositField, 1, 5);
        gridPane.add(btnCreateAccount,1,6);
        gridPane.add(backToLogin, 2, 6);


        elements.add(textFlowPane);
        elements.add(gridPane);

        return elements;
    }
}
