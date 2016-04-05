//U10416036

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
/**
 * @author MengLin
 */

public class BeanGame extends Application {
    //@Override
    int n = 0 ;
	
    public void start(Stage primaryStage) {
        BallPane b = new BallPane();
        
        Text text = new Text(20, 20, "");

        b.setOnMouseMoved(e -> {
            text.setText("x = " + e.getX() + "\n" + "y = " + e.getY());
        });
        
        b.setOnMousePressed(e -> b.pause());
        b.setOnMouseReleased(e -> b.play());
        
        Drawer drawer = new Drawer();

        Scene scene = new Scene(new StackPane(b),300,300);

        primaryStage.setScene(scene);
        b.getChildren().add(drawer);
        b.getChildren().add(text);
        primaryStage.setTitle("Bean Machine");
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

        getChildren().addAll(l1,l2,l3,l4,l5,l6,l7);
        
        
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
        
    }
    
}
