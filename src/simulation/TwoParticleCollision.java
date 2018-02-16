package simulation;

public class TwoParticleCollision extends Collision{
	
    public TwoParticleCollision(Particle p1, Particle p2, double time) {
	super(time, new Particle[] { p1, p2 });
    }

    @Override 
    public void happen(ParticleEventHandler h) {
	int first_particle_index = 0;
	int second_particle_index = 1;
	Particle p1 = particle_arr[first_particle_index];
	Particle p2 = particle_arr[second_particle_index];
	p1.collide(p1,p2);
	h.reactTo(this);
    }
}

