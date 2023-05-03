package com.example.partie1;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class PremierExempleConteneur extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox = new VBox();

        // sous menu file
        MenuItem fileNew = new MenuItem("New");
        MenuItem fileOpen = new MenuItem("Open");
        MenuItem fileSave = new MenuItem("Save");
        MenuItem fileClose = new MenuItem("Close");

        //sous menu
        MenuItem editCut = new MenuItem("Cut");
        MenuItem editCopy = new MenuItem("Copy");
        MenuItem editPaste = new MenuItem("Paste");

        // creation du menu en haut
        Menu menu1 = new Menu("File");
        menu1.getItems().add(fileNew);
        menu1.getItems().add(fileOpen);
        menu1.getItems().add(fileSave);
        menu1.getItems().add(fileClose);

        Menu menu2 = new Menu("Edit");
        menu2.getItems().add(editCut);
        menu2.getItems().add(editCopy);
        menu2.getItems().add(editPaste);

        Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);

        Label bot = new Label("Ceci est un label de page");
        bot.setAlignment(Pos.BOTTOM_CENTER);
        Separator separator2 = new Separator(Orientation.HORIZONTAL);


        // création des bouton
        Label bout = new Label("Boutons:");
        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 2");
        Button b3 = new Button("Button 3");
        Separator separator = new Separator(Orientation.VERTICAL);
        VBox vBox = new VBox(bout,b1,b2,b3);
        vBox.setAlignment(Pos.CENTER_LEFT);
        //création du grid
        GridPane gridpane = new GridPane();

        // Set one constraint at a time...
        // Places the button at the first row and second column
        Button button = new Button();
        GridPane.setRowIndex(button, 0);
        GridPane.setColumnIndex(button, 1);

        // or convenience methods set more than one constraint at once...
        Label nameLabel = new Label("Name: ");
        Label emailLabel = new Label("Email: ");
        Label pwdLabel = new Label("Password: ");
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        TextField pwdField = new TextField();
        Button sub = new Button("Submit");
        Button can = new Button("Cancel");

        GridPane.setConstraints(nameLabel, 1, 0);
        GridPane.setConstraints(nameField, 2, 0);
        GridPane.setConstraints(emailLabel, 1, 1);
        GridPane.setConstraints(emailField, 2, 1);
        GridPane.setConstraints(pwdLabel, 1, 2);
        GridPane.setConstraints(pwdField, 2, 2);
        GridPane.setConstraints(sub, 1, 3);
        GridPane.setConstraints(can, 2, 3);
        gridpane.setVgap(20);
        gridpane.setHgap(12);
        // don't forget to add children to gridpane
        VBox lab = new VBox(gridpane,separator2,bot);
        lab.setAlignment(Pos.CENTER);
        HBox.setHgrow(lab,Priority.ALWAYS);
        VBox.setVgrow(bot, Priority.ALWAYS);
        HBox.setHgrow(bot,Priority.ALWAYS);

        gridpane.getChildren().addAll(nameLabel, emailLabel,pwdLabel,nameField,emailField,pwdField,sub,can);
        gridpane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(vBox,separator, gridpane);
        hBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(gridpane, Priority.ALWAYS);
        VBox.setVgrow(hBox, Priority.ALWAYS);
        VBox.setVgrow(vBox, Priority.ALWAYS);

        vBox.setSpacing(10);
        hBox.setSpacing(10);

        // Ajout des contrôleurs au conteneur principal
        vbox.getChildren().addAll(
                menuBar,
                hBox,
                lab
        );

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
