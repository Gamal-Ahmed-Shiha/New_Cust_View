package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Duck extends Application {

    @Override
public void start(Stage primaryStage) {


//BOSS YA 3MMENA...ANA 2ASSEMTELAK EL VIEW L 3 STAGES
//2WEL STAGE T7T AHY W DY 5ASSA BE EL CREATE ACCOUNT  
    	
VBox layout = new VBox(20);
layout.setPadding(new Insets(20));
layout.setAlignment(Pos.CENTER);

Label titleLabel = new Label("Create User Account");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.getStyleClass().add("text-field");

        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");
        passwordField.getStyleClass().add("text-field");

        Button createAccountButton = new Button("CREATE ACCOUNT");
        createAccountButton.getStyleClass().add("button");
        
        Button loginButton = new Button("GO TO LOGIN");
        loginButton.getStyleClass().add("button");
        
 
        layout.getChildren().addAll(
            titleLabel,
            emailField,
            passwordField,
            createAccountButton,
            loginButton
        );

        
        Scene scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add(getClass().getResource("Rabbit.css").toExternalForm());

        primaryStage.setTitle("Create User Account");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
        
        
        // DE EL STAGE RAKAM 2 WDY 5ASSA BL LOGIN
        
        VBox layout2 = new VBox(20);
        layout2.setPadding(new Insets(20));
        layout2.setAlignment(Pos.CENTER);

        Label titleLabel2 = new Label("Login To Your Account");

        TextField emailField2 = new TextField();
        emailField2.setPromptText("Email");
        emailField2.getStyleClass().add("text-field");

        TextField passwordField2 = new TextField();
        passwordField2.setPromptText("Password");
        passwordField2.getStyleClass().add("text-field");
        
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Admin",
            "User",
            "Guest"
        );
        comboBox.setPromptText("Account Type");
        comboBox.setStyle("-fx-padding: 10px; -fx-background-radius: 5px; -fx-border-color: #6a5acd; -fx-border-radius: 5px;");

        comboBox.setOnAction(e -> {
            String selected = comboBox.getValue();
        });

        Button createAccountButton2 = new Button("BACK TO CREATE ACCOUNT");
        createAccountButton2.getStyleClass().add("button");
        
        Button loginButton2 = new Button("LOGIN");
        loginButton2.getStyleClass().add("button");
        
        layout2.getChildren().addAll(
            titleLabel2,
            emailField2,
            passwordField2,
            comboBox,
            loginButton2,
            createAccountButton2
            
        );

        
        Scene scene2 = new Scene(layout2, 400, 400);
        scene2.getStylesheets().add(getClass().getResource("Rabbit.css").toExternalForm());
        
        Stage s2 = new Stage();
        s2.setTitle("Login To Your Account");
        s2.setScene(scene2);
     
        
        //EL EVENT LISTENER DA MOHEM FASH5 EW3A TL3B FEEH
/////////////////////////////////////////////////////////////////   
        loginButton.setOnAction(e -> {
            primaryStage.hide();
            s2.show();
        });
        
        createAccountButton2.setOnAction(e -> {
        	s2.hide();
        	primaryStage.show();
        });
//////////////////////////////////////////////////////////////////           
        
         
// WSELNA LL STAGE RAKAM 3 A5ER MA7ATA        

               VBox leftMenu = new VBox();
leftMenu.setPadding(new Insets(10));
leftMenu.setSpacing(20);
leftMenu.setStyle("-fx-background-color: #f4f4f4; -fx-min-width: 150px;");


Button contractButton = new Button("UPLOAD");
contractButton.getStyleClass().add("button");

leftMenu.getChildren().addAll(contractButton);

GridPane formGrid = new GridPane();
formGrid.setPadding(new Insets(20));
formGrid.setHgap(10);
formGrid.setVgap(15);

Label[] labels = {
    new Label("First Name"), new Label("Middle Name"), new Label("Last Name"),
    new Label("SSN"), new Label("ID (Can't be changed)"),
    new Label("Email"), new Label("Phone Number"),
    new Label("Region"), new Label("Street"), new Label("Building Number"),
    new Label("New Password")
};


TextField[] textFields = new TextField[labels.length];
for (int i = 0; i < textFields.length; i++) {
    textFields[i] = new TextField();
    textFields[i].setPromptText(labels[i].getText());
    textFields[i].setPrefWidth(250);
    textFields[i].setPrefHeight(40);
}


//mtt5addesh dy 7aga zy el 2-d array keda bezzabt

for (int i = 0; i < labels.length; i++) {
    formGrid.add(labels[i], i % 3, i / 3 * 2);
    formGrid.add(textFields[i], i % 3, i / 3 * 2 + 1);
}

Button saveUpdateButton = new Button("SAVE UPDATE");
saveUpdateButton.getStyleClass().add("button");

Button downloadContractButton = new Button("DOWNLOAD CONTRACT");
downloadContractButton.getStyleClass().add("button");

//dy b2a 7aga zy el flex box fel css

HBox actionButtons = new HBox(10, saveUpdateButton, downloadContractButton);
actionButtons.setAlignment(Pos.CENTER);

VBox mainForm = new VBox(40, formGrid, actionButtons);
///////////////////////////////////////////////////////////

Button logoutButton = new Button("LOG OUT");
logoutButton.getStyleClass().add("button");
logoutButton.setPrefHeight(40);
logoutButton.setPrefWidth(150);

VBox rightMenu = new VBox(logoutButton);
rightMenu.setAlignment(Pos.TOP_RIGHT);
rightMenu.setPadding(new Insets(10));

HBox mainLayout = new HBox(leftMenu, mainForm, rightMenu);
mainLayout.setPadding(new Insets(10));

Scene scene3 = new Scene(mainLayout, 1200, 570);
Stage s3 = new Stage();
s3.setTitle("Customer FORM");
s3.setScene(scene3);
scene3.getStylesheets().add(getClass().getResource("Rabbit.css").toExternalForm());


///ew3a tel3b fh7agaaaaaaaaaaaaaaa////////////////

loginButton2.setOnAction(e -> {
    s2.hide();
    s3.show();
});
    
    logoutButton.setOnAction(e -> {
        s3.hide();
        s2.show();
 });
    
//////////////////////////////////////////////////
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}

