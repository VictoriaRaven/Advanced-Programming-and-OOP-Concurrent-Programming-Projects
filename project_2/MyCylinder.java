package project2;

import javafx.scene.shape.Cylinder;

/**
 * MyCylinder Class inherits the JavaFX Cylinder;
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
public class MyCylinder extends Cylinder {
    
	/**
	 * Cylinder Constructor that constructs the objects parameters for drawing
     * Constructor to create a cylinder with specified base, radius, and height
     * 
	 * @param centerX the Cylinders base bottom
	 * @param centerY the Cylinder's base top
	 * @param radius the Cylinder's radius
	 * @param height the Cylinder's height
	 */
    public MyCylinder(double centerX, double centerY, double radius, double height) {
        super(radius, height);
        // Set the center of the cylinder's base (bottom circle)
        setTranslateX(centerX);
        setTranslateY(centerY);
        setTranslateZ(height / 2); // Adjust for the height
        // To see the 3d Object, it is rotated.
        setRotationAxis(javafx.scene.transform.Rotate.Y_AXIS);
        setRotate(30);
    }

	/**
	 * Outputs: Area calculation number of shape
	 * (including both bases and lateral surface)
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double calculateSurfaceArea() {
        double baseArea = Math.PI * Math.pow(getRadius(), 2);
        double lateralArea = 2 * Math.PI * getRadius() * getHeight();
        return 2 * baseArea + lateralArea;
    }

	/**
	 * Outputs: Volume calculation number of shape
	 *
	 * @return VolumeValue it outputs Volume calculation number
	 */
    public double calculateVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * getHeight();
    }
}

