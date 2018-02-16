package simulation;

public class ParticleWallCollision extends Collision{
	
    private Wall wall;
    
    public ParticleWallCollision(Particle p, Wall w, double time) {
	super(time, new Particle[] { p });
	wall = w;
    }

    @Override 
    public void happen(ParticleEventHandler h) {
	int first_particle_index = 0;
	Particle p = particle_arr[first_particle_index];
	p.collide(p,wall);
	h.reactTo(this);
    }
}
