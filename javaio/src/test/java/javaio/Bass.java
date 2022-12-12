package javaio;

import com.opencsv.bean.CsvBindByName;

public class Bass {

    @CsvBindByName
    private String Make;

    @CsvBindByName
    private String Model;

    @CsvBindByName
    private String StringCount;

    public Bass(String Make, String Model, String Count) {
        this.Make = Make;
        this.Model = Model;
        this.StringCount = Count;
    }

    public String getMake() {
        return this.Make;
    }

    public String getModel() {
        return this.Model;
    }

    public String getStringCount() {
        return this.StringCount;
    }
}