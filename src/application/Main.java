package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	final Label message = new Label("");

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 260, 80);
		stage.setScene(scene);
		stage.setTitle("Password Demo");

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 0, 0, 10));
		vb.setSpacing(10);
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);

		Label label = new Label("Password");
		final PasswordField pb = new PasswordField();
		Button Okay = new Button();
		Okay.setText("Okay");
		Button Help = new Button();
		Help.setText("Help");
		Okay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!pb.getText().equals("bugaboo")) {
					message.setText("Your password is incorrect!");
					message.setTextFill(Color.web("red"));
				} else {
					message.setText("Your password has been confirmed");
					message.setTextFill(Color.web("green"));
				}
				pb.setText("");
			}
		});
		Help.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				message.setText("Help was clicked");
			}
			});
		
		pb.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (!pb.getText().equals("bugaboo")) {
					message.setText("Your password is incorrect!");
					message.setTextFill(Color.web("red"));
				} else {
					message.setText("Your password has been confirmed");
					message.setTextFill(Color.web("green"));
				}
				pb.setText("");
			}
		});


	hb.getChildren().addAll(label, pb);
	vb.getChildren().addAll(hb, message);
	hb.getChildren().addAll(Okay);
	hb.getChildren().addAll(Help);


	scene.setRoot(vb);
	stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}