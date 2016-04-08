/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballpane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author MACBOOK
 */
public class BallPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Ball b = new Ball();
        b.setOnMousePressed(e -> b.pause());
        b.setOnMouseReleased(e -> b.play());
        
        b.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP){
                b.increaseSpeed();
            }
            else if(e.getCode() == KeyCode.DOWN){
                b.decreaseSpeed();
            }});
        
        StackPane root = new StackPane();
        root.getChildren().add(b);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("BallPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MACBOOK
 */
class Ball extends Pane{
    public final double radius = 3;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;
    
    public Ball(){
        circle.setFill(Color.BLACK);
        getChildren().add(circle);
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
       
    }
    
    

    
    public void play(){
        animation.play();
    }
    public void pause(){
        animation.pause();
    }
    public void increaseSpeed(){
        animation.setRate(animation.getRate() + 0.1);
    }
    public void decreaseSpeed(){
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }
    public DoubleProperty rateProperty(){
        return animation.rateProperty();
    }
    protected void moveBall(){
        if(x<radius || x > getWidth() - radius){
            dx *= -1;
        }
        if(y<radius || y > getWidth() - radius){
            dy *= -1;
        }
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
        
    }
}
