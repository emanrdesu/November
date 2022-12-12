import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.bean.CsvToBeanBuilder;

import javaio.Bass;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSVTests {
    private List<Bass> basses;
    
    @BeforeMethod
    public void setup() throws FileNotFoundException {
        String bassesFile = "../java.io/src/test/resources/basses.csv";
        FileReader bassesReader = new FileReader(bassesFile);
        this.basses = new CsvToBeanBuilder<Bass>(bassesReader)
                           .withType(Bass.class).build().parse();
    }

    private Map<String, String> getBassesHashMap() {
        Map<String, String> result = new HashMap<String, String>();

        for(Bass b : this.basses)
            result.put(b.getMake(), b.getModel());

        return result;
    }

    @Test
    public void canGetMakesandModels() {
        var expected = new HashMap<>(){{
            put("Warwick","Streamer");
            put("Fender","Jazz");
            put("Yamaha","BB500");
        }};

        var actual = getBassesHashMap();

        var errorMessage1 = "Same hashMap keys expected";
        Assert.assertEquals(actual.keySet(), expected.keySet(), errorMessage1);
        
        var errorMessage2 = "Same key,value bass expected";
        for(String key : actual.keySet())
            Assert.assertEquals(actual.get(key), expected.get(key), errorMessage2);
    }

    @Test
    public void canPopulateBass() {
        Bass[] expected = {
           new Bass("Warwick", "Corvette", "5"),
           new Bass("Warwick", "Thumb", "5"),
           new Bass("Warwick", "Streamer", "5"),
           new Bass("Fender", "Precision", "4"),
           new Bass("Fender", "Jazz", "4"),
           new Bass("Yamaha", "BB500", "5")
        };

        Bass[] actual = this.basses.toArray(new Bass[0]);

        Assert.assertEquals(actual.length, expected.length, "Same amount of bass expected");
        for(int i = 0; i < actual.length; i++)
            Assert.assertEquals(actual[i], expected[i], "Same bass expected");
    }
}