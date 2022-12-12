package javaio;

import com.opencsv.bean.CsvBindByName;

public class Bass {

    @CsvBindByName
    private String Make;

    @CsvBindByName
    private String Model;

    @CsvBindByName
    private String StringCount;

    public Bass() { super(); }

    public Bass(String Make, String Model, String Count) {
        this.Make = Make;
        this.Model = Model;
        this.StringCount = Count;
    }

    @Override
    public boolean equals(Object bass) {
        if (bass instanceof Bass)
            return this.equals((Bass) bass);
        else
            return super.equals(bass);
    }

    public boolean equals(Bass bass) {
        return getMake().equals(bass.getMake()) &&
               getModel().equals(bass.getModel()) &&
               getStringCount().equals(bass.getStringCount());
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