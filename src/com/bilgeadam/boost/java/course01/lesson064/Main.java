package com.bilgeadam.boost.java.course01.lesson064;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage      primary;
	private BorderPane rootPane;

	@Override
	public void start(Stage primaryStage) {
		initPrimaryStage(primaryStage);
		initRootLayout();
		showPersonOverview();
	}

	private void initPrimaryStage(Stage primaryStage) {
		this.primary = primaryStage;
		this.primary.getIcons().add(new Image(getClass().getResourceAsStream("resources/TelephoneBook.png")));
		this.primary.setTitle("Benim Güzel Telefon Rehberim");
	}

	private void showPersonOverview() {
		// TODO Auto-generated method stub
		
	}

	private void initRootLayout() {
		try {
			this.rootPane  = (BorderPane) FXMLLoader.load(getClass().getResource("view/TelephoneBook.fxml"));
			Scene      scene = new Scene(this.rootPane, 400, 400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			this.primary.setScene(scene);
//			primaryStage.initStyle(StageStyle.UNDECORATED);
			this.primary.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
