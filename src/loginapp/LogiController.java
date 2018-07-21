
package loginapp;

import java.net.URL;
import java.util.ResourceBundle;

import admins.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;

public class LogiController implements Initializable {
	LoginModel loginModel = new LoginModel();

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Label DBStatus;

	@FXML
	private ComboBox<Option> combobox;

	@FXML
	private Button loginButton;
	
	

	@FXML
	private Label loginStatus;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (this.loginModel.isDatebaseConnected()) {
			this.DBStatus.setText("Connected to DB ");
		} else {
			this.DBStatus.setText("Not Connected to DB ");
		}

		this.combobox.setItems(FXCollections.observableArrayList(Option.values()));
	}

	@FXML
	public   void Login(ActionEvent event) {
		try {
	// select..  isLogin(String user, String pass, String opt)		
			if(this.loginModel.isLogin(this.username.getText(),
					this.password.getText(),
					((Option) this.combobox.getValue()).toString())) {
				Stage stage = (Stage) this.loginButton.getScene().getWindow();
				stage.close();
				switch (((Option)this.combobox.getValue()).toString()) {
				case "Admin":
					admiLogin();
					break;
				case "Student":
					studentLogin();
					break;
					
				default:
					break;
				}   
			} else { // if
				 this.loginStatus.setText("Wrong Creditials");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void studentLogin() {
		try {
			Stage userStage = new Stage();
			FXMLLoader loader = new FXMLLoader();

			Pane root = (Pane) loader.load(getClass()
					.getResource("/students/StudentFXML.fxml").openStream());

			StudentsController studentsController = 
					(StudentsController) loader.getController();
			
			  Scene scene = new Scene(root);
			  userStage.setScene(scene);
			  userStage.setTitle("Student Dashboard");
			  userStage.setResizable(false);
			  userStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void admiLogin() {

		try {
			Stage adminStage = new Stage();
			FXMLLoader adminloader = new FXMLLoader();

			Pane adminRoot = (Pane) adminloader.load(getClass()
					.getResource("/admins/AdminFXML.fxml").openStream());

			AdminController adminController = 
					(AdminController) adminloader.getController();
			
			  Scene scene = new Scene(adminRoot);
			  adminStage.setScene(scene);
			  adminStage.setTitle("Admin Dashboard");
			  adminStage.setResizable(false);
			  adminStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
