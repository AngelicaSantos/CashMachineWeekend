package rocks.zipcode.atm.login;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginComponent {
public List<Node> getLoginElements() {
    List<Node> elements = new ArrayList<>();

    Text loginHeader = new Text("DRAGON BANK UNITED");
    loginHeader.setFont(Font.font("Verdana",30));
    loginHeader.setTextAlignment(TextAlignment.RIGHT);
    loginHeader.setFill(Color.PURPLE);

    Label accountIdLabel = new Label("Account ID : ");

    TextField accountIdTextField = new TextField();

    Button btnLogin = new Button("LOGIN");
   /*elements.add(loginHeader);
   elements.add(accountIdLabel);
   elements.add(accountIdTextField);
   elements.add(btnLogin);*/

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
    return elements;

}
}
