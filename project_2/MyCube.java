package project2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Box;

/**
 * MyCube Class inherits the JavaFX Box;
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
public class MyCube extends Box {
	
	/**
	 * Cube Constructor that constructs the objects parameters for drawing circle
     * Constructor to create a cube with specified width, height, and depth
	 * 
	 * @param width the Cube's width
	 * @param height the Cube's height
	 * @param depth the Cube's depth
	 */
	public MyCube(double width, double height, double depth) {
        super(width, height, depth);
        setMaterial(new javafx.scene.paint.PhongMaterial(Color.LIGHTGREY)); // Customize material/color here
        // Set the center of the cylinder's base (bottom circle)
        // To see the 3d Object, it is rotated.
        setRotationAxis(javafx.scene.transform.Rotate.Y_AXIS);
        setRotate(30);
    }

	/**
	 * Outputs: Volume calculation number of shape
	 *
	 * @return AreaValue it outputs Volume calculation number
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
	 * Outputs:  Set the fill color for the circle (optional)
	 *
	 * @param color color of the shape to fill
	 */
    public void setFill(Color color) {
        setMaterial(new javafx.scene.paint.PhongMaterial(color));
    }
}

