package project32;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * TrafficSimulationGUI should create an application for the cars, intersections, and traffic light.
 * This should use the Car, TrafficLightDemo, Intersection classes embedded to this class to create the thread objects.
 * 
 * <p>
 * Course: CMSC 335
 * <p>
 * Date: 10/3/2024
 * <p>
 * Project: Project 3 Final
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class TrafficSimulationGUI extends JFrame {
	
	/**
	 * timelabel Java Swing label
	 */
    private JLabel timeLabel;
    //private JLabel trafficLightLabel; Testing for override.
    
    /**
     * Buttons for java swing, start, pause, stop, continue, add cars, add intersection
     */
    private JButton startButton, pauseButton, stopButton, continueButton, addCarButton, addIntersection;
    
    /**
     * Timer class to add in a 1 second interval timer.
     */
    private Timer timer;
    
    /**
     * Helps print out the timer number on the labels.
     */
    private int elapsedTime = 0;
    
    /**
     * Car objects goes in the list array.
     */
    private List<Car> cars;
    
    /**
     * Intersection objects goes in the list array
     */
    private List<Intersection> intersections; // Declare the intersections list
    
    /**
     * flags to stop, start, run, pause, continue the threads commands.
     */
    private boolean running = false;
    
    /**
     * import the threads for the trafficlightsimulator and the traffic light colors.
     */
    private TrafficLightSimulator tls;
    
    /**
     * import the threads of the trafficlightsimulator and the traffic light colors.
     */
    private Thread tlsThread;
    
    /**
     * flag to make sure the user cannot press continue until paused is pressed first.
     */
    private boolean simulationPaused = false;

    
    
    /**
     * Creates the TrafficSimulation GUI application and layout; runs it through the main function.
     */
    public TrafficSimulationGUI() {
    	/**
    	 * Add Gui layout buttons and labels.
    	 */
    	setTitle("Traffic Simulation GUI Final");
    	setSize(1200, 800);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
     	setLayout(new GridLayout(2, 3)); // GridLayout format
     	
     	/**
     	 * Add time labels.
     	 */
    	timeLabel = new JLabel("Time: 0s");
    	
    	//trafficLightLabel = new JLabel("Traffic Light 0: RED"); Testing for override.
    	
    	/**
    	 * Add buttons Labels to the controlPanel for layout.
    	 */
    	JPanel controlPanel = new JPanel();
    	startButton = new JButton("Start");
    	pauseButton = new JButton("Pause");
    	stopButton = new JButton("Stop");
    	continueButton = new JButton("Continue");
    	addCarButton = new JButton("Add Car");
    	addIntersection = new JButton("Add Intersection");
    	
    	/**
    	 * Add buttons for controlPanel and time
    	 */
    	controlPanel.add(startButton);
    	controlPanel.add(pauseButton);
    	controlPanel.add(stopButton);
    	controlPanel.add(continueButton);
    	controlPanel.add(addCarButton);
    	controlPanel.add(addIntersection);

    	add(timeLabel);
    	//add(trafficLightLabel); Testing for override.
    	add(controlPanel);

    	/**
    	 * Initialize the running thread for the pause and continue.
    	 */
        tls = new TrafficLightSimulator(TrafficLightColor.RED);
        tlsThread = new Thread(tls);
        
        /**
         * Initialize the car list
         */
        cars = new ArrayList<>();
        /**
         * Initialize the intersections list
         */
        intersections = new ArrayList<>();
        
        //Testing for intersection override.
        /*for (int i = 0; i < 1; i++) {
            Car car = new Car(i + 1, tls);
            cars.add(car);
            new Thread(car).start();
        }*/
        
        /**
         * Buttons that goes to the following methods if pressed.
         * 
         * Start starts threads and application
         * Pause pauses the threads and application
         * Stop stops threads and exit
         * Continue continues the threads and application (pause must be pressed before this)
         * Add car adds a car thread object into array list
         * Add intersection adds an intersection with a car into array list (traffic lights)
         */
        startButton.addActionListener(e -> startSimulation());
        pauseButton.addActionListener(e -> {
            pauseSimulation();
            simulationPaused = true;
        });
        stopButton.addActionListener(e -> stopSimulation());
        continueButton.addActionListener(e -> {
            if (!simulationPaused) {
                JOptionPane.showMessageDialog(controlPanel, "Please pause the simulation first!");
            } else {
                continueSimulation();
                simulationPaused = false;
            }
        });
        addCarButton.addActionListener(e -> addCar());
        addIntersection.addActionListener(e -> addIntersection());

        /**
         * Current time stamps in 1 second intervals
         */
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    elapsedTime++;
                    timeLabel.setText("Time: " + elapsedTime + "s");
                    //updateTrafficLights(); Testing for override.
                    for (Intersection intersection : intersections) {
                        intersection.updateTrafficLights();
                    }
                    updateCarPositions();
                }
            }
        });
    }

    /**
     *  If start is pressed, this will start the simulation.
     */
    private void startSimulation() {
        if(!cars.isEmpty() | !intersections.isEmpty()) {
        	cars.clear();
        	intersections.clear();
        }
        if (!tlsThread.isAlive()) {
            tlsThread = new Thread(tls);
            tlsThread.start();
        }
        running = true;
        timer.start();
        for (Intersection intersection : intersections) {
            intersection.start();
        }
        for (Car car : cars) {
            car.start();
        }
    }
    
    /**
     *  If paused is pressed, this will pause the simulation until a continue is pressed.
     */
    private void pauseSimulation() {
    	tls.pause();
        running = false;
        for (Car car : cars) {
            car.pause();
        }
        
    }

    /**
     *  If stop is pressed, this will stop and exit the simulation.
     */
    private void stopSimulation() {
        running = false;
        elapsedTime = 0;
        timeLabel.setText("Time: 0s");
        timer.stop();
        tls.cancel();
        tlsThread.interrupt();
        cars.clear();
        intersections.clear();
        System.exit(0);
    }

    /**
     * If continue is pressed, this will continue the simulation if a paused was used.
     */
    private void continueSimulation() {
    	tls.resume();
        running = true;
        timer.start();
        for (Car car : cars) {
            car.resume();
            car.start();
        }
    }

    /**
     * This uses the Car class to add a new car object to sync with the intersection and trafficlightdemo.
     */
   private void addCar() {
        if (!intersections.isEmpty()) {
            Intersection latestIntersection = intersections.get(intersections.size() - 1);
            Car car = new Car(cars.size() + 1, latestIntersection.getTls());
            cars.add(car);
            latestIntersection.addCar(car);
            new Thread(car).start();
        } else {
            Car car = new Car(cars.size() + 1, tls);
            cars.add(car);
            new Thread(car).start();
        }
    }

   /**
    * This uses the Intersection class to add a new intersection object to sync with the car and trafficlightdemo.
    */
    private void addIntersection() {
        Intersection intersection = new Intersection(intersections.size() + 1);
        intersections.add(intersection);
        for (JLabel label : intersection.getTrafficLightLabels()) {
            add(label, BoxLayout.X_AXIS);
        }
        new Thread(intersection.getTls()).start(); // Start the TrafficLightSimulator thread for the new intersection
        revalidate(); // Force update.
    }

    /**
     * Create the carPanel to add the cars objects(threads) to.
     */
    private JPanel carPanel = new JPanel();

    // Testing the label for possible override.
    //private void updateTrafficLights() {
        //trafficLightLabel.setText("Traffic Light 0: " + tls.getColor().toString());
    //}
    
    /**
     * Updates each of the car positions on the label slider and the car label.
     */
    private void updateCarPositions() {
        carPanel.removeAll(); // Clear existing sliders
        for (Car car : cars) {
            carPanel.add(car.getPositionSlider());
            carPanel.add(new JLabel(car.toString()));
        }
        add(carPanel, BorderLayout.CENTER);
        revalidate(); // Force update
    }

    /**
     * This runs the program application(multi-threading).
     * @param args this runs the TrafficSimulationGUI multi-threading car scenario
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrafficSimulationGUI simulation = new TrafficSimulationGUI();
            simulation.setVisible(true);
        });
    }
}