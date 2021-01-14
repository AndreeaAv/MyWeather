package ro.mta.se.lab;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.crypto.dsig.SignatureMethod;

public class Vreme {
    StringProperty country;
    StringProperty city;
    StringProperty wind;
    StringProperty description;

    IntegerProperty temp;
    IntegerProperty feelsLike;
    IntegerProperty humidity;

    public Vreme(String country,String city, String wind, String description, int temp, int feelsLike, int humidity){
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.wind = new SimpleStringProperty(wind);
        this.description = new SimpleStringProperty(description);
        this.temp = new SimpleIntegerProperty(temp);
        this.feelsLike = new SimpleIntegerProperty(feelsLike);
        this.humidity = new SimpleIntegerProperty(humidity);
    }

    public String getCountry(){
        return country.get();
    }

    public StringProperty countryProperty(){
        return country;
    }

    public void setCountry(String country){
        this.country.set(country);
    }

    public String getCity(){
        return city.get();
    }

    public StringProperty cityyProperty(){
        return city;
    }

    public void setCity(String city){
        this.city.set(city);
    }

    public String getWind(){
        return wind.get();
    }

    public StringProperty windProperty(){
        return wind;
    }

    public void setWind(String wind){
        this.wind.set(wind);
    }

    public String getDescription(){
        return description.get();
    }

    public StringProperty descriptionProperty(){
        return description;
    }

    public void setDescription(String description){
        this.description.set(description);
    }

    public int getTemp(){
        return temp.get();
    }

    public IntegerProperty tempProperty(){
        return temp;
    }

    public void setTemp(int temp){
        this.temp.set(temp);
    }

    public int getFeelsLike(){
        return feelsLike.get();
    }

    public IntegerProperty feelsLikeProperty(){
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike){
        this.feelsLike.set(feelsLike);
    }

    public int getHumidity(){
        return humidity.get();
    }

    public IntegerProperty humidityProperty(){
        return humidity;
    }

    public void setHumidity(int humidity){
        this.humidity.set(humidity);
    }

}
