package examples.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExecSQL {
    public static void showResultSet(ResultSet result) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i < columnCount; i++) {
            if (i > 1) {
                System.out.print(", ");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();
        while (result.next()) {
            for (int i = 1; i < columnCount; i++) {
                if (i > 1) {
                    System.out.print(", ");
                }
                System.out.print(result.getString(i));
            }
            System.out.println();
        }
    }
}
