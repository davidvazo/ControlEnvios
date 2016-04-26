package mx.trillas.ControlEnvio.front;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mx.trillas.ControlEnvio.backend.Login;
import mx.trillas.ControlEnvio.persistence.dao.UsuarioDAO;

public class LoginWindow {
	
	private static Logger logger = Logger.getLogger(UsuarioDAO.class);
	
	public void LoginStage(Stage stage) {

		try {
			VBox rootPane = new VBox();
			Scene scene = new Scene(rootPane, 450, 450);

			FlowPane usernamePane = new FlowPane(50, 50);
			FlowPane passwdPane = new FlowPane(20, 20);

			rootPane.setAlignment(Pos.CENTER);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("style/login.css").toExternalForm());
			
			Text introText = new Text("Control de paquetería");
			introText.setId("introText");

			Text loginText = new Text("Acceso");
			loginText.setId("loginText");

			rootPane.getChildren().addAll(introText, loginText);

			Label usernameLabel = new Label("Usuario");
			usernameLabel.getStyleClass().add("labels");
			TextField usernameField = new TextField();

			usernamePane.getChildren().addAll(usernameLabel, usernameField);

			Label passwdLabel = new Label("Contraseña");
			passwdLabel.getStyleClass().add("labels");
			PasswordField passwdField = new PasswordField();
			usernamePane.setAlignment(Pos.CENTER);
			passwdPane.setAlignment(Pos.CENTER);
			
			passwdField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			    @Override
			    public void handle(KeyEvent keyEvent) {
			        if (keyEvent.getCode() == KeyCode.ENTER)  {

			        	if (Login.checkLoginData(usernameField, passwdField)) {
							try {
								Login.getMenuUser(stage, usernameField.getText(), passwdField.getText());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								logger.error(e.getMessage());
							}
						} else {
							
						}
			        }
			    }
			});
			passwdPane.getChildren().addAll(passwdLabel, passwdField);
			rootPane.getChildren().addAll(usernamePane, passwdPane);
			
			Button submitButton = new Button("Aceptar");
			submitButton.setId("submitButton");
			submitButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					if (Login.checkLoginData(usernameField, passwdField)) {
						try {
							Login.getMenuUser(stage, usernameField.getText(), passwdField.getText());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							logger.error(e.getMessage());
						}
					} else {
						
					}
				}
			});
			rootPane.getChildren().add(submitButton);

			stage.setScene(scene);
			stage.setTitle("Control de paquetería - Login");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
