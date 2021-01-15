package ro.mta.se.lab.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ro.mta.se.lab.model.Oras;
import ro.mta.se.lab.model.Vreme;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VremeController {
    private ObservableList<Oras> cityData = FXCollections.observableArrayList();;
    private ObservableList<String> countries = FXCollections.observableArrayList();
    private ObservableList<String> cities = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> countryMenu;

    @FXML
    private ChoiceBox<String> cityMenu;

    @FXML
    private Label cityNameLabel;

    @FXML
    private Label countryNameLabel;

    @FXML
    private Label windLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label tempLabel;

    @FXML
    private Label feelsLikeLabel;

    @FXML
    private ImageView weatherImage;


    public VremeController(ObservableList<Oras> cityData){
        this.cityData = cityData;
    }

    @FXML
    private void initialize(){
        for (int i=0;i<cityData.size();i++){
            if (!countries.contains(cityData.get(i).countryCode))
                countries.add(cityData.get(i).countryCode);
        }
        countryMenu.setItems(countries);
        countryMenu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showCities(newValue);
            }
        });

        cityMenu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                String info = getInfo(newValue);
                Vreme thisVreme = new Vreme(info);
                showWeather(thisVreme);
            }
        });

    }

    private void showCities(String country){
        cities.removeAll(cities);
        for (int i=0;i<cityData.size();i++){
            if (cityData.get(i).countryCode.equals(country)){
                cities.add(cityData.get(i).name);
            }
        }
        cityMenu.setItems(cities);
    }

    String getInfo(String city){
        String apiAdress = "http://api.openweathermap.org/data/2.5/weather";
        String apiKey = "appid=863662843e9644cbb800ddf54f90ae4e";

        StringBuilder content = new StringBuilder();
        String requestString = apiAdress + "?q=" + city + "&" + apiKey;

        try{
            URL url = new URL(requestString);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }

            in.close();
            con.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }

    private void showWeather(Vreme thisVreme){
        cityNameLabel.setText(thisVreme.getCity());
        countryNameLabel.setText(thisVreme.getCountry());
        windLabel.setText(String.valueOf(thisVreme.getWind()));
        descriptionLabel.setText(thisVreme.getDescription());
        tempLabel.setText(String.valueOf(thisVreme.getTemp()));
        feelsLikeLabel.setText(String.valueOf(thisVreme.getFeelsLike()));

        if (thisVreme.getDescription().contains("sky") || thisVreme.getDescription().contains("sun"))
            weatherImage.setImage(new Image(getClass().getResourceAsStream("/images/sun.jpg")));
        if (thisVreme.getDescription().contains("clouds"))
            weatherImage.setImage(new Image(getClass().getResourceAsStream("/images/clouds.jpg")));
        if (thisVreme.getDescription().contains("rain"))
            weatherImage.setImage(new Image(getClass().getResourceAsStream("/images/rain.jpg")));
        if (thisVreme.getDescription().contains("snow"))
            weatherImage.setImage(new Image(getClass().getResourceAsStream("/images/snow.jpg")));
    }

    }
}
