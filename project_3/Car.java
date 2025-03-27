package project32;

import javax.swing.JSlider;


/**
* Creates a car object using muti-threading with the runnable class.
* It should adjust the distance with d=t*s in m/s and mph.
* It should adjust the slider position.
* It should print out the information of the car number and the x, speed.
* It should convert m/s to mph.
* It will also include a flag to pause, continue, start, and stop the threads.
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
class Car implements Runnable {
	
	/**
	 * Car id number value
	 */
	private int id;
	
	/**
	 * Car position value
	 */
    private double position;
    
    /**
     * Car speed value in m/s and in mph after converted.
     */
    private double speed;
    
    /**
     * JSlider positionSlider value for the Slider to display it.
     */
    private JSlider positionSlider;
    
    /**
     * TrafficLigightSimulator thread tls from TrafficLightDemo
     */
    private TrafficLightSimulator tls;
    
    /**
     * Stop flag to stop the threads
     */
    private boolean stop = false;
    
    /**
     * Pause flag to pause the threads then continue.
     */
    private boolean paused = false;
    
    /**
     * Creates the threads from Thread class.
     */
    private Thread thread;
    
    /**
     * Creates car object that syncs with traffic light simulator tls and the intersection.
     * @param id returns the car number id
     * @param tls the traffic light simulator thread to sync with the car
     */
    public Car(int id, TrafficLightSimulator tls) {
        this.id = id;
        this.position = 0;
        this.speed = 0; // Assume speed is 10 m/s
        this.positionSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, (int) position);
        this.positionSlider.setEnabled(false); // Disable user interaction
        this.tls = tls;
    }

    /**
     * Returns the id number of the car number.
     * @return id returns the id number of the car number.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the position of the slider (slider value to display)
     * @return postionSlider returns the position of the slider.
     */
    public JSlider getPositionSlider() {
        return positionSlider;
    }

    // Testing override or other options.
    /*public void run() {
        while (!stop) {
            move();
            try {
                Thread.sleep(1000); // Update position every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
    
    /**
     * Starts the threads.
     */
    public synchronized void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Runs the threads.
     * The threads will continue until paused an notified then continued otherwise stop.
     */
    public void run() {
        while (!stop) {
            synchronized (this) {
                while (paused) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            move();
            try {
                Thread.sleep(1000); // Update position every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Stop the threads.
     */
    public void stop() {
        stop = true;
    }

    /**
     * Pause the threads.
     */
    public synchronized void pause() {
        paused = true;
    }

    /**
     * Resume the threads.
     */
    public synchronized void resume() {
        paused = false;
        notify();
    }
    
    /**
     * Reset the state of the car and the position of the car.
     */
    public void reset() {
        // Reset the state of the car
        // For example, reset the position of the car
        position = 0;
    }

    /**
     * If the tls is Green or yellow move the car with d = s*t or else stop the car.
     * Use the speed units in m/s or mph and x in meters.
     * Speed is random to show cars going at random speed.
     * It should restart the distance if it is greater than 1000
     * It should restart the speed if it is greater than 160 mph. (300 mph does not exist in regular cars.)
     */
    public void move() {
        if (tls.getColor() != TrafficLightColor.RED) {
            if (position > 1000) {
                position = 0;
            }
            if ((speed * 2.236936) > 160) {
                speed = 0;
            }
            position += speed;
            speed += (int) (Math.random() * 10) + 1;
        }
        updateSlider();
    }

    /**
     * Updates the slider position to the JSlider label and displays it.
     */
    public void updateSlider() {
        positionSlider.setValue((int) position);
    }

    /**
     * Overrides the string Car object to display the car number, position, and speed with correct units.
     */
    @Override
    public String toString() {
        return "Car " + id + ": X = " + (int) position + " m, Speed = " + (int) speed + " m/s ; " + (int) (speed * 2.236936) + " mph";
    }
}