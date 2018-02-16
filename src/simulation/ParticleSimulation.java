package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;
import utils.List;

public class ParticleSimulation implements Runnable, ParticleEventHandler{

    private static final long FRAME_INTERVAL_MILLIS = 40;
    
    private final ParticlesModel          model;
    private final ParticlesView           screen;

    // what type should min queue be
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
	double currentTime = 1;
	double previousTime;
	queue = new MinPriorityQueue();	
	// add Tick event for the current time
	queue.add(new Tick(currentTime));

	// predict collision events for all particles in their initial state
	Iterable<Collision> predictedCollision = model.predictAllCollisions(currentTime);
	queue.addList(predictedCollision);

	Event currentEvent;
	while(!queue.isEmpty()) {
	    currentEvent = queue.remove();
	    //System.out.println(currentEvent.time());
	    if(currentEvent.isValid()){
		previousTime = currentTime;
		currentTime = currentEvent.time();
		model.moveParticles(currentTime - previousTime);
		currentEvent.happen(this);
	    }
	}
    }

    public void reactTo(Tick t) {
	try {
	    Thread.sleep(FRAME_INTERVAL_MILLIS);
	} catch (Exception e) {
	    System.err.println("Exception: " + e );
	}
	screen.update();
	queue.add(new Tick(t.time() + 1));
		
    }
	
    public void reactTo(Collision c) {
	Particle[] particles = c.getParticles();
	Iterable<Collision> cs = null;
	for(Particle p : particles) {
	    cs = model.predictCollisions(p, c.time());
	    queue.addList(cs);
	}		
    }
}
