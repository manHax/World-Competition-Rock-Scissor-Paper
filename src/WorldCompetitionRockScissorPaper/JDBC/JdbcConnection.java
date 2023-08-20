package WorldCompetitionRockScissorPaper.JDBC;

import WorldCompetitionRockScissorPaper.Constants;
import WorldCompetitionRockScissorPaper.Match;
import WorldCompetitionRockScissorPaper.Nation;

import java.sql.*;

public class JdbcConnection {
    public Connection conn;
    public String nationsTable = "WKSP_BISMILLAH.NATIONS";
    public String matchesTable = "WKSP_BISMILLAH.MATCHES";
    String NATION_NAME = "NATION_NAME", POINT_GROUP = "POINT_GROUP", PLAY_GROUP = "PLAY_GROUP", WINS_GROUP = "WINS_GROUP",
            DRAWS_GROUP = "DRAWS_GROUP", LOSES_GROUP = "LOSES_GROUP", WINS_SCORE = "WINS_SCORE", KNOCK_OUT_AT = "KNOCK_OUT_AT", ID = "ID", NATION_GROUP = "NATION_GROUP";
    String MATCH_NAME = "MATCH_NAME", PLAYER_1 = "PLAYER_1", PLAYER_2 = "PLAYER_2", MATCH_DATE = "MATCH_DATE", WINNER = "WINNER", SCORE_PLAYER_1 = "SCORE_PLAYER_1", SCORE_PLAYER_2 = "SCORE_PLAYER_2";


    public void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection(Constants.jdbcUrl, Constants.usernameDB, Constants.passwordDB);
        this.conn = connection;
    }

    public String generateQueryInsert(String tableName, String[] columns, Object[] values) {
//        "INSERT INTO customers (name, email) VALUES (?, ?)";
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableName).append(" (");
        for (String c : columns) {
            sb.append(c).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(") VALUES (");
        for (Object v : values) {
            if (v.getClass().getSimpleName().equalsIgnoreCase("Date")) {
                sb.append("?").append("',");
                continue;
            }
            sb.append("'").append(v).append("', ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(")");
        System.out.println(sb);
        return sb.toString();
    }

    public String generateQueryUpdate(String tableName, String[] columns, Object[] values) {
        StringBuilder sb = new StringBuilder();
        //UPDATE NATIONS SET nation_name = ? WHERE id = ?
        sb.append("UPDATE ").append(tableName).append(" SET ");
        for (int i = 1; i < columns.length; i++) {
            sb.append(columns[i]).append(" = '").append(values[i]).append("', ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(" WHERE NATION_NAME = '")
                .append(values[0]).append("'");
        System.out.println(sb);
        return sb.toString();
    }

    public void truncate(String tableName) throws SQLException, ClassNotFoundException {
        getConnection();
        String sql = "TRUNCATE TABLE " + tableName;
        PreparedStatement truncate = conn.prepareStatement(sql);
        truncate.execute();
        conn.close();
    }

    public void insertNations(String nationName) throws SQLException, ClassNotFoundException {
        getConnection();
        String[] columns = {NATION_NAME, POINT_GROUP, PLAY_GROUP, DRAWS_GROUP, LOSES_GROUP, WINS_GROUP, WINS_SCORE};
        String[] values = {nationName, "0", "0", "0", "0", "0", "0"};
        String sql = generateQueryInsert(nationsTable, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
        conn.close();
    }

    public void updateNations(Nation nation)
            throws SQLException, ClassNotFoundException {
        getConnection();
        String[] columns = {NATION_NAME, POINT_GROUP, PLAY_GROUP, DRAWS_GROUP, LOSES_GROUP, WINS_GROUP, WINS_SCORE};
        String[] values = {nation.getName(), String.valueOf(nation.getPointGroup()), String.valueOf(nation.getPlayGroup()), String.valueOf(nation.getDrawsGroup()), String.valueOf(nation.getLosesGroup()), String.valueOf(nation.getWinsGroup()), String.valueOf(nation.getWinsScore())};
        String sql = generateQueryUpdate(nationsTable, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
        conn.close();
    }

    public void setNationAsKnockout(Nation nation, String knockedOutAt) throws SQLException, ClassNotFoundException {
        getConnection();
        String[] columns = {NATION_NAME, KNOCK_OUT_AT};
        String[] values = {nation.getName(), knockedOutAt};
        String sql = generateQueryUpdate(nationsTable, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
        conn.close();
    }

    public void setNationGroup(Nation nation, String group) throws SQLException, ClassNotFoundException {
        getConnection();
        String[] columns = {NATION_NAME, NATION_GROUP};
        String[] values = {nation.getName(), group};
        String sql = generateQueryUpdate(nationsTable, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
        conn.close();
    }

    public void setResultMatch(String matchName, String winner, int score_p1, int score_p2) throws SQLException, ClassNotFoundException {
        getConnection();
        String[] columns = {MATCH_NAME, WINNER, SCORE_PLAYER_1, SCORE_PLAYER_2};
        String[] values = {matchName,winner, String.valueOf(score_p1), String.valueOf(score_p2)};
        String sql = generateQueryUpdate(matchesTable, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
        conn.close();
    }

    /*
    select MATCH_NAME,
           PLAYER_1,
           PLAYER_2,
           MATCH_DATE
    from "MATCHES" a
    */
    public void insertMatch(String player1, String player2, String matchName, Date matchDate) throws SQLException, ClassNotFoundException {
        getConnection();
        String[] columns = {MATCH_NAME, PLAYER_1, PLAYER_2, MATCH_DATE};
        Object[] values = {matchName, player1, player2, matchDate};
        String sql = generateQueryInsert(matchesTable, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.setDate(1, matchDate);
        insert.execute();
        conn.close();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String[] a = {"a", "b"};
//        System.out.println(new JdbcConnection().generateQueryUpdate("A",a,a));
//        new JdbcConnection().insertNations("Indonesia");
//        Object a = new Date(System.currentTimeMillis());
//        System.out.println(a.getClass().getSimpleName());
//        new JdbcConnection().truncate(new JdbcConnection().matchesTable);
//
//        try {
//            // Load the Oracle JDBC driver
//            Class.forName("oracle.jdbc.OracleDriver");
//            // Create a connection
//            Connection connection = DriverManager.getConnection(Constants.jdbcUrl, Constants.usernameDB, Constants.passwordDB);
//
//            // SELECT query example
//            String selectQuery = "SELECT * FROM WKSP_BISMILLAH.NATIONS";
//            PreparedStatement selectStatement = new JdbcConnection().conn.prepareStatement(selectQuery);
//            ResultSet resultSet = selectStatement.executeQuery();
//            while (resultSet.next()) {
//                // Retrieve data from result set
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("nation_name");
//                System.out.println(name);
//                // ... process data as needed
//            }
//            resultSet.close();
//            selectStatement.close();
//
//            // UPDATE query example
//            String updateQuery = "UPDATE NATIONS SET nation_name = ? WHERE id = ?";
//            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
//            updateStatement.setString(1, "New Name");
//            updateStatement.setInt(2, 1); // ID to update
//            int rowsUpdated = updateStatement.executeUpdate();
//            System.out.println(rowsUpdated + " row(s) updated.");
//            updateStatement.close();
//
//            // DELETE query example
////            String deleteQuery = "DELETE FROM your_table WHERE id = ?";
////            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
////            deleteStatement.setInt(1, 456); // ID to delete
////            int rowsDeleted = deleteStatement.executeUpdate();
////            System.out.println(rowsDeleted + " row(s) deleted.");
////            deleteStatement.close();
//
//            // Close the connection
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
