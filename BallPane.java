//U10416036

import java.security.SecureRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;



/**
 *
 * @author MACBOOK
 */
class BallPane extends Pane{
    public final double radius = 3;
    private double x = 150, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;
    SecureRandom srand = new SecureRandom();

    public BallPane(){
        circle.setFill(Color.GREEN);
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
    int random;
    
        if(y >= 87 && y < 247){
		if (y == 85) {
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		 
		}
		if( y == 115){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 145){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 175){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 205){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 235){
			random = srand.nextInt() % 2 ;
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
    //x += dx;
    y += dy;
    circle.setCenterX(x);
    circle.setCenterY(y);
        
    }
}
