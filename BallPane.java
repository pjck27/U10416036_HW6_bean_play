//U10416036


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane{
    public final double radius = 4;
    private double x = 150, y = 0;
    private double dx = 1, dy = 1;
    
    
    
    private Timeline animation; 
    private Circle circle = new Circle(x, y, radius);

    public BallPane(){
        circle.setFill(Color.RED);
        getChildren().add(circle);
        animation = new Timeline(new KeyFrame(Duration.millis(8), e -> moveBall()));
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
    int random;
    double d = 0.45;
    
    if(y >= 75 && y < 254){
        if (y == 75) {
            random = (int)(Math.random() * 2);
            if(random == 1){
                dx *= -d; 	
            }else{
                dx *= d; 
            }
		 
        }
        if(y == 100){
            random = (int)(Math.random() * 2);            
            if(random == 1){
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
            random = (int)(Math.random() * 2);
            if(random == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        if(y == 153){
            random = (int)(Math.random() * 2);
            if(random == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        if(y == 178){
            random = (int)(Math.random() * 2);
            if(random == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
        }
        if(y == 203){
            random = (int)(Math.random() * 2);
            if(random == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
	}
        if(y == 228){
            random = (int)(Math.random() * 2);
            if(random == 1){
                dx *= -1; 	
            }else{
                dx *= 1; 
            }
	}
        if(y == 228){
            random = (int)(Math.random() * 2);
            if(random == 1){
		dx *= -1; 	
            }else{
                dx *= 1; 
            }
	}
        if(y == 253){
            random = (int)(Math.random() * 2);
            if(random == 1){
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
