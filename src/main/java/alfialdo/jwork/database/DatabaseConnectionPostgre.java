package alfialdo.jwork.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnectionPostgre
{

    public static Connection connection() {
        Connection conn = null;
        final String db_name = "jwork";
        final String db_user = "postgres";
        final String db_password = "postgre";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db_name, db_user, db_password);
            System.out.println("Connected to jwork database!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+ ": " + e.getMessage());
            System.exit(0);
        }

        return conn;
    }
}
