package project2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * MyRectangle Class inherits the JavaFX Rectangle;
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
 * Project: Project 2
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class MyRectangle extends Rectangle {
	
	/**
	 * Rectangle Constructor that constructs the objects parameters for drawing
     * Constructor to create a rectangle with specified width and height
	 * 
	 * @param width the Rectangle's width
	 * @param height the Rectangle's height
	 */
    public MyRectangle(double width, double height) {
        super(width, height);
    }

	/**
	 * Outputs: Area calculation number of shape
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double calculateArea() {
        return getWidth() * getHeight();
    }
    
	/**
	 * Outputs: perimeter (circumference) calculation number of shape
	 *
	 * @return PerimeterValue it outputs Area calculation number
	 */
    public double calculatePerimeter() {
        return 2 * (getWidth() + getHeight());
    }

	/**
	 * Outputs:  Set the fill color for the shape
	 *
	 * @param color color of the shape to fill
	 */
    public void setFillColor(Color color) {
        setFill(color);
    }
}

