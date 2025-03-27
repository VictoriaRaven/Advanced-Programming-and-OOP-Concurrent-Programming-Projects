package project2;

import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 * MyTorus Class inherits the JavaFX TriangleMesh;
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
public class MyTorus extends TriangleMesh {
	
	/**
	 * Torus Constructor that constructs the objects parameters for drawing
	 * Constructor to create a Torus with specified radius, tub radius, tube divisions, radius divisions
	 * 
	 * @param radius the Torus's radius
	 * @param tubeRadius the Torus's tube radius
	 * @param tubeDivisions the Torus's tube Divisions
	 * @param radiusDivisions the Torus's radius Divisions
	 */
    public MyTorus(float radius, float tubeRadius, int tubeDivisions, int radiusDivisions) {
        float tubeFraction = 1.0f / tubeDivisions;
        float radiusFraction = 1.0f / radiusDivisions;

        for (int tubeIndex = 0; tubeIndex < tubeDivisions; tubeIndex++) {
            float tubeRadian = tubeFraction * tubeIndex * 2.0f * (float) Math.PI;
            for (int radiusIndex = 0; radiusIndex < radiusDivisions; radiusIndex++) {
                float radiusRadian = radiusFraction * radiusIndex * 2.0f * (float) Math.PI;

                float x = (radius + tubeRadius * (float) Math.cos(tubeRadian)) * (float) Math.cos(radiusRadian);
                float y = (radius + tubeRadius * (float) Math.cos(tubeRadian)) * (float) Math.sin(radiusRadian);
                float z = tubeRadius * (float) Math.sin(tubeRadian);

                getPoints().addAll(x, y, z);
                getTexCoords().addAll(radiusFraction * radiusIndex, tubeFraction * tubeIndex);
            }
        }

        for (int tubeIndex = 0; tubeIndex < tubeDivisions; tubeIndex++) {
            for (int radiusIndex = 0; radiusIndex < radiusDivisions; radiusIndex++) {
                int p0 = tubeIndex * radiusDivisions + radiusIndex;
                int p1 = (p0 + 1) % (tubeDivisions * radiusDivisions);
                int p2 = (p0 + radiusDivisions) % (tubeDivisions * radiusDivisions);
                int p3 = (p1 + radiusDivisions) % (tubeDivisions * radiusDivisions);

                getFaces().addAll(p0, 100, p1, 100, p2, 100);
                getFaces().addAll(p1, 0, p3, 0, p2, 0);
            }
        }
    }
    
	/**
	 * Override with getArea() from ThreeDimensional Shape
	 * Outputs: Area calculation number of shape
	 * @param r the Torus's radius
	 * @param R the Torus's tubeRadius
	 *
	 * @return AreaValue it outputs Area calculation number
	 */
    public double calcArea(double r, int R) {
        return Math.PI * Math.pow(r, 2) * (2 * Math.PI * R);
    }

	/**
	 * Override with getVolume() from ThreeDimensional Shape
	 * Outputs: Volume calculation number of shape
	 * @param r the Torus's radius
	 * @param R the Torus's tubeRadius
	 *
	 * @return VolumeValue it outputs Volume calculation number
	 */
    public double calcVolume(int r, int R) {
        return 2 * Math.PI * Math.PI * r * r * R;
    }
    
}


