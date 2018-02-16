package simulation;

public abstract class Collision extends AbstractEvent{

    protected Particle[] particleArr;
    private int[] hitCount;
    /**
     * Constructor for Collision
     */
    public Collision(double t, Particle[] ps) {
        // TODO implement constructor
	super(t);
	particleArr = ps;
	hitCount  = new int[particleArr.length]; 
	for(int i=0;i< particleArr.length;i++){        // store the hit count of each particle
	    hitCount[i] = particleArr[i].collisions(); // when the Collision event is created
	}
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // TODO implement this method
	for (int i=0;i< hitCount.length;i++){              // check if the original hit counts is
	    if(hitCount[i]!=particleArr[i].collisions()){  // still the same as the current one
		return false;
	    }
	}
	return true;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    public Particle[] getParticles() {
        // TODO implement this method
        return particleArr;
    }
}
