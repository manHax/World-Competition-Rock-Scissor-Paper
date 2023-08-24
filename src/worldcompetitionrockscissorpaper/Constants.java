package worldcompetitionrockscissorpaper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.Configuration;

public class Constants {
    private Constants() {

    }

    private static void readJdbcProp() {
        Configuration config ;

        String fileName="C:\\Users\\lhaki\\IdeaProjects\\FGA\\src\\worldcompetitionrockscissorpaper\\jdbc.properties";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\?");
                if (parts.length == 2) {
                    if (line.startsWith("JDBC_URL")) {
                        jdbcUrl = parts[1];
                    } else if (line.startsWith("USERNAME_DB")) {
                        usernameDB = parts[1];
                    } else if (line.startsWith("PASSWORD_DB")) {
                        passwordDb = parts[1];
                    }
                }
            }
            if (passwordDb == null || usernameDB == null || jdbcUrl == null) throw new LoadJdbcErrorException();
        } catch (IOException | LoadJdbcErrorException e) {
            e.printStackTrace();
        }
    }

    private static String jdbcUrl;
    private static String usernameDB;
    private static String passwordDb;


    public static String getJdbcUrl() {
        if (jdbcUrl == null) readJdbcProp();
        return jdbcUrl;
    }

    public static String getUsernameDB() {
        if (usernameDB == null) readJdbcProp();
        return usernameDB;
    }

    public static String getPasswordDb() {
        if (passwordDb == null) readJdbcProp();
        return passwordDb;
    }

}
