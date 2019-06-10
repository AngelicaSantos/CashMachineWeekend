package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountComponent {

    private CashMachine cashMachine;// = new CashMachine(new Bank());

    Stage stage2 = new Stage();

    public List<Node> getCreateAccountElements(Stage stage, Scene scene1, CashMachine cashMachine) {

        this.cashMachine = cashMachine;
        List<Node> elements = new ArrayList<>();
        Text loginHeader = new Text("DRAGON BANK UNITED");
        loginHeader.setFont(Font.font("Verdana",30));
        loginHeader.setTextAlignment(TextAlignment.RIGHT);
        loginHeader.setFill(Color.DARKRED);

        Label nameLabel = new Label("Name : ");
        TextField nameTextField = new TextField();

        //Text overDraftText = new Text();
       // overDraftText.setVisible(false);

        Label emailLabel = new Label("Email : ");
        TextField emailTextField = new TextField();

        Label accountTypeLabel = new Label("Account Type : ");
        TextField accountTypeField = new TextField();

        Label depositLabel = new Label("Deposit Amount : ");
        TextField depositField = new TextField();

        Button btnCreateAccount = new Button("Create Account");

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


        elements.add(textFlowPane);
        elements.add(gridPane);

        return elements;
    }
}
