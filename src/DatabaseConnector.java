import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseConnector {
    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();
        connector.selectAll();

    }

    public Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/DatabaseHomework.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.connect();
            String sql = "SELECT * FROM Books";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("BookID") + "\t" +
                        rs.getString("Title") + "\t" +
                        rs.getString("Author"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection to SQLite has been closed. This confirms it!!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}






//    public static void connect() {
//        Connection conn = null;
//        try {
//            // db parameters
//            String url = "jdbc:sqlite:C:/sqlite/db/DatabaseHomework.db";
//            // create a connection to the database
//            conn = DriverManager.getConnection(url);
//
//            System.out.println("Connection to SQLite has been established.");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
//
//
//
//
//    public static void executeSelectQuery() {
//        String url = "jdbc:sqlite:C:/sqlite/db/DatabaseHomework.db";
//        String query = "SELECT * FROM User";
//
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            // Process the result set
//            while (rs.next()) {
//                // Retrieve data from the result set
//                int column1Value = rs.getInt("UserID");
//                String column2Value = rs.getString("FirstName");
//
//                // Do something with the retrieved data
//                System.out.println("Column 1: " + column1Value);
//                System.out.println("Column 2: " + column2Value);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    public Connection connect() {
//        // SQLite connection string
//        String url = "jdbc:sqlite:C:/sqlite/db/DatabaseHomework.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }



// before no connection assignment part
//    public void selectAll(){
//        String sql = "SELECT * FROM User";
//
//        try {
//            Connection conn = this.connect();
//            Statement stmt  = conn.createStatement();
//            ResultSet rs    = stmt.executeQuery(sql);
//
//            // loop through the result set
//            while (rs.next()) {
//                System.out.println(rs.getInt("UserID") +  "\t" +
//                        rs.getString("FirstName") + "\t" +
//                        rs.getString("LastName"));
//
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
