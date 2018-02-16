package simulation;

public class TwoParticleCollision extends Collision{
	
    public TwoParticleCollision(Particle p1, Particle p2, double time) {
	super(time, new Particle[] { p1, p2 });
    }

    @Override 
    public void happen(ParticleEventHandler h) {
	int firstParticleIndex = 0;
	int secondParticleIndex = 1;
	Particle p1 = particleArr[firstParticleIndex];
	Particle p2 = particleArr[secondParticleIndex];
	p1.collide(p1,p2);      // update the particle's state
	h.reactTo(this);
    }
}

