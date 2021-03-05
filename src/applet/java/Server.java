import java.sql.*;

public class Server {
    //TODO:
    String dbLink = "";
    String dbUser = "";
    String dbPass = "";

    private static Server instance = null;
    private Connection con = null;
    private PreparedStatement queryStmt = null;

    private Server() {};

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public boolean connectToDatabase(String user, String password) throws SQLException, ClassNotFoundException {
        con = DriverManager.getConnection(dbLink, dbUser, dbPass);
//        System.out.println("OK");
        PreparedStatement checkUser = con.prepareStatement("SELECT COUNT(*) FROM User");

        ResultSet rs = checkUser.executeQuery();
//        System.out.println("Query Executed");
        rs.next();
//        System.out.println("Count="+rs.getInt(1));
        return rs.getInt(1) == 1;
    }
}
