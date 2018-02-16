package simulation;

public abstract class AbstractEvent implements Event {


    private final double event_time; 
    /**
     * Constructor for AbstractEvent.
     */
    public AbstractEvent(double time) {
        // TODO implement the constructor
	event_time = time;
    }

    /**
     * Returns the time (in ticks) at which this event will occur.
     */
    @Override
    public double time() {
        // TODO implement this method
	
        return event_time;
    }

    /**
     * Compares this object with the specified Event.
     */
    @Override
    public int compareTo(Event that) {
        // TODO implement this method

	if(this.time() == that.time()){
	    return 0;
	}
	else if(this.time() < that.time()){
	    return -1;
	}
	else
	    return 1;
    }

    public String toString() {
	return "Event at " + time();
    }
}
