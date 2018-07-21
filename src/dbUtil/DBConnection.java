package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class DBConnection {
//  private static final String SQURL = "jdbc:sqlite:school.sqlite";  // doesn't work only with full path

//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "sveta";
//    private static final String URL = "jdbc:mysql://localhost:3306/crud"; TheSchool


	// NSchoolSystem.db
    
//	private static final String  patha = "D:/HereAllWorkspaces/FromIntelliJ/GitProjects/school/src/school.sqlite";
	private static final String  patha = "NSchoolSystem.db";
	private static final String  pathSqlite = "jdbc:sqlite:" + patha;
    

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("driver Ok ");
//            return DriverManager.getConnection(SQURL);
            return DriverManager.getConnection(pathSqlite);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
