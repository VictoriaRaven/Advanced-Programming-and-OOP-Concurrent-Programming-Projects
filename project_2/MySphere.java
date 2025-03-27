package project2;

import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;


/**
 * MSphereectangle Class inherits the JavaFX Sphere;
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
public class MySphere extends Sphere {

	
	/**
	 * Sphere Constructor that constructs the objects parameters for drawing
     * Constructor to create a sphere with specified center and radius
	 * 
	 * @param radius the Sphere's radius
	 */
    public MySphere(double radius) {
        super(radius);

        setMaterial(new javafx.scene.paint.PhongMaterial(Color.LIGHTSKYBLUE));
        setRotationAxis(javafx.scene.transform.Rotate.Y_AXIS);
        setRotate(30);
     // Create a Light
        PointLight light = new PointLight();
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(300);

        // Create a Camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);
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
	 * Outputs: perimeter (circumference) calculation number of shape
	 *
	 * @return PerimeterValue it outputs Area calculation number
	 */
    public double calculateCircumference() {
        return 2 * Math.PI * getRadius();
    }
    
	/**
	 * Outputs: volume calculation number of shape
	 *
	 * @return VolumeValue it outputs Volume calculation number
	 */
    public double calculateVolume() {
    	double sqrtPi = Math.sqrt(Math.PI);
        return Math.pow(calculateArea(), 1.5) / (6 * sqrtPi);
    }

	/**
	 * Outputs:  Set the fill color for the circle (optional)
	 *
	 * @param color color of the shape to fill
	 */
    public void setFill(Color color) {
        setFill(color);
    }
}

