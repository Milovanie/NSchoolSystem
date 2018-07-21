package admins;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.DBConnection;
import javafx.beans.Observable;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/** TextField, DatePicker, TableView, TableColumn */
public class AdminController implements Initializable {
	// AdminStyleSheet.css
	// AdminFXML.fxml

	@FXML
	private TextField ID;

	@FXML
	private TextField firstname;

	@FXML
	private TextField lastname;

	@FXML
	private TextField email;

	@FXML
	private DatePicker dob;

	@FXML
	private TableView<StudentData> studentData;

	@FXML
	private TableColumn<StudentData, String> idColumn;

	@FXML
	private TableColumn<StudentData, String> firstnamecolumn;
	//
	@FXML
	private TableColumn<StudentData, String> lastnamecolumn;
	//
	@FXML
	private TableColumn<StudentData, String> emailcolumn;
	//
	@FXML
	private TableColumn<StudentData, String> dobcolumn;

	private DBConnection dbConnection;

	private ObservableListBase<StudentData> data;

	@Override
	public void initialize(URL urlLocation, ResourceBundle resources) {
		// DBConnection
		this.dbConnection = new DBConnection();
	}

	@FXML
	private void loadStudentData(ActionEvent event) {
		try {
			Connection conn = dbConnection.getConnection();

		} catch (SQLException e) {
			System.err.println("here AdminController 67 stroka ====> " + e);
			e.printStackTrace();
		}
	}
}
