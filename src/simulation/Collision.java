package simulation;

public abstract class Collision extends AbstractEvent{

    protected Particle[] particle_arr;
    private int[] hit_count;
    /**
     * Constructor for Collision
     */
    public Collision(double t, Particle[] ps) {
        // TODO implement constructori
	super(t);
	particle_arr = ps;
	hit_count  = new int[particle_arr.length];
	for(int i=0;i< particle_arr.length;i++){
	    hit_count[i] = particle_arr[i].collisions();
	}
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // TODO implement his method
	for (int i=0;i< hit_count.length;i++){
	    if(hit_count[i]!=particle_arr[i].collisions()){
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
        return particle_arr;
    }
}
