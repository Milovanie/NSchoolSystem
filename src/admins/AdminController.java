package admins;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.DBConnection;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TableView<StudentData> studenttable;

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

	private ObservableList<StudentData> data;

	@Override
	public void initialize(URL urlLocation, ResourceBundle resources) {
		// DBConnection
		this.dbConnection = new DBConnection();
	}

	private String sql = "SELECT * FRUM STUDENTS";
	
	@FXML
	private void loadStudentData(ActionEvent event) throws SQLException {
		try {
			Connection conn = DBConnection.getConnection();
			
			this.data = FXCollections.observableArrayList();
			
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			while (rs.next()) {
				this.data.add(new StudentData(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5)) );
			}
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("here AdminController loadStudentData()  SELECT * FRUM STUDENTS ====> " + e);
			e.printStackTrace();
		}
		//-----	idColumn firstnamecolumn lastnamecolumn emailcolumn dobcolumn-----@FXML-------------
		//-not this class !!!---- ID firstName lastName email- DOB ---- StudentData.java -------------
		
	this.idColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String> ("ID"));
	this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String> ("firstName"));
	this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String> ("lastName"));
	this.emailcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String> ("email"));
	this.dobcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String> ("DOB"));
	
 	this.studenttable.setItems(null);
 	this.studenttable.setItems(this.data);
	
	}
	
	@FXML
	private void addStudent(ActionEvent event) {
		/*from sqlite tables names */
		String sqlInsert = "INSERT INTO students(id, fname, lname, email, DOB)"
				+ "VALUES(?,?,?,?,?)  " ;
		try {
			Connection conn = DBConnection.getConnection();

			PreparedStatement  statement = conn.prepareStatement(sqlInsert);
			
			// -- TextField --@FXML----------
			// firstname lastname email dob
			statement.setString(1,  this.ID.getText());
			statement.setString(2,  this.firstname.getText());
			statement.setString(3,  this.lastname.getText());
			statement.setString(4,  this.email.getText());
			
			// getEditor get text from DatePicker 
			statement.setString(5,  this.dob.getEditor().getText());
			
			statement.execute();
			conn.close();
			
		} catch (Exception e) {
			System.err.println("here AdminController addStudent INSERT   STUDENTS ====> " + e);
			e.printStackTrace();
		}
		
	}
	
	
}
