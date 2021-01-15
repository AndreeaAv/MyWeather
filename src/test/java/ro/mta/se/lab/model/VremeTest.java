package ro.mta.se.lab.model;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import static org.junit.Assert.*;

public class VremeTest {

    @org.junit.Test
    public void parse() {
        String str = "{\"coord\":{\"lon\":-2.7946,\"lat\":48.4914},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":276.88,\"feels_like\":273.57,\"temp_min\":276.48,\"temp_max\":277.15,\"pressure\":1029,\"humidity\":81},\"visibility\":10000,\"wind\":{\"speed\":2.06,\"deg\":140},\"clouds\":{\"all\":0},\"dt\":1610742604,\"sys\":{\"type\":1,\"id\":6562,\"country\":\"FR\",\"sunrise\":1610697467,\"sunset\":1610728983},\"timezone\":3600,\"id\":2986678,\"name\":\"Ploufragan\",\"cod\":200}";
        JsonObject object = Json.parse(str).asObject();
        Vreme vreme1 = new Vreme(str);
        Vreme vreme2 = new Vreme("FR","Ploufragan",2.06f,"clear sky","01n",276.88f,273.57f,81);
        /*System.out.println(vreme1.country.toString()+vreme1.city.toString()+vreme1.wind.toString()+vreme1.description.toString()
            +vreme1.temp.toString()+vreme1.feelsLike.toString()+vreme1.humidity.toString());
        System.out.println(vreme2.country.toString()+vreme2.city.toString()+vreme2.wind.toString()+vreme2.description.toString()
                +vreme2.temp.toString()+vreme2.feelsLike.toString()+vreme2.humidity.toString());
         */
        assertTrue(Vreme.equals(vreme1,vreme2));
    }
}