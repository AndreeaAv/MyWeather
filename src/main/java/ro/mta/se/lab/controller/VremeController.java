package ro.mta.se.lab.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import ro.mta.se.lab.model.Oras;
import ro.mta.se.lab.model.Vreme;

import java.util.List;

public class VremeController {
    private ObservableList<Oras> cityData = FXCollections.observableArrayList();;
    private ObservableList<String> countries = FXCollections.observableArrayList();
    private ObservableList<String> cities = FXCollections.observableArrayList();



    @FXML
    private ChoiceBox<String> countryMenu;

    @FXML
    private ChoiceBox<String> cityMenu;


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
                //getInfo(newValue);
                //parse(String Json);
                //showWeather(newValue);
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

    private void showWeather(String city){

    }
}
