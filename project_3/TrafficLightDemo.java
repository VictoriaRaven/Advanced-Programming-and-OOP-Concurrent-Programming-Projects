package project32;

/**
 * An enumeration of the colors of a traffic light. 
 */
enum TrafficLightColor {  
RED, GREEN, YELLOW 
} 

/**
* A computerized traffic light using multithreading by the runnable class.  
* A simulation of a traffic light that uses 
* Utilizing an enumeration to describe the light's color. 
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
class TrafficLightSimulator implements Runnable { 

/**
 * holds the current traffic light color 
 */
public TrafficLightColor tlc;

/**
 * set to true to stop the simulation 
 */
private boolean stop = false;

/**
 * true when the light has changed
 */
private boolean changed = false; 

/**
 * set to true to pause the simulation 
 */
private boolean paused = false;

/**
 * Traffic light simulator light object
 * @param init create a tlc color object
 */
TrafficLightSimulator(TrafficLightColor init) {  
tlc = init; 
} 

/**
 * Set the Traffic light simulator to color red.
 */
TrafficLightSimulator() {  
tlc = TrafficLightColor.RED; 
} 

/**
 * Start up the lights and pause the lights.
 */
public void run() { 
    while(!stop) {	
    	if(!paused) {
            try { 
                switch(tlc) { 
                    case GREEN: 
                        Thread.sleep(10000); // green for 10 seconds 
                        break; 
                    case YELLOW: 
                        Thread.sleep(2000);  // yellow for 2 seconds 
                        break; 
                    case RED: 
                        Thread.sleep(12000); // red for 12 seconds 
                        break; 
                } 
            } catch(InterruptedException exc) { 
                System.out.println(exc); 
            } 
            changeColor(); 
        	}
    	}
    }

/**
 * Change color of the traffic light.
 */
synchronized void changeColor() { 
switch(tlc) { 
case RED: 
 tlc = TrafficLightColor.GREEN; 
 break; 
case YELLOW: 
 tlc = TrafficLightColor.RED; 
 break; 
case GREEN: 
tlc = TrafficLightColor.YELLOW; 
} 

changed = true;
notify(); // signal that the light has changed 
} 

/**
 * Wait until a light change occurs
 */
synchronized void waitForChange() { 
try { 
while(!changed) 
 wait(); // wait for light to change 
changed = false;
} catch(InterruptedException exc) { 
System.out.println(exc); 
} 
} 

/**
 * Return current color
 * @return tlc returns traffic light color name of the thread.
 */
synchronized TrafficLightColor getColor() { 
return tlc; 
} 

/**
 * Stop the traffic light. 
 */
synchronized void cancel() { 
stop = true;
} 
    /**
     * Pause the traffic light.
     */
    synchronized void pause() {
        paused = true;
    }

    /**
     * Resume the traffic light.
     */
    synchronized void resume() {
        paused = true;
    }
}

/**
 * Testing for the traffic lights demo simulation if it works.
 */
class TrafficLightDemo {  
public static void main(String args[]) {  
TrafficLightSimulator tl =
new TrafficLightSimulator(TrafficLightColor.GREEN); 

Thread thrd = new Thread(tl);
thrd.start();

for(int i=0; i < 9; i++) { 
System.out.println(tl.getColor()); 
tl.waitForChange(); 
} 

tl.cancel(); 
}  
}

