package sg.edu.nus.iss.vttp5_day19l.model;

public class Weather {
    
    private String country;
    private String region;
    private Double latitude; // when to use double?
    private Double longitude;
    private Double pm25;
    private Double co;
    
    public Weather() {
    }

    public Weather(String country, String region, Double latitude, Double longitude, Double pm25, Double co) {
        this.country = country;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pm25 = pm25;
        this.co = co;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    @Override
    public String toString() {
        return country + "," + region + "," + latitude + ","
                + longitude + "," + pm25 + "," + co;
    }

    
    
    
}
