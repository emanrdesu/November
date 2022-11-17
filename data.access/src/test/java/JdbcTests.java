import java.sql.*;
import data.access.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

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
        
        String[] actual = accessor.ExecuteSingleColumn(query);
        
        String[] expected = {
                "Ziguinchor",
                "Zhoushan",
                "Zhezqazghan",
                "Zeleznogorsk",
                "Zaria",
                "Zapopan",
                "Zaoyang",
                "Zanzibar",
                "Zalantun",
                "Yuzhou"
        };
        
        String errorMessage = "City should be returned.";
        
        for (int i = 0; i < actual.length; i++)
            Assert.assertEquals(actual[i], expected[i], errorMessage);
    }
	
    @Test
    public void canExecuteCell() {
        var query = "select max(amount) from payment";
        var actual = accessor.ExecuteSingleCell(query); 
        var expected = "11.99";
        var errorMessage = "Number should be returned.";
        Assert.assertEquals(actual, expected, errorMessage);
    }
	
    @Test
    public void canExecuteView() {
        var query = "select title from film_list where actors like '%bob fawcett%'";
        
        DataRow[] actual = accessor.Execute(query);
        
        String[] expected = {
                "ACE GOLDFINGER",
                "ADAPTATION HOLES",
                "CHINATOWN GLADIATOR",
                "CIRCUS YOUTH",
                "CONTROL ANTHEM",
                "DARES PLUTO",
                "DARN FORRESTER",
                "DAZED PUNK",
                "DYNAMITE TARZAN",
                "HATE HANDICAP",
                "HOMICIDE PEACH",
                "JACKET FRISCO",
                "JUMANJI BLADE",
                "LAWLESS VISION",
                "LEATHERNECKS DWARFS",
                "OSCAR GOLD",
                "PELICAN COMFORTS",
                "PERSONAL LADYBUGS",
                "RAGING AIRPLANE",
                "RUN PACIFIC",
                "RUNNER MADIGAN",
                "SADDLE ANTITRUST",
                "SCORPION APOLLO",
                "SHAWSHANK BUBBLE",
                "TAXI KICK"
        };

        var errorMessage = "Title should be returned.";
        
        for (int i = 0; i < actual.length; i++)
            Assert.assertEquals(actual[i].GetColumns()[0], expected[i], errorMessage);
    }

    @Test
    public void canExecuteStoredProcedure() {
        var query = "call film_in_stock " + 
                    "((select film_id from film " +
                      "where title like '%alien center%'), " +
                     "2, @count)";
        
        var actual = accessor.ExecuteSingleColumn(query);
        String[] expected = { "73", "74", "75", "76" };
        var errorMessage = "Inventory ID should be returned.";
        
        for (int i = 0; i < actual.length; i++)
            Assert.assertEquals(actual[i], expected[i], errorMessage);        
    }
}