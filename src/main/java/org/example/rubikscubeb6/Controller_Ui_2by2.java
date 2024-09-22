package org.example.rubikscubeb6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.cubeLogical.cubes.Controller_Cube_2by2;
import org.example.cubeLogical.data.IlogicalCubes;
import org.example.cubeLogical.data.Point;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Ui_2by2 implements Initializable {

    private IlogicalCubes controller2by2;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button bt_Back;

    @FXML
    private Text txt_Standart0;
    @FXML
    private Text txt_Standart1;
    @FXML
    private Text txt_Standart2;
    @FXML
    private Text txt_Standart3;
    @FXML
    private Text txt_Standart4;
    @FXML
    private Text txt_Standart5;
    @FXML
    private Text txt_Standart6;
    @FXML
    private Text txt_Standart7;

    public void pressed_btBack(ActionEvent event) throws IOException {
        System.out.println("Controller_Ui_2by2.pressed_btBack");
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller_Ui_2by2.initialize");
        controller2by2 =  new Controller_Cube_2by2();
        controller2by2.start();
        updateTextFields();
        //txt_Standart0.setText("Nothing");
    }
    private void updateTextFields(){
        System.out.println("Controller_Ui_2by2.updateTextFields");
        Point[] points = controller2by2.getPoints();
        System.out.println("length: " + points.length);
        txt_Standart0.setText(points[0].getName());
        txt_Standart1.setText(points[1].getName());
        txt_Standart2.setText(points[2].getName());
        txt_Standart3.setText(points[3].getName());
        txt_Standart4.setText(points[4].getName());
        txt_Standart5.setText(points[5].getName());
        txt_Standart6.setText(points[6].getName());
        txt_Standart7.setText(points[7].getName());
    }
}
