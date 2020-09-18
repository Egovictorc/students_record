package model;

import java.sql.*;

public class DBClass {
    private final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/school?serverTimezone=UTC",
    SERVERNAME = "root",
    PASSWORD = "root";

    Connection conn;

    public void createConnection() {
    try {
        conn = DriverManager.getConnection(CONNECTION_STRING, SERVERNAME, PASSWORD);
    } catch (SQLException e) {
        System.out.println("error connection to database: "+ e.getMessage());
    }
    }

    public ResultSet queryDB() throws SQLException {
        Statement stmt = conn.createStatement();
        String sqlSelect = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(sqlSelect);

        return rs;
    }
}
