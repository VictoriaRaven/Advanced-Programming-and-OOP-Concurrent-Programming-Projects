package project2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Circle Class inherits the JavaFX Circle;
 * It has a constructor for the inputs; 
 * Calculates and returns the area;
 * Calculates and returns the circumference;
 * Fills the color of the Shape.
 * 
 * <p>
 * Course: CMSC 335
 * <p>
 * Date: 9/4/2024
 * <p>
 * Project: Project 1
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class MyCircle extends Circle {
	
    /**
     * Circle Constructor that constructs the objects parameters for drawing
     * Constructor to create a circle with specified center and radius
     * 
     * @param centerX the Circle's x
     * @param centerX the Circle's Y
     * @param centerX the Circle's radius
     */
    public MyCircle(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

	/**
	 * Outputs: Area calculation number of shape
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double calculateArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
    
	/**
	 * Outputs: Circumference (perimeter) calculation number of shape
	 *
	 * @return CircumferenceValue it outputs Area calculation number
	 */
    public double calculateCircumference() {
        return 2 * Math.PI * getRadius();
    }

	/**
	 * Outputs:  Set the fill color for the circle (optional)
	 *
	 * @param color color of the shape to fill
	 */
    public void setFillColor(Color color) {
        setFill(color);
    }
}
