import java.sql.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import data.access.*;

public class JdbcTests {
    private DatabaseAccessor accessor; 

    @BeforeMethod
    public void setup() {
        try {
            String login = "jdbc:mysql://localhost:3306/Sakila";
            accessor = new DatabaseUtility(DriverManager.getConnection(login));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canExecuteSingleColumn() {
        var query = "select city from city order by city desc limit 10";
        accessor.ExecuteSingleColumn(query);
    }
	
    @Test
    public void canExecuteCell() {
        var query = "select max(amount) from payment";
        accessor.ExecuteSingleCell(query).equals("11.99"); // true
    }
	
    @Test
    public void canExecuteView() {
        var query = "select * from film_list where actors like '%bob fawcett%'";
        accessor.Execute(query);
    }

    @Test
    public void canExecuteStoredProcedure() {
        var query = "call film_in_stock " + 
                    "((select film_id from film " +
                      "where title like '%alien center%'), " +
                     "2, @count)";

        accessor.Execute(query);
    }
}
