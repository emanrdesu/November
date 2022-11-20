package data.access;
import java.sql.*;

public class Row implements DataRow {
	
    private String[] columns;

    public static Row Parse(ResultSet resultSet) {
        try {
            int columnCount = resultSet.getMetaData().getColumnCount();
            String[] columns = new String[columnCount];

            for(int i = 0; i < columnCount; i++)
                columns[i] = resultSet.getString(i+1).toString();
            
            return new Row(columns);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Row(String[] columns) {
        this.columns = columns;
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