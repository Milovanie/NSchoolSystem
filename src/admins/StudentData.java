package admins;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {

	/**final but here is setter: <br>this.ID.set(ID), <br> getID and IDProperty */
	private final StringProperty ID;
	/**final but here is setter: <br>this.firstName.set(firstName), <br>getFirstName and firstNameProperty*/
	private final StringProperty firstName;
	/**final but here is setter: <br>this.lastName.set(lastName), <br>getLastName and lastNameProperty*/
	private final StringProperty lastName;
	/**final but here is setter: <br>this.email.set(email), <br>getEmail and emailProperty  */
	private final StringProperty email;
	/**final but here is setter: <br>this.DOB.set(DOB), <br>getDOB and DOBProperty  */
	private final StringProperty DOB;

	public StudentData(String ID, String firstName, 
			String lastName, String email, String DOB) {

		this.ID = new SimpleStringProperty(ID);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
		this.DOB = new SimpleStringProperty(DOB);
	}

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDOB() { 
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }
	
}
