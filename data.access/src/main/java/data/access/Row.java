package data.access;
import java.sql.*;

public class Row implements DataRow {
	
    private String[] columns;

    public Row(ResultSet resultSet) {
        try {
            int columnCount = resultSet.getMetaData().getColumnCount();
            columns = new String[columnCount];

            for(int i = 0; i < columnCount; i++)
                columns[i] = resultSet.getString(i+1).toString();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public String[] GetColumns() {
        return this.columns;
    }

    public void print() {
        for(String c : GetColumns())
            System.out.print(c + " ");

        System.out.println();
    }
}