//U10416036
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
public class BeanGame extends Application {
    BallPane b = new BallPane();
    public void start(Stage primaryStage) {
        b.setOnMouseClicked(e -> {
            
            
            BallPane ball = new BallPane();
            b.getChildren().add(ball);
            ball.play();
        });
        Drawer drawer = new Drawer();
        Scene scene = new Scene(new StackPane(b),300,300);
        primaryStage.setScene(scene);
        b.getChildren().add(drawer);
        b.setOnMouseReleased(e -> b.play());
        primaryStage.setTitle("Bean Machine");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
class Drawer extends Pane{
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
                c1.setRadius(4.0f);
                getChildren().add(c1);
            }
        }   
    }
}
class BallPane extends Pane{
    public final double radius = 4;
    private double x = 150, y = 0;
    private double dx = 1, dy = 1;
    private Timeline animation; 
    private Circle circle = new Circle(x, y, radius);
    public BallPane(){
        Paint[] color = {Color.RED,Color.DARKORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.BLUEVIOLET,Color.GREENYELLOW,Color.PLUM,Color.TURQUOISE}; 
        Random r = new Random();
        int c =  r.nextInt(9);
        circle.setFill((Paint)color[c]);
        getChildren().add(circle);
        animation = new Timeline(new KeyFrame(Duration.millis(8), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    public void play(){
        animation.play();
    }
    protected void moveBall(){
    int random;
    double d = 0.45;
    if(y >= 75 && y < 254){
        if (y == 75) {
            if((int)(Math.random() * 2) == 1){
                dx *= -d; 	
            }else{
                dx *= d; 
            }
		 
        }
        if(y == 100){     
            if((int)(Math.random() * 2) == 1){
                if(dx == d||dx == -d){
                    dx *= -1; 	
                }
                else dx *= -d;
            }else{
                if(dx == d||dx == -d){
                    dx *= 1; 
                }
                else dx *= d;
            }
        }
        if(y == 125){
            if((int)(Math.random() * 2) == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        if(y == 153){
            if((int)(Math.random() * 2) == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        if(y == 178){
            if((int)(Math.random() * 2) == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        if(y == 203){
            if((int)(Math.random() * 2) == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
	}
        if(y == 228){
            if((int)(Math.random() * 2) == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
	}
        if(y == 228){
            if((int)(Math.random() * 2) == 1){
		dx *= -1; 	
            }else{
                dx *= 1; 
            }
	}
        if(y == 253){
            if((int)(Math.random() * 2) == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        x += dx;
    }
    if(y == 275){
        dy *= 0;
    }
    // Adjust ball position
    y += dy;
    circle.setCenterX(x);
    circle.setCenterY(y);
    }
}
