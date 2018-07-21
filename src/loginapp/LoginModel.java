package loginapp;

import dbUtil.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;

    public LoginModel() {
        try {

            this.connection = DBConnection.getConnection();
            System.out.println(" connection OK ");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (this.connection == null) {
            System.out.println("No connection , exit");
            System.exit(1);
        }
    }

    public boolean isDatebaseConnected() {
        return this.connection != null;
    }

    public boolean isLogin(String user, String pass, String opt) throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;

 
		String sql = " SELECT * FROM  login where username = ? and password = ? and division = ?";

        try {

            System.out.println("  ");
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            pr.setString(3, opt);

            rs = pr.executeQuery();

            boolean boll;
            if(rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            rs.close();
            pr.close();

        }

    }

}
