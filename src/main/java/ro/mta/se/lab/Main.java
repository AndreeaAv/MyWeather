package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.VremeController;
import ro.mta.se.lab.model.Oras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main extends Application{
    private ObservableList<Oras> cityData = FXCollections.observableArrayList();
    private String inputFile="input.txt";

    public static void Main(String[] args){
        launch(args);
    }

    public void initialize(String inputFile){
        String[] tokens = new String[200];

        try{
            File file = new File(inputFile);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                tokens = data.split("[ \t]+");
                cityData.add(new Oras(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }


    }

    public void start(Stage primaryStage){
        initialize(inputFile);
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            loader.setController(new VremeController(cityData));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
