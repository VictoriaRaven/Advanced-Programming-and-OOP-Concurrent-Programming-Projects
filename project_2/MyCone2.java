package project2;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
/**
 * MyCone Class inherits the JavaFX Group;
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
public class MyCone2 {
	
	/**
	 * Ellipse base Circle
	 */
    private Ellipse baseCircle;
    
	/**
	 * Polygon triangle
	 */
    private Polygon triangle;
    
	/**
	 * Group coneGroup
	 */
    private Group coneGroup;
    
    /**
     * Cone Constructor that constructs the objects parameters for drawing
     * Constructor to create a cone with specified center, height, dim, and radius
     * 
     * @param rX the Cone's base radius
     * @param rY the Cone's top radius
     * @param t1 triangle vertex top x
     * @param t2 triangle vertex top y
     * @param br1 triangle vertex bottom right x
     * @param br2 triangle vertex bottom right y
     * @param bl1 triangle vertex bottom left x
     * @param bl2 triangle vertex bottom right y
     */
    public MyCone2(double rX, double rY, double t1, double t2, double br1, double br2, double bl1, double bl2) {
        // Create the base circle
        baseCircle = new Ellipse(rX, rY);
        baseCircle.setFill(Color.BLACK); // Slightly transparent
        baseCircle.setTranslateX(-50);
        baseCircle.setTranslateY(100);
        // Create the triangle (side)
        double[] trianglePoints = {
                t1, t2, // Top vertex
                br1, br2, // Bottom-right vertex
                bl1, bl2 // Bottom-left vertex
        };
        triangle = new Polygon(trianglePoints);
        triangle.setFill(Color.BLACK); // Slightly transparent
        triangle.setTranslateX(-200);

        // Group both shapes together
        coneGroup = new Group(baseCircle, triangle);
    }

    public Group getConeGroup() {
        return coneGroup;
    }
    
	/**
	 * Override with getArea() from ThreeDimensional Shape
	 * Outputs: Area calculation number of shape
	 * @param radius the Cone's radius
	 * @param height the Cone's height
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double getArea(int radius, int height) {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

	/**
	 * Override with getVolume() from ThreeDimensional Shape
	 * Outputs: Volume calculation number of shape
	 * @param radius  the Cone's radius
	 * @param height  the Cone's height
	 *
	 * @return VolumeValue it outputs Volume calculation number
	 */
    public double getVolume(double radius, double height) {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }
}


