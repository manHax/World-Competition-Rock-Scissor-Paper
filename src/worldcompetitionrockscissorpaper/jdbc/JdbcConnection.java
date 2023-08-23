package worldcompetitionrockscissorpaper.jdbc;

import worldcompetitionrockscissorpaper.Constants;
import worldcompetitionrockscissorpaper.Nation;

import java.sql.*;

public class JdbcConnection {
    public static Connection conn;
    public static final String NATION_TABLE = "WKSP_BISMILLAH.NATIONS";
    public static final String MATCHES_TABLE = "WKSP_BISMILLAH.MATCHES";
    public static final String NATION_NAME = "NATION_NAME";
    public static final String POINT_GROUP = "POINT_GROUP";
    public static final String PLAY_GROUP = "PLAY_GROUP";
    public static final String WINS_GROUP = "WINS_GROUP";
    public static final String DRAWS_GROUP = "DRAWS_GROUP";
    public static final String LOSES_GROUP = "LOSES_GROUP";
    public static final String WINS_SCORE = "WINS_SCORE";
    public static final String KNOCK_OUT_AT = "KNOCK_OUT_AT";
    public static final String ID = "ID";
    public static final String NATION_GROUP = "NATION_GROUP";
    public static final String MATCH_NAME = "MATCH_NAME";
    public static final String PLAYER_1 = "PLAYER_1";
    public static final String PLAYER_2 = "PLAYER_2";
    public static final String MATCH_DATE = "MATCH_DATE";
    public static final String WINNER = "WINNER";
    public static final String SCORE_PLAYER_1 = "SCORE_PLAYER_1";
    public static final String SCORE_PLAYER_2 = "SCORE_PLAYER_2";
    
    public JdbcConnection(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            this.conn = DriverManager.getConnection(Constants.JDBC_URL, Constants.USERNAME_DB, Constants.PASSWORD_DB);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateQueryInsert(String tableName, String[] columns, Object[] values) {
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

    private static String generateQueryUpdate(String tableName, String[] columns, Object[] values) {
        StringBuilder sb = new StringBuilder();
        //UPDATE NATIONS SET nation_name = ? WHERE id = ?
        sb.append("UPDATE ").append(tableName).append(" SET ");
        for (int i = 1; i < columns.length; i++) {
            sb.append(columns[i]).append(" = '").append(values[i]).append("', ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(" WHERE ").append(columns[0]).append(" = '")
                .append(values[0]).append("'");
        System.out.println(sb);
        return sb.toString();
    }

    public static void truncate(String tableName) throws SQLException {
        String sql = "TRUNCATE TABLE " + tableName;
        PreparedStatement truncate = conn.prepareStatement(sql);
        truncate.execute();
    }

    public static void insertNations(String nationName) throws SQLException {
        String[] columns = {NATION_NAME, POINT_GROUP, PLAY_GROUP, DRAWS_GROUP, LOSES_GROUP, WINS_GROUP, WINS_SCORE};
        String[] values = {nationName, "0", "0", "0", "0", "0", "0"};
        String sql = generateQueryInsert(NATION_TABLE, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
    }

    public static void updateNations(Nation nation)
            throws SQLException {
        String[] columns = {NATION_NAME, POINT_GROUP, PLAY_GROUP, DRAWS_GROUP, LOSES_GROUP, WINS_GROUP, WINS_SCORE};
        String[] values = {nation.getName(), String.valueOf(nation.getPointGroup()), String.valueOf(nation.getPlayGroup()), String.valueOf(nation.getDrawsGroup()), String.valueOf(nation.getLosesGroup()), String.valueOf(nation.getWinsGroup()), String.valueOf(nation.getWinsScore())};
        String sql = generateQueryUpdate(NATION_TABLE, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
    }

    public static void setNationAsKnockout(Nation nation, String knockedOutAt) throws SQLException {
        String[] columns = {NATION_NAME, KNOCK_OUT_AT};
        String[] values = {nation.getName(), knockedOutAt};
        String sql = generateQueryUpdate(NATION_TABLE, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
    }

    public static void setNationGroup(Nation nation, String group) throws SQLException {
        String[] columns = {NATION_NAME, NATION_GROUP};
        String[] values = {nation.getName(), group};
        String sql = generateQueryUpdate(NATION_TABLE, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
    }

    public static void setResultMatch(String matchName, String winner, int scoreP1, int scoreP2) throws SQLException {
        String[] columns = {MATCH_NAME, WINNER, SCORE_PLAYER_1, SCORE_PLAYER_2};
        String[] values = {matchName, winner, String.valueOf(scoreP1), String.valueOf(scoreP2)};
        String sql = generateQueryUpdate(MATCHES_TABLE, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.execute();
    }
    public static void insertMatch(String player1, String player2, String matchName, Date matchDate) throws SQLException {
        String[] columns = {MATCH_NAME, PLAYER_1, PLAYER_2, MATCH_DATE};
        Object[] values = {matchName, player1, player2, matchDate};
        String sql = generateQueryInsert(MATCHES_TABLE, columns, values);
        PreparedStatement insert = conn.prepareStatement(sql);
        insert.setDate(1, matchDate);
        insert.execute();
    }

}
