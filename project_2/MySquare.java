package project2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Box;

/**
 * MySquare Class inherits the JavaFX Box;
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
public class MySquare extends Box {

	/**
	 * Square Constructor that constructs the objects parameters for drawing
     * Constructor to create a square with specified side length
	 * 
	 * @param sideLength the Square's side length
	 */
    public MySquare(double sideLength) {
        super(sideLength, sideLength, sideLength);
    }

	/**
	 * Outputs: Volume calculation number of shape
	 *
	 * @return VolumeValue it outputs Volume calculation number
	 */
    public double calculateVolume() {
        return Math.pow(getWidth(), 3);
    }

	/**
	 * Outputs: Area calculation number of shape
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double calculateSurfaceArea() {
        return 6 * Math.pow(getWidth(), 2);
    }

	/**
	 * Outputs:  Set the fill color for the shape
	 *
	 * @param color color of the shape to fill
	 */
    public void setFillColor(Color color) {
        setMaterial(new javafx.scene.paint.PhongMaterial(color));
    }
}
