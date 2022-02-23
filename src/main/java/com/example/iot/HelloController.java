package com.example.iot;

import com.example.iot.dao.IHouseDAO;
import com.example.iot.dao.ISensorDAO;
import com.example.iot.dao.impl.HouseDAO;
import com.example.iot.dao.impl.SensorDAO;
import com.example.iot.model.House;
import com.example.iot.model.Sensor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<String> houses;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label d1;

    @FXML
    private Label d2;

    @FXML
    private Label d3;

    @FXML
    private Label d4;

    @FXML
    private CheckBox led1;

    @FXML
    private CheckBox led2;

    @FXML
    private CheckBox led3;

    @FXML
    private CheckBox led4;

    @FXML
    private CheckBox door1;

    @FXML
    private CheckBox door2;

    @FXML
    private CheckBox door3;

    @FXML
    private CheckBox door4;

    @FXML
    private Button show;

    private ISensorDAO sensorDAO = new SensorDAO();
    private IHouseDAO houseDAO = new HouseDAO();
    private  List<House> listHouses = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listHouses = houseDAO.findAll();
        House house = listHouses.get(0);
        List<String> _typeBikes = listHouses.stream().map(House::getName).collect(Collectors.toList());
        houses.getItems().addAll(_typeBikes);
        houses.getSelectionModel().select(0);

        setInfo(listHouses.get(0).getId());

        show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = houses.getValue();
                Integer id = 0;
                for(House h: listHouses){
                    if(h.getName().equals(name)){
                        id = h.getId();
                    }
                }
                setInfo(id);
            }
        });
    }

    private void setInfo(Integer id){
        List<Sensor> leds = sensorDAO.findByType("LED", id);
        CheckBox led = led1;
        Label l = l1;
        for(int i = 0; i < leds.size() && i < 4; i++){
            l.setText(leds.get(i).getIdServer().toString());
            led.setSelected(false);
        }

        List<Sensor> doors = sensorDAO.findByType("DOOR", id);
        CheckBox door = door1;
        Label d = d1;
        for(int i = 0; i < doors.size() && i < 4; i++){
            d.setText(leds.get(i).getIdServer().toString());
            door.setSelected(false);
        }
    }
}