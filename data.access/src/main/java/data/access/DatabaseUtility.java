package data.access;
import java.sql.*;
import java.util.*;

public class DatabaseUtility implements DatabaseAccessor {

    private Connection connection;

    public DatabaseUtility(Connection connection) {
        this.connection = connection;
    }

    public String[] ExecuteSingleColumn(String sql) {
        DataRow[] rows = Execute(sql);
        String[] column = new String[rows.length];
        
        for(int i = 0; i < rows.length; i++)
            column[i] = rows[i].GetColumns()[0];
        
        return column;
    }

    public String ExecuteSingleCell(String sql) {
        return Execute(sql)[0].GetColumns()[0];
    }

    public DataRow[] Execute(String sql) {
        try {
            // not prepared but works with stored procedures
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<DataRow> result = new ArrayList<>();

            while(resultSet.next())
                result.add(Row.Parse(resultSet));

            return result.toArray(new DataRow[0]);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}