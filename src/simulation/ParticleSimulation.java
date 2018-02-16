package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;
import utils.List;

public class ParticleSimulation implements Runnable, ParticleEventHandler{

    private static final long FRAME_INTERVAL_MILLIS = 40;
    
    private final ParticlesModel          model;
    private final ParticlesView           screen;

    private MinPriorityQueue<Event> queue;

    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        // TODO implement constructor
	screen = new ParticlesView(name, m);
	model = m; 
    }

    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(screen);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // TODO complete implementing this method

	// create the queue and add Tick event	
	double currentTime = 1;
	double previousTime;
	queue = new MinPriorityQueue();	
	queue.add(new Tick(currentTime));

	// predict Collision events for all particles in the initial state 
	// and add these collisions to the queue
	Iterable<Collision> predictedCollision = model.predictAllCollisions(currentTime);
	queue.addList(predictedCollision);

	Event currentEvent;

	// loop until the queue is empty
	while(!queue.isEmpty()) {

	    // get the event that will happen next
	    currentEvent = queue.remove();

	    // if the event is valid, update all particles 
	    if(currentEvent.isValid()){
		previousTime = currentTime;
		currentTime = currentEvent.time();
		model.moveParticles(currentTime - previousTime);
		currentEvent.happen(this);
	    }
	}
    }

    // update the screen and add new Tick event 
    public void reactTo(Tick t) {

	try {
	    Thread.sleep(FRAME_INTERVAL_MILLIS);
	} catch (Exception e) {
	    System.err.println("Exception: " + e );
	}

	screen.update();
	queue.add(new Tick(t.time() + 1));
		
    }
	
    // get the particles related to this collision and add the predicted collisions to the queue
    public void reactTo(Collision c) {

	Particle[] particles = c.getParticles();
	Iterable<Collision> cs = null;

	for(Particle p : particles) {
	    cs = model.predictCollisions(p, c.time());
	    queue.addList(cs);
	}		
    }
}
