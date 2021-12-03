module MyTelephoneBook {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.bilgeadam.boost.java.course01.lesson064 to javafx.graphics, javafx.fxml;
}
