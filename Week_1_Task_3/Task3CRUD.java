package Week_1_Task_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task3CRUD {
    public static void main(String[] args) {

        // Base JDBC URL (NO database name here)
        String baseUrl = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "12345678";

        String newDB = "tempdb";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 1. Connect to default postgres database
            conn = DriverManager.getConnection(baseUrl + "postgres", user, password);
            conn.setAutoCommit(true); // REQUIRED for CREATE/DROP DATABASE
            System.out.println("1.] Connected to postgres database.");

            // 2. Create temporary database
            stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + newDB);
            System.out.println("2.] Database '" + newDB + "' created.");

            // Close postgres connection
            stmt.close();
            conn.close();

            // 3. Connect to tempdb
            conn = DriverManager.getConnection(baseUrl + newDB, user, password);
            stmt = conn.createStatement();
            System.out.println("3.] Connected to temporary database '" + newDB + "'.");

            // 4. Create table
            String createTable =
                    "CREATE TABLE faculty (" +
                            "faculty_id SERIAL PRIMARY KEY, " +
                            "faculty_name VARCHAR(50), " +
                            "dept_name VARCHAR(100))";

            stmt.executeUpdate(createTable);
            System.out.println("4.] Table 'faculty' created.");

            // 5. Insert data
            stmt.executeUpdate("INSERT INTO faculty (faculty_name, dept_name) VALUES ('araf khan', 'Computer Science')");
            stmt.executeUpdate("INSERT INTO faculty (faculty_name, dept_name) VALUES (' tofiq Shaikh', 'Commerce')");
            stmt.executeUpdate("INSERT INTO faculty (faculty_name, dept_name) VALUES ('zaid shaikh', 'Mathematics')");
            System.out.println("5.] Sample data inserted.");

            // 6. Display data
            rs = stmt.executeQuery("SELECT * FROM faculty");

            System.out.println("------------------------------------");
            System.out.println("faculty_id | faculty_name | dept_name");
            System.out.println("------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("faculty_id") + " | " +
                                rs.getString("faculty_name") + " | " +
                                rs.getString("dept_name")
                );
            }

            System.out.println("------------------------------------");

            // 7. Drop table
            stmt.executeUpdate("DROP TABLE faculty");
            System.out.println("6.] Table 'faculty' deleted.");

            // Close tempdb connection
            rs.close();
            stmt.close();
            conn.close();

            // 8. Reconnect to postgres and drop database
            conn = DriverManager.getConnection(baseUrl + "postgres", user, password);
            conn.setAutoCommit(true);
            stmt = conn.createStatement();
            stmt.executeUpdate("DROP DATABASE " + newDB);
            System.out.println("7.] Database '" + newDB + "' deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}

            System.out.println("8.] All JDBC objects closed.");
        }
    }
}
