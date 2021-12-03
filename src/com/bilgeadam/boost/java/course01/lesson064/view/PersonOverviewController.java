package com.bilgeadam.boost.java.course01.lesson064.view;

import java.util.Optional;

import javax.security.auth.callback.ConfirmationCallback;

import com.bilgeadam.boost.java.course01.lesson064.Main;
import com.bilgeadam.boost.java.course01.lesson064.model.Person;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class PersonOverviewController {

	private Main main; // all data kept in main application

	@FXML
	private TableView<Person>           tblPerson;
	@FXML
	private TableColumn<Person, String> colFirstName;
	@FXML
	private TableColumn<Person, String> colLastName;

	@FXML
	private Label lblFirstName;
	@FXML
	private Label lblLastName;
	@FXML
	private Label lblTelephone;
	@FXML
	private Label lblCity;
	@FXML
	private Label lblStreet;
	@FXML
	private Label lblZIP;
	@FXML
	private Label lblBirthday;

	public PersonOverviewController() {
		super();
	}

	@FXML
	private void initialize() {
		colFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty()); // ki�i listesini
		colLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty()); // y�kle ve haz�rla

		showPersonDetails(null); // ayr�nt�l� bilgileri s�f�rla

		/*
		 * Alternatif olarak �nce br change listener yarat�l�p addListener metoduna
		 * eklenebilir lambda expression kullanmak �stemeyenlere �iddetle �nerilir
		 */
		ChangeListener<Person> kjkj = new ChangeListener<Person>() {
			@Override
			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				showPersonDetails(newValue);
			}
		};

		// se�ili sat�r�n �zelliklerine bir changeListener ekliyor.
		tblPerson.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	public void setMain(Main main) {
		this.main = main;
		tblPerson.setItems(main.getPeople());
	}

	private void showPersonDetails(Person person) {
		if (person == null) {
			lblFirstName.setText("");
			lblLastName.setText("");
			lblTelephone.setText("");
			lblStreet.setText("");
			lblCity.setText("");
			lblZIP.setText("");
			lblBirthday.setText("");
		}
		else {
			lblFirstName.setText(person.getFirstName());
			lblLastName.setText(person.getLastName());
			lblTelephone.setText(person.getTelephone());
			lblStreet.setText(person.getStreet());
			lblCity.setText(person.getCity());
			lblZIP.setText("" + person.getZip());
			lblBirthday.setText(person.getFormattedDate(person.getBirthday()));
		}
	}

	@FXML
	private void delete() {
		int selected = tblPerson.getSelectionModel().getSelectedIndex(); // tabloda hangi sat�r�n se�ili oldu�unu
																			// s�yl�yor
		if (selected >= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initOwner(this.main.getPrimary());

			Optional<ButtonType> type = alert.showAndWait();
			if (type.get().getText().equalsIgnoreCase("OK"))
				tblPerson.getItems().remove(selected); // aktif olan sat�r� listeden siliyor
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(this.main.getPrimary());
			alert.setTitle("D�KKAT");
			alert.setHeaderText("Ki�i se�ili de�il!");
			alert.setContentText("L�tfen bir ki�i se�iniz");
			alert.show();
		}
	}
}
