package com.bilgeadam.boost.java.course01.lesson064.view;

import com.bilgeadam.boost.java.course01.lesson064.Main;
import com.bilgeadam.boost.java.course01.lesson064.model.Person;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {

	private Main main;	// all data kept in main application

	@FXML
	private TableView<Person>           tblPerson;
	@FXML
	private TableColumn<Person, String> colFirstName;
	@FXML
	private TableColumn<Person, String> colLastName;

	public PersonOverviewController() {
		super();
	}

	@FXML
	private void initialize() {
		colFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
		colLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
	}
	
	public void setMain(Main main) {
		this.main = main;
		tblPerson.setItems(main.getPeople());
	}
}
