package project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Polygon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;

/**
 * Javafx UI, Takes information from combo box;
 * Takes Shape Type;
 * Takes Shape Size;
 * Prints out shape with combo box and button;
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
public class Project2 extends Application {
	

	
	 /**
	  * Enter Button and label, Javafx
	  */
	private final Button tfEnter = new Button("Enter");
	
	 /**
	  * Clear Button and label, Javafx
	  */
	private final Button tfClear = new Button("Clear");
	
	 /**
	  * Shape Type ComboBox Button 1, Javafx
	  */
	private final ComboBox<String> cbo = new ComboBox<>();
	
	 /**
	  * Size Type ComboBox Button 2, Javafx
	  */
	private final ComboBox<String> cbo2 = new ComboBox<>();
	
	
	 /**
	  * Shape Type ComboBox Button 1 option labels with String [], Javafx
	  */
	private final String[] ShapesMenu = {"Circle","Rectangle","Square","Triangle","Sphere","Cube","Cone","Cylinder","Torus","Exit" };
	
	 /**
	  * Size Type ComboBox Button 2 option labels with String [], Javafx
	  */
	private final String[] ShapesDim = {"Small","Medium","Large"};
	
	/**
     * Javafx UI, creates labels, combo box, button layout;
     * Draws a shape with combo box; Strings [] for combo box choices;
     * 
     * @Override override the start method in Application class
	 *
	 * @throws Exception if the user input is incorrect with not 4 items
	 *                               on one line
	 * @param primaryStage creates the primary stage for the Javafx UI Application
	 */
	@Override
	public void start (Stage primaryStage) throws Exception {

		tfEnter.setAlignment(Pos.BOTTOM_RIGHT);
		tfClear.setAlignment(Pos.BOTTOM_RIGHT);
		// Create a grid pane and place all nodes, labels, and buttons into it
		GridPane pane = new GridPane();
		pane.setVgap(3);                // Vertical height
		pane.setHgap(3);                // Horizontal height
		pane.setAlignment(Pos.CENTER);  // Position center
		
		// Create Distance
		pane.add(new Label("*********Welcome to the Java OO Shapes Program **********\t"),0, 1); //x, y; Set up label
		pane.add(new Label("Select from the menu below:"), 0, 2);
		pane.add(new Label("Construct a: "), 0, 3);
		
		
		// Add Combo box 1 option for Distance
	    pane.add(cbo, 0, 4);
	    cbo.setValue("Circle");  // Set default label
	    cbo.setPrefWidth(120);  // Set fixed width size
	    ObservableList<String> items = 
	  	      FXCollections.observableArrayList(ShapesMenu);
	  	    cbo.getItems().addAll(items); // Add items to combo box
	  	
	    pane.add(new Label("Shape Dimensions:"), 0, 5);
	  	    
			// Add Combo box 1 option for Distance
		    pane.add(cbo2, 0, 6);
		    cbo2.setValue("Small");  // Set default label
		    cbo2.setPrefWidth(120);  // Set fixed width size
		    ObservableList<String> items2 = 
		  	      FXCollections.observableArrayList(ShapesDim);
		  	    cbo2.getItems().addAll(items2); // Add items to combo box
		
		// Create Button
		// Button for calculating TripCost
		pane.add(tfEnter, 0, 7);                    // Set up button for calculation button
		pane.add(tfClear, 0, 8); 
		
		
		/**
		 *  Handles action when the 'Enter' button is clicked;
		 *  prints out the selected shape
		 *
		 * @param event The event triggered by clicking the button.
		 */
		tfEnter.setOnAction(event-> {
			
		    /**
		     * Try/catch for calculating TotalTripCost and User Input
		     * 
		     * @throws NumberFormatException if the user input on file is incorrect
		     */
			try {
				
				String selectedShape = cbo.getValue();
				String size = cbo2.getValue();
				
	            if ("Circle".equals(selectedShape)) {
	            	
		            if("Small".equals(size)){
		            	MyCircle myCircle = new MyCircle(150, 150, 40);
		                myCircle.setFillColor(Color.PURPLE); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCircle);
		            }
		            else if("Medium".equals(size)){
		            	MyCircle myCircle = new MyCircle(150, 150, 70);
		                myCircle.setFillColor(Color.PURPLE); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCircle);
		            }
		            else if("Large".equals(size)){
		            	MyCircle myCircle = new MyCircle(150, 150, 100);
		                myCircle.setFillColor(Color.PURPLE); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCircle);
		            }

	            } else if ("Rectangle".equals(selectedShape)) {
	            	
		            if("Small".equals(size)){
		            	MyRectangle myRectangle = new MyRectangle(150, 40);
		                myRectangle.setFillColor(Color.ORANGE); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myRectangle);
		            }
		            else if("Medium".equals(size)){
		            	MyRectangle myRectangle = new MyRectangle(200, 70);
		                myRectangle.setFillColor(Color.ORANGE); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myRectangle);
		            }
		            else if("Large".equals(size)){
		            	MyRectangle myRectangle = new MyRectangle(250, 100);
		                myRectangle.setFillColor(Color.ORANGE); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myRectangle);
		            }
	            
	            } else if ("Square".equals(selectedShape)) {
	                
		            if("Small".equals(size)){
		            	MySquare mySquare = new MySquare(40);
		                mySquare.setFillColor(Color.GREEN); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(mySquare);
		            }
		            else if("Medium".equals(size)){
		            	MySquare mySquare = new MySquare(70);
		                mySquare.setFillColor(Color.GREEN); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(mySquare);
		            }
		            else if("Large".equals(size)){
		            	MySquare mySquare = new MySquare(100);
		                mySquare.setFillColor(Color.GREEN); // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(mySquare);
		            }
	            } else if ("Triangle".equals(selectedShape)) {
			            
			            if("Small".equals(size)){
			            	MyTriangle myTriangle = new MyTriangle(0, 0, 40, 0, 40, 40);
			                myTriangle.setFill(Color.RED); // Optional: Set a fill color
			                // Create a pane to hold the circle
			                pane.getChildren().add(myTriangle);
			            }
			            else if("Medium".equals(size)){
			            	MyTriangle myTriangle = new MyTriangle(0, 0, 70, 0, 70, 70);
			                myTriangle.setFill(Color.RED); // Optional: Set a fill color
			                // Create a pane to hold the circle
			                pane.getChildren().add(myTriangle);
			            }
			            else if("Large".equals(size)){
			            	MyTriangle myTriangle = new MyTriangle(0, 0, 100, 0, 100, 100);
			                myTriangle.setFill(Color.RED); // Optional: Set a fill color
			                // Create a pane to hold the circle
			                pane.getChildren().add(myTriangle);
			            }
			            
	            } else if ("Sphere".equals(selectedShape)) {
	            
		            if("Small".equals(size)){
		            	MySphere mySphere = new MySphere(15);
		                // Create a pane to hold the circle
		                pane.getChildren().add(mySphere);
		            }
		            else if("Medium".equals(size)){
		            	MySphere mySphere = new MySphere(40);
		                // Create a pane to hold the circle
		                pane.getChildren().add(mySphere);
		            }
		            else if("Large".equals(size)){
		            	MySphere mySphere = new MySphere(80);
		                // Create a pane to hold the circle
		                pane.getChildren().add(mySphere);
		            }
		            
               } else if ("Cube".equals(selectedShape)) {
            	   
		            if("Small".equals(size)){
		            	MyCube myCube = new MyCube(50, 50, 10);
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCube);
		                
		                Image image = new Image("project2/CubeS.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(100);
		                pane.getChildren().add(imageView);
		                
		            }
		            else if("Medium".equals(size)){
		            	MyCube myCube = new MyCube(100, 100, 50);
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCube);
		                
		                Image image = new Image("project2/CubeM.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(200);
		                pane.getChildren().add(imageView);
		            }
		            else if("Large".equals(size)){
		            	MyCube myCube = new MyCube(200, 200, 80);
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCube);
		                
		                Image image = new Image("project2/CubeL.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(300);
		                pane.getChildren().add(imageView);
		            }
               } else if ("Cone".equals(selectedShape)) {
            	   //openPopup(primaryStage);
		            if("Small".equals(size)){
		            	
		            	/*MyCone myCone = new MyCone(80, 30, 20, 16);
		            	myCone.setTranslateX(150);
		                pane.getChildren().add(myCone);*/
		                
		                Ellipse baseCircle1 = new Ellipse(50, 15); // Radius of the base circle
		                //baseCircle.setTranslateX(250);
		                baseCircle1.setTranslateY(-75);

		                // Create the triangle (side)
		                Polygon triangle1 = new Polygon(
		                		100, 100,
		                        200, 100,
		                        150, 250
		                );
		                pane.getChildren().add(baseCircle1);
		                pane.getChildren().add(triangle1);
		                
		                Image image = new Image("project2/ConeS.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(100);
		                pane.getChildren().add(imageView);
		            }
		            else if("Medium".equals(size)){
		            	/*MyCone myCone = new MyCone(100, 50, 20, 36);
		            	myCone.setTranslateX(200);
		                pane.getChildren().add(myCone);*/
		                
		                Ellipse baseCircle2 = new Ellipse(75, 20); // Radius of the base circle
		                //baseCircle.setTranslateX(250);
		                baseCircle2.setTranslateY(-110);

		                // Create the triangle (side)
		                Polygon triangle2 = new Polygon(
		                        150, 150,
		                        300, 150,
		                        225, 375
		                );
		                pane.getChildren().add(baseCircle2);
		                pane.getChildren().add(triangle2);
		                
		                Image image = new Image("project2/ConeM.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(200);
		                pane.getChildren().add(imageView);
		            }
		            else if("Large".equals(size)){
		            	/*MyCone myCone = new MyCone(150, 100, 40, 72);
		            	myCone.setTranslateX(200);
		                pane.getChildren().add(myCone);*/
		                
		                Ellipse baseCircle3 = new Ellipse(100, 30); // Radius of the base circle
		                //baseCircle.setTranslateX(250);
		                baseCircle3.setTranslateY(-150);

		                // Create the triangle (side)
		                Polygon triangle3 = new Polygon(
		                        200, 200,
		                        400, 200,
		                        300, 500
		                );
		                pane.getChildren().add(baseCircle3);
		                pane.getChildren().add(triangle3);
		                
		                Image image = new Image("project2/ConeL.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(200);
		                pane.getChildren().add(imageView);
		            }
               } else if ("Cylinder".equals(selectedShape)) {
                   
		            if("Small".equals(size)){
		            	MyCylinder myCylinder = new MyCylinder(50, 0, 20, 40);
		                 // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCylinder);
		                
		                Image image = new Image("project2/CylinderS.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(100);
		                pane.getChildren().add(imageView);
		            }
		            else if("Medium".equals(size)){
		            	MyCylinder myCylinder = new MyCylinder(50, 0, 50, 70);
		                 // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCylinder);
		                
		                Image image = new Image("project2/CylinderM.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(200);
		                pane.getChildren().add(imageView);
		            }
		            else if("Large".equals(size)){
		            	MyCylinder myCylinder = new MyCylinder(50, 0, 80, 100);
		                 // Optional: Set a fill color
		                // Create a pane to hold the circle
		                pane.getChildren().add(myCylinder);
		                
		                Image image = new Image("project2/CylinderL.png");
		                //Creating the image view
		                ImageView imageView = new ImageView(image);
		                //Setting image to the image view
		                imageView.setTranslateX(200);
		                pane.getChildren().add(imageView);
		            }
               } else if ("Torus".equals(selectedShape)) {
       	        // Create the centered torus mesh
            	   
		            if("Small".equals(size)){
		       	        MyTorus centeredTorus = new MyTorus(50, 15, 32, 16);
		       	        MeshView centeredTorusMeshView = new MeshView(centeredTorus);
		       	        centeredTorusMeshView.setMaterial(new javafx.scene.paint.PhongMaterial(Color.LIGHTBLUE));
		       	        pane.getChildren().add(centeredTorusMeshView);
		            }
		            else if("Medium".equals(size)){
		       	        MyTorus centeredTorus = new MyTorus(100, 30, 64, 32);
		       	        MeshView centeredTorusMeshView = new MeshView(centeredTorus);
		       	        centeredTorusMeshView.setMaterial(new javafx.scene.paint.PhongMaterial(Color.LIGHTBLUE));
		       	        pane.getChildren().add(centeredTorusMeshView);
		            }
		            else if("Large".equals(size)){
		       	        MyTorus centeredTorus = new MyTorus(130, 60, 94, 62);
		       	        MeshView centeredTorusMeshView = new MeshView(centeredTorus);
		       	        centeredTorusMeshView.setMaterial(new javafx.scene.paint.PhongMaterial(Color.LIGHTBLUE));
		       	        pane.getChildren().add(centeredTorusMeshView);
		            }
           } else if ("Exit".equals(selectedShape)) {
        	   Platform.exit();
           }
           else {
        	   showInvalidInputPopup("Invalid, Choose a selection.");
           }
	            //Cone and Torus do not work
	            //Cube is not a cube but a square
	            //Same with sphere but circle.
			} catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
	            // Handle invalid input (pop up an error)
	            showInvalidInputPopup("Invalid, Choose a selection.");
	        } // End try/catch
			
	    }); // End button action
		

		tfClear.setOnAction(event-> {
			try {
			pane.getChildren().remove(8, 9); // Removes the last nodes of shape
			}catch (IndexOutOfBoundsException e) {
				showInvalidInputPopup("Scene is already clear from all objects created...");
			}
		});

		// Output the application, scene, pane, and primary stage
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 900, 700); 
		primaryStage.setTitle("Shapes Drawing Program"); // Set the stage title
		primaryStage.setScene(scene);                 // Place the scene in the stage
		primaryStage.show();                          // Display the stage / application
	} // End start method for Javafx Application
	
	/**
     * Javafx UI; Creates alerts; Error/Invalid input message into a pop up Alert;
	 *
	 * @param message the error/invalid input alert message for the Javafx UI Application
	 */
	private void showInvalidInputPopup(String message) {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Error: Invalid Input");
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	} // End showInvalidInputPopup for alert message

	
} // End Project2 class
	

