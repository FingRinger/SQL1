package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {

    private static QueryRunner runner;
    private static Connection conn;

    @SneakyThrows
    public static void setUp() {
        runner = new QueryRunner();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "user", "pass");
    }

    @SneakyThrows
    public static void resetVerifyCode() {
        setUp();
        String dataSQL = "DELETE FROM auth_codes";
        runner.update(conn, dataSQL);
    }

    @SneakyThrows
    public static String getValidVerifyCode(String login){
        setUp();
        String dataSQL = "SELECT code FROM auth_codes " +
                "JOIN users ON user_id = users.id " +
                "WHERE login = ? " +
                "ORDER BY created DESC LIMIT 1;";
        return runner.query(conn, dataSQL, new ScalarHandler<String>(), login);
    }


}
