package project2;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
	
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
public class MyCone extends Group {
	
    /**
     * Cone Constructor that constructs the objects parameters for drawing
     * Constructor to create a cone with specified center, height, dim, and radius
     * 
     * @param r1 the Cone's base radius
     * @param r2 the Cone's top radius
     * @param h the Cone's height
     * @param rounds the Cone's number of divisions around the cone
     */
	    public MyCone(float r1, float r2, float h, int rounds) {
	        // Create a new group to hold our cone
	        Group cone = new Group();
	        PhongMaterial material = new PhongMaterial(Color.BLUE);

	        // Define parameters for the cone
	        //float r1 = 100.0f; // 100.0fBase radius
	        //float r2 = 50.0f; // 50.0fTop radius
	        //float h = 20.0f; // 20.0fHeight
	        //int rounds = 36; // 36Number of divisions around the cone

	        float[] points = new float[rounds * 12];
	        float[] textCoords = {
	            0.5f, 0,
	            0, 1,
	            1, 1
	        };
	        int[] faces = new int[rounds * 12];

	        // Calculate vertex positions for the cone
	        for (int i = 0; i < rounds; i++) {
	            int index = i * 12;
	            // Vertex 0
	            points[index] = (float) Math.cos(Math.toRadians(i)) * r2;
	            points[index + 1] = (float) Math.sin(Math.toRadians(i)) * r2;
	            points[index + 2] = h / 2;
	            // Vertex 1
	            // ... similar calculations for other vertices
	            // ...
	        }

	        // Define faces for the cone
	        // ...

	        // Create a TriangleMesh and add points, texture coordinates, and faces
	        TriangleMesh mesh = new TriangleMesh();
	        mesh.getPoints().addAll(points);
	        mesh.getTexCoords().addAll(textCoords);
	        mesh.getFaces().addAll(faces);

	        // Create two circles (top and bottom) to cap the cone
	        Cylinder circle1 = new Cylinder(r1, 0.1);
	        circle1.setMaterial(material);
	        circle1.setTranslateZ(-h / 2);
	        circle1.setRotationAxis(Rotate.X_AXIS);
	        circle1.setRotate(90);

	        Cylinder circle2 = new Cylinder(r2, 0.1);
	        circle2.setMaterial(material);
	        circle2.setTranslateZ(h / 2);
	        circle2.setRotationAxis(Rotate.X_AXIS);
	        circle2.setRotate(90);

	        // Create a MeshView to display the cone
	        MeshView meshView = new MeshView();
	        meshView.setMesh(mesh);
	        meshView.setMaterial(material);

	        // Add everything to the cone group
	        cone.getChildren().addAll(meshView, circle1, circle2);

	        // Rotate the cone
	        Rotate rotation = new Rotate(90, Rotate.X_AXIS);
	        cone.getTransforms().add(rotation);

	        // Add the cone group to this parent group
	        getChildren().addAll(cone);
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
