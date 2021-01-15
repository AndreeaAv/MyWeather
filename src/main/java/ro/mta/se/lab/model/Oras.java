package ro.mta.se.lab.model;

public class Oras {
    public String id;
    public String name;
    public String lat;
    public String lon;
    public String countryCode;

    public Oras(String id, String name, String lat, String lon, String countryCode){
        this.id=id;
        this.name=name;
        this.lat=lat;
        this.lon=lon;
        this.countryCode=countryCode;
    }
}
