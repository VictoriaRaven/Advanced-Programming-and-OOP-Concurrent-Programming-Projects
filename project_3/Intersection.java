package project32;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

/**
 * Intersection class multithreads using thread class.
 * This creates the intersection threads working together with the car and trafficlightdemo
 * This creates a new traffic light intersection and to add cars into it as well.
 * It should create a new thread and label.
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
class Intersection {
	
	/**
	 * Integer id number for what traffic light number it is.
	 */
    private int id;
    
    /**
     * JLabel for the new intersection and traffic lights for the GUI.
     */
    private JLabel[] trafficLightLabels;
    
    /**
     * Syncs the intersection threads to the traffic light threads
     */
    private TrafficLightSimulator tls;
    
    /**
     * Creates a new thread per intersection
     */
    private Thread tlsThread;
    
    /**
     * Syncs the cars to the intersection and the threads of the traffic lights.
     */
    private List<Car> cars;

    /**
     * Creates the Intersection object with the JLabel to synic the traffic lgihts to the intersection.
     * It should also sync and allow the cars to be added.
     * In order: Add intersection then add the car then the traffic lights sync with the added car
     * @param id intersection number that you created for the traffic light.
     */
    public Intersection(int id) {
        this.id = id;
        this.trafficLightLabels = new JLabel[1];
        for (int i = 0; i < 1; i++) {
            this.trafficLightLabels[i] = new JLabel("Traffic Light " + id + ": " + (i + 1) + " RED");
        }
        this.tls = new TrafficLightSimulator(TrafficLightColor.RED);
        this.tlsThread = new Thread(tls);
        this.cars = new ArrayList<>();
    }

    /**
     * Returns the id number of the traffic light/intersection made.
     * @return id returns the id number
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the JLabel of the traffic light labels.
     * @return trafficLightLabels returns the trafficLightLabels of the JLabel
     */
    public JLabel[] getTrafficLightLabels() {
        return trafficLightLabels;
    }

    /**
     * Returns the thread of the TrafficLightSimulator to sync with trafficLightLabel.
     * @return tls returns the thread of the TrafficLightSimulator to sync with trafficLightLabel.
     */
    public TrafficLightSimulator getTls() {
        return tls;
    }

    /**
     * Allows to add the cars per intersection and sync with the traffic lights.
     */
    public void addCar(Car car) {
        cars.add(car);
    }
    
    /**
     * Starts the threads
     */
    public void start() {
        tlsThread.start();
    }

    /**
     * Stop the threads.
     */
    public void stop() {
        tls.cancel();
        tlsThread.interrupt();
    }
    
    /**
     * Pauses the threads.
     */
    public void pause() {
    	tls.pause();
    }
    
    /**
     * Resumes the threads
     */
    public void resume() {
    	tls.resume();
    }
    
    /**
     *  In the Intersection class:
     *  Reset the intersection
     */
    public void reset() {
        tls = new TrafficLightSimulator(TrafficLightColor.RED);
    }

    /**
     * Update the traffic light labels thread names color (Red, Green, Yellow)
     */
    public void updateTrafficLights() {
        for (JLabel label : trafficLightLabels) {
            label.setText("Traffic Light " + id + ": " + tls.getColor().toString());
        }
    }
}

