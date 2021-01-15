package ro.mta.se.lab.model;

import javafx.beans.property.*;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import org.json.simple.JSONObject;
import javax.xml.crypto.dsig.SignatureMethod;

public class Vreme {
    StringProperty country;
    StringProperty city;
    StringProperty description;
    StringProperty icon;

    FloatProperty wind;
    FloatProperty temp;
    FloatProperty feelsLike;
    IntegerProperty humidity;

    public Vreme(String jsonString){
        JsonObject object = Json.parse(jsonString).asObject();

        JsonArray weather = object.get("weather").asArray();
        for (JsonValue item : weather){
            this.description = new SimpleStringProperty(item.asObject().getString("description","Not found"));
        }

        this.temp = new SimpleFloatProperty(object.get("main").asObject().getFloat("temp",-100));
        this.feelsLike = new SimpleFloatProperty(object.get("main").asObject().getFloat("feels_like",-100));
        this.humidity = new SimpleIntegerProperty(object.get("main").asObject().getInt("humidity",-100));

        this.wind = new SimpleFloatProperty(object.get("wind").asObject().getFloat("speed",-100));

        this.country = new SimpleStringProperty(object.get("sys").asObject().getString("country","Not Found"));
        this.city = new SimpleStringProperty(object.getString("name","Not Found"));

        //System.out.println(this.city.toString() + this.country.toString() + this.temp.toString() + this.feelsLike.toString()+this.humidity.toString()+this.wind.toString());
    }

    public Vreme(String country,String city, float wind, String description, String icon, float temp, float feelsLike, int humidity){
        this.country = new SimpleStringProperty(country);
        this.city = new SimpleStringProperty(city);
        this.wind = new SimpleFloatProperty(wind);
        this.description = new SimpleStringProperty(description);
        this.icon = new SimpleStringProperty(icon);
        this.temp = new SimpleFloatProperty(temp);
        this.feelsLike = new SimpleFloatProperty(feelsLike);
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

    public StringProperty cityProperty(){
        return city;
    }

    public void setCity(String city){
        this.city.set(city);
    }

    public String getIcon(){
        return icon.get();
    }

    public StringProperty iconProperty(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon.set(icon);
    }

    public float getWind(){
        return wind.get();
    }

    public FloatProperty windProperty(){
        return wind;
    }

    public void setWind(float wind){
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

    public float getTemp(){
        return temp.get();
    }

    public FloatProperty tempProperty(){
        return temp;
    }

    public void setTemp(int temp){
        this.temp.set(temp);
    }

    public float getFeelsLike(){
        return feelsLike.get();
    }

    public FloatProperty feelsLikeProperty(){
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
