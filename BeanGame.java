//U10416036

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
/**
 * @author MengLin
 */

public class BeanGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Create a scene and place it in the stage
        Scene scene = new Scene(new Drawer(), 300, 300);
        //Set the stage title
        primaryStage.setTitle("BeanGame");
        //Place the scene in the stage
        primaryStage.setScene(scene);
        //Display the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class Drawer extends Pane{
    public final double radius = 3;
    private double x = radius, y = radius;
    private double dx = 0, dy = 1;
    private Timeline animation;
    private Circle ball = new Circle(x, y, radius);
    
    public Drawer(){
        int slot = 8;
        //Draw line around the machine
        Line l1 = new Line(130,55,130,85);
        Line l2 = new Line(130,85,60,250);
        Line l3 = new Line(60,250,60,280);
        Line l4 = new Line(60,280,240,280);
        Line l5 = new Line(240,280,240,250);
        Line l6 = new Line(240,250,170,85);
        Line l7 = new Line(170,85,170,55);

        getChildren().add(l1);
        getChildren().add(l2);
        getChildren().add(l3);
        getChildren().add(l4);
        getChildren().add(l5);
        getChildren().add(l6);
        getChildren().add(l7);
        
        //Calculate how many slot at bottom
        double bottom = ((240 - 60) / slot);
        //Draw slots 
        for(int i = 1; i < slot; i++){
            int locate = (int)(60 + Math.round((bottom) * i));
            Line s = new Line(locate, 250, locate, 280);
            getChildren().add(s);
        }
        //Calculate the location
        float x = (240 - 60) / (slot*2);
        float y = (250 - 90) / (slot-2);
        
        //Use loop th draw the circle of the bean machine
        for(int i = 0;i<(slot-1);i++){
            for(int j = 0; j <= i; j++){
                Circle c1 = new Circle();
                c1.setCenterX(148.5-x*i + 2*x*j);
                c1.setCenterY(95+y*i);
                c1.setRadius(5.0f);
                getChildren().add(c1);
            }
        }
        
        ball.setFill(Color.BLACK);
        getChildren().add(ball);
        animation = new Timeline(new KeyFrame(Duration.millis(20),e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    public void play(){
        animation.play();
    }
    
    public void pause(){
        animation.pause();
    }
    
    
    public DoubleProperty rateProperty(){
        return animation.rateProperty();
    }
    
    protected void moveBall(){
        if(x < radius || x > getWidth() - radius){
            dx *= -1;
        }
        if(y < radius || y > getHeight() - radius){
            dy *= -1;
        }
    
        x += dx;
        y += dy;
        
        ball.setCenterX(x);
        ball.setCenterY(y);
    }
}
