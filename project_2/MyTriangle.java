package project2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * MyTriangle Class inherits the JavaFX Polygon;
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
public class MyTriangle extends Polygon {
    // Constructor to create a triangle with specified vertices
	/**
	 * Triangle Constructor that constructs the objects parameters for drawing
	 * Constructor to create a Triangle with specified vertices
	 * 
	 * @param x1 the Triangle's vertex x1
	 * @param y1 the Triangle's vertex y1
	 * @param x2 the Triangle's vertex x2
	 * @param y2 the Triangle's vertex y2
	 * @param x3 the Triangle's vertex x3
	 * @param y3 the Triangle's vertex y3
	 */
    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        getPoints().addAll(x1, y1, x2, y2, x3, y3);
        setStroke(Color.BLACK); // Set the outline color (stroke)
        setFill(Color.TRANSPARENT); // Set the fill color (transparent for now)
    }
    


	/**
	 * Outputs: Area calculation number of shape
	 * @param base the triangle's base
	 * @param height the triangle's height
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double calculateArea(double base, double height) {

        return 0.5 * base * height;
    }
    
	/**
	 * Outputs: perimeter (circumference or sum of all sides) calculation number of shape
	 * @param base the triangle's base
	 * @param height the triangle's height
	 *
	 * @return PerimeterValue it outputs Area calculation number
	 */
    public double calculatePerimeter(int base, int height) {
        // Assuming it's an equilateral triangle (all sides equal)
        double sideLength = Math.sqrt(base * base + 4 * height * height) / 2;
        return 3 * sideLength;
    }
    
}
