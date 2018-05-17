/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlecoordinate;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author winte
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label1;
    @FXML 
    private TextField X1, Y1, r1, X2, Y2, r2;
    @FXML
    private Button button;
    
    @FXML
   private AnchorPane pane1;
    public Pane pane = new Pane();
    public Group group = new Group();
    
    private Circle c1 = new Circle();
    private Circle c2 = new Circle();
    
    
 
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
   
    
    @FXML 
    public boolean circleOverlap(Circle c1, Circle c2){
       double c1x = c1.getCenterX();
        double c1y = c1.getCenterY();
        double c1r = c1.getRadius();
        double c2x = c2.getCenterX();
        double c2y = c2.getCenterY();
        double c2r = c2.getRadius();
        
        double changeOfx = c2x - c1x;
        double changOfy = c2y -c1y; 
        
        double distance = Math.sqrt((changOfy * changOfy) + (changeOfx * changeOfx)); 
        
        if (distance > (c1r + c2r)){
            return false;
        }else if (distance < Math.abs(c1r - c2r)){
            return false;
        } 
        else{
            return true;
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       group.getChildren().addAll(c1, c2);
        pane.getChildren().add(group);
        pane1.getChildren().add(pane);
        button.setOnAction(e->{
            c1.setCenterX(Double.parseDouble(X1.getText()));
            c1.setCenterY(Double.parseDouble(Y1.getText()));
            c1.setRadius(Double.parseDouble(r1.getText()));
            c2.setCenterX(Double.parseDouble(X2.getText()));
            c2.setCenterY(Double.parseDouble(Y2.getText()));
            c2.setRadius(Double.parseDouble(r2.getText()));
            c1.setFill(Color.TRANSPARENT);
            c2.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c2.setStroke(Color.BLACK);
        if (circleOverlap(c1, c2)){
            label1.setText("Yes");
        }else{
            label1.setText("No");
        }
            
        });
        
       c1.setOnMouseDragged(e->{
           c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
            X1.setText(String.valueOf(c1.getCenterX()));
        Y1.setText(String.valueOf(c1.getCenterY()));
        if (circleOverlap(c1, c2)){
            label1.setText("Yes");
        }else{
            label1.setText("No");
        }
        });
        c2.setOnMouseDragged(e->{
            c2.setCenterX(e.getX());
        c2.setCenterY(e.getY());
        X2.setText(String.valueOf(c2.getCenterX()));
        Y2.setText(String.valueOf(c2.getCenterY()));
        if (circleOverlap(c1, c2)){
            label1.setText("Yes");
        }else{
            label1.setText("No");
        }
        });
        
    
}
}
